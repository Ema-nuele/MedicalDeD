package it.uniroma3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="Paziente")
public class Paziente{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idPaziente;
	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private String cognome;
    @Column(nullable=false)
	private String indirizzo;
	
	
    
    public Paziente(String nome,String cognome,String indirizzo)
    {
    	this.nome=nome;
    	this.cognome=cognome;
    	this.indirizzo=indirizzo;
    }
    
	public Long getIdPaziente()
	{
		return this.idPaziente;
	}
	
	public void setIdPaziente(Long idPaziente) 
	{
		this.idPaziente = idPaziente;
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
	
	public String getIndirizzo() 
	{
		return indirizzo;
	}
	
	public void setIndirizzo(String indirizzo) 
	{
		this.indirizzo = indirizzo;
	}
	
	public Paziente()
	{
		
	}

}
