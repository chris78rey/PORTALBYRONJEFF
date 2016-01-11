/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.pom_01_domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author christian_ruiz
 */
@Entity
@Table(name = "V_CLAVE_RESET")
public class VClaveReset implements Serializable {

    private static final long serialVersionUID = 1L;

    public VClaveReset() {
    }

    @Column(name = "ID")
    @Id
    @Basic(optional = false)
    private BigDecimal id;

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return this.id;
    }
    @Column(name = "USU_ID")
    @Basic(optional = true)
    private BigDecimal usuId;

    public void setUsuId(BigDecimal usuId) {
        this.usuId = usuId;
    }

    public BigDecimal getUsuId() {
        return this.usuId;
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

    @Column(name = "EMAIL")
    @Basic(optional = true)
    private String email;

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    @Column(name = "CLAVE_TEMPORAL")
    @Basic(optional = true)
    private String claveTemporal;

    public void setClaveTemporal(String claveTemporal) {
        this.claveTemporal = claveTemporal;
    }

    public String getClaveTemporal() {
        return this.claveTemporal;
    }
    
    @Column(name = "FECHA_SOLICITUD")
    @Basic(optional = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSolicitud;

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public Date getFechaSolicitud() {
        return this.fechaSolicitud;
    }
}
