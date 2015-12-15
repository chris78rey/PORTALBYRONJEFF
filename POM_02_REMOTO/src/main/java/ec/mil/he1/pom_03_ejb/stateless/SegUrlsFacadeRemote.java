/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.pom_03_ejb.stateless;

import ec.mil.he1.pom_01_domain.SegUrls;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author christian_ruiz
 */
@Remote
public interface SegUrlsFacadeRemote {

    void create(SegUrls segUrls);

    void edit(SegUrls segUrls);

    void remove(SegUrls segUrls);

    SegUrls find(Object id);

    List<SegUrls> findAll();

    List<SegUrls> findRange(int[] range);

    int count();
    
}
