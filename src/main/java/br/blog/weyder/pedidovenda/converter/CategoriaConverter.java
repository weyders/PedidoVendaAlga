package br.blog.weyder.pedidovenda.converter;

import br.blog.weyder.pedidovenda.model.Categoria;
import br.blog.weyder.pedidovenda.repository.Categorias;
import br.blog.weyder.pedidovenda.util.cdi.CDIServiceLocator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

@FacesConverter(forClass = Categoria.class)
public class CategoriaConverter implements Converter {

    //@Inject //Não funciona no JSF 2.1 e 2.2
    private Categorias categorias;

    public CategoriaConverter() {
        this.categorias = CDIServiceLocator.getBean(Categorias.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Categoria retorno = null;

        if (value != null) {
            Long id = new Long(value);
            retorno = categorias.porId(id);
        }

        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            return ((Categoria) value).getId().toString();
        }

        return "";
    }

}
