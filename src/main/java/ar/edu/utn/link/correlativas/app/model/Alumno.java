package ar.edu.utn.link.correlativas.app.model;

import javax.persistence.*;
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
	private List<Curso> cursos;
	@Transient
	private Collection<Materia>  materiasAprovadas;
	
		
	public Alumno(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Alumno() {
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
	public Collection<Materia> getMateriasAprovadas() {
		return  materiasAprovadas;
	}
	public void setMateriasAprovadas(Collection<Materia> materiasAprovadas) {
		this.materiasAprovadas = materiasAprovadas;
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
