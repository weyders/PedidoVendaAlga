package br.blog.weyder.pedidovenda.controller;

import br.blog.weyder.pedidovenda.model.Produto;
import br.blog.weyder.pedidovenda.repository.Produtos;
import br.blog.weyder.pedidovenda.repository.filter.ProdutoFilter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author weyder
 */
@Named
@ViewScoped
public class PesquisaProdutosBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Produtos produtos;
    
    private ProdutoFilter filtro;
    private List<Produto> produtosFiltrados;

    public PesquisaProdutosBean() {
        this.filtro = new ProdutoFilter();
    }

    public void pesquisar() {
        produtosFiltrados = produtos.filtrados(filtro);
    }
    
    public List<Produto> getProdutosFiltrados() {
        
        return produtosFiltrados;
    }
    
    
    public ProdutoFilter getFiltro() {
        return filtro;
    }
}
