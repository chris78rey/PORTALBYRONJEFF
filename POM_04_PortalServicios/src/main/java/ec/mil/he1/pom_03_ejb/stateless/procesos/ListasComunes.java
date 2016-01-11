/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.pom_03_ejb.stateless.procesos;

import ec.mil.he1.pom_01_domain.Cantones;
import ec.mil.he1.pom_01_domain.Cantones_;
import ec.mil.he1.pom_01_domain.Parroquias;
import ec.mil.he1.pom_01_domain.Parroquias_;
import ec.mil.he1.pom_01_domain.Provincias;
import ec.mil.he1.pom_01_domain.Provincias_;
import ec.mil.he1.pom_01_domain.VCambioClaveNuevPortal;
import ec.mil.he1.pom_01_domain.VCambioClaveNuevPortal_;
import ec.mil.he1.pom_01_domain.VClaveReset;
import ec.mil.he1.pom_01_domain.VClaveReset_;
import ec.mil.he1.pom_01_domain.VDetallePaciente;
import ec.mil.he1.pom_01_domain.VDetallePaciente_;
import ec.mil.he1.pom_03_ejb.stateless.VTurnosReservados;
import ec.mil.he1.pom_03_ejb.stateless.VTurnosReservados_;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author christian_ruiz
 */
@Stateless
@PermitAll
public class ListasComunes {

    @PersistenceContext(unitName = "PU-EJBPORTAL")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Provincias> ListProvincias() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Provincias> cq = cb.createQuery(Provincias.class);
        Root<Provincias> root = cq.from(Provincias.class);
        cq.orderBy(cb.asc(root.get(Provincias_.provincia)));
        List resultList = em.createQuery(cq).setHint("eclipselink.refresh", "true").getResultList();
        return resultList;
    }

    public List<Cantones> ListCantones(String proId) {
        if (proId.length() != 0) {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Cantones> cq = cb.createQuery(Cantones.class);
            Root<Cantones> root = cq.from(Cantones.class);
            cq.orderBy(cb.asc(root.get(Cantones_.canton)));
            List<Cantones> resultList = em.createQuery(cq).setHint("eclipselink.refresh", "true").getResultList();
            List<Cantones> resultList2 = new ArrayList<>();

            for (Cantones resultList1 : resultList) {
                if (resultList1.getCantonesPK().getPrvCodigo().equalsIgnoreCase(proId)) {
                    resultList2.add(resultList1);
                }
            }
            return resultList2;
        } else {
            return null;
        }

    }

    public List<Parroquias> ListParroquias(String proId, String canId) {

        if (canId.length() != 0) {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Parroquias> cq = cb.createQuery(Parroquias.class);
            Root<Parroquias> root = cq.from(Parroquias.class);
            cq.orderBy(cb.asc(root.get(Parroquias_.parroquia)));
            List<Parroquias> resultList = em.createQuery(cq).setHint("eclipselink.refresh", "true").getResultList();
            List<Parroquias> resultList2 = new ArrayList<>();

            for (Parroquias resultList21 : resultList) {
                if (resultList21.getParroquiasPK().getCntCodigo().equalsIgnoreCase(canId) && resultList21.getParroquiasPK().getCntPrvCodigo().equals(proId)) {
                    resultList2.add(resultList21);
                }

            }
            return resultList2;
        } else {
            return null;
        }

    }

    public List<Map> buscaHistorial(String pCriterio) {

        String sql;
        sql = " SELECT TO_CHAR (FECHA,  'fmday/dd/month/yyyy',  'nls_date_language = spanish')FECHAS, "
                + "NUMERO, APELLIDOS, NOMBRES, "
                + "(CASE ESTADO WHEN 'R' THEN 'RESERVADO' WHEN "
                + "'A' THEN 'ATENDIDO' WHEN 'P' THEN 'PAGADO'  END) "
                + "ESTADO, TIPO   "
                + "FROM SIS.TURNOS_CE, "
                + "SIS.PERSONAL, SIS.PACIENTES  "
                + "WHERE TURNOS_CE.PCN_NUMERO_HC = " + pCriterio + " "
                + "AND CODIGO = TURNOS_CE.PRS_CODIGO AND "
                + "NUMERO_HC = TURNOS_CE.PCN_NUMERO_HC "
                + "AND ESTADO IN ('R') "
                + " ORDER BY FECHA DESC";
//si existen parámetros se deben poner ? en las posiciones respectivas 
        Query query = em.createNativeQuery(sql);

        List<Object[]> results = query.getResultList();
        List data = new ArrayList<>();

        if (!results.isEmpty()) {
            for (Object[] result : results) {
                HashMap resultMap = new HashMap();
                resultMap.put("FECHAS", result[0]);
                resultMap.put("NUMERO", result[1]);
                resultMap.put("APELLIDOS", result[2]);
                resultMap.put("NOMBRES", result[3]);
                resultMap.put("ESTADO", result[4]);
                resultMap.put("TIPO", result[5]);
                data.add(resultMap);

            }
        }

        return data;

    }

    public List<Map> litaPermanencias(String paciente, String pFecha1, String pFecha2) {

        pFecha1 = (pFecha1.length() == 0) ? "2000/01/01" : pFecha1;
        pFecha2 = (pFecha2.length() == 0) ? "2000/01/01" : pFecha2;

        String sql = "SELECT bloqueado,       CEDULA,       APELLIDO_PATERNO,       PRIMER_NOMBRE,       ENFERMEDAD,       TO_CHAR (FECHA_INGRESO,                'fmdd/month/yyyy',                'nls_date_language = spanish')          FECHA_INGRESOs,       TO_CHAR (FECHA_ALTA, 'fmdd/month/yyyy', 'nls_date_language = spanish')          FECHA_ALTAs,       TOTAL_DIAS  FROM (  SELECT DISTINCT bloqueado,                          CEDULA,                          APELLIDO_PATERNO,                          PRIMER_NOMBRE,                          ENFERMEDAD,                          FECHA_INGRESO,                          FECHA_ALTA,                          TOTAL_DIAS            FROM SIS.TURNOS_CAMAS,                 SIS.PERMANENCIAS_Y_ATENCIONES,                 SIS.PACIENTES,                 SIS.DIAGNOSTICOS_PACIENTE,                 SIS.ENFERMEDADES,                 SIS.CAMAS_HOSPITALIZACION           WHERE     (   TO_CHAR (PERMANENCIAS_Y_ATENCIONES.PCN_NUMERO_HC) LIKE                            '%" + paciente + "%'                      OR TO_CHAR (CEDULA) LIKE '%" + paciente + "%'                      OR TO_CHAR (APELLIDO_PATERNO) LIKE '%" + paciente + "%')                 AND PERMANENCIAS_Y_ATENCIONES.PCN_NUMERO_HC =                        PRM_PCN_NUMERO_HC                 AND NUMERO = PRM_NUMERO                 AND NUMERO_HC = PERMANENCIAS_Y_ATENCIONES.PCN_NUMERO_HC                 AND NUMERO_HC = DIAGNOSTICOS_PACIENTE.PCN_NUMERO_HC                 AND DGNPCN_ID = DGNPCN_DGNPCN_ID                 AND CODIGO = ENF_CODIGO                 AND CAMA = CMAHSP_CAMA                 AND SALA = CMAHSP_SALA                 AND TO_CHAR (FECHA_INGRESO, 'yyyymmdd') BETWEEN '" + pFecha1 + "'                                                             AND '" + pFecha2 + "'        ORDER BY FECHA_INGRESO DESC)";
        System.out.println("sql = " + sql);
        //si existen parámetros se deben poner ? en las posiciones respectivas 
        Query query = em.createNativeQuery(sql);

        List<Object[]> results = query.getResultList();
        List data = new ArrayList<>();

        if (!results.isEmpty()) {
            for (Object[] result : results) {
                HashMap resultMap = new HashMap();
                resultMap.put("BLOQUEADO", result[0]);
                resultMap.put("CEDULA", result[1]);
                resultMap.put("APELLIDO_PATERNO", result[2]);
                resultMap.put("PRIMER_NOMBRE", result[3]);
                resultMap.put("ENFERMEDAD", result[4]);
                resultMap.put("FECHA_INGRESOs", result[5]);
                resultMap.put("FECHA_ALTAs", result[6]);
                resultMap.put("TOTAL_DIAS", result[7]);
                data.add(resultMap);

            }
        }
        return data;

    }

    public List<VDetallePaciente> findPacientePorHC(Integer par) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<VDetallePaciente> cq = cb.createQuery(VDetallePaciente.class);
        Root<VDetallePaciente> root = cq.from(VDetallePaciente.class);
        cq.where(cb.equal(root.get(VDetallePaciente_.numeroHc), par));
        List resultList = em.createQuery(cq).setHint("eclipselink.refresh", "true").getResultList();
        return resultList;
    }
//ESTE METODO PERMITE TRAER  LOS DEPENDIENTTES DE MILITAR

    public List<Map> listaBuscaDependientes(String pCriterio) {
        String sql
                = "  SELECT 'DEPENDIENTES' DEPEN,"
                + "         (SELECT RV_MEANING"
                + "            FROM SIS.CG_REF_CODES CG_REF_CODES_1"
                + "           WHERE RV_DOMAIN = 'FUERZA' AND RV_LOW_VALUE = PACIENTES_1.FUERZA)"
                + "            FUERZA,"
                + "         (SELECT RV_MEANING"
                + "            FROM SIS.CG_REF_CODES CG_REF_CODES_1"
                + "           WHERE     RV_DOMAIN = 'GRADO MILITAR'"
                + "                 AND RV_LOW_VALUE = PACIENTES_1.grado)"
                + "            GRADOM,"
                + "         (SELECT DESCRIPCION TIPO_PACIENTE"
                + "            FROM SIS.PROMOCIONES_PACIENTES PACI, SIS.PROMOCIONES"
                + "           WHERE     PACI.PCN_NUMERO_HC = PACIENTES_1.NUMERO_HC"
                + "                 AND CODIGO = PACI.PRM_CODIGO"
                + "                 AND (PACI.PCN_NUMERO_HC, PACI.FECHA_CATEGORIZACION) IN (  SELECT PP.PCN_NUMERO_HC,"
                + "                                                                                  MAX ("
                + "                                                                                     PP.FECHA_CATEGORIZACION)"
                + "                                                                             FROM SIS.PROMOCIONES_PACIENTES PP"
                + "                                                                            WHERE PP.PCN_NUMERO_HC ="
                + "                                                                                     PACIENTES_1.NUMERO_HC"
                + "                                                                         GROUP BY PP.PCN_NUMERO_HC)"
                + "                 AND ROWNUM = 1)"
                + "            CATEG_PACIENTE,"
                + "         (SELECT RV_MEANING"
                + "            FROM SIS.CG_REF_CODES, SIS.PACIENTES"
                + "           WHERE     RV_DOMAIN = 'SITUACION_FINANCIERA'"
                + "                 AND NUMERO_HC = PACIENTES_1.NUMERO_HC"
                + "                 AND SITUACION = RV_LOW_VALUE)"
                + "            TIPO_DEPENDENCIA,"
                + "         PACIENTES_1.NUMERO_HC,"
                + "         PACIENTES_1.PRIMER_NOMBRE,"
                + "         PACIENTES_1.APELLIDO_PATERNO,"
                + "         PACIENTES_1.SEXO,"
                + "         PACIENTES_1.ESTADO_CIVIL,"
                + "         PACIENTES_1.CLASIFICACION,"
                + "         PACIENTES_1.APELLIDO_MATERNO,"
                + "         PACIENTES_1.SEGUNDO_NOMBRE,"
                + "         PACIENTES_1.CEDULA,"
                + "         PACIENTES_1.FECHA_NACIMIENTO,"
                + "         PACIENTES_1.NUMERO_AFILIACION_IESS,"
                + "         PACIENTES_1.OCP_CODIGO,"
                + "        (case when PACIENTES_1.BLOQUEADO='F' then 'Usuario Activo' Else 'Usuario no Activo' end) BLOQUEADO ,"
                + "         PACIENTES_1.TIPO_PACIENTE,"
                + "         PACIENTES_1.EMAIL,"
                + "         PACIENTES_1.NUMERO_HC_ANTERIOR,"
                + "         PACIENTES_1.FUERZA,"
                + "         PACIENTES_1.GRADO,"
                + "         PACIENTES_1.SITUACION,"
                + "         PACIENTES_1.ID_ISSFA_TITULAR,"
                + "         PACIENTES_1.ID_ISSFA,"
                + "         PACIENTES_1.TELEFONO,"
                + "         PACIENTES_1.TELEFONO_TRABAJO"
                + "    FROM SIS.PACIENTES, SIS.PACIENTES PACIENTES_1"
                + "   WHERE     PACIENTES.NUMERO_HC = '" + pCriterio + "'"
                + "         AND PACIENTES_1.ID_ISSFA_TITULAR = PACIENTES.ID_ISSFA_TITULAR"
                + "         AND SIS.PACIENTES.NUMERO_HC <> PACIENTES_1.NUMERO_HC"
                + " ORDER BY   PACIENTES_1.ID_ISSFA,TIPO_DEPENDENCIA";
//        System.out.println("sql = " + sql);
        Query query = em.createNativeQuery(sql);

        List<Object[]> results = query.getResultList();
        List data = new ArrayList<>();

        if (!results.isEmpty()) {
            for (Object[] result : results) {
                HashMap resultMap = new HashMap();
                resultMap.put("DEPEN", result[0]);
                resultMap.put("FUERZA", result[1]);
                resultMap.put("GRADOM", result[2]);
                resultMap.put("CATEG_PACIENTE", result[3]);
                resultMap.put("TIPO_DEPENDENCIA", result[4]);
                resultMap.put("NUMERO_HC", result[5]);
                resultMap.put("PRIMER_NOMBRE", result[6]);
                resultMap.put("APELLIDO_PATERNO", result[7]);
                resultMap.put("SEXO", result[8]);
                resultMap.put("ESTADO_CIVIL", result[9]);
                resultMap.put("CLASIFICACION", result[10]);
                resultMap.put("APELLIDO_MATERNO", result[11]);
                resultMap.put("SEGUNDO_NOMBRE", result[12]);
                resultMap.put("CEDULA", result[13]);
                resultMap.put("FECHA_NACIMIENTO", result[14]);
                resultMap.put("NUMERO_AFILIACION_IESS", result[15]);
                resultMap.put("OCP_CODIGO", result[16]);
                resultMap.put("BLOQUEADO", result[17]);
                resultMap.put("TIPO_PACIENTE", result[18]);
                resultMap.put("EMAIL", result[19]);
                resultMap.put("GRADO", result[20]);
                resultMap.put("SITUACION", result[21]);
                resultMap.put("ID_ISSFA_TITULAR", result[22]);
                resultMap.put("ID_ISSFA", result[23]);
                resultMap.put("TELEFONO", result[26]);
                resultMap.put("TELEFONO_TRABAJO", result[27]);
                data.add(resultMap);

            }
        }
        return data;

    }

    public List<Map> listaBuscaFechasCertificados(String pCriterio) {
        String sql
                = "SELECT NUMERO, to_char(FECHA, 'fmday/dd/month/yyyy','nls_date_language = spanish' ) FECHAs"
                + "    FROM SIS.CERTIFICADOS, SIS.PACIENTES"
                + "   WHERE     CERTIFICADOS.PCN_NUMERO_HC = " + pCriterio + ""
                + "         AND NUMERO_HC = CERTIFICADOS.PCN_NUMERO_HC"
                + " ORDER BY NUMERO desc, FECHA DESC";
//        System.out.println("sql = " + sql);
        Query query = em.createNativeQuery(sql);

        List<Object[]> results = query.getResultList();
        List data = new ArrayList<>();

        if (!results.isEmpty()) {
            for (Object[] result : results) {
                HashMap resultMap = new HashMap();
                resultMap.put("NUMERO", result[0]);
                resultMap.put("FECHA", result[1]);
                data.add(resultMap);

            }
        }
        return data;

    }

    //METODO PARA REALIZAR LA FACTURACION 
    public List<Map> listaFacturasPorHC(String pHC) {
        String sql
                = "  SELECT FACTURA_ELECTRONICA_SRI.FCT_NUMERO codigo,"
                + "         FACTURA_ELECTRONICA_SRI.FECHA_EMISION,"
                + "         FACTURA_ELECTRONICA_SRI.FCT_CAJA,"
                + "         PERSONAL.APELLIDOS || ' ' || PERSONAL.NOMBRES realizado_por,"
                + "         FACTURA_ELECTRONICA_SRI.RUC,"
                + "         estab || '-' || pto_emi || '-' || FACTURA_ELECTRONICA_SRI.SECUENCIAL"
                + "            nro_fact,"
                + "         SUM (DISTINCT FACTURA_ELECTRONICA_DTL_SRI.PRCTOT_SINIMP)"
                + "            valor_cancelado"
                + "    FROM SIS.DETALLES_FACTURA,"
                + "         SIS.CARGOS,"
                + "         SIS.FACTURAS,"
                + "         SIS.FACTURA_ELECTRONICA_SRI,"
                + "         SIS.PACIENTES,"
                + "         SIS.FACTURA_ELECTRONICA_DTL_SRI,"
                + "         SIS.ITEM_CARGOS,"
                + "         SIS.PERSONAL"
                + "   WHERE     CARGOS.CODIGO = DETALLES_FACTURA.CRG_CODIGO"
                + "         AND CARGOS.TIPO = DETALLES_FACTURA.CRG_TIPO"
                + "         AND FACTURAS.CAJA = DETALLES_FACTURA.FCT_CAJA"
                + "         AND FACTURAS.NUMERO = DETALLES_FACTURA.FCT_NUMERO"
                + "         AND FACTURAS.NUMERO = FACTURA_ELECTRONICA_SRI.FCT_NUMERO"
                + "         AND FACTURAS.CAJA = FACTURA_ELECTRONICA_SRI.FCT_CAJA"
                + "         AND FACTURA_ELECTRONICA_SRI.FCT_NUMERO ="
                + "                FACTURA_ELECTRONICA_DTL_SRI.FCT_NUMERO"
                + "         AND FACTURA_ELECTRONICA_SRI.FCT_CAJA ="
                + "                FACTURA_ELECTRONICA_DTL_SRI.FCT_CAJA"
                + "         AND PACIENTES.NUMERO_HC = FACTURAS.PCN_NUMERO_HC"
                + "         AND DETALLES_FACTURA.CRG_CODIGO = ITEM_CARGOS.CRG_CODIGO"
                + "         AND DETALLES_FACTURA.CRG_TIPO = ITEM_CARGOS.CRG_TIPO"
                + "         AND PACIENTES.NUMERO_HC = " + pHC
                + "         AND AMBIENTE = 2"
                + "         AND PERSONAL.CODIGO = FACTURAS.PRS_CODIGO"
                + " GROUP BY FACTURA_ELECTRONICA_SRI.FCT_NUMERO,"
                + "         FACTURA_ELECTRONICA_SRI.FECHA_EMISION,"
                + "         FACTURA_ELECTRONICA_SRI.FCT_CAJA,"
                + "         PERSONAL.APELLIDOS || ' ' || PERSONAL.NOMBRES,"
                + "         FACTURA_ELECTRONICA_SRI.RUC,"
                + "         estab || '-' || pto_emi || '-' || FACTURA_ELECTRONICA_SRI.SECUENCIAL"
                + " ORDER BY FACTURA_ELECTRONICA_SRI.FECHA_EMISION desc    ";

        Query query = em.createNativeQuery(sql);

        List<Object[]> results = query.getResultList();
        List data = new ArrayList<>();

        if (!results.isEmpty()) {
            for (Object[] result : results) {
                HashMap resultMap = new HashMap();
                resultMap.put("CODIGO", result[0]);
                resultMap.put("FECHA_EMISION", result[1]);
                resultMap.put("FCT_CAJA", result[2]);
                resultMap.put("REALIZADO_POR", result[3]);
                resultMap.put("RUC", result[4]);
                resultMap.put("NRO_FACT", result[5]);
                resultMap.put("VALOR_CANCELADO", result[6]);
                data.add(resultMap);

            }
        }
        return data;

    }

    //// CONSULTA PARA VERIFICAR LOS TURNOS POR PRIMERA VEZ
    public List<Map> listaturnossiguientes() {
        String sql
                = "  SELECT MV_SERVICIOS_PORTAL.NOMBRE,   "
                + "            TO_CHAR (MV_SERVICIOS_PORTAL.FECHA_DISPONIBLE,   "
                + "                     'fmdd',   "
                + "                     'nls_date_language = spanish')   "
                + "         || ' de '   "
                + "         || TO_CHAR (MV_SERVICIOS_PORTAL.FECHA_DISPONIBLE,   "
                + "                     'fmmonth',   "
                + "                     'nls_date_language = spanish')   "
                + "         || ' de '   "
                + "         || TO_CHAR (MV_SERVICIOS_PORTAL.FECHA_DISPONIBLE,   "
                + "                     'fmyyyy',   "
                + "                     'nls_date_language = spanish')   "
                + "            FECHA_DISPONIBLE,   "
                + "         MV_SERVICIOS_PORTAL.CONSULTORIO,   "
                + "         MV_SERVICIOS_PORTAL.DISPONIBLES   "
                + "    FROM TABLEAU.MV_SERVICIOS_PORTAL   "
                + "ORDER BY MV_SERVICIOS_PORTAL.FECHA_DISPONIBLE asc   ";

        //si existen parámetros se deben poner ? en las posiciones respectivas 
        Query query = em.createNativeQuery(sql);

        List<Object[]> results = query.getResultList();
        List data = new ArrayList<HashMap>();

        if (!results.isEmpty()) {
            for (Object[] result : results) {
                HashMap resultMap = new HashMap();
                resultMap.put("NOMBRE", result[0]);
                resultMap.put("FECHA_DISPONIBLE", result[1]);
                resultMap.put("CONSULTORIO", result[2]);
                resultMap.put("DISPONIBLES", result[3]);
                data.add(resultMap);

            }
        }
        return data;

    }

    public List<VTurnosReservados> findTurnosReservadosByHC(String par) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<VTurnosReservados> cq = cb.createQuery(VTurnosReservados.class);
        Root<VTurnosReservados> root = cq.from(VTurnosReservados.class);
        cq.where(cb.equal(root.get(VTurnosReservados_.pcnNumeroHc), par));
        List resultList = em.createQuery(cq).setHint("eclipselink.refresh", "true").getResultList();
        return resultList;
    }

    public List<VCambioClaveNuevPortal> findVistaCambioClave(String cedula) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<VCambioClaveNuevPortal> cq = cb.createQuery(VCambioClaveNuevPortal.class);
        Root<VCambioClaveNuevPortal> root = cq.from(VCambioClaveNuevPortal.class);
        cq.where(cb.equal(root.get(VCambioClaveNuevPortal_.cedulaLogin), cedula));
        List resultList = em.createQuery(cq).setHint("eclipselink.refresh", "true").getResultList();
        return resultList;
    }

    //hacer una función que busque la existencia de su clave 
    public List<VClaveReset> findByCCusuarioRegistrado(String CC) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<VClaveReset> cq = cb.createQuery(VClaveReset.class);
        Root<VClaveReset> root = cq.from(VClaveReset.class);
        cq.where(cb.equal(root.get(VClaveReset_.cedulaLogin), CC));
        List resultList = em.createQuery(cq).setHint("eclipselink.refresh", "true").getResultList();
        return resultList;
    }

}
