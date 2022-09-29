package ar.edu.utn.link.correlativas.app.alumno;

public class AlumnoRepetidoException extends Exception {
    private String nombre;
    public AlumnoRepetidoException( String nombree) {
        this.nombre = nombree;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
