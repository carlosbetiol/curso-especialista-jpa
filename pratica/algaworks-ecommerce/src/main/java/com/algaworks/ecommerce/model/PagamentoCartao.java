package com.algaworks.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@DiscriminatorValue("cartao") // valor a diferenciar na DiscriminatorColumn na tabela Pagamento, usado somente em single table strategy
@Entity
//@Table(name = "pagamento_cartao") // em singletable essa tabela é ignorada, fica tudo na pagamento
//@Table(name = "pagamento_cartao") // na estrategia table_per_class, isso é necessário
public class PagamentoCartao extends Pagamento {

    @Column(name = "numero_cartao")
    private String numeroCartao;

}
