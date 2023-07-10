package br.edu.femass.dao;

import jakarta.persistence.Query;

import java.util.List;

import br.edu.femass.entities.Usuario;

public class DaoUsuario extends Dao<Usuario>{

    public DaoUsuario(Class<Usuario> entity) {
        super(entity);
    }
    public DaoUsuario() {
        super(Usuario.class);
    }
    public List<Usuario> findByName(String nome) {
        Query q = em.createQuery("select c from Usuario c where c.nome = '" + nome + "'");
        return q.getResultList();
    }
}
