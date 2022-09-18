package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController /*PARA QUE SPRING levante este controlador y hacer algo*/
@RequestMapping("/materias") /* defino la api - la ruta*/
public class MateriasController  {

    @GetMapping("/")
    public List<Materia> materias(){
        List<Materia> materias = new ArrayList<>();
        return materias;
    }
}
