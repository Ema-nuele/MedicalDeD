package it.uniroma3.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import it.uniroma3.facade.FacadeEsame;
import it.uniroma3.model.Esame;
import it.uniroma3.model.Medico;
import it.uniroma3.model.Paziente;
import it.uniroma3.model.TipologiaEsame;

@ManagedBean(name="controllerEsame")
@SessionScoped

public class ControllerEsame 
{
	private Paziente paziente;
	private TipologiaEsame tipoEsame;
	private Date dataCreazione;
	private Date dataPrenotazione;
	private String dataEsame;
	private Medico medico;
	private Esame esame;
	
	private List<Medico> medici;
	private List<Paziente> pazienti;
	private List<TipologiaEsame> tipologie;
	
	private Long sceltaM;
	private String sceltaT;
	private Long sceltaP;
	
	@EJB(beanName="facadeEsame")
	private FacadeEsame facade;

	
	public String creaEsame()   // chiamato da inserisci data
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try{
			 this.dataPrenotazione=formatter.parse(this.dataEsame);
		    }
		 catch (ParseException e)
				{
				e.printStackTrace();
				return "inserisciDataEsame";
				}
		this.tipologie = facade.ottieniTipologie();
		this.medici = facade.ottieniMedici();
		this.pazienti = facade.ottieniPazienti();
		this.dataCreazione=new Date();  // si puo fare anche dopo
		
		return "inserisciEsame";
	}
	
	public String salvaEsame() // da chiamare in conferma esame
	{
		this.facade.aggiungi(this.esame);
		return "confermaEsameAvvenuta";
	}
	
	

	public String compilaEsame()        // chiamato in inserisci esame 
	{
		
		for(Medico m : this.medici)
		{
			if(m.getId().equals(this.sceltaM))
				this.medico=m;
		}
		
		for(TipologiaEsame t : this.tipologie)
		      {
			     if(t.getNomeTipologia().equals(this.sceltaT))
				  this.tipoEsame = t;
		       }
		        
	  	for(Paziente p : this.pazienti)
   	  		{
  	  			if(p.getIdPaziente().equals(this.sceltaP))
  					this.paziente = p;
		    }
	  	
	 this.esame = new Esame(this.paziente,this.tipoEsame,this.dataCreazione,this.dataPrenotazione, this.medico);	
	return "confermaEsame";	        	
	}		

	
	public String annulla()
	{
		this.esame=null;
		return "amministrazione";
	}

	public String cancella() 
	{
		this.esame.setDataCreazione(null);
		this.esame.setDataEsame(null);
		this.esame.setMedico(null);
		this.esame.setPaziente(null);
		this.esame.setTipologia(null);
		this.facade.cancella(this.esame);
		return "amministrazione";
	}
	
	public String getSceltaT() 
	{
		return sceltaT;
	}

    public void setSceltaT(String sceltaT) 
    {
		this.sceltaT = sceltaT;
	}


	public Long getSceltaP() 
	{
		return this.sceltaP;
	}

	public List<Medico> getMedici() 
	{
		return medici;
	}


	public void setMedici(List<Medico> medici) 
	{
		this.medici = medici;
	}


	public List<Paziente> getPazienti() 
	{
		return pazienti;
	}


	public void setPazienti(List<Paziente> pazienti) 
	{
		this.pazienti = pazienti;
	}


	public List<TipologiaEsame> getTipologie() 
	{
		return tipologie;
	}


	public void setTipologie(List<TipologiaEsame> tipologie) 
	{
		this.tipologie = tipologie;
	}


	public Paziente getPaziente()
	{
		return this.paziente;
	}

	public void setPaziente(Paziente paziente) 
	{
		this.paziente = paziente;
	}

	public TipologiaEsame getTipoEsame() 
	{
		return this.tipoEsame;
	}

	public void setTipoEsame(TipologiaEsame tipoEsame)
	{
		this.tipoEsame = tipoEsame;
	}

	public Date getDataCreazione() 
	{
		return this.dataCreazione;
	}

	public void setDataCreazione(Date dataCreazione) 
	{
		this.dataCreazione = dataCreazione;
	}

	public String getDataEsame() 
	{
		return this.dataEsame;
	}

	public void setDataEsame(String dataEsame) 
	{
		this.dataEsame = dataEsame;
	}

	public Medico getMedico() 
	{
		return this.medico;
	}

	public void setMedico(Medico medico) 
	{
		this.medico = medico;
	}


	public Esame getEsame() 
	{
		return esame;
	
	}


	public void setEsame(Esame esame) 
	{
		this.esame = esame;
	}

	public Date getDataPrenotazione()
	{
		return dataPrenotazione;
	}

	public void setDataPrenotazione(Date dataPrenotazione) 
	{
		this.dataPrenotazione = dataPrenotazione;
	}

	public void setSceltaM(Long sceltaM)
	{
		this.sceltaM = sceltaM;
	}

	public void setSceltaP(Long sceltaP) 
	{
		this.sceltaP = sceltaP;
	}

	public Long getSceltaM() 
	{
		return this.sceltaM;
	}

}
