/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.pom_03_ejb.stateless;

import ec.mil.he1.pom_01_domain.Parroquias;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author christian_ruiz
 */
@Remote
public interface ParroquiasFacadeRemote {

    void create(Parroquias parroquias);

    void edit(Parroquias parroquias);

    void remove(Parroquias parroquias);

    Parroquias find(Object id);

    List<Parroquias> findAll();

    List<Parroquias> findRange(int[] range);

    int count();
    
}
