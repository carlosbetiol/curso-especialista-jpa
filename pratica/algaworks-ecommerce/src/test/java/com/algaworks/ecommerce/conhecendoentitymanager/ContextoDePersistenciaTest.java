package com.algaworks.ecommerce.conhecendoentitymanager;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Produto;
import org.junit.Test;

import java.math.BigDecimal;

public class ContextoDePersistenciaTest extends EntityManagerTest {

    @Test
    public void usarContextoPersistencia() {
        entityManager.getTransaction().begin();

        // coloca o objeto no contexto de persistencia e realiza mudanćas que podem ser commitadas
        Produto produto = entityManager.find(Produto.class, 1);
        // na linha abaixo ocorre uma Dirty Checking (checagem de sujeira, termo usado para ver se algo mudou),
        // ocorre qdo esta no contexto de persistencia
        produto.setPreco(new BigDecimal(100.0));

        Produto produto2 = new Produto();
        produto2.setNome("Caneca para café");
        produto2.setPreco(new BigDecimal(10.0));
        produto2.setDescricao("Boa caneca para café");
        entityManager.persist(produto2); // colocou o objeto no contexto de persistencia

        Produto produto3 = new Produto();
        produto3.setNome("Caneca para chá");
        produto3.setPreco(new BigDecimal(10.0));
        produto3.setDescricao("Boa caneca para chá");
        produto3 = entityManager.merge(produto3); // colocou o objeto no contexto de persistencia

        entityManager.flush(); // apenas para teste, manda o que está pendente para o banco

        // na linha abaixo ocorre uma Dirty Checking (checagem de sujeira, termo usado para ver se algo mudou),
        // ocorre qdo esta no contexto de persistencia
        produto3.setDescricao("Alterar descrićão"); // estando no contexto de persistencia é possivel mudar o valor para ser commitado

        entityManager.getTransaction().commit();

    }
}
