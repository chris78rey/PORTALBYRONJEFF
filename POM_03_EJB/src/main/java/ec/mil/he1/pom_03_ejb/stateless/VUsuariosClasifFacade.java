/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.pom_03_ejb.stateless;

import ec.mil.he1.pom_01_domain.VUsuariosClasif;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author christian_ruiz
 */
@Stateless
@PermitAll
public class VUsuariosClasifFacade extends AbstractFacade<VUsuariosClasif> implements ec.mil.he1.pom_03_ejb.stateless.VUsuariosClasifFacadeRemote {
    @PersistenceContext(unitName = "PU-EJBPORTAL")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VUsuariosClasifFacade() {
        super(VUsuariosClasif.class);
    }
    
}
