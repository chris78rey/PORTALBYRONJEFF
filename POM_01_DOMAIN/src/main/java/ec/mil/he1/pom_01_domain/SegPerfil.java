/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.pom_01_domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "SEG_PERFIL")
@NamedQueries({
    @NamedQuery(name = "SegPerfil.findAll", query = "SELECT s FROM SegPerfil s")})
public class SegPerfil implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "PER_ID")
    private BigDecimal perId;
    @Column(name = "MOD_ID")
    private BigInteger modId;
    @Column(name = "PER_DESCRIPCION")
    private String perDescripcion;
    @Column(name = "PER_FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date perFechaCreacion;
    @Column(name = "PER_DEFAULT")
    private BigInteger perDefault;
    @Column(name = "PER_ORDEN_PRESENTACION")
    private BigInteger perOrdenPresentacion;

    public SegPerfil() {
    }

    public SegPerfil(BigDecimal perId) {
        this.perId = perId;
    }

    public BigDecimal getPerId() {
        return perId;
    }

    public void setPerId(BigDecimal perId) {
        this.perId = perId;
    }

    public BigInteger getModId() {
        return modId;
    }

    public void setModId(BigInteger modId) {
        this.modId = modId;
    }

    public String getPerDescripcion() {
        return perDescripcion;
    }

    public void setPerDescripcion(String perDescripcion) {
        this.perDescripcion = perDescripcion;
    }

    public Date getPerFechaCreacion() {
        return perFechaCreacion;
    }

    public void setPerFechaCreacion(Date perFechaCreacion) {
        this.perFechaCreacion = perFechaCreacion;
    }

    public BigInteger getPerDefault() {
        return perDefault;
    }

    public void setPerDefault(BigInteger perDefault) {
        this.perDefault = perDefault;
    }

    public BigInteger getPerOrdenPresentacion() {
        return perOrdenPresentacion;
    }

    public void setPerOrdenPresentacion(BigInteger perOrdenPresentacion) {
        this.perOrdenPresentacion = perOrdenPresentacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perId != null ? perId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegPerfil)) {
            return false;
        }
        SegPerfil other = (SegPerfil) object;
        if ((this.perId == null && other.perId != null) || (this.perId != null && !this.perId.equals(other.perId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.pom_01_domain.SegPerfil[ perId=" + perId + " ]";
    }
    
}
