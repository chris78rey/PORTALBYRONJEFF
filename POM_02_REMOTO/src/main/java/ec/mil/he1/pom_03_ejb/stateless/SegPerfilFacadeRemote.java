/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.pom_03_ejb.stateless;

import ec.mil.he1.pom_01_domain.SegPerfil;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author christian_ruiz
 */
@Remote
public interface SegPerfilFacadeRemote {

    void create(SegPerfil segPerfil);

    void edit(SegPerfil segPerfil);

    void remove(SegPerfil segPerfil);

    SegPerfil find(Object id);

    List<SegPerfil> findAll();

    List<SegPerfil> findRange(int[] range);

    int count();
    
}
