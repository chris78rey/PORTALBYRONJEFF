/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.pom_01_domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author christian_ruiz
 */
@Embeddable
public class SeguimientosSocialesPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "FCHSCL_NUMERO")
    private int fchsclNumero;
    @Basic(optional = false)
    @Column(name = "GSTSCL_CODIGO")
    private String gstsclCodigo;
    @Basic(optional = false)
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    public SeguimientosSocialesPK() {
    }

    public SeguimientosSocialesPK(int fchsclNumero, String gstsclCodigo, Date fecha) {
        this.fchsclNumero = fchsclNumero;
        this.gstsclCodigo = gstsclCodigo;
        this.fecha = fecha;
    }

    public int getFchsclNumero() {
        return fchsclNumero;
    }

    public void setFchsclNumero(int fchsclNumero) {
        this.fchsclNumero = fchsclNumero;
    }

    public String getGstsclCodigo() {
        return gstsclCodigo;
    }

    public void setGstsclCodigo(String gstsclCodigo) {
        this.gstsclCodigo = gstsclCodigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) fchsclNumero;
        hash += (gstsclCodigo != null ? gstsclCodigo.hashCode() : 0);
        hash += (fecha != null ? fecha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeguimientosSocialesPK)) {
            return false;
        }
        SeguimientosSocialesPK other = (SeguimientosSocialesPK) object;
        if (this.fchsclNumero != other.fchsclNumero) {
            return false;
        }
        if ((this.gstsclCodigo == null && other.gstsclCodigo != null) || (this.gstsclCodigo != null && !this.gstsclCodigo.equals(other.gstsclCodigo))) {
            return false;
        }
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.pom_01_domain.SeguimientosSocialesPK[ fchsclNumero=" + fchsclNumero + ", gstsclCodigo=" + gstsclCodigo + ", fecha=" + fecha + " ]";
    }
    
}
