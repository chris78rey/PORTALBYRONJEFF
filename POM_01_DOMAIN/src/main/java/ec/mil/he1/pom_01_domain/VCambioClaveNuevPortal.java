package ec.mil.he1.pom_01_domain;


import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "V_CAMBIO_CLAVE_NUEV_PORTAL")

public class VCambioClaveNuevPortal implements Serializable {
    private static final long serialVersionUID = 9004451991482640975L;

    @Column(name = "CLAVE_NUEVA", table = "V_CAMBIO_CLAVE_NUEV_PORTAL", length = 24)
    @Basic
    private String claveNueva;

    @Column(name = "CLAVE_NUEVA2", table = "V_CAMBIO_CLAVE_NUEV_PORTAL", length = 24)
    @Basic
    private String claveNueva2;

    @Column(name = "CEDULA_LOGIN", table = "V_CAMBIO_CLAVE_NUEV_PORTAL", length = 40000)
    @Basic
    private String cedulaLogin;

    @Column(name = "ID", table = "V_CAMBIO_CLAVE_NUEV_PORTAL", nullable = false, precision = 38)
    @Id
    private BigDecimal id;

    @Column(name = "USU_CLAVE", table = "V_CAMBIO_CLAVE_NUEV_PORTAL", length = 4000)
    @Basic
    private String usuClave;

    public VCambioClaveNuevPortal() {

    }

    public String getClaveNueva() {
        return this.claveNueva;
    }

    public void setClaveNueva(String claveNueva) {
        this.claveNueva = claveNueva;
    }

    public String getClaveNueva2() {
        return this.claveNueva2;
    }

    public void setClaveNueva2(String claveNueva2) {
        this.claveNueva2 = claveNueva2;
    }

    public String getCedulaLogin() {
        return this.cedulaLogin;
    }

    public void setCedulaLogin(String cedulaLogin) {
        this.cedulaLogin = cedulaLogin;
    }

    public BigDecimal getId() {
        return this.id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getUsuClave() {
        return this.usuClave;
    }

    public void setUsuClave(String usuClave) {
        this.usuClave = usuClave;
    }
}
