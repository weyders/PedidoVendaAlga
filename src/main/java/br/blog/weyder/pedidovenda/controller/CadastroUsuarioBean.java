package br.blog.weyder.pedidovenda.controller;

import br.blog.weyder.pedidovenda.model.Usuario;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author weyder
 */
@Named
@ViewScoped
public class CadastroUsuarioBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Usuario usuario;
    
    public CadastroUsuarioBean(){
        usuario = new Usuario();
    }
    
    public void Salvar(){
        
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    
    
}
