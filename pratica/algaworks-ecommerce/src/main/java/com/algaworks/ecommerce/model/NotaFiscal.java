package com.algaworks.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "nota_fiscal")
public class NotaFiscal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="pedido_id")
    private Integer pedidoId;

    private String xml;

    @Column(name="data_emissao")
    private Date dataEmissao;

    @Column(name="nota_fiscal_id")
    private Integer notaFiscalId;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    private BigDecimal total;

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
