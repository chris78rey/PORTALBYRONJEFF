/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.pom_03_ejb.stateless;

import ec.mil.he1.pom_01_domain.VProvCanParr;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author christian_ruiz
 */
@Remote
public interface VProvCanParrFacadeRemote {

    void create(VProvCanParr vProvCanParr);

    void edit(VProvCanParr vProvCanParr);

    void remove(VProvCanParr vProvCanParr);

    VProvCanParr find(Object id);

    List<VProvCanParr> findAll();

    List<VProvCanParr> findRange(int[] range);

    int count();
    
}
