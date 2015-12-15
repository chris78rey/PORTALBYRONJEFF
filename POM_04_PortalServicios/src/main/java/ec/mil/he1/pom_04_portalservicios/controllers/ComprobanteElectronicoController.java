/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.pom_04_portalservicios.controllers;

import ec.mil.he1.pom_01_domain.SegUsuario;
import ec.mil.he1.pom_01_domain.VUsuariosClasif;
import ec.mil.he1.pom_03_ejb.stateless.procesos.ListasComunes ;
import java.io.Serializable;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import static javax.faces.context.FacesContext.getCurrentInstance;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpSession;

/**
 *
 * @author byron_simbana
 */
@Named(value = "comprobanteElectronicoController")
@ViewScoped
public class  ComprobanteElectronicoController implements Serializable {
    
    private static final long serialVersionUID = -1;
    @EJB
    private ListasComunes  listasComunes;
    private SegUsuario segUsuario = new SegUsuario();
    private List<Map> listaFacturasPorHC = new ArrayList<>();
    private VUsuariosClasif vUsuariosClasif;

    @PostConstruct
    private void init() {
        out.println("@PostConstruct");
        FacesContext facesContext = getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        vUsuariosClasif = (VUsuariosClasif) session.getAttribute("vUsuariosClasif");
        segUsuario = (SegUsuario) session.getAttribute("segUsuario");

    }

    public List<Map> listaFacturasPorHC(String pHC) {
        return listasComunes.listaFacturasPorHC(pHC);
    }

    public List<Map> getListaFacturasPorHC() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);

        listaFacturasPorHC = listasComunes.listaFacturasPorHC(     segUsuario.getNumeroHc().toString()          ); 
        return listaFacturasPorHC;
    }

    /**
     * Creates a new instance of ComprobanteElectronicoController
     */
    public ComprobanteElectronicoController() {
    }

}
