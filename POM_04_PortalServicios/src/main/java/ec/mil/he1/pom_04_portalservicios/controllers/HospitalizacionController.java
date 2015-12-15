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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import static javax.faces.context.FacesContext.getCurrentInstance;
import javax.servlet.http.HttpSession;

/**
 *
 * @author christian_ruiz
 */
@Named(value = "hospitalizacionController")
@ViewScoped
public class HospitalizacionController implements Serializable {

    private static final long serialVersionUID = 4092410302953095249L;
    private VUsuariosClasif vUsuariosClasif;
    private SegUsuario segUsuario = new SegUsuario();

    @EJB
    private ListasComunesRemote listasComunes;

    @PostConstruct
    private void init() {
        out.println("@PostConstruct");
        FacesContext facesContext = getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        vUsuariosClasif = (VUsuariosClasif) session.getAttribute("vUsuariosClasif");
        segUsuario = (SegUsuario) session.getAttribute("segUsuario");

    }

    private Date date1;
    private Date date2;

    private String strDate1 = "2000/01/01";
    private String strDate2 = "2000/01/01";

    /**
     * Creates a new instance of HospitalizacionController
     */
    public HospitalizacionController() {
    }

    /**
     * @return the date1
     */
    public Date getDate1() {
        return date1;
    }

    /**
     * @param date1 the date1 to set
     */
    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    /**
     * @return the date2
     */
    public Date getDate2() {
        return date2;
    }

    /**
     * @param date2 the date2 to set
     */
    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    /**
     * @return the strDate1
     */
    public String getStrDate1() {
        return strDate1;
    }

    /**
     * @param strDate1 the strDate1 to set
     */
    public void setStrDate1(String strDate1) {
        this.strDate1 = strDate1;
    }

    /**
     * @return the strDate2
     */
    public String getStrDate2() {
        return strDate2;
    }

    /**
     * @param strDate2 the strDate2 to set
     */
    public void setStrDate2(String strDate2) {
        this.strDate2 = strDate2;
    }

    public void click() {
        SimpleDateFormat sm = new SimpleDateFormat("yyyyMMdd");

        strDate1 = sm.format(date1);
        strDate2 = sm.format(date2);

        litaPermanencias = listaPermanencias(segUsuario.getNumeroHc().toString(), strDate1, strDate2);

    }
    //esto se coloca en el Managed Bean  
    private List<Map> litaPermanencias = new ArrayList<>();

    public List<Map> listaPermanencias(String paciente, String pFecha1, String pFecha2) {
        List<Map> litaPermanencias1 = listasComunes.litaPermanencias(paciente, pFecha1, pFecha2);
        return litaPermanencias1;
    }
    private static final Logger LOG = Logger.getLogger(HospitalizacionController.class.getName());

    /**
     * @return the litaPermanencias
     */
    public List<Map> getLitaPermanencias() {

        return litaPermanencias;
    }
}
