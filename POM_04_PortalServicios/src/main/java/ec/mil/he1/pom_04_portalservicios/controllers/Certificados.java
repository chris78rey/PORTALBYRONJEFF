/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.pom_04_portalservicios.controllers;

import ec.mil.he1.pom_01_domain.SegUsuario;
import ec.mil.he1.pom_01_domain.VUsuariosClasif;
import ec.mil.he1.pom_03_ejb.stateless.procesos.ListasComunes;
import java.io.IOException;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import static javax.faces.context.FacesContext.getCurrentInstance;
import javax.servlet.http.HttpSession;

/**
 *
 * @author christian_ruiz
 */
@Named(value = "certificados")
@ViewScoped
public class Certificados implements Serializable {

    private static final long serialVersionUID = -754931071112804936L;

    @EJB
    private ListasComunes listasComunes;
    VUsuariosClasif vUsuariosClasif = new VUsuariosClasif();
    SegUsuario segUsuario = new SegUsuario();

    /**
     * Creates a new instance of Certificados
     */
    public Certificados() {
    }

    @PostConstruct
    private void init() {
        out.println("@PostConstruct");
        FacesContext facesContext = getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        vUsuariosClasif = (VUsuariosClasif) session.getAttribute("vUsuariosClasif");
        segUsuario = (SegUsuario) session.getAttribute("segUsuario");

    }

    public List<Map> listaBuscaFechasCertificados(String pCriterio) {
        return listasComunes.listaBuscaFechasCertificados(pCriterio);
    }

    public List<Map> getListaDetalleCertificados() {
        List data = new ArrayList<>();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);

        data = listasComunes.listaBuscaFechasCertificados(vUsuariosClasif.getNumeroHc().toString());
        return data;
    }

    public String accionImprimirPDF(String id) throws IOException {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);

        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect("http://servicios.he1.mil.ec/Paciente-war/certMed?kkjdndj=" + vUsuariosClasif.getNumeroHc() + "&sddvaxd=" + id);
        return null;
    }
}
