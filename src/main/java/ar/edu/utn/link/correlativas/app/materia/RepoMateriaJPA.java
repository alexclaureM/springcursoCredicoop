package ar.edu.utn.link.correlativas.app.materia;

import ar.edu.utn.link.correlativas.model.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/*esta clase reemplazara a RepoMateriaEnMemoria*/
/*debemos confirugar un path*/
@RepositoryRestResource(path = "materia2")
public interface RepoMateriaJPA extends JpaRepository<Materia, Long > {
    /*JpaReposory tendra 2 elementos: UNO, la entidad que MANIPULAREMOS-MATERIA
    * y la otra entidad, el tipo de la ID*/
    /* LA CLASE JpaRepository tendra: un FINDALL, FindSort, findId, saveAll ..etc */
    /* extiende al JpaRepository un PagingAndSortingRepository que tiene una metodos paginables
    /*lo necesario para buscar/guardar x ID*/
    /* el metodo paginable es para las paginas */

}
