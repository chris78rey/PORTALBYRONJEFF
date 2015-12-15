/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.pom_03_ejb.stateless;

import ec.mil.he1.pom_01_domain.SegUsuario;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author christian_ruiz
 */
@Remote
public interface SegUsuarioFacadeRemote {

    void create(SegUsuario segUsuario);

    void edit(SegUsuario segUsuario);

    void remove(SegUsuario segUsuario);

    SegUsuario find(Object id);

    List<SegUsuario> findAll();

    List<SegUsuario> findRange(int[] range);

    int count();
    
}
