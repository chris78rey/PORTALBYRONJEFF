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
import ec.mil.he1.pom_03_ejb.stateless.SegUsuarioFacadeRemote;
import ec.mil.he1.pom_03_ejb.stateless.procesos.ListasComunesRemote;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
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
@ViewScoped
public class ActualizaDatosController implements Serializable {

    @EJB
    private transient SegUsuarioFacadeRemote segUsuarioFacade;

    private static final long serialVersionUID = 5190460509652921601L;
    @EJB
    private transient ListasComunesRemote listasComunes;
    List<Cantones> cantoneses = new ArrayList<>();

    String proId = "";
    String canId = "";
    private String parrId = "";
    private static final Logger LOG = Logger.getLogger(ActualizaDatosController.class.getName());

    VUsuariosClasif vUsuariosClasif;
    private SegUsuario segUsuario = new SegUsuario();

    @PostConstruct
    private void init() {
        out.println("@PostConstruct");
        FacesContext facesContext = getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        vUsuariosClasif = (VUsuariosClasif) session.getAttribute("vUsuariosClasif");
        segUsuario = (SegUsuario) session.getAttribute("segUsuario");
        proId = segUsuario.getCntPrvCodigo();
        cantoneses = listasComunes.ListCantones(segUsuario.getCntPrvCodigo());
        parroquiases = ListParroquias(segUsuario.getCntCodigo());
        System.out.println("segUsuario.getCodigo() = " + segUsuario.getCodigo());
    }

    public ActualizaDatosController() {
    }

    public void listen2(AjaxBehaviorEvent event) {
        parroquiases.clear();
        parroquiases = ListParroquias(segUsuario.getCntCodigo());

    }

    public void listen3(AjaxBehaviorEvent event) {
        System.out.println("" + segUsuario.getCodigo());

        out.println("ingresa");
    }

    public void buttonGuardarDP(ActionEvent actionEvent) throws SQLException {
//        segUsuario.setActualizarDatos(BigInteger.ZERO);
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
        out.println("proId = " + proId);
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

    /**
     * @param parroquiases the parroquiases to set
     */
    public void setParroquiases(List<Parroquias> parroquiases) {
        this.parroquiases = parroquiases;
    }
    private List<Parroquias> parroquiases = new ArrayList<>();

    public List<Parroquias> ListParroquias(String canId) {
        return listasComunes.ListParroquias(proId, canId);
    }

    public ListasComunesRemote getListasComunes() {
        return listasComunes;
    }

    public void setListasComunes(ListasComunesRemote listasComunes) {
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
        cantoneses = listasComunes.ListCantones(segUsuario.getCntPrvCodigo());
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
