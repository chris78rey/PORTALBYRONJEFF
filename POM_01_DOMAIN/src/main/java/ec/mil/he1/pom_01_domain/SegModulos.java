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
@Table(name = "SEG_MODULOS")
@NamedQueries({
    @NamedQuery(name = "SegModulos.findAll", query = "SELECT s FROM SegModulos s")})
public class SegModulos implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "MOD_ID")
    private BigDecimal modId;
    @Column(name = "ORG_ID")
    private BigInteger orgId;
    @Column(name = "MOD_NOMBRE_MODULO")
    private String modNombreModulo;
    @Column(name = "MOD_FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modFechaCreacion;
    @Column(name = "MOD_URL")
    private String modUrl;
    @Column(name = "MOD_URL_SIGUIENTE")
    private String modUrlSiguiente;
    @Column(name = "MOD_LOGO_NAME")
    private String modLogoName;
    @Column(name = "MOD_TITULO")
    private String modTitulo;
    @Column(name = "URL_CAMBIA")
    private BigInteger urlCambia;
    @Column(name = "MOD_ORDEN")
    private BigInteger modOrden;
    @Column(name = "MOD_CAMPO_ASOC_USUARIO")
    private String modCampoAsocUsuario;

    public SegModulos() {
    }

    public SegModulos(BigDecimal modId) {
        this.modId = modId;
    }

    public BigDecimal getModId() {
        return modId;
    }

    public void setModId(BigDecimal modId) {
        this.modId = modId;
    }

    public BigInteger getOrgId() {
        return orgId;
    }

    public void setOrgId(BigInteger orgId) {
        this.orgId = orgId;
    }

    public String getModNombreModulo() {
        return modNombreModulo;
    }

    public void setModNombreModulo(String modNombreModulo) {
        this.modNombreModulo = modNombreModulo;
    }

    public Date getModFechaCreacion() {
        return modFechaCreacion;
    }

    public void setModFechaCreacion(Date modFechaCreacion) {
        this.modFechaCreacion = modFechaCreacion;
    }

    public String getModUrl() {
        return modUrl;
    }

    public void setModUrl(String modUrl) {
        this.modUrl = modUrl;
    }

    public String getModUrlSiguiente() {
        return modUrlSiguiente;
    }

    public void setModUrlSiguiente(String modUrlSiguiente) {
        this.modUrlSiguiente = modUrlSiguiente;
    }

    public String getModLogoName() {
        return modLogoName;
    }

    public void setModLogoName(String modLogoName) {
        this.modLogoName = modLogoName;
    }

    public String getModTitulo() {
        return modTitulo;
    }

    public void setModTitulo(String modTitulo) {
        this.modTitulo = modTitulo;
    }

    public BigInteger getUrlCambia() {
        return urlCambia;
    }

    public void setUrlCambia(BigInteger urlCambia) {
        this.urlCambia = urlCambia;
    }

    public BigInteger getModOrden() {
        return modOrden;
    }

    public void setModOrden(BigInteger modOrden) {
        this.modOrden = modOrden;
    }

    /**
     * @return the modCampoAsocUsuario
     */
    public String getModCampoAsocUsuario() {
        return modCampoAsocUsuario;
    }

    /**
     * @param modCampoAsocUsuario the modCampoAsocUsuario to set
     */
    public void setModCampoAsocUsuario(String modCampoAsocUsuario) {
        this.modCampoAsocUsuario = modCampoAsocUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (modId != null ? modId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegModulos)) {
            return false;
        }
        SegModulos other = (SegModulos) object;
        if ((this.modId == null && other.modId != null) || (this.modId != null && !this.modId.equals(other.modId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.pom_01_domain.SegModulos[ modId=" + modId + " ]";
    }

}
