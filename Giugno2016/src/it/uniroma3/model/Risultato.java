package it.uniroma3.model;
import javax.persistence.*;

@Entity
@Table(name ="Risultato")
public class Risultato {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@OneToOne
	private Indicatore nome;

	private String valore;
	
	public Indicatore getNome()
	{
		return this.nome;
	}
	
	
	public String getValore() 
	{
		return valore;
	}
	
	public void setValore(String valore) 
	{
		this.valore = valore;
	}
}
