package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.app.alumno.RepoAlumnos;
import ar.edu.utn.link.correlativas.app.model.Alumno;
import ar.edu.utn.link.correlativas.app.model.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@RepositoryRestResource
public class AlumnosControllerComplement {

    @Autowired
    RepoAlumnoJPA repoAl;
    @Autowired
    RepoMateriaJPA repo;

    @PostMapping("/alumnos/{alumnoId}/materiaAprobada")
    public @ResponseBody ResponseEntity<Object> agregarMateriaAprobada(@PathVariable("alumnoId") Long alumnoId,@RequestBody Long dd){
        Optional<Alumno> alumnoOpcional = repoAl.findById(alumnoId);
        Optional<Materia> materiaOpcional = repo.findById(alumnoId);
        if(!alumnoOpcional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        Alumno alumno = alumnoOpcional.get();
        Materia materia = materiaOpcional.get();
        return null;
    }

}
