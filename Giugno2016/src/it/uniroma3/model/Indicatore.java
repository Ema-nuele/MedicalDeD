package it.uniroma3.model;


import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Indicatore {
	
	@Id
	private String nome;
	
	public String getNome() 
	{
		return nome;
	}

	
	
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
}
