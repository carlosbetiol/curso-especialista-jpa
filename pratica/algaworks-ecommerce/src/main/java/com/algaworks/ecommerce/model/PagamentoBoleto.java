package com.algaworks.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "pagamento_boleto")
public class PagamentoBoleto extends EntidadeBaseInteger {

    @Column(name="pedido_id")
    private Integer pedidoId;

    @Enumerated(EnumType.STRING)
    private StatusPagamento status;

    @Column(name="codigo_barras")
    private String codigoBarras;

}
