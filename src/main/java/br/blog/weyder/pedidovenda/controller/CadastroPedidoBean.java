package br.blog.weyder.pedidovenda.controller;

import br.blog.weyder.pedidovenda.model.EnderecoEntrega;
import br.blog.weyder.pedidovenda.model.Pedido;
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
public class CadastroPedidoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Pedido pedido;

    private List<Integer> itens;

    public CadastroPedidoBean() {
        pedido = new Pedido();
        pedido.setEnderecoEntrega(new EnderecoEntrega());
        itens = new ArrayList<>();
        itens.add(1);
    }

    public void salvar() {

    }

    public Pedido getPedido() {
        return pedido;
    }

    public List<Integer> getItens() {
        return itens;
    }
}
