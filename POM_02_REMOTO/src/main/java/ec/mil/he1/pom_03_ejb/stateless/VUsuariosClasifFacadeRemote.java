/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.pom_03_ejb.stateless;

import ec.mil.he1.pom_01_domain.VUsuariosClasif;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author christian_ruiz
 */
@Remote
public interface VUsuariosClasifFacadeRemote {

    void create(VUsuariosClasif vUsuariosClasif);

    void edit(VUsuariosClasif vUsuariosClasif);

    void remove(VUsuariosClasif vUsuariosClasif);

    VUsuariosClasif find(Object id);

    List<VUsuariosClasif> findAll();

    List<VUsuariosClasif> findRange(int[] range);

    int count();
    
}
