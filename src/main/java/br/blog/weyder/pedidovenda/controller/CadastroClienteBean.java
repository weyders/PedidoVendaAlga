/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.blog.weyder.pedidovenda.controller;

import br.blog.weyder.pedidovenda.model.Cliente;
import br.blog.weyder.pedidovenda.model.Endereco;
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
public class CadastroClienteBean implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private Cliente cliente;
    private Endereco endereco;
    
    public CadastroClienteBean() {
        cliente = new Cliente();
        endereco = new Endereco();
    }
    
    public void salvar() {
        
    }
    
    public void salvarEndereco() {
        
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Endereco getEndereco() {
        return endereco;
    }
       
}
