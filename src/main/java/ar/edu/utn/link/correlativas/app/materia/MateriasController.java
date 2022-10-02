package ar.edu.utn.link.correlativas.app.materia;

import ar.edu.utn.link.correlativas.app.RepoMateriaJPA;
import ar.edu.utn.link.correlativas.app.model.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/*donde iran los END-POINTS*/
@RestController /*PARA QUE SPRING levante este controlador y hacer algo*/
@RequestMapping("/materias_old") /* defino la api - la ruta para acceder a MATERIAS (solo a esta!)*/
public class MateriasController {

    @Autowired
    RepoMateriaJPA repo;  // por que necesito que levante RepoMateriasEnMemoria y este utiliza RepoMaterias
    //otra forma seria por constructor y los instancie, pero en tienpo de ejecucion, pide mucha memoria y colpasa

    @GetMapping("/")
    public List<Materia> materias() {
        List<Materia> materias = new ArrayList<>();
        return materias;
    }
/*DEBIDO A QUE ESTOY USANDO REPOMATERIAJPA MateriaController.class estaria dejandose a un lado*/
    //pero LOS CONTROLLERS SON HECHO PARA QUE LOS CLIENTES LO USEN DESDE AFUERA!
/*
    @GetMapping("/{nombreDeMateria}")
    public Materia materia(@PathVariable("nombreDeMateria") String nombre) {
        return repo.findByNombre(nombre);
    }


    //GET!!!
    @GetMapping(path = {"", "/"})
    public Page<Materia> materias(Pageable page, @RequestParam(value = "anio", required = false) Integer anio) {
        //return repo.all();
        if (anio != null) {
            return repo.findByAnio(anio,page);
        } else {
            return repo.findAll(page);
        }
    }


    @PostMapping("/")
    public String alta(@RequestBody @Valid Materia materia , BindingResult bindingResult) throws MateriaRepetidaException {
        if (bindingResult.hasErrors()) {
            return "No está OK";
        } else {
            repo.save(materia);
            return "Materia generada.";
        }
    }
*/

}