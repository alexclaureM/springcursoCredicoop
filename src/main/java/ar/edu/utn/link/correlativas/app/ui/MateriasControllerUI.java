package ar.edu.utn.link.correlativas.app.ui;

import ar.edu.utn.link.correlativas.app.model.Materia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class MateriasControllerUI {
    /*si quiero mostrar una pagina que metodo htpp debo usar*/

    @GetMapping("materia/{materiaId}")
    public String vistaMateria(@PathVariable("materiaId") Long materiaId , Model model){
            Optional<Materia> materiaOpcional = repo.findById(materiaId);
            model.addAttribute("materiaId",materiaId);
            return "materia";
        }

    @GetMapping("/materia")
    public String vistaMateria(Model model, Pageable page){
        Page<Materia> materias = repo.findAll(page);
        model.addAttribute("materias",materias.getContent());
        return "materias";
    }
}
