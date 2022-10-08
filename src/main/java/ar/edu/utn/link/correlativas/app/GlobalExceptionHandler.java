package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.app.materia.MateriaRepetidaException;
import ar.edu.utn.link.correlativas.app.model.MateriCorrelativasException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

// se activa cuando hay un error
@ControllerAdvice
public class GlobalExceptionHandler {
    // cuando salte un error y que ningun proceso lo agarra, que agarre esta excepcion
    // ES OTRA FORMA DE QUE AGARRE LOS THROWS EXCEPTIONS
    // ES MAS QUE NADA POR SI NO LLEGUE A DEFINIR UNA EXCEPCION A MANOPLA
    // LO DEFINO A ALGO MAS GLOBAL
    // Y TIENE QUE IR EN EL NOMBRE DEL METODO THROWS EXCEPTION
    @ExceptionHandler(MateriaRepetidaException.class)
    @ResponseBody // para que lo muestre en el body esta excepcion con su mensaje
    @ResponseStatus(HttpStatus.CONFLICT) // para que me marque en el body que tipo de estado se encontrara la excepcion
    String materiaRepetida(MateriaRepetidaException ex){
        return "la materia " + ex.getNombreMateria() + " ya existe";
    }


    /* ESTOS METODOS SON PARA HABER EXCEPCIONES MAS GLOBALES
    * YA QUE BUENO, SI NO QUIERO AGREGAR EL TRY CATCH EN EL METODO
    *  DEFINO ESTO DE FORMA GLOBAL Y CUANDO LLEGUE A ESE METODO Y SURGA UN ERROR
    * DEBIDO A QUE TENGO EL EXCEPTIONHANDLER (claseExcepcion clas)
    * va a venir a ese lado y se complementara con esta clase GLOBAL*/
    @ExceptionHandler(MateriCorrelativasException.class)
    @ResponseBody // para que lo muestre en el body esta excepcion con su mensaje
    @ResponseStatus(HttpStatus.CONFLICT) // para que me marque en el body que tipo de estado se encontrara la excepcion
    String correlativaMal(MateriCorrelativasException ex){
        return ex.getLocalizedMessage();
    }

}
