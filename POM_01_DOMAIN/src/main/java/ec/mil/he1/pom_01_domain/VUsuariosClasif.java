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
@Table(name = "V_USUARIOS_CLASIF")
@NamedQueries({
    @NamedQuery(name = "VUsuariosClasif.findAll", query = "SELECT v FROM VUsuariosClasif v")})
public class VUsuariosClasif implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "TIPO_USER")
    private String tipoUser;
    @Column(name = "CEDULA_LOGIN")
    private String cedulaLogin;
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Column(name = "NOMBRES")
    private String nombres;
    @Column(name = "CELULAR")
    private String celular;
    @Column(name = "ID_ISSFA")
    private String idIssfa;
    @Column(name = "NUMERO_HC")
    private BigInteger numeroHc;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PER_CODIGO")
    private String perCodigo;
    @Column(name = "NOM_ID")
    private BigInteger nomId;
    @Column(name = "USU_EXT")
    private BigInteger usuExt;
    @Column(name = "CARGO_EN_PERSONAL")
    private String cargoEnPersonal;
    @Column(name = "MEDICO_ESPECIALISTA")
    private String medicoEspecialista;
    @Column(name = "ACTUALIZAR_DATOS")
    private BigDecimal actualizarDatos;

    public VUsuariosClasif() {
    }

    public VUsuariosClasif(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(String tipoUser) {
        this.tipoUser = tipoUser;
    }

    public String getCedulaLogin() {
        return cedulaLogin;
    }

    public void setCedulaLogin(String cedulaLogin) {
        this.cedulaLogin = cedulaLogin;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getIdIssfa() {
        return idIssfa;
    }

    public void setIdIssfa(String idIssfa) {
        this.idIssfa = idIssfa;
    }

    public BigInteger getNumeroHc() {
        return numeroHc;
    }

    public void setNumeroHc(BigInteger numeroHc) {
        this.numeroHc = numeroHc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPerCodigo() {
        return perCodigo;
    }

    public void setPerCodigo(String perCodigo) {
        this.perCodigo = perCodigo;
    }

    public BigInteger getNomId() {
        return nomId;
    }

    public void setNomId(BigInteger nomId) {
        this.nomId = nomId;
    }

    public BigInteger getUsuExt() {
        return usuExt;
    }

    public void setUsuExt(BigInteger usuExt) {
        this.usuExt = usuExt;
    }

    public String getCargoEnPersonal() {
        return cargoEnPersonal;
    }

    public void setCargoEnPersonal(String cargoEnPersonal) {
        this.cargoEnPersonal = cargoEnPersonal;
    }

    public String getMedicoEspecialista() {
        return medicoEspecialista;
    }

    public void setMedicoEspecialista(String medicoEspecialista) {
        this.medicoEspecialista = medicoEspecialista;
    }

    public BigDecimal getActualizarDatos() {
        return actualizarDatos;
    }

    public void setActualizarDatos(BigDecimal actualizarDatos) {
        this.actualizarDatos = actualizarDatos;
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
        if (!(object instanceof VUsuariosClasif)) {
            return false;
        }
        VUsuariosClasif other = (VUsuariosClasif) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.pom_01_domain.VUsuariosClasif[ id=" + id + " ]";
    }

}
