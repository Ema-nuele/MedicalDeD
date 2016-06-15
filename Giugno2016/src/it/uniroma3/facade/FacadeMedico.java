package it.uniroma3.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import it.uniroma3.model.Esame;
import it.uniroma3.model.Medico;


@Stateless(name = "facadeMedico")
public class FacadeMedico 
{
    	@PersistenceContext(unitName = "clinica-unit")
    	private EntityManager em;

    @SuppressWarnings("unchecked")
    public List<Medico> medici() 
    {
    	Query query = em.createQuery("SELECT m FROM Medico m");
    	List<Medico> lista =(List<Medico>) query.getResultList();
    	return lista;
    }

	@SuppressWarnings("unchecked")
	public List<Esame> cerca(String nome, String cognome) 
	{
		Query query=em.createQuery("SELECT m FROM Medico m WHERE m.nome=: nome AND m.cognome= :cognome" );
			query.setParameter("nome", nome);
			query.setParameter("cognome", cognome);
				Medico m=(Medico)query.getSingleResult();
				query=em.createQuery("SELECT e FROM Esame e WHERE e.medico= :medico");
				query.setParameter("medico", m);
		return (List<Esame>)query.getResultList();
				
	}

	public void aggiungi(Medico m) 
	{
		em.persist(m);
	}

}
