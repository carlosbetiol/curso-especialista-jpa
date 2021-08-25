package com.algaworks.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "estoque")
public class Estoque extends EntidadeBaseInteger{

    @OneToOne(optional = false)
    @JoinColumn(name="produto_id")
    private Produto produto;

    @Column()
    private Integer quantidade;

}
