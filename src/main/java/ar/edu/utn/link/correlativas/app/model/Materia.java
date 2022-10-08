package ar.edu.utn.link.correlativas.app.model;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
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

	@ManyToMany // Una materia puede ser correlativa de varias
	private Collection<Materia> correlativas;

	//para la baja logica de los datos en MATERIA
	// para que se fije si es activo esta materia , si no es activo, sacar de la bbdd
	// si esta activo se mantiene en la base de datos esta materia
	private boolean activo;

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
		return new ArrayList<Materia>(this.correlativas);

	}
	protected void setCorrelativas(Collection<Materia> correlativas) {
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

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public boolean isActivo() {
		return activo;
	}

	// recorda que como tienen throws tiene que tendre su excepcion añadida en el metodo
	public void agregarCorrelativa(Materia correlativaId) throws MateriCorrelativasException {
		if(this.equals(correlativaId)){
			throw new MateriCorrelativasException("una materia no puede ser correlativa a si misma",this,correlativaId);
		}
		if(this.equals(correlativaId)){
			throw new MateriCorrelativasException("esta materia ya es correlativa",this,correlativaId);
		}
		if(correlativaId.isActivo() || this.isActivo()){
			throw new MateriCorrelativasException("la materia no es valida",this,correlativaId);
		}
		this.correlativas.add(correlativaId);
	}
}
