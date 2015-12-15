/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.pom_03_ejb.stateless;

import ec.mil.he1.pom_01_domain.VUsuarioHe1;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author christian_ruiz
 */
@Remote
public interface VUsuarioHe1FacadeRemote {

    void create(VUsuarioHe1 vUsuarioHe1);

    void edit(VUsuarioHe1 vUsuarioHe1);

    void remove(VUsuarioHe1 vUsuarioHe1);

    VUsuarioHe1 find(Object id);

    List<VUsuarioHe1> findAll();

    List<VUsuarioHe1> findRange(int[] range);

    int count();
    
}
