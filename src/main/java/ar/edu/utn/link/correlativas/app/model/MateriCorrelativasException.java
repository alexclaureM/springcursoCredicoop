package ar.edu.utn.link.correlativas.app.model;

public class MateriCorrelativasException extends Exception{

    private  Materia correlativa;
    private Materia materia;

    public MateriCorrelativasException() {
        super();
    }

    public MateriCorrelativasException(String message) {
        super(message);
    }

    public MateriCorrelativasException(String message, Materia materia , Materia correlativa) {
        super(message);
        this.materia = materia;
        this.correlativa = correlativa;
    }
    public MateriCorrelativasException(String message, Throwable cause) {
        super(message, cause);
    }

    public MateriCorrelativasException(Throwable cause) {
        super(cause);
    }

    public MateriCorrelativasException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
