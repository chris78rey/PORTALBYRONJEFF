/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.mil.he1.pom_04_portalservicios.controllers;

import ec.mil.he1.pom_03_ejb.stateless.procesos.ListasComunes  ;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;

/**
 *
 * @author christian_ruiz
 */
@Named(value="certificados")
@ViewScoped
public class Certificados implements Serializable {
    private static final long serialVersionUID = -754931071112804936L;

    public List<Map> listaBuscaFechasCertificados(String pCriterio) {
        return listasComunes.listaBuscaFechasCertificados(pCriterio);
    }
    @EJB
    private ListasComunes   listasComunes;

    /** Creates a new instance of Certificados */
    public Certificados() {
    }

}
