package it.uniroma3.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity

// possibile lista che ritorna tutti gli esami
//List<TipologiaEsame> esami= em.createNamedQuery("mostraTipologie").getResultList();

public class TipologiaEsame {
	@Id
	private String nomeTipologia;
	@Column(nullable=false)
	private String descrizione;
	@Column(nullable=false)
	private double costoTipologia;
	
	
	@OneToMany( cascade = {CascadeType.ALL})
	private List<Prerequisito> prerequisiti;
	
	
	@OneToMany( cascade = {CascadeType.ALL})
	private List<Indicatore> indicatori;
	
	public String getNomeTipologia()
	{
		return this.nomeTipologia;
	}
	
	public void setNomeTipologia(String nome)
	{
		this.nomeTipologia = nome;
	}
	
	public String getDescrizione() 
	{
		return this.descrizione;
	}
	
	public void setDescrizione(String descrizione)
	{
		this.descrizione = descrizione;
	}
	
	public double getCosto() 
	{
		return this.costoTipologia;
	}
	
	public void setCosto(int costo) 
	{
		this.costoTipologia = costo;
	}

	public double getCostoTipologia() 
	{
		return costoTipologia;
	}

	public void setCostoTipologia(double costoTipologia)
	{
		this.costoTipologia = costoTipologia;
	}

	public List<Prerequisito> getPrerequisiti() 
	{
		return prerequisiti;
	}

	public void setPrerequisiti(List<Prerequisito> prerequisiti) 
	{
		this.prerequisiti = prerequisiti;
	}

	public List<Indicatore> getIndicatori()
	{
		return indicatori;
	}

	public void setIndicatori(List<Indicatore> indicatori) 
	{
		this.indicatori = indicatori;
	}

	public TipologiaEsame(String nomeTipologia, String descrizione, double costoTipologia) 
	{
		this.nomeTipologia = nomeTipologia;
		this.descrizione = descrizione;
		this.costoTipologia = costoTipologia;
		this.indicatori=new ArrayList<>();
		this.prerequisiti=new ArrayList<>();
	}

	public void aggiungiPrerequisito(Prerequisito p) 
	{
	 this.prerequisiti.add(p);
		
	}

	public TipologiaEsame()
	{
	
	}
}
