/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.pom_04_portalservicios.controllers;

import ec.mil.he1.pom_01_domain.Cantones;
import ec.mil.he1.pom_01_domain.Parroquias;
import ec.mil.he1.pom_01_domain.Provincias;
import ec.mil.he1.pom_01_domain.SegUsuario;
import ec.mil.he1.pom_01_domain.VUsuariosClasif;
import ec.mil.he1.pom_03_ejb.stateless.SegUsuarioFacade;
import ec.mil.he1.pom_03_ejb.stateless.procesos.ListasComunes;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import static javax.faces.context.FacesContext.getCurrentInstance;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.servlet.http.HttpSession;

/**
 *
 * @author christian_ruiz
 */
@Named(value = "actualizaDatosController")
@SessionScoped
public class ActualizaDatosController implements Serializable {

    @EJB
    private transient SegUsuarioFacade segUsuarioFacade;

    private static final long serialVersionUID = 5190460509652921601L;
    @EJB
    private transient ListasComunes listasComunes;
    List<Cantones> cantoneses = new ArrayList<>();

    String proId = "";
    String canId = "";
    private String parrId = "";
    private static final Logger LOG = Logger.getLogger(ActualizaDatosController.class.getName());

    VUsuariosClasif vUsuariosClasif;
    private SegUsuario segUsuario = new SegUsuario();

    @PostConstruct
    private void init() {
       
        FacesContext facesContext = getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        vUsuariosClasif = (VUsuariosClasif) session.getAttribute("vUsuariosClasif");
        segUsuario = (SegUsuario) session.getAttribute("segUsuario");

        proId = segUsuario.getCntPrvCodigo();
        canId = segUsuario.getCntCodigo();
        parrId = segUsuario.getCodigo();

        cantoneses = listasComunes.ListCantones(proId);
        parroquiases = ListParroquias(canId);

    }

    public ActualizaDatosController() {
    }

    public void listen2(AjaxBehaviorEvent event) {
   
        parroquiases.clear();
        parroquiases = ListParroquias(canId);

    }

    public void listen3(AjaxBehaviorEvent event) {
 
    }

    public void buttonGuardarDP(ActionEvent actionEvent) throws SQLException {
//        segUsuario.setActualizarDatos(BigInteger.ZERO);
        segUsuario.setCntPrvCodigo(proId);
        segUsuario.setCntCodigo(canId);
        segUsuario.setCodigo(parrId);
        segUsuarioFacade.edit(segUsuario);
        segUsuario = segUsuarioFacade.find(segUsuario.getId());
        //almacenar la data en la tabla de seg usuario y en el atributo de sesion
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        session.setAttribute("segUsuario", segUsuario);

    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {

        this.proId = proId;
    }

    public String getCanId() {
        return canId;
    }

    public void setCanId(String canId) {
        this.canId = canId;
    }

    public List<Cantones> getCantoneses() {

        return cantoneses;
    }

    public void setCantoneses(List<Cantones> cantoneses) {
        this.cantoneses = cantoneses;
    }

    /**
     * @return the parrId
     */
    public String getParrId() {
        return parrId;
    }

    /**
     * @param parrId the parrId to set
     */
    public void setParrId(String parrId) {
        this.parrId = parrId;
    }

    /**
     * @return the parroquiases
     */
    public List<Parroquias> getParroquiases() {
        return parroquiases;
    }

    private List<Parroquias> parroquiases = new ArrayList<>();

    public List<Parroquias> ListParroquias(String canId) {
        return listasComunes.ListParroquias(proId, canId);
    }

    public ListasComunes getListasComunes() {
        return listasComunes;
    }

    public void setListasComunes(ListasComunes listasComunes) {
        this.listasComunes = listasComunes;
    }

    public VUsuariosClasif getvUsuariosClasif() {
        return vUsuariosClasif;
    }

    public void setvUsuariosClasif(VUsuariosClasif vUsuariosClasif) {
        this.vUsuariosClasif = vUsuariosClasif;
    }

    public List<Provincias> getListProvincias() {
        return listasComunes.ListProvincias();
    }

    public void listen1(AjaxBehaviorEvent event) {
        cantoneses.clear();
        parroquiases.clear();
        canId = "-1";        
        cantoneses = listasComunes.ListCantones(proId);
    }

    /**
     * @return the segUsuario
     */
    public SegUsuario getSegUsuario() {
        return segUsuario;
    }

    /**
     * @param segUsuario the segUsuario to set
     */
    public void setSegUsuario(SegUsuario segUsuario) {
        this.segUsuario = segUsuario;
    }

}
