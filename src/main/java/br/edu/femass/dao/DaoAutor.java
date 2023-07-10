package br.edu.femass.dao;

import jakarta.persistence.Query;

import java.util.List;
import br.edu.femass.entities.Autor;


public class DaoAutor extends Dao<Autor>{

    public DaoAutor(Class<Autor> entity) {
        super(entity);
    }
    public DaoAutor() {
        super(Autor.class);
    }
    public List<Autor> findByName(String nome) {
        Query q = em.createQuery("select c from Aluno c where c.nome = '" + nome + "'");
        return q.getResultList();
    }
}
