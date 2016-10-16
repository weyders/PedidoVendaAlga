package br.blog.weyder.pedidovenda.repository;

import br.blog.weyder.pedidovenda.model.Categoria;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author weyder
 */
public class Categorias implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private EntityManager manager;
    
    public Categoria porId(Long id) {
        return manager.find(Categoria.class, id);
    }
            
    public List<Categoria> raizes() {
        // Nome da classe, entidade por isso é maiuscula
        return manager.createQuery("from Categoria where categoriaPai is null",
                Categoria.class).getResultList(); 
    }
    
    public List<Categoria> subcategoriasDe(Categoria categoriaPai) {
        return manager.createQuery("from Categoria where categoriaPai = :raiz",
                Categoria.class).setParameter("raiz", categoriaPai).getResultList();
    }
}
