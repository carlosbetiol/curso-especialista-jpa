package com.algaworks.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Setter
@Getter
@Entity
@Table(name = "pagamento_cartao")
public class PagamentoCartao {

    @Id
    private Integer id;

    @Column(name="pedido_id")
    private Integer pedidoId;

    @Enumerated(EnumType.STRING)
    private StatusPagamento status;

    private String numero;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PagamentoCartao pagamentoCartao = (PagamentoCartao) o;

        return id.equals(pagamentoCartao.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
