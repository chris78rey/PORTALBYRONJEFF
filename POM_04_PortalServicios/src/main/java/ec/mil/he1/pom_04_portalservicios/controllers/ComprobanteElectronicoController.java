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
import java.io.Serializable;
import static java.lang.System.out;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import static javax.faces.context.FacesContext.getCurrentInstance;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author byron_simbana
 */
@Named(value = "comprobanteElectronicoController")
@ViewScoped
public class ComprobanteElectronicoController implements Serializable {

    private static final long serialVersionUID = -1;
    @EJB
    private ListasComunes listasComunes;
    private SegUsuario segUsuario = new SegUsuario();
    private List<Map> listaFacturasPorHC = new ArrayList<>();
    private VUsuariosClasif vUsuariosClasif;

    @Resource(name = "JDBCSERVICIOSHE1")
    private DataSource dataSourceHe1;

    @PostConstruct
    private void init() {
        out.println("@PostConstruct");
        FacesContext facesContext = getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        vUsuariosClasif = (VUsuariosClasif) session.getAttribute("vUsuariosClasif");
        segUsuario = (SegUsuario) session.getAttribute("segUsuario");

    }

    public List<Map> listaFacturasPorHC(String pHC) {
        return listasComunes.listaFacturasPorHC(pHC);
    }

    public List<Map> getListaFacturasPorHC() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        listaFacturasPorHC = listasComunes.listaFacturasPorHC(segUsuario.getNumeroHc().toString());
        return listaFacturasPorHC;
    }

    public String buscaIDFactura(String rid, String valor) {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            String URL = ec.getRequestContextPath()+ "/Factura?kkjdndj=" + rid + "&sddvaxd=" + valor;
            //PASA PARAM ID de la factura y la caha
            ec.redirect(URL);
        } catch (IOException ex) {
            Logger.getLogger(Factura.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public StreamedContent doReport() throws Exception {
        // setting up some basic stuff
        // This is not so pretty, I would much rather like not to pull web beans into here, 
        // but you know...

        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        HttpServletRequest req = (HttpServletRequest) ectx.getRequest();
        ServletContext servletContext = req.getSession().getServletContext();

        //HashMap<String, String> hashMap = new HashMap<String, String>();
        HashMap hashMap = new HashMap();
        hashMap.put("rid", "AAA2PEAAGAAKbcbAAC");
        hashMap.put("valor", "36.88");

        String reportFilename = null;
        Connection connection = null;
        byte[] bytes = null;
        try {
            String jrxmlPath = servletContext.getRealPath("/WEB-INF/report/");
            String reportfile = "FacturasHE1.jasper";
            // directories where the report files are 
            String jrxmlfile = jrxmlPath + "/" + reportfile;

            //InputStream is = this.getClass().getClassLoader().getResourceAsStream("/WEB-INF/report/"+jrxmlfile);
            JasperReport jasperReport = JasperCompileManager.compileReport(jrxmlfile);
            //is.close();

            // we use the ReportsCharts class as data source 
            // instead of connecting directly to the database
            connection = dataSourceHe1.getConnection();
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hashMap, connection);

            // and directories where the reports will be generated
            String reportsPath = servletContext.getRealPath("/WEB-INF/report/");
            reportFilename = "reports_" + req.getSession().getId() + ".html";
            String reportFile = reportsPath + "/" + reportFilename;

            bytes = JasperExportManager.exportReportToPdf(jasperPrint);
        } catch (JRException e) {
            System.out.println("e = " + e.getLocalizedMessage());
        } finally {
            connection.close();
        }
        return new DefaultStreamedContent(new ByteArrayInputStream(bytes));
    }

    public ComprobanteElectronicoController() {
    }

}
