package it.uniroma3.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import it.uniroma3.model.Amministratore;

@Stateless(name = "facadeAdmin")
	public class FacadeAdmin {  

		@PersistenceContext(unitName = "clinica-unit")
		private EntityManager em;

		
		public void creaAmministratore(Amministratore a)
		{
			em.persist(a);
		}
		
		public Amministratore login(Long id,String password)
		{
			Query query = em.createQuery("SELECT a FROM Amministratore a WHERE a.id = :id");
			query.setParameter("id",id);
		try{
			if(query.getSingleResult()!=null)
				{            
					Amministratore a=(Amministratore) query.getSingleResult();
			             if(a.getPassword().equals(password))
			             return a;
				
				} 
			}
		catch(NoResultException e)
			{
				e.printStackTrace();
			}
		return null;
			
         }
}
