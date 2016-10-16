package br.blog.weyder.pedidovenda.controller;

import br.blog.weyder.pedidovenda.model.Categoria;
import br.blog.weyder.pedidovenda.model.Produto;
import br.blog.weyder.pedidovenda.repository.Categorias;
import br.blog.weyder.pedidovenda.service.CadastroProdutoService;
import br.blog.weyder.pedidovenda.util.jsf.FacesUtil;

import java.io.Serializable;
import java.util.ArrayList;
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
    
    @Inject
    private CadastroProdutoService cadastroProdutoService; 

    private Produto produto;
    private Categoria categoriaPai;

    private List<Categoria> categoriasRaizes;
    private List<Categoria> subcategorias;

    public CadastroProdutoBean() {
        //produto = new Produto();
        limpar();
    }

    public void inicializar() {
        if (FacesUtil.isNotPostback()) {
            categoriasRaizes = categorias.raizes();
        }
    }

    public void carregarSubcategorias() {
        subcategorias = categorias.subcategoriasDe(categoriaPai);
    }
    
    private void limpar() {
        produto = new Produto();
        categoriaPai = null;
        subcategorias = new ArrayList<>();
    }
    
    public void salvar() {
       this.produto = cadastroProdutoService.salvar(this.produto);
       limpar();
       
       FacesUtil.addInfoMessage("Produto salvo com sucesso.");
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

    public List<Categoria> getSubcategorias() {
        return subcategorias;
    }
}
