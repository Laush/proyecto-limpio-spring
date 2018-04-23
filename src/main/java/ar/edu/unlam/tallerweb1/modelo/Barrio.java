package ar.edu.unlam.tallerweb1.modelo;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Barrio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name="ID")
	private Long id;
	private String nombre;
	@ManyToOne
    private Comuna comuna;// relaciona con la tabla comuna
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getComuna() {
		return nombre;
	}
	public void setComuna(String nombre) {
		this.nombre = nombre;
	}
	
    //hashcode()..
	//equals..
	
}
