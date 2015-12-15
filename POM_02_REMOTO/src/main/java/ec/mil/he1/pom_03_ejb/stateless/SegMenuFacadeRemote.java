/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.pom_03_ejb.stateless;

import ec.mil.he1.pom_01_domain.SegMenu;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author christian_ruiz
 */
@Remote
public interface SegMenuFacadeRemote {

    void create(SegMenu segMenu);

    void edit(SegMenu segMenu);

    void remove(SegMenu segMenu);

    SegMenu find(Object id);

    List<SegMenu> findAll();

    List<SegMenu> findRange(int[] range);

    int count();
    
}
