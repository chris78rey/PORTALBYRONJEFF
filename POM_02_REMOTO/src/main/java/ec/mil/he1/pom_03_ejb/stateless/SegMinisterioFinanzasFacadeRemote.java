/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.pom_03_ejb.stateless;

import ec.mil.he1.pom_01_domain.SegMinisterioFinanzas;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author christian_ruiz
 */
@Remote
public interface SegMinisterioFinanzasFacadeRemote {

    void create(SegMinisterioFinanzas segMinisterioFinanzas);

    void edit(SegMinisterioFinanzas segMinisterioFinanzas);

    void remove(SegMinisterioFinanzas segMinisterioFinanzas);

    SegMinisterioFinanzas find(Object id);

    List<SegMinisterioFinanzas> findAll();

    List<SegMinisterioFinanzas> findRange(int[] range);

    int count();
    
}
