package it.uniroma3.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import it.uniroma3.model.TipologiaEsame;
import it.uniroma3.facade.FacadeTipologia;
import it.uniroma3.model.Indicatore;
import it.uniroma3.model.Prerequisito;

@ManagedBean(name="controllerTipologia")
@SessionScoped
public class ControllerTipologia
{
	@EJB(beanName="facadeTipologia")
	private FacadeTipologia facade;
	
	private String nomeTipologia;
	private String descrizione;
	private double costoTipologia;
	private TipologiaEsame tipologia;
	private List<Prerequisito> prerequisiti;
	private List<Indicatore> indicatori;
	private Prerequisito p;
	private Indicatore i;
	private String sceltaPre;
	private String sceltaInd;
	private String Errore;
	
	
	
	public String vaiAiPrerequisiti()
	{
		this.prerequisiti = facade.ottieniPrerequisiti();
		this.indicatori = facade.ottieniIndicatori();
		tipologia=new TipologiaEsame(this.nomeTipologia,this.descrizione,this.costoTipologia);
		facade.aggiungi(tipologia);
		return "inserisciPrerequisiti";
	}
	
	public String vaiAllaConferma()
	{
		return "confermaTipologiaEsame";
	}
	
	
	public String annulla()
	{
		this.tipologia=null;
		return"inserisciTipologiaEsame";
	}

	
	public String termina()
	{
		return "inserimentoTipologiaAvvenuto";
	}
	
	public String cancella()
	{
		this.tipologia.setPrerequisiti(null);
		this.tipologia.setIndicatori(null);
		this.facade.cancella(this.tipologia);
		return "amministrazione";
	}
	
	public String aggiungiPrerequisito()
	{
		if(this.sceltaPre.equals(""))
			return "inserisciPrerequisiti";
		for(Prerequisito j:this.prerequisiti)
		{
			if(j.getNome().equals(this.sceltaPre))
				{  this.p=j;
		           facade.aggiungiPrerequisitoATipologia(this.tipologia,this.p);
		           this.sceltaPre="";
		           return "inserisciPrerequisiti";
				}
	     }
		this.setErrore();
		return "inserisciPrerequisiti";
	}
	
	public String aggiungiIndicatore()
	{
		if(this.sceltaInd.equals(""))
			return "inserisciPrerequisiti";
		for(Indicatore k:this.indicatori)
		{
			if(k.getNome().equals(this.sceltaInd))
				{  this.i=k;
		           facade.aggiungiIndicatoreATipologia(this.tipologia,this.i);
		           this.sceltaInd="";
		           return "inserisciPrerequisiti";
				}
	     }
		this.setErrore();
		return "inserisciPrerequisito";
	}
	
	
	public String getNomeTipologia() 
	{
		return this.nomeTipologia;
	}

	public void setNomeTipologia(String nomeTipologia) 
	{
		this.nomeTipologia = nomeTipologia;
	}

	public String getDescrizione() 
	{
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) 
	{
		this.descrizione = descrizione;
	}

	public double getCostoTipologia() 
	{
		return this.costoTipologia;
	}

	public void setCostoTipologia(double costoTipologia) 
	{
		this.costoTipologia = costoTipologia;
	}

	public TipologiaEsame getTipologia()
	{
		return this.tipologia;
	}

	public void setTipologia(TipologiaEsame tipologia) 
	{
		this.tipologia = tipologia;
	}
	
	public Indicatore getI() 
	{
		return i;
	}

	public void setI(Indicatore i) 
	{
		this.i = i;
	}

	public Prerequisito getP() 
	{
		return p;
	}

	public List<Indicatore> getIndicatori() 
	{
		return indicatori;
	}

	public void setIndicatori(List<Indicatore> indicatori) 
	{
		this.indicatori = indicatori;
	}

	public void setP(Prerequisito p) 
	{
		this.p = p;
	}

	
	
	public List<Prerequisito> getPrerequisiti() 
	{
		return this.prerequisiti;
	}

	public void setPrerequisiti(List<Prerequisito> prerequisiti) 
	{
		this.prerequisiti = prerequisiti;
	}


	public String getErrore() 
	{
		return this.Errore;
	}


	public void setErrore()
	{
		Errore = "Scelta non valida, controllare i nomi mostrati";
	}


	public String getSceltaPre() 
	{
		return sceltaPre;
	}


	public void setSceltaPre(String sceltaPre) 
	{
		this.sceltaPre = sceltaPre;
	}


	public String getSceltaInd() 
	{
		return sceltaInd;
	}


	public void setSceltaInd(String sceltaInd) 
	{
		this.sceltaInd = sceltaInd;
	}

}
