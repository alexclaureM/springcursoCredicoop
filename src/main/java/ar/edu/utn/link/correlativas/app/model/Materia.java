package ar.edu.utn.link.correlativas.app.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Collection;

@Entity
@Table(name = "materia")
public class Materia {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank
	private String nombre;
	@Min(1)
	private int anio;

	@Transient
	private Collection<Materia> correlativas;
	
	public Materia(){
	// los objetos en HIBERNATE que ayudaban a que funcione -> se necesita un CONSTRUCTOR vacio
		// LO MISMO PASA PARA SPRING, se necesita un constructor VACIO
		// debido al CONTRATO DE BUILD
	}

	public Materia(String nombre, int anio) {
		super();
		this.nombre = nombre;
		this.anio = anio;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Collection<Materia> getCorrelativas() {
		return correlativas;
	}
	public void setCorrelativas(Collection<Materia> correlativas) {
		this.correlativas = correlativas;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Materia{" +
				"nombre='" + nombre + '\'' +
				", correlativas=" + correlativas +
				'}';
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}
}
