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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author christian_ruiz
 */
@Entity
@Table(name = "SEG_LOGS_SISTEMA")
@NamedQueries({
    @NamedQuery(name = "SegLogsSistema.findAll", query = "SELECT s FROM SegLogsSistema s")})
public class SegLogsSistema implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "LSI_ID")
    private BigDecimal lsiId;
    @Column(name = "LSI_MENSAJE")
    private String lsiMensaje;
    @Column(name = "LSI_FECHA_EVENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lsiFechaEvento;
    @Column(name = "MODULO")
    private String modulo;

    public SegLogsSistema() {
    }

    public SegLogsSistema(BigDecimal lsiId) {
        this.lsiId = lsiId;
    }

    public BigDecimal getLsiId() {
        return lsiId;
    }

    public void setLsiId(BigDecimal lsiId) {
        this.lsiId = lsiId;
    }

    public String getLsiMensaje() {
        return lsiMensaje;
    }

    public void setLsiMensaje(String lsiMensaje) {
        this.lsiMensaje = lsiMensaje;
    }

    public Date getLsiFechaEvento() {
        return lsiFechaEvento;
    }

    public void setLsiFechaEvento(Date lsiFechaEvento) {
        this.lsiFechaEvento = lsiFechaEvento;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lsiId != null ? lsiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegLogsSistema)) {
            return false;
        }
        SegLogsSistema other = (SegLogsSistema) object;
        if ((this.lsiId == null && other.lsiId != null) || (this.lsiId != null && !this.lsiId.equals(other.lsiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.pom_01_domain.SegLogsSistema[ lsiId=" + lsiId + " ]";
    }
    
}
