/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.pom_04_portalservicios.controllers;

import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;

/**
 *
 * @author christian_ruiz
 */
@Named(value = "titulo")
@ViewScoped
public class TituloController implements Serializable {

    private static final long serialVersionUID = -3027213830801731928L;
    private String tituloEncabezado = "HOSPITAL DE ESPECIALIDADES DE LAS FUERZAS ARMADAS N°1-SERVICIOS";

    /**
     * Creates a new instance of TituloController
     */
    public TituloController() {
    }

    /**
     * @return the tituloEncabezado
     */
    public String getTituloEncabezado() {
        return tituloEncabezado;
    }

    /**
     * @param tituloEncabezado the tituloEncabezado to set
     */
    public void setTituloEncabezado(String tituloEncabezado) {
        this.tituloEncabezado = tituloEncabezado;
    }

}
