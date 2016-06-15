package it.uniroma3.facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import it.uniroma3.model.TipologiaEsame;

@Stateless(name="facadeOfferta")
public class FacadeOfferta {
	
	@PersistenceContext(unitName="clinica-unit")
	private EntityManager em;
	
	
	@SuppressWarnings("unchecked")
	public List<TipologiaEsame> elencoTipologia() 
	{
		Query query = em.createQuery("SELECT t FROM TipologiaEsame t");
		List<TipologiaEsame> lista = (List<TipologiaEsame>)query.getResultList();
		return lista;
	}

}
