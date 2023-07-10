package br.edu.femass.entities;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Aluno extends Leitor{

    
    public Aluno(String nome, String telefone, String email, String matricula) {
        super(nome, telefone, email);
        this.matricula = matricula;
    }

    private String matricula;
   // @ManyToMany(cascade = CascadeType.ALL)
    //private List<Setor> setores = new ArrayList<>();

   // public void addSetor(Setor setor) {
    //    setores.add(setor);    }

    
}
