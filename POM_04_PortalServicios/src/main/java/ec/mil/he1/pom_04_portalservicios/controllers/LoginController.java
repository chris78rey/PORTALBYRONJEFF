/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.pom_04_portalservicios.controllers;

import ec.mil.he1.pom_01_domain.SegUsuario;
import ec.mil.he1.pom_01_domain.VUsuariosClasif;
import ec.mil.he1.pom_03_ejb.stateless.VUsuariosClasifFacade;
import ec.mil.he1.pom_03_ejb.stateless.procesos.LoginSessionBean;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.SQLException;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author christian_ruiz
 */
@Named(value = "loginController")
@SessionScoped
public class LoginController implements Serializable {

    String paginaSiguiente = "";
    @EJB
    private transient VUsuariosClasifFacade vUsuariosClasifFacade;
    private VUsuariosClasif vUsuariosClasif = new VUsuariosClasif();

    private static final long serialVersionUID = -9036861759497150346L;
    private SegUsuario segUsuario = new SegUsuario();

    String mensaje = "";

    @EJB
    private transient LoginSessionBean loginSessionBean;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    private String password = "Jesus";
    private String username = "0603362989";
    private String email = "";

    public LoginSessionBean getLoginSessionBean() {
        return loginSessionBean;
    }

    public void setLoginSessionBean(LoginSessionBean loginSessionBean) {
        this.loginSessionBean = loginSessionBean;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Creates a new instance of LoginController
     */
    public LoginController() {
    }

    public void buttonActionPersonal(ActionEvent actionEvent) throws SQLException {
        String Login = loginSessionBean.Login(username, password, "2");

        switch (Login) {
            case "1":
                mensaje = "Su usuario y clave estan correctas";
                setSegUsuario(loginSessionBean.usuarioByCC(this.username));
                //con este objeto se tiene ya los nombres
                setvUsuariosClasif(vUsuariosClasifFacade.find(getSegUsuario().getId()));
                FacesContext facesContext = FacesContext.getCurrentInstance();
                HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
                session.setAttribute("vUsuariosClasif", getvUsuariosClasif());
                session.setAttribute("segUsuario", getSegUsuario());
                BigDecimal bd = getvUsuariosClasif().getActualizarDatos();
                //si el usuario esta registrado bien pero tiene 
                //la misma cadena en la clave se debe redireccionar
                if (username.equalsIgnoreCase(password)) {
                    paginaSiguiente = "/auto/vCambioClaveNuevPortal/List";
                } else if (bd.equals(new BigDecimal("1"))) {
                    paginaSiguiente = "actualizarDP.xhtml";
                } else {
                    paginaSiguiente = "dashboard.xhtml";
                }
                password = "";
                break;
            case "0":
                mensaje = "Usuario o clave mal ingresados";
                break;
            case "-2":
                mensaje = "Usuario con más de un registro";
                break;
            case "4":
                mensaje = "El usuario no tiene acceso al módulo";
                break;
            case "5":
                mensaje = "Módulo inexistente, este mensaje es solo para sistemas";
                break;
            default:
                mensaje = "";

        }

    }

    public String accionIngresoPersonal() throws IOException, NamingException, SQLException {
        //despliego el mensaje
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Warning!", mensaje));
        mensaje = "";
        String ps = paginaSiguiente;
        paginaSiguiente = "";
        return ps;
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

    /**
     * @return the vUsuariosClasif
     */
    public VUsuariosClasif getvUsuariosClasif() {
        return vUsuariosClasif;
    }

    /**
     * @param vUsuariosClasif the vUsuariosClasif to set
     */
    public void setvUsuariosClasif(VUsuariosClasif vUsuariosClasif) {
        this.vUsuariosClasif = vUsuariosClasif;
    }

    public void logout() throws IOException {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.invalidateSession();
        ec.redirect(ec.getRequestContextPath() + "/");
    }
}
