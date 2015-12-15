/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.pom_04_portalservicios.controllers;

import ec.mil.he1.pom_01_domain.Provincias;
import ec.mil.he1.pom_03_ejb.stateless.ProvinciasFacadeRemote;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author christian_ruiz
 */
@Named(value = "converterGeneral")
@ViewScoped
public class ConverterGeneral implements Serializable {

    @EJB
    private transient ProvinciasFacadeRemote provinciasFacade;

    /**
     * @return the provinciasFacade
     */
    public ProvinciasFacadeRemote getProvinciasFacade() {
        return provinciasFacade;
    }

    /**
     * @param provinciasFacade the provinciasFacade to set
     */
    public void setProvinciasFacade(ProvinciasFacadeRemote provinciasFacade) {
        this.provinciasFacade = provinciasFacade;
    }

    /**
     * Creates a new instance of ConverterGeneral
     */
    public ConverterGeneral() {
    }

    @FacesConverter(forClass = Provincias.class)
    public static class ProvinciasControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ConverterGeneral controller = (ConverterGeneral) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "converterGeneral");
            Provincias find = controller.getProvinciasFacade().find(value);
            return find;
        }

        java.lang.String getKey(String value) {
            java.lang.String key;
            key = value;
            return key;
        }

        String getStringKey(java.lang.String value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Provincias) {
                Provincias o = (Provincias) object;
                return getStringKey(o.getCodigo());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Provincias.class.getName());
            }
        }

    }

}
