package com.algaworks.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "nota_fiscal")
public class NotaFiscal {

    @Id
    @Column(name = "pedido_id")
    private Integer id;

    @MapsId // com isso, ao tentar persistir nao precisa fazer setId direto, ele pega daqui.
    @OneToOne(optional = false)
//    @JoinColumn(name="pedido_id", insertable = false, updatable = false)
    @JoinColumn(name="pedido_id") // usando MapsId remove-se insertable e updatable
    private Pedido pedido;

    @Lob
    private byte[] xml;

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
