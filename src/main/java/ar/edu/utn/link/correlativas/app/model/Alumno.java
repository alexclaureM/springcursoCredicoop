package ar.edu.utn.link.correlativas.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "alumno")
public class Alumno {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Long id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	@Transient
	@JsonIgnore
	private List<Curso> cursos;
	@ManyToMany // le debo matchear donde estara la foreig key
	private Collection<Materia>  materiasAprobadas;
	
		
	public Alumno(String nombre) {
		this();
		this.nombre = nombre;
	}
	/*
	public Alumno(String nombre, String apellido){
		this.nombre = nombre;
		this.apellido=apellido;
	}
*/
	public Alumno() {
		this.materiasAprobadas=new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Curso> getCursos() {
		return cursos;
	}
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	public Collection<Materia> getMateriasAprobadas() {
		return  materiasAprobadas;
	}
	public void setMateriasAprovadas(Collection<Materia> materiasAprovadas) {
		this.materiasAprobadas = materiasAprovadas;
	}

	public Long getId() {
		return id;
	}

	public String getApellido() {
		return apellido;
	}

	public void inscribir(Curso curso) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
