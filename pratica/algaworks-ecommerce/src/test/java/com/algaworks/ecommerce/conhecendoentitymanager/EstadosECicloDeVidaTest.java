package com.algaworks.ecommerce.conhecendoentitymanager;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Categoria;
import org.junit.Test;

public class EstadosECicloDeVidaTest extends EntityManagerTest {

    @Test
    public void analisarEstados() {
        // estado transiente ou novo
        Categoria categoriaNovo = new Categoria();

        // categoria nova passa a ser gerenciada (o retorno passa a ser gerenciado)
        Categoria categoriaGerenciadaMerge = entityManager.merge(categoriaNovo);

        // estado gerenciado
        Categoria categoriaGerenciada = entityManager.find(Categoria.class, 1);

        // estado removed
        entityManager.remove(categoriaGerenciada);
        // volta ela para o estado gerenciado
        entityManager.persist(categoriaGerenciada);

        // estado detached (desanexado)
        entityManager.detach(categoriaGerenciada);
    }
}
