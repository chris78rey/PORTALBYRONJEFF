/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.pom_03_ejb.stateless;

import java.util.List;

/**
 *
 * @author christian_ruiz
 */
@javax.ejb.Remote
public interface SegLogsSistemaFacadeRemote {

    void create(ec.mil.he1.pom_01_domain.SegLogsSistema segLogsSistema);

    void edit(ec.mil.he1.pom_01_domain.SegLogsSistema segLogsSistema);

    void remove(ec.mil.he1.pom_01_domain.SegLogsSistema segLogsSistema);

    ec.mil.he1.pom_01_domain.SegLogsSistema find(Object id);

    int count();

}
