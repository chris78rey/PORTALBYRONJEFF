/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.pom_01_domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author christian_ruiz
 */
@Entity
@Table(name = "CANTONES")
@NamedQueries({
    @NamedQuery(name = "Cantones.findAll", query = "SELECT c FROM Cantones c")})
public class Cantones implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CantonesPK cantonesPK;
    @Column(name = "CANTON")
    private String canton;

    public Cantones() {
    }

    public Cantones(CantonesPK cantonesPK) {
        this.cantonesPK = cantonesPK;
    }

    public Cantones(String prvCodigo, String codigo) {
        this.cantonesPK = new CantonesPK(prvCodigo, codigo);
    }

    public CantonesPK getCantonesPK() {
        return cantonesPK;
    }

    public void setCantonesPK(CantonesPK cantonesPK) {
        this.cantonesPK = cantonesPK;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cantonesPK != null ? cantonesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cantones)) {
            return false;
        }
        Cantones other = (Cantones) object;
        if ((this.cantonesPK == null && other.cantonesPK != null) || (this.cantonesPK != null && !this.cantonesPK.equals(other.cantonesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.pom_01_domain.Cantones[ cantonesPK=" + cantonesPK + " ]";
    }
    
}
