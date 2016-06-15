package it.uniroma3.model;


import javax.persistence.*;

@Entity
public class Prerequisito {
	
	@Id
	private String nome;
	@Column(nullable=false)
	private String valore;
	
	public String getNome() 
	{
		return nome;
	}
	
	
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	
	public String getValore()
	{
		return valore;
	}
	
	public void setValore(String valore)
	{
		this.valore = valore;
	}
	
	public Prerequisito(String nome, String valore) 
	{
		this.nome = nome;
		this.valore = valore;
	}
	
	public Prerequisito()
	{
		
	}
}
