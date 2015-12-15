/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.pom_03_ejb.stateless;

import ec.mil.he1.pom_01_domain.SegMenuHabilita;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author christian_ruiz
 */
@Remote
public interface SegMenuHabilitaFacadeRemote {

    void create(SegMenuHabilita segMenuHabilita);

    void edit(SegMenuHabilita segMenuHabilita);

    void remove(SegMenuHabilita segMenuHabilita);

    SegMenuHabilita find(Object id);

    List<SegMenuHabilita> findAll();

    List<SegMenuHabilita> findRange(int[] range);

    int count();
    
}
