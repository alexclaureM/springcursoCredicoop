package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.Materia;
import org.springframework.beans.factory.annotation.Autowired;
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

    public static void main(String[] args) {
        SpringApplication.run(AppCorrelativas.class, args);
        /*a partir de aca levanto el servicio
         * y le digo que lo que debe correr es la clase
         * */
    }

    @Bean
    public CommandLineRunner ejemplo(RepoMateriaEnMemoria repo) {
        return (cosas) -> {
            repo.save(new Materia("SO"));
            System.out.println(unNumero);
        };
    }
}

