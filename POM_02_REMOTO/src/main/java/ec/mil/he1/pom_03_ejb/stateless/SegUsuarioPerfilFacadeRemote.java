/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.pom_03_ejb.stateless;

import ec.mil.he1.pom_01_domain.SegUsuarioPerfil;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author christian_ruiz
 */
@Remote
public interface SegUsuarioPerfilFacadeRemote {

    void create(SegUsuarioPerfil segUsuarioPerfil);

    void edit(SegUsuarioPerfil segUsuarioPerfil);

    void remove(SegUsuarioPerfil segUsuarioPerfil);

    SegUsuarioPerfil find(Object id);

    List<SegUsuarioPerfil> findAll();

    List<SegUsuarioPerfil> findRange(int[] range);

    int count();
    
}
