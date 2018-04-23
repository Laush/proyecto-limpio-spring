package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Comuna {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombreComuna;
	private String nombreBarrio;
	//@OneToMany  // relacion bidireccional, se pone en ambos lados // da error falta collecion
	//private Barrio bar;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
		
	public String getNombre() {
		return nombreComuna;
	}
	public void setNombre(String nombreComuna) {
		this.nombreComuna = nombreComuna;
	}
	
	public String getBarrios() {
		return nombreBarrio;
	}
	public void setBarrios(String nombreBarrio) {
		this.nombreBarrio = nombreBarrio;
	}
	

	
}
