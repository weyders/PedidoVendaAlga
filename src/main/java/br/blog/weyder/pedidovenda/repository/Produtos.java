package br.blog.weyder.pedidovenda.repository;

import br.blog.weyder.pedidovenda.model.Categoria;
import br.blog.weyder.pedidovenda.model.Produto;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

/**
 *
 * @author weyder
 */
public class Produtos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Produto guardar(Produto produto) {
        EntityTransaction trx = manager.getTransaction();
        trx.begin();

        produto = manager.merge(produto);

        trx.commit();

        return produto;
    }

    public Produto porSku(String sku) {
        try {
            return manager.createQuery("from Produto where upper(sku) = :sku", Produto.class)
                    .setParameter("sku", sku.toUpperCase())
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
