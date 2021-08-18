package com.algaworks.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "pagamento_cartao", uniqueConstraints = {
        @UniqueConstraint(name="uk_npagamento_cartao_pedido_id", columnNames = { "pedido_id"} )
})
public class PagamentoCartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(optional = false)
    @JoinColumn(name="pedido_id")
    private Pedido pedido;

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
