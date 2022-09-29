package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.app.materia.MateriaRepetidaException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

// se activa cuando hay un error
@ControllerAdvice
public class GlobalExceptionHandler {
    // cuando salte un error y que ningun proceso lo agarra, que agarre esta excepcion
    @ExceptionHandler(MateriaRepetidaException.class)
    @ResponseBody // para que lo muestre en el body esta excepcion con su mensaje
    @ResponseStatus(HttpStatus.CONFLICT) // para que me marque en el body que tipo de estado se encontrara la excepcion
    String materiaRepetida(MateriaRepetidaException ex){
        return "la materia " + ex.getNombreMateria() + " ya existe";
    }
}
