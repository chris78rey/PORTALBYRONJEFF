/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.pom_03_ejb.stateless.procesos;

import ec.mil.he1.pom_01_domain.Cantones;
import ec.mil.he1.pom_01_domain.Parroquias;
import ec.mil.he1.pom_01_domain.Provincias;
import ec.mil.he1.pom_01_domain.VDetallePaciente;
import java.util.List;
import java.util.Map;
import javax.ejb.Remote;

/**
 *
 * @author christian_ruiz
 */
@Remote
public interface ListasComunesRemote {

    public List<Provincias> ListProvincias();

    public List<Cantones> ListCantones(String proId);

    public List<Parroquias> ListParroquias(String proId,String canId);

    public List<Map> buscaHistorial(String pCriterio);

    public List<Map> litaPermanencias(String paciente, String pFecha1, String pFecha2);

    public List<VDetallePaciente> findPacientePorHC(Integer par);

    public List<Map> listaBuscaDependientes(String pCriterio);

    public List<Map> listaBuscaFechasCertificados(String pCriterio);

    public List<Map> listaFacturasPorHC(String pHC);

    public List<Map> listaturnossiguientes();

    
    
}
