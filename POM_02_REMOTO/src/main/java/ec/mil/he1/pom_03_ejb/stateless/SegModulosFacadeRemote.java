/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.pom_03_ejb.stateless;

import ec.mil.he1.pom_01_domain.SegModulos;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author christian_ruiz
 */
@Remote
public interface SegModulosFacadeRemote {

    void create(SegModulos segModulos);

    void edit(SegModulos segModulos);

    void remove(SegModulos segModulos);

    SegModulos find(Object id);

    List<SegModulos> findAll();

    List<SegModulos> findRange(int[] range);

    int count();
    
}
