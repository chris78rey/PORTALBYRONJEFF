/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.pom_03_ejb.stateless;

import ec.mil.he1.pom_01_domain.SeguimientosSociales;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author christian_ruiz
 */
@Remote
public interface SeguimientosSocialesFacadeRemote {

    void create(SeguimientosSociales seguimientosSociales);

    void edit(SeguimientosSociales seguimientosSociales);

    void remove(SeguimientosSociales seguimientosSociales);

    SeguimientosSociales find(Object id);

    List<SeguimientosSociales> findAll();

    List<SeguimientosSociales> findRange(int[] range);

    int count();
    
}
