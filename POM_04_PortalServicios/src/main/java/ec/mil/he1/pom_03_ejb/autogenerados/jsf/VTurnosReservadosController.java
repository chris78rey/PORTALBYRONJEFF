package ec.mil.he1.pom_03_ejb.autogenerados.jsf;

import ec.mil.he1.pom_01_domain.SegUsuario;
import ec.mil.he1.pom_01_domain.VUsuariosClasif;
import ec.mil.he1.pom_03_ejb.stateless.VTurnosReservados;
import ec.mil.he1.pom_03_ejb.autogenerados.jsf.util.JsfUtil;
import ec.mil.he1.pom_03_ejb.autogenerados.jsf.util.JsfUtil.PersistAction;
import ec.mil.he1.pom_03_ejb.autogenerados.sessionbean.VTurnosReservadosFacade;
import ec.mil.he1.pom_03_ejb.stateless.procesos.ListasComunes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import static javax.faces.context.FacesContext.getCurrentInstance;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.servlet.http.HttpSession;

@Named("vTurnosReservadosController")
@SessionScoped
public class VTurnosReservadosController implements Serializable {
    
    @EJB
    private ListasComunes listasComunes;
    private static final long serialVersionUID = 7575673842271464132L;
    
    @EJB
    private ec.mil.he1.pom_03_ejb.autogenerados.sessionbean.VTurnosReservadosFacade ejbFacade;
    private List<VTurnosReservados> items = null;
    private VTurnosReservados selected;
    private VUsuariosClasif vUsuariosClasif;
    private SegUsuario segUsuario;
    
    @PostConstruct
    private void init() {
        System.out.println("@PostConstruct");
        FacesContext facesContext = getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        vUsuariosClasif = (VUsuariosClasif) session.getAttribute("vUsuariosClasif");
        segUsuario = (SegUsuario) session.getAttribute("segUsuario");
        listaturnosReservadoses = findTurnosReservadosByHC(vUsuariosClasif.getNumeroHc().toString());
        
    }
    
    private List<VTurnosReservados> listaturnosReservadoses = new ArrayList<>();
    
    public List<VTurnosReservados> findTurnosReservadosByHC(String par) {
        return listasComunes.findTurnosReservadosByHC(par);
    }
    
    public VTurnosReservadosController() {
    }
    
    public VTurnosReservados getSelected() {
        return selected;
    }
    
    public void setSelected(VTurnosReservados selected) {
        this.selected = selected;
    }
    
    protected void setEmbeddableKeys() {
    }
    
    protected void initializeEmbeddableKey() {
    }
    
    private VTurnosReservadosFacade getFacade() {
        return ejbFacade;
    }
    
    public VTurnosReservados prepareCreate() {
        selected = new VTurnosReservados();
        initializeEmbeddableKey();
        return selected;
    }
    
    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/BundleCancelaTurno").getString("VTurnosReservadosCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }
    
    public void update() {
        selected.setFecha("2mar78");
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/BundleCancelaTurno").getString("VTurnosReservadosUpdated"));
        listaturnosReservadoses = findTurnosReservadosByHC(vUsuariosClasif.getNumeroHc().toString());
        
    }
    
    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/BundleCancelaTurno").getString("VTurnosReservadosDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }
    
    public List<VTurnosReservados> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }
    
    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/BundleCancelaTurno").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/BundleCancelaTurno").getString("PersistenceErrorOccured"));
            }
        }
    }
    
    public VTurnosReservados getVTurnosReservados(java.lang.String id) {
        return getFacade().find(id);
    }
    
    public List<VTurnosReservados> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }
    
    public List<VTurnosReservados> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    /**
     * @return the listaturnosReservadoses
     */
    public List<VTurnosReservados> getListaturnosReservadoses() {
        return listaturnosReservadoses;
    }

    /**
     * @param listaturnosReservadoses the listaturnosReservadoses to set
     */
    public void setListaturnosReservadoses(List<VTurnosReservados> listaturnosReservadoses) {
        this.listaturnosReservadoses = listaturnosReservadoses;
    }
    
    @FacesConverter(forClass = VTurnosReservados.class)
    public static class VTurnosReservadosControllerConverter implements Converter {
        
        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            VTurnosReservadosController controller = (VTurnosReservadosController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "vTurnosReservadosController");
            return controller.getVTurnosReservados(getKey(value));
        }
        
        java.lang.String getKey(String value) {
            java.lang.String key;
            key = value;
            return key;
        }
        
        String getStringKey(java.lang.String value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }
        
        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof VTurnosReservados) {
                VTurnosReservados o = (VTurnosReservados) object;
                return getStringKey(o.getNumeroId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), VTurnosReservados.class.getName()});
                return null;
            }
        }
        
    }
    
}
