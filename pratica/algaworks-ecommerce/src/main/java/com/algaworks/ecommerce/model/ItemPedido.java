package com.algaworks.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Setter
@Getter
@Entity
@Table(name = "item_pedido")
public class ItemPedido {

    @EmbeddedId
    private ItemPedidoId id;

    @MapsId("pedidoId") // é o atributo na classe EmbeddedId referente ao id do pedido
    @ManyToOne(optional = false)
//    @JoinColumn(name="pedido_id", insertable = false, updatable = false)
    @JoinColumn(name="pedido_id") // com MapsId nao se usa insertable e updatable
    private Pedido pedido;

    @MapsId("produtoId") // é o atributo na classe EmbeddedId referente ao id do produto
    @ManyToOne(optional = false)
//    @JoinColumn(name="produto_id", insertable = false, updatable = false)
    @JoinColumn(name="produto_id") // com MapsId nao se usa insertable e updatable
    private Produto produto;

    @Column(name="preco_produto")
    private BigDecimal precoProduto;

    private Integer quantidade;


}
