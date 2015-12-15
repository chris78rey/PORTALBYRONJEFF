/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.pom_04_portalservicios.controllers;

import ec.mil.he1.pom_01_domain.SegUsuario;
import ec.mil.he1.pom_01_domain.VDetallePaciente;
import ec.mil.he1.pom_01_domain.VUsuariosClasif;
import ec.mil.he1.pom_03_ejb.stateless.procesos.ListasComunes ;
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
@Named(value = "coberturaISSFAController")
@ViewScoped
public class CoberturaISSFAController implements Serializable {

    @EJB
    private ListasComunes  listasComunes;
    private static final long serialVersionUID = 1754638594827420575L;
    private VUsuariosClasif vUsuariosClasif;
    private SegUsuario segUsuario = new SegUsuario();
    private List<VDetallePaciente> listDetallePaciente = new ArrayList<>();
    private VDetallePaciente vDetallePaciente = new VDetallePaciente();
    private List<Map> listaBuscaDependientes = new ArrayList<>();

    public List<VDetallePaciente> findPacientePorHC(Integer par) {
        return listasComunes.findPacientePorHC(par);
    }

    public List<Map> listaBuscaDependientes(String pCriterio) {
        return listasComunes.listaBuscaDependientes(pCriterio);
    }

    @PostConstruct
    private void init() {
        out.println("@PostConstruct");
        FacesContext facesContext = getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        vUsuariosClasif = (VUsuariosClasif) session.getAttribute("vUsuariosClasif");
        segUsuario = (SegUsuario) session.getAttribute("segUsuario");
        listDetallePaciente = findPacientePorHC(vUsuariosClasif.getNumeroHc().intValue());
        for (VDetallePaciente listDetallePaciente1 : listDetallePaciente) {
            vDetallePaciente = listDetallePaciente1;
        }
        listaBuscaDependientes = listaBuscaDependientes(vUsuariosClasif.getNumeroHc().toString());

    }

    /**
     * Creates a new instance of CoberturaISSFAController
     */
    public CoberturaISSFAController() {
    }

    /**
     * @return the listDetallePaciente
     */
    public List<VDetallePaciente> getListDetallePaciente() {
        return listDetallePaciente;
    }

    /**
     * @return the vDetallePaciente
     */
    public VDetallePaciente getvDetallePaciente() {
        return vDetallePaciente;
    }

    /**
     * @param vDetallePaciente the vDetallePaciente to set
     */
    public void setvDetallePaciente(VDetallePaciente vDetallePaciente) {
        this.vDetallePaciente = vDetallePaciente;
    }

    /**
     * @return the listaBuscaDependientes
     */
    public List<Map> getListaBuscaDependientes() {
        return listaBuscaDependientes;
    }

}
