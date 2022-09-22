package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController /*PARA QUE SPRING levante este controlador y hacer algo*/
@RequestMapping("/materias") /* defino la api - la ruta*/
public class MateriasController {

    @Autowired
    RepoMaterias repo;


    @GetMapping("/")
    public List<Materia> materias() {
        List<Materia> materias = new ArrayList<>();
        return materias;
    }

    /* DE LA CLASE 22/9 */
    @GetMapping(path = {"", "/"})
    public Page<Materia> materias(Pageable page, @RequestParam(value = "anio", required = false) Integer anio) {
        //return repo.all();
        if (anio != null) {
            return new PageImpl<Materia>(repo.porAnio(anio));
        } else {
            return repo.page(page);
        }
    }

    @GetMapping("/{nombre}")
    public Materia materia(@PathVariable("nombre") String nombre) {
        return repo.porNombre(nombre);
    }

    @PostMapping("/")
    public String alta(@RequestBody @Valid Materia materia, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "No está OK";
        } else {
            repo.save(materia);
            return "Materia generada.";
        }
    }
}