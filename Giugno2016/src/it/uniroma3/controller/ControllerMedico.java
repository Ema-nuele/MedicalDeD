package it.uniroma3.controller;

import it.uniroma3.model.Medico;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import it.uniroma3.model.Esame;
import it.uniroma3.facade.FacadeMedico;


@ManagedBean(name="controllerMedico")
public class ControllerMedico 
{
    private String nome;
	private String cognome;
	private String specializzazione;
	private Medico medico;
	private List<Esame> esami;
	private List<Medico> medici;
	private String sceltaMN;
	private String sceltaMC;
	private String errore;
	@EJB(beanName="facadeMedico")
	private FacadeMedico facade;
	
	public String cercaMedico() 
	{
		this.medici = facade.medici();
		return "esamiMedico";

	}
	
	
	public List<Medico> getMedici() 
	{
		return medici;
	}

	public void setMedici(List<Medico> medici) 
	{
		this.medici = medici;
	}

	public String cercaEsami()
	{
		this.medici = facade.medici();
		for(Medico m : this.medici) 
		{
			if(m.getNome().equals(this.sceltaMN) && m.getCognome().equals(this.sceltaMC))
			{
				this.medico = m;
				this.esami=this.facade.cerca(this.medico.getNome(),this.medico.getCognome());
				return "mostraEsamiMedico";
			}
		}
	return "esamiMedico";
	}
	
	
	
	public String getSceltaMN() 
	{
		return sceltaMN;
	}

	public void setSceltaMN(String sceltaMN) 
	{
		this.sceltaMN = sceltaMN;
	}

	public String getSceltaMC() 
	{
		return sceltaMC;
	}

	public void setSceltaMC(String sceltaMC) 
	{
		this.sceltaMC = sceltaMC;
	}

	public String getErrore() 
	{
		return errore;
	}

	public void setErrore() 
	{
		this.errore = "Scelta non valida, controllare i dati mostrati";
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
	public Medico getMedico() 
	{
		return this.medico;
	}
	public void setMedico(Medico medico) 
	{
		this.medico = medico;
	}

	public List<Esame> getEsami() 
	{
		return this.esami;
	}

	public void setEsami(List<Esame> esami)
	{
		this.esami = esami;
	}
	
	public String confermaMedico()
	{
	  this.medico=new Medico(this.nome,this.cognome,this.specializzazione);	
	  facade.aggiungi(this.medico);
	  return "confermaMedico";
	}
	public String aggiungi() 
	{
		return "inserimentoMedicoAvvenuto";
	}
	
	public String annulla() 
	{
		this.medico=null;
		return "inserisciMedico";
	}

	public String getSpecializzazione() 
	{
		return this.specializzazione;
	}

	public void setSpecializzazione(String specializzazione) 
	{
		this.specializzazione = specializzazione;
	}
	
}
