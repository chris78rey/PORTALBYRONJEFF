/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.pom_03_ejb.stateless;

import ec.mil.he1.pom_01_domain.SegUsuariosExternos;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author christian_ruiz
 */
@Remote
public interface SegUsuariosExternosFacadeRemote {

    void create(SegUsuariosExternos segUsuariosExternos);

    void edit(SegUsuariosExternos segUsuariosExternos);

    void remove(SegUsuariosExternos segUsuariosExternos);

    SegUsuariosExternos find(Object id);

    List<SegUsuariosExternos> findAll();

    List<SegUsuariosExternos> findRange(int[] range);

    int count();
    
}
