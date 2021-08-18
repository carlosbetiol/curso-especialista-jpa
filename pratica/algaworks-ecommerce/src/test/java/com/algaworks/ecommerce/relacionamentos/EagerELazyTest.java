package com.algaworks.ecommerce.relacionamentos;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Pedido;
import org.junit.Test;

public class EagerELazyTest extends EntityManagerTest {

    @Test
    public void verificarComportamento() {
        Pedido pedido = entityManager.find(Pedido.class, 1);

        // se o atributo estiver como EAGER (ancioso) na relacao entao nao precisa da linha abaixo, caso LAZY (preguićoso) sim.
//        pedido.getItens().isEmpty();

    }
}
