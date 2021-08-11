package com.algaworks.ecommerce.iniciandocomjpa;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Produto;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class OperacoesComTransacaoTest extends EntityManagerTest {

    @Test
    public void impedirOperacaoComBancoDeDados() {

        Produto produto = entityManager.find(Produto.class, 1);

        entityManager.detach(produto);

        entityManager.getTransaction().begin();
        produto.setNome("Kindle Paperwhite 2 geraćao");
        // entityManager.merge(produto); // dessa forma nao precisa do merge pq o objeto ja é gerenciado pelo entityManager qdo deu find
        entityManager.getTransaction().commit();

        entityManager.clear(); // forća buscar da base de dados para fazer a asserćão, caso contrário pega do cache do objeto entityManager

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
        Assert.assertNotNull(produtoVerificacao);
        Assert.assertEquals("Kindle", produtoVerificacao.getNome());

    }

    @Test
    public void mostrarDiferencaPersistMerge() {

        Produto produtoPersist = new Produto();
        produtoPersist.setId(5);
        produtoPersist.setNome("Smartphone One Plus");
        produtoPersist.setDescricao("O processador mais rápido.");
        produtoPersist.setPreco(new BigDecimal(2000));

        entityManager.getTransaction().begin();
        entityManager.persist(produtoPersist); // insere e coloca o objeto como gerenciado
        produtoPersist.setNome("Smartphone Two Plus"); // faz o update uma vez que o ojbeto esta gerenciado pelo entityManager
        entityManager.getTransaction().commit();

        entityManager.clear(); // forća buscar da base de dados para fazer a asserćão, caso contrário pega do cache do objeto entityManager

        Produto produtoVerificacaoPersist = entityManager.find(Produto.class, produtoPersist.getId());
        Assert.assertNotNull(produtoVerificacaoPersist);

        Produto produtoMerge = new Produto();
        produtoMerge.setId(6);
        produtoMerge.setNome("Notebook Dell");
        produtoMerge.setDescricao("O melhor da categoria.");
        produtoMerge.setPreco(new BigDecimal(2000));

        entityManager.getTransaction().begin();
        entityManager.merge(produtoMerge); // insert mas nao coloca o objeto como gerenciado para resolver poderia usar a linha abaixo
//        produtoMerge = entityManager.merge(produtoMerge);
        produtoMerge.setNome("Notebook Dell 2"); // essa linha nao atualiza a tabela pq o objeto nao fica gerenciado qdo usa merge
        entityManager.getTransaction().commit();

        entityManager.clear(); // forća buscar da base de dados para fazer a asserćão, caso contrário pega do cache do objeto entityManager

        Produto produtoVerificacaoMerge = entityManager.find(Produto.class, produtoMerge.getId());
        Assert.assertNotNull(produtoVerificacaoMerge);


    }

    @Test
    public void insertirObjetoComMerge() {

        Produto produto = new Produto();
        produto.setId(4);
        produto.setNome("Microfone Rode Videmic");
        produto.setDescricao("A melhor qualidade de som.");
        produto.setPreco(new BigDecimal(1000));

        entityManager.getTransaction().begin();
        entityManager.merge(produto);
        entityManager.getTransaction().commit();

        entityManager.clear(); // forća buscar da base de dados para fazer a asserćão, caso contrário pega do cache do objeto entityManager

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
        Assert.assertNotNull(produtoVerificacao);
        Assert.assertEquals("Microfone Rode Videmic", produtoVerificacao.getNome());

    }

    @Test
    public void atualizarObjetoGerenciado() {

        Produto produto = entityManager.find(Produto.class, 1);


        entityManager.getTransaction().begin();
        produto.setNome("Kindle Paperwhite 2 geraćao");
        // entityManager.merge(produto); // dessa forma nao precisa do merge pq o objeto ja é gerenciado pelo entityManager qdo deu find
        entityManager.getTransaction().commit();

        entityManager.clear(); // forća buscar da base de dados para fazer a asserćão, caso contrário pega do cache do objeto entityManager

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
        Assert.assertNotNull(produtoVerificacao);
        Assert.assertEquals("Kindle Paperwhite 2 geraćao", produtoVerificacao.getNome());

    }

    @Test
    public void atualizarObjeto() {

        Produto produto = new Produto();
        produto.setId(1);
        produto.setNome("Kindle Paperwhite");
        produto.setDescricao("Conheca o novo Kindle.");
        produto.setPreco(new BigDecimal(599));
        // quando o objeto é novo e criado desta forma, todos os atributos devem ser preenchidos caso contrário ficarao como null

        entityManager.getTransaction().begin();
        entityManager.merge(produto);
        entityManager.getTransaction().commit();

        entityManager.clear(); // forća buscar da base de dados para fazer a asserćão, caso contrário pega do cache do objeto entityManager

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
        Assert.assertNotNull(produtoVerificacao);
        Assert.assertEquals("Kindle Paperwhite", produtoVerificacao.getNome());

    }

    @Test
    public void removerObjeto() {

        Produto produto = entityManager.find(Produto.class, 3);

        entityManager.getTransaction().begin();
        entityManager.remove(produto);
        entityManager.getTransaction().commit();

//        entityManager.clear(); // nao é necessário na asserćao para operaáo de remoćao.

        Produto produtoVerificacao = entityManager.find(Produto.class, 3);
        Assert.assertNull(produtoVerificacao);

    }

    @Test
    public void inserirOPrimeiroObjeto() {
        Produto produto = new Produto()    ;

        produto.setId(2);
        produto.setNome("Câmera Canon");
        produto.setDescricao("A melhor definićão para suas fotos");
        produto.setPreco(new BigDecimal(5000));

        entityManager.getTransaction().begin();
        entityManager.persist(produto);
        entityManager.getTransaction().commit();

        entityManager.clear(); // forća buscar da base de dados para fazer a asserćão, caso contrário pega do cache do objeto entityManager

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
        Assert.assertNotNull(produtoVerificacao);

    }


    @Test
    public void abrirEFecharATransacao() {
//        Produto produto = new Produto(); // Sometne para o método não mostrar erros

        entityManager.getTransaction().begin();

//        entityManager.persist(produto);
//        entityManager.merge(produto);
//        entityManager.remove(produto);

        entityManager.getTransaction().commit();
    }
}
