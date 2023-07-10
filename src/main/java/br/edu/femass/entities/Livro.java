package br.edu.femass.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @ManyToOne(cascade = CascadeType.ALL)
    private Genero genero;
    private Integer ano;
    private String edicao;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Autor> autores = new ArrayList<>();
    

    public void addAutor(Autor autor) {
        autores.add(autor);
    }
}
