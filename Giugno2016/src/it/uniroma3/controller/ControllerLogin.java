package it.uniroma3.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import it.uniroma3.facade.FacadeAdmin;
import it.uniroma3.model.Amministratore;

@ManagedBean(name="controllerLogin")
@SessionScoped

public class ControllerLogin 
{
	private Long id;
	private String password;
	private Amministratore amministratore;

	@EJB(beanName="facadeAdmin")
	private FacadeAdmin facade;
	
	
	public String logout()
	{
		this.amministratore=null;
		return "MedicalDeD";
	}
	
	
	
	public Amministratore getAmministratore() 
	{
		return amministratore;
	}


	public void setAmministratore(Amministratore amministratore) 
	{
		this.amministratore = amministratore;
	}


	public FacadeAdmin getFacade() 
	{
		return facade;
	}


	public void setFacade(FacadeAdmin facade) 
	{
		this.facade = facade;
	}


	public String login()
	{
	 
	   this.amministratore=facade.login(this.id,this.password);
	   if(this.amministratore!=null)
		   return "amministrazione";
	   return "login";
		   
	  }

	public String home() 
	{
		return "MedicalDeD";
	}


	public Long getId() 
	{
		return this.id;
	}


	public void setId(Long id) 
	{
		this.id = id;
	}


	public String getPassword() 
	{
		return password;
	}


	public void setPassword(String password) 
	{
		this.password = password;
	}
	
}
