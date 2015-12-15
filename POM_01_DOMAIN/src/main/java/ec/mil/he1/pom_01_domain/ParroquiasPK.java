/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.pom_01_domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author christian_ruiz
 */
@Embeddable
public class ParroquiasPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "CNT_PRV_CODIGO")
    private String cntPrvCodigo;
    @Basic(optional = false)
    @Column(name = "CNT_CODIGO")
    private String cntCodigo;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;

    public ParroquiasPK() {
    }

    public ParroquiasPK(String cntPrvCodigo, String cntCodigo, String codigo) {
        this.cntPrvCodigo = cntPrvCodigo;
        this.cntCodigo = cntCodigo;
        this.codigo = codigo;
    }

    public String getCntPrvCodigo() {
        return cntPrvCodigo;
    }

    public void setCntPrvCodigo(String cntPrvCodigo) {
        this.cntPrvCodigo = cntPrvCodigo;
    }

    public String getCntCodigo() {
        return cntCodigo;
    }

    public void setCntCodigo(String cntCodigo) {
        this.cntCodigo = cntCodigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cntPrvCodigo != null ? cntPrvCodigo.hashCode() : 0);
        hash += (cntCodigo != null ? cntCodigo.hashCode() : 0);
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParroquiasPK)) {
            return false;
        }
        ParroquiasPK other = (ParroquiasPK) object;
        if ((this.cntPrvCodigo == null && other.cntPrvCodigo != null) || (this.cntPrvCodigo != null && !this.cntPrvCodigo.equals(other.cntPrvCodigo))) {
            return false;
        }
        if ((this.cntCodigo == null && other.cntCodigo != null) || (this.cntCodigo != null && !this.cntCodigo.equals(other.cntCodigo))) {
            return false;
        }
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.pom_01_domain.ParroquiasPK[ cntPrvCodigo=" + cntPrvCodigo + ", cntCodigo=" + cntCodigo + ", codigo=" + codigo + " ]";
    }
    
}
