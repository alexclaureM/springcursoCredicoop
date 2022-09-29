package ar.edu.utn.link.correlativas.app.materia;

public class MateriaRepetidaException extends RuntimeException {
    private String nombreMateria;

    public MateriaRepetidaException(String materia_repetida) {
        super();
        nombreMateria=materia_repetida;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }
}
