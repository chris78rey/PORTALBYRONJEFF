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
@Table(name = "SEG_MINISTERIO_FINANZAS")
@NamedQueries({
    @NamedQuery(name = "SegMinisterioFinanzas.findAll", query = "SELECT s FROM SegMinisterioFinanzas s")})
public class SegMinisterioFinanzas implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "TRL_ID")
    private BigInteger trlId;
    @Column(name = "MFI_ANIO")
    private String mfiAnio;
    @Column(name = "MFI_MES")
    private String mfiMes;
    @Column(name = "MFI_CODIGO")
    private String mfiCodigo;
    @Column(name = "MFI_DESC")
    private String mfiDesc;
    @Column(name = "ACTIVO")
    private BigInteger activo;
    @Column(name = "ORDEN")
    private BigInteger orden;

    public SegMinisterioFinanzas() {
    }

    public SegMinisterioFinanzas(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getTrlId() {
        return trlId;
    }

    public void setTrlId(BigInteger trlId) {
        this.trlId = trlId;
    }

    public String getMfiAnio() {
        return mfiAnio;
    }

    public void setMfiAnio(String mfiAnio) {
        this.mfiAnio = mfiAnio;
    }

    public String getMfiMes() {
        return mfiMes;
    }

    public void setMfiMes(String mfiMes) {
        this.mfiMes = mfiMes;
    }

    public String getMfiCodigo() {
        return mfiCodigo;
    }

    public void setMfiCodigo(String mfiCodigo) {
        this.mfiCodigo = mfiCodigo;
    }

    public String getMfiDesc() {
        return mfiDesc;
    }

    public void setMfiDesc(String mfiDesc) {
        this.mfiDesc = mfiDesc;
    }

    public BigInteger getActivo() {
        return activo;
    }

    public void setActivo(BigInteger activo) {
        this.activo = activo;
    }

    public BigInteger getOrden() {
        return orden;
    }

    public void setOrden(BigInteger orden) {
        this.orden = orden;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegMinisterioFinanzas)) {
            return false;
        }
        SegMinisterioFinanzas other = (SegMinisterioFinanzas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.pom_01_domain.SegMinisterioFinanzas[ id=" + id + " ]";
    }
    
}
