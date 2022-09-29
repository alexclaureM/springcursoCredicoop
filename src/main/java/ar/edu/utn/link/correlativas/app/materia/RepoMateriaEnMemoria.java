package ar.edu.utn.link.correlativas.app.materia;

import ar.edu.utn.link.correlativas.Materia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RepoMateriaEnMemoria implements RepoMaterias  {

    private List<Materia> materias;

    public RepoMateriaEnMemoria() {
        super();
        this.materias = new ArrayList<>();
    }

    @Override
    public void save(Materia unaMateria) {
        if(this.existeMateriaDeNombre(unaMateria.getNombre())){
            throw new MateriaRepetidaException("materia repetida");
        }
        materias.add(unaMateria);
        //System.out.println("Materia: "+ unaMateria);
    }

    /*CLASE 22/9 */

    public List<Materia> all(){
        return this.materias;
    }

    /*ESTO NO SE VA A USAR SEGUIDO, PERO ES PARA MOSTRAR Y EJEMPLIFICAR COMO YO LE DOY
    * UN CRITERIO A LA HORA DE MOSTRAR LOS DATOS
    * le digo : traeme 'x' datos , por cada pagina de toda la lista de Materias que haya*/
    public Page<Materia> page(Pageable page){
        int desde = page.getPageNumber() * page.getPageSize();
        List<Materia> sublist2 = this.materias.subList(desde, desde + page.getPageSize());
        return new PageImpl<Materia>(sublist2, page, this.materias.size());
        // el new PageImpl le tengo que pasar 3 cosas: CONTENIDO, el paginable y EL Total

    }

    public Materia porNombre(String nombre){
        return this.materias.stream().filter(x -> x.getNombre().equals(nombre)).findFirst().get();
    }

    public List<Materia> porAnio(int anio){
        return this.materias.stream().filter(x -> x.getAnio().equals(anio)).collect(Collectors.toList());
        //Collectors.toList(), debido a que el getAnio es Integer, entonces tiene una pequeña cosa rara
        // que se le debe considerar. es OTRO TIPO DE DATO lo que esta devolviendo , de mayor rango que Int
    }
    @Override
    public boolean existeMateriaDeNombre(String nombre){
        long count = this.materias.stream().filter(x->x.getNombre().equals(nombre)).count();
        return count >0;
    }

}
