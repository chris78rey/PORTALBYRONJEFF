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
@Table(name = "SEG_MENU")
@NamedQueries({
    @NamedQuery(name = "SegMenu.findAll", query = "SELECT s FROM SegMenu s")})
public class SegMenu implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "MEN_ID")
    private BigDecimal menId;
    @Column(name = "MOD_ID")
    private BigInteger modId;
    @Column(name = "MEN_ID_RECURSIVO")
    private BigInteger menIdRecursivo;
    @Column(name = "MEN_NIVEL")
    private BigInteger menNivel;
    @Column(name = "MEN_ORDEN")
    private BigInteger menOrden;
    @Column(name = "MEN_DISPLAY")
    private String menDisplay;
    @Column(name = "MEN_URL")
    private String menUrl;
    @Column(name = "MEN_HIDE")
    private String menHide;

    public SegMenu() {
    }

    public SegMenu(BigDecimal menId) {
        this.menId = menId;
    }

    public BigDecimal getMenId() {
        return menId;
    }

    public void setMenId(BigDecimal menId) {
        this.menId = menId;
    }

    public BigInteger getModId() {
        return modId;
    }

    public void setModId(BigInteger modId) {
        this.modId = modId;
    }

    public BigInteger getMenIdRecursivo() {
        return menIdRecursivo;
    }

    public void setMenIdRecursivo(BigInteger menIdRecursivo) {
        this.menIdRecursivo = menIdRecursivo;
    }

    public BigInteger getMenNivel() {
        return menNivel;
    }

    public void setMenNivel(BigInteger menNivel) {
        this.menNivel = menNivel;
    }

    public BigInteger getMenOrden() {
        return menOrden;
    }

    public void setMenOrden(BigInteger menOrden) {
        this.menOrden = menOrden;
    }

    public String getMenDisplay() {
        return menDisplay;
    }

    public void setMenDisplay(String menDisplay) {
        this.menDisplay = menDisplay;
    }

    public String getMenUrl() {
        return menUrl;
    }

    public void setMenUrl(String menUrl) {
        this.menUrl = menUrl;
    }

    public String getMenHide() {
        return menHide;
    }

    public void setMenHide(String menHide) {
        this.menHide = menHide;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (menId != null ? menId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegMenu)) {
            return false;
        }
        SegMenu other = (SegMenu) object;
        if ((this.menId == null && other.menId != null) || (this.menId != null && !this.menId.equals(other.menId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.pom_01_domain.SegMenu[ menId=" + menId + " ]";
    }
    
}
