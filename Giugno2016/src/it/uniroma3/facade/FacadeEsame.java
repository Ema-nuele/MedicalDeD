package it.uniroma3.facade;

import java.util.List;

import it.uniroma3.model.Esame;
import it.uniroma3.model.Medico;
import it.uniroma3.model.Paziente;
import it.uniroma3.model.TipologiaEsame;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "facadeEsame")
public class FacadeEsame {

	@PersistenceContext(unitName = "clinica-unit")
	private EntityManager em;
    

	public void aggiungi(Esame esame) 
	{
		em.persist(esame);		
	}
	
	@SuppressWarnings("unchecked")
	public List<TipologiaEsame> ottieniTipologie()
	{
		
		Query query = em.createQuery("SELECT t FROM TipologiaEsame t");
		List<TipologiaEsame> lista = (List<TipologiaEsame>)query.getResultList();
		return lista;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Medico> ottieniMedici() 
	{
		Query query = em.createQuery("SELECT m FROM Medico m");
		List<Medico> lista = (List<Medico>)query.getResultList();
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Paziente> ottieniPazienti() 
	{
		Query query = em.createQuery("SELECT p FROM Paziente p");
		List<Paziente> lista =(List<Paziente>)query.getResultList();
		return lista;
	}
	
	public void aggiungiTipologiaAEsame(Esame esame, TipologiaEsame t) 
	{
		esame.setTipologia(t);
		em.merge(esame);
		em.merge(t);
		em.flush();
	}
	
	public void aggiungiPazienteAEsame(Esame esame, Paziente p)
	{
		esame.setPaziente(p);
		em.merge(esame);
		em.merge(p);
		em.flush();
		
	}
	
	public void aggiungiMedicoAEsame(Esame esame, Medico m) 
	{
		esame.setMedico(m);
		em.merge(esame);
		em.merge(m);
		em.flush();
		
	}
	
	public void cancella(Esame esame) 
	{
		em.merge(esame);
		Query query = em.createQuery("DELETE FROM Esame e WHERE e.id =:id");
		query.setParameter("id", esame.getId());
		query.executeUpdate();
		em.flush();
		
	}

}
