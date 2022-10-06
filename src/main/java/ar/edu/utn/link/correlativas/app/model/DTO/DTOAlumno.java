package ar.edu.utn.link.correlativas.app.model.DTO;

import ar.edu.utn.link.correlativas.app.model.Alumno;
import org.springframework.data.rest.core.config.Projection;

/*releer esto! */
@Projection(name = "alumno1",types={Alumno.class})
public class DTOAlumno {
/*quiero el nombre completo y la cantidad de materias aprobadas!*/

}
