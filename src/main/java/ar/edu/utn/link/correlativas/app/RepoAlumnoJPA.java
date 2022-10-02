package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.app.model.Alumno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "alumnos")
public interface RepoAlumnoJPA extends JpaRepository<Alumno,Long> {
    Alumno findAlumnoByNombreAndApellido (String nombre,String apellido); // poara buscar alumno por nombre

    Page<Alumno> findAlumnoByNombre(String nombre, Pageable page);
    //mirar el .docs repository query keywords para ver que funciones se puede utilizar


}
