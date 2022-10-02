package ar.edu.utn.link.correlativas.app.materia;

import ar.edu.utn.link.correlativas.model.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/*donde iran los END-POINTS*/
@RestController /*PARA QUE SPRING levante este controlador y hacer algo*/
@RequestMapping("/materias") /* defino la api - la ruta para acceder a MATERIAS (solo a esta!)*/
public class MateriasController {

    @Autowired
    RepoMaterias repo;  // por que necesito que levante RepoMateriasEnMemoria y este utiliza RepoMaterias

    /*
    y esto para que es? bueno resulta que es una query para cuando YO QUIERO MATERIAS de forma individual
    se debo agregar al GetMapping el atributo nombreMateira y que esto este en el metodo materia(TYPE nombreMateria)

    @GetMappint(path=("/{nombreMateria}"))
    public List<Materia> materia(@PathVariable(nombreMateria) String unaMateria){
       return repo.porNombre(unaMateria);
       }

       --------------------------------------------------------
    supongamos que el listado de Materias y los traigo a todos... no es mucho traer todo a la vez?
    - y depende, si tengo 300 materias ...y traerlos todo a la vez es feo ya que tal vez 2 personas hagan
    request y explotaria...
    y esto por que pasa? por que tengo repo.all() => este repo no deberia existir!

    @GetMapping("","/")
    public List<Materia> materias() {
        return repo.all();
    }

    entonces como PAGINO? => Lo que deberia hacer es agregar un parametro de cuantos elementos por pagina
    quiero traer
    ===> para traer unos pocos elementos x pagina USO el metodo PAGE() de Spring!
        estara del lado de la interfaz RepoMaterias
    */
    @GetMapping("/")
    public List<Materia> materias() {
        List<Materia> materias = new ArrayList<>();
        return materias;
    }

    /* DE LA CLASE 22/9 */

    @GetMapping("/{nombreDeMateria}")
    public Materia materia(@PathVariable("nombreDeMateria") String nombre) {
        return repo.porNombre(nombre);
    }

    //aca es donde traigo las materias, ya sea por algun parametro estilo materia?=ads , o por anio?=2
    // (en la URL), el PAGEABLE page, me soluciona todo lo referido a las querys consulto.
    // @RequestParam es para tomar algo del QUERYSTRING(algo que yo puedo poner como x ej: anio)
    // que es required= false?. es por si no me meto algun valor, me puede devolver NULO. y rompe pagina.
    // existe defaultValue=0 . que es para que me devuelva


    //GET!!!
    @GetMapping(path = {"", "/"})
    // el Page es propio del spring, con su tipo Materia para que me devuelva las Pagina en si!
    // y Pegeable es de la biblioteca de Spring para el tema de CoutPage and SizePage
    //  se le puede poner un REQUIRED = FALSE , o DEFAULT = null
    public Page<Materia> materias(Pageable page, @RequestParam(value = "anio", required = false) Integer anio) {
        //return repo.all();
        if (anio != null) {
            return new PageImpl<Materia>(repo.porAnio(anio));
        } else {
            return repo.page(page);
        }
    }

    //POST!
    //@valid, es una anotacion que esta para que Valide que la materia es una materia que EXISTA
    // evita escribir otros codigos
    //BindingResult es parte de Spring que nos ayudara a ser mas claro a la hora de devuelva consulta x postma
    // nos dira como fallo o funciono el Json Body con Materia
    @PostMapping("/")
    public String alta(@RequestBody @Valid Materia materia , BindingResult bindingResult) throws MateriaRepetidaException {
        if (bindingResult.hasErrors()) {
            return "No está OK";
        } else {
            repo.save(materia);
            return "Materia generada.";
        }
    }
}