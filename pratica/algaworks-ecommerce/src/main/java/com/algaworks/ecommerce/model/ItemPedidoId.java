package com.algaworks.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ItemPedidoId implements Serializable {

    @Column(name = "pedido_id")
    private Integer pedidoId;

    @Column(name = "produto_id")
    private Integer produtoId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemPedidoId that = (ItemPedidoId) o;

        if (!pedidoId.equals(that.pedidoId)) return false;
        return produtoId.equals(that.produtoId);
    }

    @Override
    public int hashCode() {
        int result = pedidoId.hashCode();
        result = 31 * result + produtoId.hashCode();
        return result;
    }
}
