package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.Materia;
import org.springframework.stereotype.Repository;

@Repository
public class RepoMaterias {

    public void save(Materia unaMateria){
        System.out.println(unaMateria);
    }
}
