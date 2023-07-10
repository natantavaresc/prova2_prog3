package br.edu.femass.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Professor extends Leitor{
    private String formacao;

    public Professor(String nome, String telefone, String email, String formacao) {
        super(nome, telefone, email);
        this.formacao = formacao;
    }

    
   // @ManyToMany(cascade = CascadeType.ALL)
    //private List<Setor> setores = new ArrayList<>();

   // public void addSetor(Setor setor) {
    //    setores.add(setor);    }
}
