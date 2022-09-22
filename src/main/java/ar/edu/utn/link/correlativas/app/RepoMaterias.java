package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.Materia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepoMaterias {
    public void save(Materia unaMateria);


 /* DE LA CLASE 22*9*/

    public List<Materia> all();

    public Page<Materia> page(Pageable page);

    public Materia porNombre(String nombre);

    public List<Materia> porAnio(int anio);
}

