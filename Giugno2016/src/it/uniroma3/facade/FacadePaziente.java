package it.uniroma3.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.uniroma3.model.Paziente;

@Stateless(name = "facadePaziente")
public class FacadePaziente {

	    
	@PersistenceContext(unitName = "clinica-unit")
		private EntityManager em;
	    
	    
	    public void aggiungi(Paziente p)
	    {
	    	em.persist(p);
	    }

}
