package com.algaworks.ecommerce.model;

import com.algaworks.ecommerce.listener.GenericoListener;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@EntityListeners({ GenericoListener.class })
@Entity
@Table(name = "produto", uniqueConstraints = { @UniqueConstraint(name = "unq_nome", columnNames = { "nome" })},
        indexes = { @Index(name = "idx_nome", columnList = "nome")})
public class Produto extends EntidadeBaseInteger {

    @Column(length =  100, nullable = false) // nome varchar(255) quando nao especifica
    private String nome;

    @Column(columnDefinition = "varchar(275) not null default 'descricao'")
    private String descricao;

    private BigDecimal preco;

    @ManyToMany
    @JoinTable(name = "produto_categoria",
        joinColumns = @JoinColumn(name = "produto_id"),
        inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private List<Categoria> categorias;

    @OneToOne(mappedBy = "produto")
    private Estoque estoque;

    @Column(name="data_criacao", updatable = false, nullable = false)
    private LocalDateTime dataCriacao;

    @Column(name="data_ultima_atualizacao", insertable = false)
    private LocalDateTime dataUltimaAtualizacao;

    @ElementCollection
    @CollectionTable(name = "produto_tag",
            joinColumns = @JoinColumn(name = "produto_id"))
    @Column(name = "tag", length = 50, nullable = false)
    private List<String> tags;

    @ElementCollection
    @CollectionTable(name = "produto_atributo",
            joinColumns = @JoinColumn(name = "produto_id"))
    private List<Atributo> atributos;

    @Lob
    private byte[] foto;

}
