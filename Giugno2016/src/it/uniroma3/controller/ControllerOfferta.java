package it.uniroma3.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import it.uniroma3.facade.FacadeOfferta;
import it.uniroma3.model.TipologiaEsame;

@ManagedBean(name="controllerOfferta")
@SessionScoped

public class ControllerOfferta {
	
	@EJB(beanName="facadeOfferta")
	private FacadeOfferta facade;
	
	private List<TipologiaEsame> tipologie;
	private TipologiaEsame tipologia;
	private String descrizione;
	private String errore;
	private String sceltaT;
	
	public List<TipologiaEsame> getTipologie() 
	{
		return tipologie;
	}


	
	public void setTipologie(List<TipologiaEsame> tipologie) 
	{
		this.tipologie = tipologie;
	}
	
	
	public String getSceltaT() 
	{
		return sceltaT;
	}


	public void setSceltaT(String sceltaT) 
	{
		this.sceltaT = sceltaT;
	}


	public String getDescrizione() 
	{
		return descrizione;
	}


	public void setDescrizione(String descrizione) 
	{
		this.descrizione = descrizione;
	}


	public String getErrore() 
	{
		return errore;
	}


	public void setErrore() 
	{
		this.errore = "Informazioni Errate";
	}


	public TipologiaEsame getTipologia() 
	{
		return tipologia;
	}


	public void setTipologia(TipologiaEsame tipologia) 
	{
		this.tipologia = tipologia;
	}


	public String vaiASelezione() 
	{
		this.tipologie = facade.elencoTipologia();
	return "selezionaTipologia";
	}
	
	public String vaiADescrzione() 
	{
		this.tipologie = facade.elencoTipologia();
		for(TipologiaEsame t : this.tipologie)
		{
			if(t.getNomeTipologia().equals(this.sceltaT))
			{
				this.tipologia=t;
				return "informazioniEsame";
			}
		}
		return "selezionaTipologia";
	}

}
