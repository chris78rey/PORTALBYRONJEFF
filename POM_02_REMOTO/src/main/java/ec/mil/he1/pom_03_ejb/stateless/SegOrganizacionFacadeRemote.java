/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.pom_03_ejb.stateless;

import ec.mil.he1.pom_01_domain.SegOrganizacion;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author christian_ruiz
 */
@Remote
public interface SegOrganizacionFacadeRemote {

    void create(SegOrganizacion segOrganizacion);

    void edit(SegOrganizacion segOrganizacion);

    void remove(SegOrganizacion segOrganizacion);

    SegOrganizacion find(Object id);

    List<SegOrganizacion> findAll();

    List<SegOrganizacion> findRange(int[] range);

    int count();
    
}
