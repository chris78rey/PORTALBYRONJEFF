/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.pom_01_domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "SEGUIMIENTOS_SOCIALES")
@NamedQueries({
    @NamedQuery(name = "SeguimientosSociales.findAll", query = "SELECT s FROM SeguimientosSociales s")})
public class SeguimientosSociales implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SeguimientosSocialesPK seguimientosSocialesPK;
    @Column(name = "PRS_CODIGO")
    private String prsCodigo;
    @Column(name = "OBSERVACION")
    private String observacion;
    @Column(name = "TIEMPO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tiempo;
    @Column(name = "EFECTIVA")
    private String efectiva;
    @Column(name = "CAMA_FASEC")
    private String camaFasec;

    public SeguimientosSociales() {
    }

    public SeguimientosSociales(SeguimientosSocialesPK seguimientosSocialesPK) {
        this.seguimientosSocialesPK = seguimientosSocialesPK;
    }

    public SeguimientosSociales(int fchsclNumero, String gstsclCodigo, Date fecha) {
        this.seguimientosSocialesPK = new SeguimientosSocialesPK(fchsclNumero, gstsclCodigo, fecha);
    }

    public SeguimientosSocialesPK getSeguimientosSocialesPK() {
        return seguimientosSocialesPK;
    }

    public void setSeguimientosSocialesPK(SeguimientosSocialesPK seguimientosSocialesPK) {
        this.seguimientosSocialesPK = seguimientosSocialesPK;
    }

    public String getPrsCodigo() {
        return prsCodigo;
    }

    public void setPrsCodigo(String prsCodigo) {
        this.prsCodigo = prsCodigo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Date getTiempo() {
        return tiempo;
    }

    public void setTiempo(Date tiempo) {
        this.tiempo = tiempo;
    }

    public String getEfectiva() {
        return efectiva;
    }

    public void setEfectiva(String efectiva) {
        this.efectiva = efectiva;
    }

    public String getCamaFasec() {
        return camaFasec;
    }

    public void setCamaFasec(String camaFasec) {
        this.camaFasec = camaFasec;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seguimientosSocialesPK != null ? seguimientosSocialesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeguimientosSociales)) {
            return false;
        }
        SeguimientosSociales other = (SeguimientosSociales) object;
        if ((this.seguimientosSocialesPK == null && other.seguimientosSocialesPK != null) || (this.seguimientosSocialesPK != null && !this.seguimientosSocialesPK.equals(other.seguimientosSocialesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.pom_01_domain.SeguimientosSociales[ seguimientosSocialesPK=" + seguimientosSocialesPK + " ]";
    }
    
}
