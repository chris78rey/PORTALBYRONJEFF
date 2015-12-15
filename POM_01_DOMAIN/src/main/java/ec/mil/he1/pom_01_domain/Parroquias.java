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
@Table(name = "PARROQUIAS")
@NamedQueries({
    @NamedQuery(name = "Parroquias.findAll", query = "SELECT p FROM Parroquias p")})
public class Parroquias implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ParroquiasPK parroquiasPK;
    @Column(name = "PARROQUIA")
    private String parroquia;

    public Parroquias() {
    }

    public Parroquias(ParroquiasPK parroquiasPK) {
        this.parroquiasPK = parroquiasPK;
    }

    public Parroquias(String cntPrvCodigo, String cntCodigo, String codigo) {
        this.parroquiasPK = new ParroquiasPK(cntPrvCodigo, cntCodigo, codigo);
    }

    public ParroquiasPK getParroquiasPK() {
        return parroquiasPK;
    }

    public void setParroquiasPK(ParroquiasPK parroquiasPK) {
        this.parroquiasPK = parroquiasPK;
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
        hash += (parroquiasPK != null ? parroquiasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parroquias)) {
            return false;
        }
        Parroquias other = (Parroquias) object;
        if ((this.parroquiasPK == null && other.parroquiasPK != null) || (this.parroquiasPK != null && !this.parroquiasPK.equals(other.parroquiasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.pom_01_domain.Parroquias[ parroquiasPK=" + parroquiasPK + " ]";
    }
    
}
