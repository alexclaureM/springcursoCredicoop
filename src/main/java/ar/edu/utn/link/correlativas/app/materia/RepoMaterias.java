package ar.edu.utn.link.correlativas.app.materia;

import ar.edu.utn.link.correlativas.app.model.Materia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;



// no lo usariamos mas --> usamos REPOMATEERIAJPA
@Repository
public interface RepoMaterias {
    public void save(Materia unaMateria) throws MateriaRepetidaException;

    public List<Materia> all();

    /*
    * Page<Materia> page(int nroPage, int size);
    * este metodo servira para paginar, donde un variable sea numero de pagina, y lo otro la variable
    * */
    public Page<Materia> page(Pageable page);

    public Materia porNombre(String nombre);

    public List<Materia> porAnio(int anio);

    boolean existeMateriaDeNombre(String nombre);
}

