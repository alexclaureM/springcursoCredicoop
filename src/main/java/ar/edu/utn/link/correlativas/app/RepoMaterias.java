package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.Materia;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoMaterias {

    public void save(Materia unaMateria);
    }

