package it.uniroma3.facade;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import it.uniroma3.model.Indicatore;
import it.uniroma3.model.Prerequisito;
import it.uniroma3.model.TipologiaEsame;

@Stateless(name = "facadeTipologia")
public class FacadeTipologia {

	    
	@PersistenceContext(unitName = "clinica-unit")
		private EntityManager em;
	    
	    
	    public void aggiungi(TipologiaEsame tipo)
	    {
	    	em.persist(tipo);
	    	
	    }
	    
	    @SuppressWarnings("unchecked")
		public List<Prerequisito> ottieniPrerequisiti() 
	    {
			Query query = em.createQuery("SELECT t FROM Prerequisito t");
			List<Prerequisito> lista = new ArrayList<>();
			lista = (List<Prerequisito>)query.getResultList();
			return lista;
		}
	    
	    @SuppressWarnings("unchecked")
		public List<Indicatore> ottieniIndicatori() 
	    {
	    	
	    	Query query = em.createQuery("SELECT i FROM Indicatore i");
	    	List<Indicatore> lista = (List<Indicatore>)query.getResultList();
	    	return lista;
	    }


		public void aggiungiPrerequisitoATipologia(TipologiaEsame tipologia, Prerequisito p)
		{
			tipologia.getPrerequisiti().add(p);
			em.merge(tipologia);
			em.merge(p);
			em.flush();
		}


		public void aggiungiIndicatoreATipologia(TipologiaEsame tipologia, Indicatore i) 
		{
			tipologia.getIndicatori().add(i);
			em.merge(tipologia);
			em.merge(i);
			em.flush();
		}


		public void cancella(TipologiaEsame tipologia) 
		{
			em.merge(tipologia);
			Query query = em.createQuery("DELETE FROM TipologiaEsame i WHERE i.nomeTipologia = :nome");
			query.setParameter("nome", tipologia.getNomeTipologia());
			query.executeUpdate();
			em.flush();
			
		}
} 