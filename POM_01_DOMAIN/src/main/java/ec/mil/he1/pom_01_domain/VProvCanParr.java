/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.pom_01_domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author christian_ruiz
 */
@Entity
@Table(name = "V_PROV_CAN_PARR")
@NamedQueries({
    @NamedQuery(name = "VProvCanParr.findAll", query = "SELECT v FROM VProvCanParr v")})
public class VProvCanParr implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "RID")
    private String rid;
    @Basic(optional = false)
    @Column(name = "PROVINCIAS_CODIGO")
    private String provinciasCodigo;
    @Basic(optional = false)
    @Column(name = "CANTONES_CODIGO")
    private String cantonesCodigo;
    @Basic(optional = false)
    @Column(name = "PARROQUIAS_CODIGO")
    private String parroquiasCodigo;
    @Basic(optional = false)
    @Column(name = "PROVINCIA")
    private String provincia;
    @Basic(optional = false)
    @Column(name = "CANTON")
    private String canton;
    @Basic(optional = false)
    @Column(name = "PARROQUIA")
    private String parroquia;

    public VProvCanParr() {
    }

    public VProvCanParr(String rid) {
        this.rid = rid;
    }

    public VProvCanParr(String rid, String provinciasCodigo, String cantonesCodigo, String parroquiasCodigo, String provincia, String canton, String parroquia) {
        this.rid = rid;
        this.provinciasCodigo = provinciasCodigo;
        this.cantonesCodigo = cantonesCodigo;
        this.parroquiasCodigo = parroquiasCodigo;
        this.provincia = provincia;
        this.canton = canton;
        this.parroquia = parroquia;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getProvinciasCodigo() {
        return provinciasCodigo;
    }

    public void setProvinciasCodigo(String provinciasCodigo) {
        this.provinciasCodigo = provinciasCodigo;
    }

    public String getCantonesCodigo() {
        return cantonesCodigo;
    }

    public void setCantonesCodigo(String cantonesCodigo) {
        this.cantonesCodigo = cantonesCodigo;
    }

    public String getParroquiasCodigo() {
        return parroquiasCodigo;
    }

    public void setParroquiasCodigo(String parroquiasCodigo) {
        this.parroquiasCodigo = parroquiasCodigo;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getParroquia() {
        return parroquia;
    }

    public void setParroquia(String parroquia) {
        this.parroquia = parroquia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rid != null ? rid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VProvCanParr)) {
            return false;
        }
        VProvCanParr other = (VProvCanParr) object;
        if ((this.rid == null && other.rid != null) || (this.rid != null && !this.rid.equals(other.rid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.pom_01_domain.VProvCanParr[ rid=" + rid + " ]";
    }
    
}
