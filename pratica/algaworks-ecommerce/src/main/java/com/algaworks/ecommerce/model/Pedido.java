package com.algaworks.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente; // pega cliente_id de forma automatica qdo nao tem mapeamento de coluna

    @Column(name="data_pedido")
    private LocalDateTime dataPedido;

    @Column(name="data_conclusao")
    private LocalDateTime dataConclusao;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    private BigDecimal total;

    @OneToOne(mappedBy = "pedido")
    private PagamentoCartao pagamento;

    @OneToOne(mappedBy = "pedido")
    private NotaFiscal notafiscal;

    @Embedded
    private EnderecoEntregaPedido enderecoEntrega;

    @OneToMany(mappedBy = "pedido", fetch = FetchType.EAGER )
    private List<ItemPedido> itens;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pedido pedido = (Pedido) o;

        return id.equals(pedido.id);
    }


    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
