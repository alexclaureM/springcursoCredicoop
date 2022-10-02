package ar.edu.utn.link.correlativas.app.alumno;

import ar.edu.utn.link.correlativas.app.model.Alumno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoAlumnos {
     public void save(Alumno unAlumno) throws AlumnoRepetidoException;

     public Page<Alumno> page(Pageable page);

     public Alumno porNombre(String nombre);

     boolean existeAlumnoRepetido(String nombre);

}
