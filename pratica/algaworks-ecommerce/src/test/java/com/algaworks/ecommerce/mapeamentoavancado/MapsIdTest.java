package com.algaworks.ecommerce.mapeamentoavancado;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Date;

public class MapsIdTest extends EntityManagerTest {

    @Test
    public void inserirPagamento() {
        Pedido pedido = entityManager.find(Pedido.class, 1);

        NotaFiscal notafiscal = new NotaFiscal();
//        notafiscal.setId(pedido.getId()); // como na classe tem o MapsId, essa linha não é necessária
        notafiscal.setPedido(pedido);
        notafiscal.setDataEmissao(new Date());
        notafiscal.setXml("<xml/>".getBytes());

        entityManager.getTransaction().begin();
        entityManager.persist(notafiscal);
        entityManager.getTransaction().commit();

        entityManager.clear();

        NotaFiscal notaFiscalVerificacao = entityManager.find(NotaFiscal.class, notafiscal.getId());
        Assert.assertNotNull(notaFiscalVerificacao);
        Assert.assertEquals(pedido.getId(), notaFiscalVerificacao.getId());

    }

    @Test
    public void inserirItemPedido() {
        Cliente cliente = entityManager.find(Cliente.class, 1);
        Produto produto = entityManager.find(Produto.class, 1);

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setDataCriacao(LocalDateTime.now());
        pedido.setStatus(StatusPedido.AGUARDANDO);
        pedido.setTotal(produto.getPreco());

        //usando o @mapsId na classe nao é mais necessário dar persist flush para gerar o id do pedido para
        // prosseguir para o item
        // entityManager.persist(pedido);
        // entityManager.flush();

        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setId(new ItemPedidoId()); // ao utilizar mapsId na classe, nao precisa especificar os parametros de ItemPedidoId
        itemPedido.setPedido(pedido);
        itemPedido.setProduto(produto);
        itemPedido.setPrecoProduto(produto.getPreco());
        itemPedido.setQuantidade(1);

        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.persist(itemPedido);
        entityManager.getTransaction().commit();

        entityManager.clear();

        ItemPedido itemPedidoVerificacao = entityManager.find(
                ItemPedido.class, new ItemPedidoId(pedido.getId(), produto.getId()));
        Assert.assertNotNull(itemPedidoVerificacao);
    }

}
