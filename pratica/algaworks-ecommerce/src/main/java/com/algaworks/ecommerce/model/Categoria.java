package com.algaworks.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "categoria", uniqueConstraints = { @UniqueConstraint(name = "unq_nome", columnNames = { "nome" })})
public class Categoria extends EntidadeBaseInteger{

    @Column(length = 100, nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name="categoria_pai_id")
    private Categoria categoriaPai;

    @OneToMany(mappedBy = "categoriaPai")
    private List<Categoria> categorias;

    @ManyToMany(mappedBy = "categorias")
    private List<Produto> produtos;

}
