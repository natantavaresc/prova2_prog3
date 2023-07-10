package br.edu.femass.dao;
import jakarta.persistence.Query;
import java.util.List;
import br.edu.femass.entities.Genero;

public class DaoGenero extends Dao<Genero>{

    public DaoGenero(Class<Genero> entity) {
        super(entity);
    }
    public DaoGenero() {
        super(Genero.class);
    }
    public List<Genero> findByName(String nome) {
        Query q = em.createQuery("select c from Aluno c where c.nome = '" + nome + "'");
        return q.getResultList();
    }
}