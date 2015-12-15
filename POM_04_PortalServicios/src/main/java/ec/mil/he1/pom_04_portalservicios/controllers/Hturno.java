/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.pom_04_portalservicios.controllers;

import ec.mil.he1.pom_01_domain.SegUsuario;
import ec.mil.he1.pom_01_domain.VUsuariosClasif;
import ec.mil.he1.pom_03_ejb.stateless.procesos.ListasComunesRemote;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import static javax.faces.context.FacesContext.getCurrentInstance;
import javax.servlet.http.HttpSession;

/**
 *
 * @author christian_ruiz
 */
@Named(value = "hturno")
@ViewScoped
public class Hturno implements Serializable {

    @EJB
    private ListasComunesRemote listasComunes;
    private List<Map> listaDeTurnos = new ArrayList<>();
    private VUsuariosClasif vUsuariosClasif;
    private SegUsuario segUsuario = new SegUsuario();

    public List<Map> buscaHistorial(String pCriterio) {
        return listasComunes.buscaHistorial(pCriterio);
    }

    /**
     * Creates a new instance of Hturno
     */
    public Hturno() {

    }

    @PostConstruct
    private void init() {
        out.println("@PostConstruct");
        FacesContext facesContext = getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        vUsuariosClasif = (VUsuariosClasif) session.getAttribute("vUsuariosClasif");
        segUsuario = (SegUsuario) session.getAttribute("segUsuario");

    }

    /**
     * @return the listaDeTurnos
     */
    public List<Map> getListaDeTurnos() {
        listaDeTurnos = buscaHistorial(segUsuario.getNumeroHc().toString());
        return listaDeTurnos;
    }

}
