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
@Table(name = "SEG_USUARIO")
@NamedQueries({
    @NamedQuery(name = "SegUsuario.findAll", query = "SELECT s FROM SegUsuario s")})
public class SegUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
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
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "TELEFONO")
    private String telefono;
    @Column(name = "CELULAR")
    private String celular;
    @Column(name = "DIRECCION_DOMICILIO")
    private String direccionDomicilio;
    @Column(name = "CNT_PRV_CODIGO")
    private String cntPrvCodigo;
    @Column(name = "CNT_CODIGO")
    private String cntCodigo;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "INACTIVA")
    private Character inactiva;
    @Column(name = "OCULTAR")
    private BigInteger ocultar;
    @Column(name = "ACTUALIZAR_DATOS")
    private BigInteger actualizarDatos;

    public SegUsuario() {
    }

    public SegUsuario(BigDecimal id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccionDomicilio() {
        return direccionDomicilio;
    }

    public void setDireccionDomicilio(String direccionDomicilio) {
        this.direccionDomicilio = direccionDomicilio;
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
        System.out.println("codigo = " + codigo);
        System.out.println("codigo = " + codigo);
        this.codigo = codigo;
    }

    public Character getInactiva() {
        return inactiva;
    }

    public void setInactiva(Character inactiva) {
        this.inactiva = inactiva;
    }

    public BigInteger getOcultar() {
        return ocultar;
    }

    public void setOcultar(BigInteger ocultar) {
        this.ocultar = ocultar;
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
        if (!(object instanceof SegUsuario)) {
            return false;
        }
        SegUsuario other = (SegUsuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.pom_01_domain.SegUsuario[ id=" + id + " ]";
    }

    public BigInteger getActualizarDatos() {
        return actualizarDatos;
    }

    public void setActualizarDatos(BigInteger actualizarDatos) {
        this.actualizarDatos = actualizarDatos;
    }

}
