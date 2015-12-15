/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.pom_03_ejb.stateless.procesos;

import ec.mil.he1.pom_01_domain.SegUsuario;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author christian_ruiz
 */
@Remote
public interface LoginSessionBeanRemote {
    public String Login(String pCedula, String pClave, String pModulo);
    public List<SegUsuario> listaUsuarioByCC(String CC);
    public SegUsuario usuarioByCC(String CC);

}
