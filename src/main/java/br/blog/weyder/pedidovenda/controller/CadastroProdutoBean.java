package br.blog.weyder.pedidovenda.controller;

import br.blog.weyder.pedidovenda.model.Categoria;
import br.blog.weyder.pedidovenda.model.Produto;
import br.blog.weyder.pedidovenda.repository.Categorias;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;


@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Inject
    private Categorias categorias;
            
    private Produto produto;
    private Categoria categoriaPai;
    
    private List<Categoria> categoriasRaizes;

    public CadastroProdutoBean() {
        produto = new Produto();
    }
    
    public void inicializar() {
        System.out.println("Inicializando.........");
        categoriasRaizes = categorias.raizes();
    }

    public void salvar() {
        System.out.println("Categoria pai selecionada " + getCategoriaPai().getDescricao());
    }
    
    public Produto getProduto() {
        return produto;
    }

    public List<Categoria> getCategoriasRaizes() {
        return categoriasRaizes;
    }

    @NotNull
    public Categoria getCategoriaPai() {
        return categoriaPai;
    }

    public void setCategoriaPai(Categoria categoriaPai) {
        this.categoriaPai = categoriaPai;
    }
    
}
