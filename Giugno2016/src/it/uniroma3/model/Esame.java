package it.uniroma3.model;

import java.util.Date;
import java.util.List;
import javax.persistence.*;



@Entity
@Table(name ="Esame")
public class Esame {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	private Paziente paziente;
	@OneToOne
	private TipologiaEsame tipologia;
	
	@Temporal (TemporalType.TIMESTAMP)
    private Date dataCreazione;
	@Column(nullable=false)
	private Date dataEsame;
	@OneToOne
	private Medico medico;
	@OneToMany
	private List<Risultato> risultati;
	
	
	public Esame(Paziente paziente, TipologiaEsame tipologia, 
					Date dataCreazione, Date dataEsame, Medico medico) 
	{
		this.paziente = paziente;
		this.tipologia = tipologia;
		this.dataCreazione = dataCreazione;
		this.dataEsame = dataEsame;
		this.medico = medico;
	}


	public Esame()
	{
		
	}
	
	public TipologiaEsame getTipologia() 
	{
		return this.tipologia;
	}

	public void setTipologia(TipologiaEsame tipologia) 
	{
		this.tipologia = tipologia;
	}

	public Long getId() 
	{
		return id;
	}
	
	public Paziente getPaziente() 
	{
		return paziente;
	}
	
	public void setPaziente(Paziente paziente) 
	{
		this.paziente = paziente;
	}
	
	public Date getDataCreazione() 
	{
		return dataCreazione;
	}
	
	public void setDataCreazione(Date dataCreazione) 
	{
		this.dataCreazione = dataCreazione;
	}
	
	public Date getDataEsame() 
	{
		return dataEsame;
	}
	
	public void setDataEsame(Date dataEsame)
	{
		this.dataEsame = dataEsame;
	}
	
	public Medico getMedico() 
	{
		return medico;
	}
	
	public void setMedico(Medico medico) 
	{
		this.medico = medico;
	}
	
	public List<Risultato> getRisultati() 
	{
		return risultati;
	}
	
	public void setRisultati(Risultato r) 
	{
		this.risultati.add(r);
	}

}