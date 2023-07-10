package br.edu.femass.dao;
import jakarta.persistence.Query;
import java.util.List;
import br.edu.femass.entities.Professor;


public class DaoProfessor extends Dao<Professor>{

    public DaoProfessor(Class<Professor> entity) {
        super(entity);
    }
    public DaoProfessor() {
        super(Professor.class);
    }
    public List<Professor> findByName(String nome) {
        Query q = em.createQuery("select c from Aluno c where c.nome = '" + nome + "'");
        return q.getResultList();
    }
}
