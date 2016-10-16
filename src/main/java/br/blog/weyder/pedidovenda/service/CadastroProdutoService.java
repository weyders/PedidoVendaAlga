package br.blog.weyder.pedidovenda.service;

import br.blog.weyder.pedidovenda.model.Produto;
import br.blog.weyder.pedidovenda.repository.Produtos;

import java.io.Serializable;
import javax.inject.Inject;

/**
 *
 * @author weyder
 */
public class CadastroProdutoService implements Serializable{

       public static final long serialVersionUID = 1L;
       
       @Inject
       private Produtos produtos;
       
       public Produto salvar(Produto produto) {
           // Regra de negocio onde nao pode ter 2 SKU
           Produto produtoExistente = produtos.porSku(produto.getSku());
           
           if (produtoExistente != null) {
               throw new NegocioException("Já existe o produto com o SKU informado.");
           }
           
           return produtos.guardar(produto);
       } 
}
