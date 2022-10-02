package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.app.model.Materia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

/*esta clase reemplazara a RepoMateriaEnMemoria*/
/*debemos confirugar un path*/
@RepositoryRestResource(path = "materias") // nos ahorramos el tema del get-post
public interface RepoMateriaJPA extends JpaRepository<Materia, Long > {
    /*JpaReposory tendra 2 elementos: UNO, la entidad que MANIPULAREMOS-MATERIA
    * y la otra entidad, el tipo de la ID*/
    /* LA CLASE JpaRepository tendra: un FINDALL, FindSort, findId, saveAll ..etc */
    /* extiende al JpaRepository un PagingAndSortingRepository que tiene una metodos paginables
    /*lo necesario para buscar/guardar x ID*/
    /* el metodo paginable es para las paginas */
    // BUSCO UNA MATERIA POR AÑO
    // QUE DEBERIA DEVOLVER ? -> LISTA DE MATERIAS -- PAGINA DE MATERIAS
    Page<Materia> findByAnio(Integer anio,Pageable page);
    /*esto ya devuelve una pagina!*/
    Materia findByNombre(String nombreMateria);

    @Override
    @RestResource(exported=false) // para evitar que no se mande automaticamente
    void deleteById(Long id);

    @Override
    @RestResource(exported=false)
    void delete(Materia id);
}
