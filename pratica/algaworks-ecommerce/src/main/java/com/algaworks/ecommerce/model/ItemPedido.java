package com.algaworks.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "item_pedido")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="pedido_id")
    private Integer pedidoId;

    @Column(name="produto_id")
    private Integer produtoId;

    @Column(name="preco_produto")
    private BigDecimal precoProduto;

    private Integer quantidade;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemPedido itemPedido = (ItemPedido) o;

        return id.equals(itemPedido.id);
    }


    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
