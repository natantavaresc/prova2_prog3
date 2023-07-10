package br.edu.femass.dao;

import jakarta.persistence.Query;

import java.util.List;

import br.edu.femass.entities.Aluno;


public class DaoAluno extends Dao<Aluno>{

    public DaoAluno(Class<Aluno> entity) {
        super(entity);
    }
    public DaoAluno() {
        super(Aluno.class);
    }
    public List<Aluno> findByName(String nome) {
        Query q = em.createQuery("select c from Aluno c where c.nome = '" + nome + "'");
        return q.getResultList();
    }
}
