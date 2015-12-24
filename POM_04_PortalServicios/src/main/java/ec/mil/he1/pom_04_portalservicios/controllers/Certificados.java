/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.pom_04_portalservicios.controllers;

import ec.mil.he1.pom_01_domain.SegUsuario;
import ec.mil.he1.pom_01_domain.VUsuariosClasif;
import ec.mil.he1.pom_03_ejb.stateless.procesos.ListasComunes;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.inject.Named;
import java.io.Serializable;
import static java.lang.System.out;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import static javax.faces.context.FacesContext.getCurrentInstance;
import javax.enterprise.context.SessionScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import org.primefaces.model.ByteArrayContent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author christian_ruiz
 */
@Named(value = "certificados")
@SessionScoped
public class Certificados implements Serializable {

    @Resource(name = "JDBCSERVICIOSHE1")
    private transient DataSource dataSourceHe1;

    private static final long serialVersionUID = -754931071112804936L;

    @EJB
    private transient  ListasComunes listasComunes;
    VUsuariosClasif vUsuariosClasif = new VUsuariosClasif();
    SegUsuario segUsuario = new SegUsuario();

    /**
     * Creates a new instance of Certificados
     */
    public Certificados() {
    }

    @PostConstruct
    private void init() {
        out.println("@PostConstruct");
        FacesContext facesContext = getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        vUsuariosClasif = (VUsuariosClasif) session.getAttribute("vUsuariosClasif");
        segUsuario = (SegUsuario) session.getAttribute("segUsuario");

    }

    public List<Map> listaBuscaFechasCertificados(String pCriterio) {
        return listasComunes.listaBuscaFechasCertificados(pCriterio);
    }

    public List<Map> getListaDetalleCertificados() {
        List data = new ArrayList<>();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);

        data = listasComunes.listaBuscaFechasCertificados(vUsuariosClasif.getNumeroHc().toString());
        return data;
    }

    public String accionImprimirPDF(String id) throws IOException {
        content = new ByteArrayContent();
        onPrerender(id);
        return null;
    }

//    se debe crear este metodo en este caso es de la factura
    public StreamedContent getContent() {

        return content;
    }

    public void setContent(StreamedContent content) {
        this.content = content;
    }

    private StreamedContent content;

    public void onPrerender(String id) {

        try {
            FacesContext context = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
            ServletContext servletContext = session.getServletContext();

            HashMap hashMap = new HashMap();
            Connection connection = dataSourceHe1.getConnection();
            byte[] bytes = null;
            try {
                //aca se coloca los parámetros del reporte
                hashMap.put("hc", vUsuariosClasif.getNumeroHc().toString());
                hashMap.put("numeroCertificado", id);
                hashMap.put("sello", "http://servicios.he1.mil.ec/AppImg/resources/images/logoHe1_blanco.png");

                //dentro de la carpeta WEB-INF se debe colocar los reportes, 
                //en este caso se coloca los .jrxml no el .jasper
                String jrxmlPath = servletContext.getRealPath("/WEB-INF/report/");
                // directories where the report files are 
                String reportfile = "CertificadoMedico.jrxml";
                String jrxmlfile = jrxmlPath + "/" + reportfile;

                //InputStream is = this.getClass().getClassLoader().getResourceAsStream("/WEB-INF/report/"+jrxmlfile);
                JasperReport jasperReport = JasperCompileManager.compileReport(jrxmlfile);            //is.close();

                //se obtiene la conexion a la base de datos
                connection = dataSourceHe1.getConnection();
                //se envia los parametros en este caso el compilado, el hashmap con los param del reporte y la conexión 
                //a la base de datos
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hashMap, connection);
                //se almacena la impresión en un arreglo de bytes    
                bytes = JasperExportManager.exportReportToPdf(jasperPrint);

                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);

                content = new DefaultStreamedContent(byteArrayInputStream, "application/pdf");

            } catch (JRException e) {
                //en caso de error imprimirlo
                System.out.println("e = " + e.getLocalizedMessage());
            } finally {
                //se cierra la conexion
                connection.close();

            }

        } catch (Exception e) {
        }
    }

}
