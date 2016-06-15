package it.uniroma3.model;

import javax.persistence.*;

@Entity
@Table(name ="Medico")
public class Medico {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private String cognome;
	private String specializzazione;
	
	public Medico()
	{
		
	}
	
	
	public Long getId() 
	{
		return this.id;
	}

	public String getCognome()
	{
		return cognome;
	}

	public void setCognome(String cognome) 
	{
		this.cognome = cognome;
	}

	public String getSpecializzazione()
	{
		return specializzazione;
	}

	public void setSpecializzazione(String specializzazione)
	{
		this.specializzazione = specializzazione;
	}

	public void setNome(String nome) 
	
	{
		this.nome = nome;
	}
	
	public String getNome()
	{
		return this.nome;
	}

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Medico(String nome, String cognome, String specializzazione) 
	{
		this.nome = nome;
		this.cognome = cognome;
		this.specializzazione = specializzazione;
	}
}
