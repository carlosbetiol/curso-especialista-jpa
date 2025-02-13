package com.algaworks.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@DiscriminatorColumn(name = "tipo_pagamento",
        discriminatorType = DiscriminatorType.STRING)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
@Table(name = "pagamento")
public abstract class Pagamento extends EntidadeBaseInteger {

    @MapsId
    @OneToOne(optional = false)
    @JoinColumn(name="pedido_id")
    private Pedido pedido;

    @Column(length = 30, nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusPagamento status;

}
