/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.pom_03_ejb.stateless;

import ec.mil.he1.pom_01_domain.VDetallePaciente;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author christian_ruiz
 */
@Remote
public interface VDetallePacienteFacadeRemote {

    void create(VDetallePaciente vDetallePaciente);

    void edit(VDetallePaciente vDetallePaciente);

    void remove(VDetallePaciente vDetallePaciente);

    VDetallePaciente find(Object id);

    List<VDetallePaciente> findAll();

    List<VDetallePaciente> findRange(int[] range);

    int count();
    
}
