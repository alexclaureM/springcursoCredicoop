package ar.edu.utn.link.correlativas.app.alumno;

import ar.edu.utn.link.correlativas.Alumno;
import ar.edu.utn.link.correlativas.app.materia.MateriaRepetidaException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public class RepoAlumnosEnMemoria implements RepoAlumnos {

    private List<Alumno> alumnos;
    public RepoAlumnosEnMemoria() {
        super();
        this.alumnos = new ArrayList<>();
    }

    @Override
    public void save(Alumno unAlumno) {
        if(this.existeAlumnoRepetido(unAlumno.getNombre())){
            throw new MateriaRepetidaException("Alumno repetida");
        }
        alumnos.add(unAlumno);

    }

    /*CLASE 22/9 */

    public List<Alumno> all(){
        return this.alumnos;
    }

    /*ESTO NO SE VA A USAR SEGUIDO, PERO ES PARA MOSTRAR Y EJEMPLIFICAR COMO YO LE DOY
     * UN CRITERIO A LA HORA DE MOSTRAR LOS DATOS
     * le digo : traeme 'x' datos , por cada pagina de toda la lista de Materias que haya*/
    public Page<Alumno> page(Pageable page){
        int desde = page.getPageNumber() * page.getPageSize();
        List<Alumno> sublist2 = this.alumnos.subList(desde, desde + page.getPageSize());
        return new PageImpl<Alumno>(sublist2, page, this.alumnos.size());
        // el new PageImpl le tengo que pasar 3 cosas: CONTENIDO, el paginable y EL Total

    }

    public Alumno porNombre(String nombre){
        return this.alumnos.stream().filter(x -> x.getNombre().equals(nombre)).findFirst().get();
    }

    @Override
    public boolean existeAlumnoRepetido(String nombre){
        long count = this.alumnos.stream().filter(x->x.getNombre().equals(nombre)).count();
        return count >0;
    }
}
