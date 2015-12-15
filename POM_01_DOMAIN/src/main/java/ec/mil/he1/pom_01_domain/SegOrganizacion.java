/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.pom_01_domain;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "SEG_ORGANIZACION")
@NamedQueries({
    @NamedQuery(name = "SegOrganizacion.findAll", query = "SELECT s FROM SegOrganizacion s")})
public class SegOrganizacion implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ORG_ID")
    private BigDecimal orgId;
    @Column(name = "ORG_NOMBRE")
    private String orgNombre;
    @Column(name = "ORG_RUC")
    private String orgRuc;

    public SegOrganizacion() {
    }

    public SegOrganizacion(BigDecimal orgId) {
        this.orgId = orgId;
    }

    public BigDecimal getOrgId() {
        return orgId;
    }

    public void setOrgId(BigDecimal orgId) {
        this.orgId = orgId;
    }

    public String getOrgNombre() {
        return orgNombre;
    }

    public void setOrgNombre(String orgNombre) {
        this.orgNombre = orgNombre;
    }

    public String getOrgRuc() {
        return orgRuc;
    }

    public void setOrgRuc(String orgRuc) {
        this.orgRuc = orgRuc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orgId != null ? orgId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegOrganizacion)) {
            return false;
        }
        SegOrganizacion other = (SegOrganizacion) object;
        if ((this.orgId == null && other.orgId != null) || (this.orgId != null && !this.orgId.equals(other.orgId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.mil.he1.pom_01_domain.SegOrganizacion[ orgId=" + orgId + " ]";
    }
    
}
