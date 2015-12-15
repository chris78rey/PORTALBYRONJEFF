/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.pom_03_ejb.stateless.procesos;

import ec.mil.he1.pom_01_domain.SegUsuario;
import ec.mil.he1.pom_01_domain.SegUsuario_;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author christian_ruiz
 */
@Stateless
@PermitAll
public class LoginSessionBean implements LoginSessionBeanRemote{

    @PersistenceContext(unitName = "PU-EJBPORTAL")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public String Login(String pCedula, String pClave, String pModulo) {
        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("P_LOGIN_COMUN_MODULO");
        // set parameters
        storedProcedure.registerStoredProcedureParameter("P_CEDULA", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("P_CLAVE", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("P_MODULO", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("P_RETORNA", String.class, ParameterMode.OUT);

        storedProcedure.setParameter("P_CEDULA", pCedula);
        storedProcedure.setParameter("P_CLAVE", pClave);
        storedProcedure.setParameter("P_MODULO", pModulo);
        // execute SP
        storedProcedure.execute();
        // get result
        String pRetorna = (String) storedProcedure.getOutputParameterValue("P_RETORNA");
        return pRetorna;
    }

    @Override
    public List<SegUsuario> listaUsuarioByCC(String CC) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<SegUsuario> cq = cb.createQuery(SegUsuario.class);
        Root<SegUsuario> root = cq.from(SegUsuario.class);
        cq.where(cb.equal(root.get(SegUsuario_.cedulaLogin), CC));
        List resultList = em.createQuery(cq).setHint("eclipselink.refresh", "true").getResultList();
        return resultList;

    }

    @Override
    public SegUsuario usuarioByCC(String CC) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<SegUsuario> cq = cb.createQuery(SegUsuario.class);
        Root<SegUsuario> root = cq.from(SegUsuario.class);
        cq.where(cb.equal(root.get(SegUsuario_.cedulaLogin), CC));
        List<SegUsuario> resultList = em.createQuery(cq).setHint("eclipselink.refresh", "true").getResultList();       
    
        
        SegUsuario segUsuario = new SegUsuario();
        for (SegUsuario resultList1 : resultList) {
            segUsuario = resultList1;
        }
        return segUsuario;

    }

}
