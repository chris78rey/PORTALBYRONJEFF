/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.pom_01_domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author christian_ruiz
 */
@Entity
@Table(name = "V_CAMBIO_CLAVE_NUEV_PORTAL")
public class VCambioClaveNuevPortal implements Serializable {

    private static final long serialVersionUID = 1L;

    public VCambioClaveNuevPortal() {
    }

    @Column(name = "ID")
    @Id
    @Basic(optional = false)
    private BigDecimal iD;

    public void setID(BigDecimal iD) {
        this.iD = iD;
    }

    public BigDecimal getID() {
        return this.iD;
    }

    @Column(name = "CEDULA_LOGIN")
    @Basic(optional = true)
    private String cedulaLogin;

    public void setCedulaLogin(String cedulaLogin) {
        this.cedulaLogin = cedulaLogin;
    }

    public String getCedulaLogin() {
        return this.cedulaLogin;
    }

    @Column(name = "USU_CLAVE")
    @Basic(optional = true)
    private String usuClave;

    public void setUsuClave(String usuClave) {
        this.usuClave = usuClave;
    }

    public String getUsuClave() {
        return this.usuClave;
    }
    @Column(name = "CLAVE_NUEVA")
    @Basic(optional = true)
    private String claveNueva;

    public void setClaveNueva(String claveNueva) {
        this.claveNueva = claveNueva;
    }

    public String getClaveNueva() {
        return this.claveNueva;
    }
    @Column(name = "CLAVE_NUEVA2")
    @Basic(optional = true)
    private String claveNueva2;

    public void setClaveNueva2(String claveNueva2) {
        this.claveNueva2 = claveNueva2;
    }

    public String getClaveNueva2() {
        return this.claveNueva2;
    }
}
