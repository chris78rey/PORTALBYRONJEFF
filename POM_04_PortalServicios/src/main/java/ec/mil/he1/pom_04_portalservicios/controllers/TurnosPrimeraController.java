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
@Named(value = "turnosPrimeraController")
@ViewScoped
public class TurnosPrimeraController implements Serializable{

    // CODIGO PARA MANTENER LA SESION ACTIVA Y PODER TOMAR LOS DATOS DEL USUARIO QUE ESTA LOGEADO
    @EJB transient 
    private ListasComunes  listasComunes;
    private SegUsuario segUsuario = new SegUsuario();
    private List<Map> listaturnossiguientes = new ArrayList<>();
    private VUsuariosClasif vUsuariosClasif;
  
    @PostConstruct
    private void init() {
        out.println("@PostConstruct");
        FacesContext facesContext = getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        vUsuariosClasif = (VUsuariosClasif) session.getAttribute("vUsuariosClasif");  
    }
  
    /// CODIGO DE TURNOS PRIMERA VEZ
     public List<Map> listaturnossiguientes() {
        return listasComunes.listaturnossiguientes();
    }
    
    public List<Map> getListaturnossiguientes() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        /*   HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);*/

        listaturnossiguientes = listasComunes.listaturnossiguientes(); 
        return listaturnossiguientes;
      
    }
      /**
     * Creates a new instance of TurnosPrimeraController
     */
    public TurnosPrimeraController() {
    }
    
}
