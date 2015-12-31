/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.pom_03_ejb.stateless;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author christian_ruiz
 */
@Entity
@Table(name = "V_TURNOS_RESERVADOS")
public class VTurnosReservados implements Serializable {

    private static final long serialVersionUID = 1L;

    public VTurnosReservados() {
    }
    @Column(name = "NUMERO_ID")
    @Basic(optional = false)
    @Id
    private String numeroId;

    public void setNumeroId(String numeroId) {
        this.numeroId = numeroId;
    }

    public String getNumeroId() {
        return this.numeroId;
    }

    @Column(name = "PCN_NUMERO_HC")
    @Basic(optional = true)
    private String pcnNumeroHc;

    public void setPcnNumeroHc(String pcnNumeroHc) {
        this.pcnNumeroHc = pcnNumeroHc;
    }

    public String getPcnNumeroHc() {
        return this.pcnNumeroHc;
    }

    @Column(name = "SERVICIO")
    @Basic(optional = true)
    private String servicio;

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getServicio() {
        return this.servicio;
    }

    @Column(name = "CONSULTORIO")
    @Basic(optional = true)
    private String consultorio;

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }

    public String getConsultorio() {
        return this.consultorio;
    }

    @Column(name = "FECHA")
    @Basic(optional = true)
    private String fecha;

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFecha() {
        return this.fecha;
    }

}
