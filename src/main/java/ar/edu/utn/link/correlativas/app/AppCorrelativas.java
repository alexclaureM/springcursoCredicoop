package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.model.Alumno;
import ar.edu.utn.link.correlativas.model.Materia;
import ar.edu.utn.link.correlativas.app.alumno.RepoAlumnos;
import ar.edu.utn.link.correlativas.app.materia.RepoMaterias;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppCorrelativas {

    /* --> esta variable lo reemplazo como atributo en la linea PULBLIC COMMANDLINE...
    @Autowired
    private RepoMaterias mate;
    */
    @Value("${algo}") /*mecanismo basico para meter valores! usando ressources -> application.properties*/
    private int unNumero;

    @Value("${path}")
    private String path;


    public static void main(String[] args) {
        SpringApplication.run(AppCorrelativas.class, args);
        /*a partir de aca levanto el servicio
         * y le digo que lo que debe correr es la clase
         * */
    }

    @Bean
    public CommandLineRunner ejemplo(RepoMaterias repo, RepoAlumnos repoAlumno) {
        return (cosas) -> {
            repo.save(new Materia("SO",2));
            repo.save(new Materia("Analisis II",2));
            repo.save(new Materia("Fisica",2));
            repo.save(new Materia("Algoritmo",1));
            repo.save(new Materia("DDS",3));

            repoAlumno.save(new Alumno("juanito"));
            repoAlumno.save(new Alumno("ricardo"));
            repoAlumno.save(new Alumno("celmirita"));
            repoAlumno.save(new Alumno("julieta"));
            repoAlumno.save(new Alumno("julia"));

            System.out.println(unNumero);
            System.out.println(path);
        };
    }
}

