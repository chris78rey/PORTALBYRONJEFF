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
@Table(name = "V_USUARIO_HE1")
@NamedQueries({
    @NamedQuery(name = "VUsuarioHe1.findAll", query = "SELECT v FROM VUsuarioHe1 v")})
public class VUsuarioHe1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "TIPO_USER")
    private String tipoUser;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @Column(name = "USU_TIPO")
    private Character usuTipo;
    @Column(name = "NUMERO_HC")
    private BigInteger numeroHc;
    @Column(name = "UEX_ID")
    private BigInteger uexId;
    @Column(name = "PER_CODIGO")
    private String perCodigo;
    @Column(name = "USU_CLAVE")
    private String usuClave;
    @Column(name = "NOM_ID")
    private BigInteger nomId;
    @Column(name = "CEDULA_LOGIN")
    private String cedulaLogin;
    @Column(name = "HC")
    private BigInteger hc;
    @Column(name = "USU_EXT")
    private BigInteger usuExt;
    @Column(name = "PERSONAL")
    private String personal;
    @Column(name = "NOMINA")
    private BigInteger nomina;
    @Column(name = "CARGO_EN_PERSONAL")
    private String cargoEnPersonal;

    public VUsuarioHe1() {
    }

    public VUsuarioHe1(BigDecimal id) {
        this.id = id;
    }

    public VUsuarioHe1(BigDecimal id, Character usuTipo) {
        this.id = id;
        this.usuTipo = usuTipo;
    }

    public String getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(String tipoUser) {
        this.tipoUser = tipoUser;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Character getUsuTipo() {
        return usuTipo;
    }

    public void setUsuTipo(Character usuTipo) {
        this.usuTipo = usuTipo;
    }

    public BigInteger getNumeroHc() {
        return numeroHc;
    }

    public void setNumeroHc(BigInteger numeroHc) {
        this.numeroHc = numeroHc;
    }

    public BigInteger getUexId() {
        return uexId;
    }

    public void setUexId(BigInteger uexId) {
        this.uexId = uexId;
    }

    public String getPerCodigo() {
        return perCodigo;
    }

    public void setPerCodigo(String perCodigo) {
        this.perCodigo = perCodigo;
    }

    public String getUsuClave() {
        return usuClave;
    }

    public void setUsuClave(String usuClave) {
        this.usuClave = usuClave;
    }

    public BigInteger getNomId() {
        return nomId;
    }

    public void setNomId(BigInteger nomId) {
        this.nomId = nomId;
    }

    public String getCedulaLogin() {
        return cedulaLogin;
    }

    public void setCedulaLogin(String cedulaLogin) {
        this.cedulaLogin = cedulaLogin;
    }

    public BigInteger getHc() {
        return hc;
    }

    public void setHc(BigInteger hc) {
        this.hc = hc;
    }

    public BigInteger getUsuExt() {
        return usuExt;
    }

    public void setUsuExt(BigInteger usuExt) {
        this.usuExt = usuExt;
    }

    public String getPersonal() {
        return personal;
    }

    public void setPersonal(String personal) {
        this.personal = personal;
    }

    public BigInteger getNomina() {
        return nomina;
    }

    public void setNomina(BigInteger nomina) {
        this.nomina = nomina;
    }

    public String getCargoEnPersonal() {
        return cargoEnPersonal;
    }

    public void setCargoEnPersonal(String cargoEnPersonal) {
        this.cargoEnPersonal = cargoEnPersonal;
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
        if (!(object instanceof VUsuarioHe1)) {
            return false;
        }
        VUsuarioHe1 other = (VUsuarioHe1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.pom_01_domain.VUsuarioHe1[ id=" + id + " ]";
    }
    
}
