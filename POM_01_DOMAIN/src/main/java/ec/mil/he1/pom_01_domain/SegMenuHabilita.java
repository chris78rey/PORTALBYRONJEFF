/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.pom_01_domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "SEG_MENU_HABILITA")
@NamedQueries({
    @NamedQuery(name = "SegMenuHabilita.findAll", query = "SELECT s FROM SegMenuHabilita s")})
public class SegMenuHabilita implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "MHA_ID")
    private BigDecimal mhaId;
    @Column(name = "PER_ID")
    private BigInteger perId;
    @Column(name = "MEN_ID")
    private BigInteger menId;
    @Column(name = "MHA_HABILITA")
    private BigInteger mhaHabilita;
    @Column(name = "MHA_GUARDAR")
    private BigInteger mhaGuardar;
    @Column(name = "MHA_NUEVO_REGISTRO")
    private BigInteger mhaNuevoRegistro;
    @Column(name = "MHA_ELIMINAR")
    private BigInteger mhaEliminar;
    @Column(name = "MHA_EDITAR")
    private BigInteger mhaEditar;

    public SegMenuHabilita() {
    }

    public SegMenuHabilita(BigDecimal mhaId) {
        this.mhaId = mhaId;
    }

    public BigDecimal getMhaId() {
        return mhaId;
    }

    public void setMhaId(BigDecimal mhaId) {
        this.mhaId = mhaId;
    }

    public BigInteger getPerId() {
        return perId;
    }

    public void setPerId(BigInteger perId) {
        this.perId = perId;
    }

    public BigInteger getMenId() {
        return menId;
    }

    public void setMenId(BigInteger menId) {
        this.menId = menId;
    }

    public BigInteger getMhaHabilita() {
        return mhaHabilita;
    }

    public void setMhaHabilita(BigInteger mhaHabilita) {
        this.mhaHabilita = mhaHabilita;
    }

    public BigInteger getMhaGuardar() {
        return mhaGuardar;
    }

    public void setMhaGuardar(BigInteger mhaGuardar) {
        this.mhaGuardar = mhaGuardar;
    }

    public BigInteger getMhaNuevoRegistro() {
        return mhaNuevoRegistro;
    }

    public void setMhaNuevoRegistro(BigInteger mhaNuevoRegistro) {
        this.mhaNuevoRegistro = mhaNuevoRegistro;
    }

    public BigInteger getMhaEliminar() {
        return mhaEliminar;
    }

    public void setMhaEliminar(BigInteger mhaEliminar) {
        this.mhaEliminar = mhaEliminar;
    }

    public BigInteger getMhaEditar() {
        return mhaEditar;
    }

    public void setMhaEditar(BigInteger mhaEditar) {
        this.mhaEditar = mhaEditar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mhaId != null ? mhaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegMenuHabilita)) {
            return false;
        }
        SegMenuHabilita other = (SegMenuHabilita) object;
        if ((this.mhaId == null && other.mhaId != null) || (this.mhaId != null && !this.mhaId.equals(other.mhaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.pom_01_domain.SegMenuHabilita[ mhaId=" + mhaId + " ]";
    }
    
}
