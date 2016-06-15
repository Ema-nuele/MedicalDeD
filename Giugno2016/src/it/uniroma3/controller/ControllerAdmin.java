package it.uniroma3.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import it.uniroma3.facade.FacadeAdmin;
import it.uniroma3.model.Amministratore;

@ManagedBean(name="controllerAdmin")
public class ControllerAdmin {
	
	private Long id;
	private String nome;
	private String cognome;
	private String email;
	private String username;
	private String indirizzo;
	private String password;
	private Amministratore a;
	
	@EJB(beanName="facadeAdmin")
	private FacadeAdmin facade;
	
	
	public String conferma() 
	{
		a = new Amministratore(this.nome,this.cognome,this.username,
				this.password,this.email,this.indirizzo);
		facade.creaAmministratore(a);
		return "confermaNuovoAdmin";
	}
	
	public String annulla() 
	{
		return "inserisciAdmin";
	}
	
	public String aggiungi()
	{
		return "inserimentoAdminAvvenuto";
	}

	public String getNome() 
	{
		return nome;
	}

	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	public String getCognome() 
	{
		return cognome;
	}

	public void setCognome(String cognome) 
	{
		this.cognome = cognome;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getUsername() 
	{
		return username;
	}

	public void setUsername(String username) 
	{
		this.username = username;
	}

	public String getIndirizzo() 
	{
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) 
	{
		this.indirizzo = indirizzo;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public FacadeAdmin getFacade() 
	{
		return facade;
	}

	public void setFacade(FacadeAdmin facade) 
	{
		this.facade = facade;
	}

	public Long getId() 
	{
		return id;
	}

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Amministratore getA()
	{
		return a;
	}

	public void setA(Amministratore a) 
	{
		this.a = a;
	}
}
