package com.algaworks.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "nota_fiscal", uniqueConstraints = {
        @UniqueConstraint(name="uk_nota_fiscal_pedido_id", columnNames = { "pedido_id"} )
})
public class NotaFiscal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(optional = false)
    @JoinColumn(name="pedido_id")
    private Pedido pedido;

    private String xml;

    @Column(name="data_emissao")
    private Date dataEmissao;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NotaFiscal notaFiscal = (NotaFiscal) o;

        return id.equals(notaFiscal.id);
    }


    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
