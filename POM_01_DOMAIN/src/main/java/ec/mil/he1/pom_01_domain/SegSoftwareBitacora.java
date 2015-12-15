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
@Table(name = "SEG_SOFTWARE_BITACORA")
@NamedQueries({
    @NamedQuery(name = "SegSoftwareBitacora.findAll", query = "SELECT s FROM SegSoftwareBitacora s")})
public class SegSoftwareBitacora implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MODULO")
    private String modulo;

    public SegSoftwareBitacora() {
    }

    public SegSoftwareBitacora(String modulo) {
        this.modulo = modulo;
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
        hash += (modulo != null ? modulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegSoftwareBitacora)) {
            return false;
        }
        SegSoftwareBitacora other = (SegSoftwareBitacora) object;
        if ((this.modulo == null && other.modulo != null) || (this.modulo != null && !this.modulo.equals(other.modulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.pom_01_domain.SegSoftwareBitacora[ modulo=" + modulo + " ]";
    }
    
}
