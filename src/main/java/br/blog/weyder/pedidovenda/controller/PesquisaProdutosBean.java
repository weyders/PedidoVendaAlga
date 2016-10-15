package br.blog.weyder.pedidovenda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author weyder
 */
@Named
@ViewScoped
public class PesquisaProdutosBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Integer> produtosFiltrados;

    public PesquisaProdutosBean() {
        produtosFiltrados = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            produtosFiltrados.add(i);
        }
    }

    public List<Integer> getProdutosFiltrados() {
        return produtosFiltrados;
    }
}
