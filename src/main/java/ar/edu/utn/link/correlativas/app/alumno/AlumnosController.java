package ar.edu.utn.link.correlativas.app.alumno;

import ar.edu.utn.link.correlativas.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/alumnos")
public class AlumnosController {
    @Autowired(required = true)
    RepoAlumnos repoAl;

    @GetMapping(path = {"", "/"})
    // el Page es propio del spring, con su tipo Materia para que me devuelva las Pagina en si!
    // y Pegeable es de la biblioteca de Spring para el tema de CoutPage and SizePage
    //  se le puede poner un REQUIRED = FALSE , o DEFAULT = null
    public Page<Alumno> alumnos(Pageable page) {
            return repoAl.page(page);
    }

    @PostMapping("/")
    public String alta(@RequestBody @Valid Alumno alumno , BindingResult bindingResult) throws AlumnoRepetidoException {
        if (bindingResult.hasErrors()) {
            return "No está OK";
        } else {
            repoAl.save(alumno);
            return "Materia generada.";
        }
    }


}
