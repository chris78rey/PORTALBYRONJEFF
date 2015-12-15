/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.pom_03_ejb.stateless;

import ec.mil.he1.pom_01_domain.SegSoftwareBitacora;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author christian_ruiz
 */
@Remote
public interface SegSoftwareBitacoraFacadeRemote {

    void create(SegSoftwareBitacora segSoftwareBitacora);

    void edit(SegSoftwareBitacora segSoftwareBitacora);

    void remove(SegSoftwareBitacora segSoftwareBitacora);

    SegSoftwareBitacora find(Object id);

    List<SegSoftwareBitacora> findAll();

    List<SegSoftwareBitacora> findRange(int[] range);

    int count();
    
}
