/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.pom_01_domain;

import java.io.Serializable;
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
@Table(name = "V_DETALLE_PACIENTE")
@NamedQueries({
    @NamedQuery(name = "VDetallePaciente.findAll", query = "SELECT v FROM VDetallePaciente v")})
public class VDetallePaciente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NUMERO_HC")
    private Integer numeroHc;
    @Column(name = "DERECHO")
    private String derecho;
    @Column(name = "FUERZA")
    private String fuerza;
    @Column(name = "GRADOM")
    private String gradom;
    @Column(name = "TIPO_DEPENDENCIA")
    private String tipoDependencia;
    @Column(name = "LOGEADO")
    private String logeado;
    @Column(name = "PRIMER_NOMBRE")
    private String primerNombre;
    @Column(name = "APELLIDO_PATERNO")
    private String apellidoPaterno;
    @Column(name = "SEXO")
    private String sexo;
    @Basic(optional = false)
    @Column(name = "ESTADO_CIVIL")
    private String estadoCivil;
    @Basic(optional = false)
    @Column(name = "CLASIFICACION")
    private String clasificacion;
    @Column(name = "APELLIDO_MATERNO")
    private String apellidoMaterno;
    @Column(name = "SEGUNDO_NOMBRE")
    private String segundoNombre;
    @Column(name = "CEDULA")
    private String cedula;
    @Column(name = "FECHA_NACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    @Column(name = "NUMERO_AFILIACION_IESS")
    private Long numeroAfiliacionIess;
    @Column(name = "OCP_CODIGO")
    private String ocpCodigo;
    @Column(name = "BLOQUEADO")
    private String bloqueado;
    @Basic(optional = false)
    @Column(name = "TIPO_PACIENTE")
    private String tipoPaciente;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "NUMERO_HC_ANTERIOR")
    private Long numeroHcAnterior;
    @Column(name = "FUERZA_")
    private String fuerza1;
    @Column(name = "GRADO")
    private String grado;
    @Column(name = "SITUACION")
    private String situacion;
    @Column(name = "ID_ISSFA_TITULAR")
    private String idIssfaTitular;
    @Column(name = "ID_ISSFA")
    private String idIssfa;
    @Column(name = "ES_TITULAR")
    private String esTitular;
    @Column(name = "TELEFONO")
    private String telefono;
    @Column(name = "TELEFONO_TRABAJO")
    private String telefonoTrabajo;
    @Column(name = "CELULAR")
    private String celular;

    public VDetallePaciente() {
    }

    public VDetallePaciente(Integer numeroHc) {
        this.numeroHc = numeroHc;
    }

    public VDetallePaciente(Integer numeroHc, String estadoCivil, String clasificacion, String tipoPaciente) {
        this.numeroHc = numeroHc;
        this.estadoCivil = estadoCivil;
        this.clasificacion = clasificacion;
        this.tipoPaciente = tipoPaciente;
    }

    public Integer getNumeroHc() {
        return numeroHc;
    }

    public void setNumeroHc(Integer numeroHc) {
        this.numeroHc = numeroHc;
    }

    public String getDerecho() {
        return derecho;
    }

    public void setDerecho(String derecho) {
        this.derecho = derecho;
    }

    public String getFuerza() {
        return fuerza;
    }

    public void setFuerza(String fuerza) {
        this.fuerza = fuerza;
    }

    public String getGradom() {
        return gradom;
    }

    public void setGradom(String gradom) {
        this.gradom = gradom;
    }

    public String getTipoDependencia() {
        return tipoDependencia;
    }

    public void setTipoDependencia(String tipoDependencia) {
        this.tipoDependencia = tipoDependencia;
    }

    public String getLogeado() {
        return logeado;
    }

    public void setLogeado(String logeado) {
        this.logeado = logeado;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Long getNumeroAfiliacionIess() {
        return numeroAfiliacionIess;
    }

    public void setNumeroAfiliacionIess(Long numeroAfiliacionIess) {
        this.numeroAfiliacionIess = numeroAfiliacionIess;
    }

    public String getOcpCodigo() {
        return ocpCodigo;
    }

    public void setOcpCodigo(String ocpCodigo) {
        this.ocpCodigo = ocpCodigo;
    }

    public String getBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(String bloqueado) {
        this.bloqueado = bloqueado;
    }

    public String getTipoPaciente() {
        return tipoPaciente;
    }

    public void setTipoPaciente(String tipoPaciente) {
        this.tipoPaciente = tipoPaciente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getNumeroHcAnterior() {
        return numeroHcAnterior;
    }

    public void setNumeroHcAnterior(Long numeroHcAnterior) {
        this.numeroHcAnterior = numeroHcAnterior;
    }

    public String getFuerza1() {
        return fuerza1;
    }

    public void setFuerza1(String fuerza1) {
        this.fuerza1 = fuerza1;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    public String getIdIssfaTitular() {
        return idIssfaTitular;
    }

    public void setIdIssfaTitular(String idIssfaTitular) {
        this.idIssfaTitular = idIssfaTitular;
    }

    public String getIdIssfa() {
        return idIssfa;
    }

    public void setIdIssfa(String idIssfa) {
        this.idIssfa = idIssfa;
    }

    public String getEsTitular() {
        return esTitular;
    }

    public void setEsTitular(String esTitular) {
        this.esTitular = esTitular;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefonoTrabajo() {
        return telefonoTrabajo;
    }

    public void setTelefonoTrabajo(String telefonoTrabajo) {
        this.telefonoTrabajo = telefonoTrabajo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroHc != null ? numeroHc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VDetallePaciente)) {
            return false;
        }
        VDetallePaciente other = (VDetallePaciente) object;
        if ((this.numeroHc == null && other.numeroHc != null) || (this.numeroHc != null && !this.numeroHc.equals(other.numeroHc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.pom_01_domain.VDetallePaciente[ numeroHc=" + numeroHc + " ]";
    }
    
}
