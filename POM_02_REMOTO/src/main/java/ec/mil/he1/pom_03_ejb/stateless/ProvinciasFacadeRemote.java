/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.pom_03_ejb.stateless;

import ec.mil.he1.pom_01_domain.Provincias;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author christian_ruiz
 */
@Remote
public interface ProvinciasFacadeRemote {

    void create(Provincias provincias);

    void edit(Provincias provincias);

    void remove(Provincias provincias);

    Provincias find(Object id);

    List<Provincias> findAll();

    List<Provincias> findRange(int[] range);

    int count();
    
}
