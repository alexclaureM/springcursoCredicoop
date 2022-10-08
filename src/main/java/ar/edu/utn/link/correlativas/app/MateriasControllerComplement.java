package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.app.model.MateriCorrelativasException;
import ar.edu.utn.link.correlativas.app.model.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.xml.ws.Response;
import java.util.Optional;

@RepositoryRestController
/* esta anotacion es importante
* con esto decimos : vas a hacer algo que va a complementar o ayudar a un
* rest controller
* le digo a spring que lo va a gestionarlo
* y va a estar relacionado con la api que estas exponiendo (RESTcontroller)
* */
public class MateriasControllerComplement {

    @Autowired
    RepoMateriaJPA repo;

    // con este metodo piso los @verride @restRESOURCE delet de materiaJPA
    @Transactional
    /* va el path completo*/
    @DeleteMapping("/materias/{materiaId}")
    //{materiaId} debe coincidir con variable DE @pathVariable(materiaID)
    public @ResponseBody ResponseEntity<Object> delete(@PathVariable("materiaId") Long materiaId) {
        // Materia materia = repo.findAllById(materiId);
        /* para no andar controlando si existe o NO mejor colocar OPCIONAL*/
        Optional<Materia> materiaOpcional = repo.findById(materiaId);

        //para evitar que lo referenceen una vez "dado de baja" ...
        // o para evitar romper el programa debido a x ejemplo un id que no existe en la bbdd
        if (materiaOpcional.isPresent()) {
            Materia materia = materiaOpcional.get();
            if (materia.isActivo()) { /* para decir si la materia esta activa o no*/
                materia.setActivo(false);
                return ResponseEntity.ok("materia borrada ok");
            }
        }
        // materiaOpcional.get().setActivo(false);
        return ResponseEntity.notFound().build(); // "la materia no existe"
        // el notFound esta armado para estos casos...
        // return new ResponseEntity <Object> ("la materia no exsite",HttpsStatus.NOT_FOUND);


        // repo.save(materia)
        /* no siempre querre guardar ALGO con el repo.save()
         * por ahi querre guardar una coleccion
         * y si quiero guarda muchos?
         * debo agregar una anotacion @transactional
         *   que sirve para que cuando trabaje con muchos datos
         *   al final de todo haga un commit de que debe hacer un save*/

        // todo lo extra que no esta contemplado en LA ABM
        // -->lo debo definir en materiasControlerComplement
    }


    /*para agregar las materias correlativas a la lista*/
    /* cada operacion es independiente a la anterior */
    @PostMapping("materias/{materiaId}/correlativas")
    public @ResponseBody ResponseEntity<Object> agregarCorrelativa(@PathVariable("materiaId") Long materiaId, @RequestBody Long correlativaId){
        // le tengo que pasar el body para obtener

        /* validar input y obtener objetos (de la capa de datos) */
        Optional<Materia> materiaOpcional = repo.findById(materiaId); // valido que la materia exista
        Optional<Materia> materiaCorrelativaOpcional = repo.findById(materiaId);
        // busco las materias correspondientes a esas correlativas
        // pero con esto afirmo de que las materias opcionales ya existen

        // pero si no existe? => entonces necesito validar x si no existe
        if(!materiaOpcional.isPresent() ||  !materiaCorrelativaOpcional.isPresent()){
            return ResponseEntity.notFound().build(); // por si no existe
        }
        Materia materia = materiaOpcional.get();
        Materia correlativa = materiaCorrelativaOpcional.get();
        /* **************** esta parte de agregar materia es del dominio y al usarlo en esta capa, debe ser lo mas chico posible */
        try{
            materia.agregarCorrelativa(correlativa);
        }   catch(MateriCorrelativasException ex){
            return new ResponseEntity<Object>(ex.getLocalizedMessage(),HttpStatus.BAD_REQUEST);
        }
       //ALTERNATIVA 1

        //materia.getCorrelativas().add(materiaCorrelativaOpcional.get());

        /* ************* la respuesta al usuario ******************** */
        return ResponseEntity.ok().build();
    }
}
