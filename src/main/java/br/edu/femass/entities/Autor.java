package br.edu.femass.entities;

import jakarta.persistence.*;
import lombok.*;



@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobreNome;


    public Autor(String nome, String sobreNome) {
        this.nome = nome;
        this.sobreNome = sobreNome;
    }


    @Override
    public String toString() {
        return "Autor [nome=" + nome + ", sobreNome=" + sobreNome + "]";
    }
    

}
