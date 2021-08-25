package com.algaworks.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "nota_fiscal")
public class NotaFiscal extends EntidadeBaseInteger{

    @MapsId // com isso, ao tentar persistir nao precisa fazer setId direto, ele pega daqui.
    @OneToOne(optional = false)
//    @JoinColumn(name="pedido_id", insertable = false, updatable = false)
    @JoinColumn(name="pedido_id") // usando MapsId remove-se insertable e updatable
    private Pedido pedido;

    @Lob
    @Column(nullable = false)
    private byte[] xml;

    @Column(name="data_emissao", nullable = false)
    private Date dataEmissao;

}
