// CRUD - Create Read Update Delete

package com.algaworks.ecommerce.iniciandocomjpa;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Cliente;
import org.junit.Assert;
import org.junit.Test;

public class PrimeiroCrudTest extends EntityManagerTest {

    @Test
    public void inserirRegistro() {
        Cliente cliente = new Cliente();
        cliente.setId(3);
        cliente.setNome("Carlos Betiol");

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteVerificacao = entityManager.find(Cliente.class, 3);
        Assert.assertNotNull(clienteVerificacao);
        Assert.assertEquals("Carlos Betiol", clienteVerificacao.getNome() );

    }

    @Test
    public void buscarPorIdentificador() {
        Cliente cliente = entityManager.find(Cliente.class, 2);

        Assert.assertNotNull(cliente);
    }

    @Test
    public void atualizarRegistro() {
        Cliente cliente = entityManager.find(Cliente.class, 2);

        entityManager.getTransaction().begin();
        cliente.setNome("Tabajara Sheiran");
        entityManager.getTransaction().commit();

        Cliente clienteVerificacao = entityManager.find(Cliente.class, 2);
        Assert.assertNotNull(clienteVerificacao);
        Assert.assertEquals("Tabajara Sheiran", clienteVerificacao.getNome() );

    }

    @Test
    public void removerRegistro() {

        Cliente cliente = entityManager.find(Cliente.class, 1);

        entityManager.getTransaction().begin();
        entityManager.remove(cliente);
        entityManager.getTransaction().commit();

        Cliente clienteVerificacao = entityManager.find(Cliente.class, 1);
        Assert.assertNull(clienteVerificacao);

    }
}
