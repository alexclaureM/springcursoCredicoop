package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.Materia;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepoMateriaEnMemoria implements RepoMaterias  {

    private List<Materia> materias;

    public RepoMateriaEnMemoria() {
        super();
        this.materias = new ArrayList<>();
    }

    @Override
    public void save(Materia unaMateria) {
        materias.add(unaMateria);
        System.out.println(unaMateria);
    }

}
