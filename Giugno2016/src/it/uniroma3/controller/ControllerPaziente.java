package it.uniroma3.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import it.uniroma3.facade.FacadePaziente;
import it.uniroma3.model.Paziente;

@ManagedBean(name="controllerPaziente")
@SessionScoped
public class ControllerPaziente {
	
	private String nome;
	private String cognome;
	private String indirizzo;
	private Paziente paziente;
	
	@EJB(beanName="facadePaziente")
	private FacadePaziente facade;
	
	
	public String confermaPaziente()
	{
		paziente=new Paziente(this.nome,this.cognome,this.indirizzo);
		return "confermaRegistrazionePaziente";
	}
	
	
	public String inserimentoPaziente()
	{
        facade.aggiungi(paziente);
		return "registrazionePazienteAvvenuta";
	}
	
	public String annulla()
	{
		this.paziente=null;
		return "registrazionePaziente";
	}

	public String getNome()
	{
		return this.nome;
	}

	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	public String getCognome() 
	{
		return this.cognome;
	}

	public void setCognome(String cognome) 
	{
		this.cognome = cognome;
	}

	public String getIndirizzo() 
	{
		return this.indirizzo;
	}

	public void setIndirizzo(String indirizzo) 
	{
		this.indirizzo = indirizzo;
	}

	public Paziente getPaziente() 
	{
		return this.paziente;
	}

	public void setPaziente(Paziente paziente) 
	{
		this.paziente = paziente;
	}
}
