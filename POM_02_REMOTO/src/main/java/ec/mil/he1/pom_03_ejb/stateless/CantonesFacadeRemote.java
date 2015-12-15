/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.pom_03_ejb.stateless;

import ec.mil.he1.pom_01_domain.Cantones;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author christian_ruiz
 */
@Remote
public interface CantonesFacadeRemote {

    void create(Cantones cantones);

    void edit(Cantones cantones);

    void remove(Cantones cantones);

    Cantones find(Object id);

    List<Cantones> findAll();

    List<Cantones> findRange(int[] range);

    int count();
    
}
