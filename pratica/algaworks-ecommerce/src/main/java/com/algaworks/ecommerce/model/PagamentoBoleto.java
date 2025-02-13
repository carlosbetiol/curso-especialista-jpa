package com.algaworks.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@DiscriminatorValue("boleto") // valor a diferenciar na DiscriminatorColumn na tabela Pagamento, usado somente em single table strategy
@Entity
//@Table(name = "pagamento_boleto") // em singletable essa tabela é ignorada, fica tudo na pagamento
//@Table(name = "pagamento_boleto") // na estrategia table_per_class, isso é necessário
public class PagamentoBoleto extends Pagamento {

    @Column(name="codigo_barras", length = 100, nullable = false)
    private String codigoBarras;

}
