package ec.mil.he1.pom_03_ejb.autogenerados.jsf;

import ec.mil.he1.pom_01_domain.SegUsuario;
import ec.mil.he1.pom_01_domain.VCambioClaveNuevPortal;
import ec.mil.he1.pom_01_domain.VUsuariosClasif;
import ec.mil.he1.pom_03_ejb.autogenerados.jsf.util.JsfUtil;
import ec.mil.he1.pom_03_ejb.autogenerados.jsf.util.JsfUtil.PersistAction;
import ec.mil.he1.pom_03_ejb.autogenerados.sessionbean.VCambioClaveNuevPortalFacade;
import ec.mil.he1.pom_03_ejb.stateless.procesos.ListasComunes;

import java.io.Serializable;
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

@Named("vCambioClaveNuevPortalController")
@SessionScoped
public class VCambioClaveNuevPortalController implements Serializable {

    @EJB
    private ListasComunes listasComunes;

    @EJB
    private ec.mil.he1.pom_03_ejb.autogenerados.sessionbean.VCambioClaveNuevPortalFacade ejbFacade;
    private List<VCambioClaveNuevPortal> items = null;
    private List<VCambioClaveNuevPortal> itemsCclave = null;
    private VCambioClaveNuevPortal selected;
    private VUsuariosClasif vUsuariosClasif;
    private SegUsuario segUsuario;

    public VCambioClaveNuevPortalController() {
    }

    public List<VCambioClaveNuevPortal> findVistaCambioClave(String cedula) {
        return listasComunes.findVistaCambioClave(cedula);
    }

    @PostConstruct
    private void init() {

        FacesContext facesContext = getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        vUsuariosClasif = (VUsuariosClasif) session.getAttribute("vUsuariosClasif");
        segUsuario = (SegUsuario) session.getAttribute("segUsuario");

        itemsCclave = findVistaCambioClave(segUsuario.getCedulaLogin());

    }

    public VCambioClaveNuevPortal getSelected() {
        return selected;
    }

    public void setSelected(VCambioClaveNuevPortal selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private VCambioClaveNuevPortalFacade getFacade() {
        return ejbFacade;
    }

    public VCambioClaveNuevPortal prepareCreate() {
        selected = new VCambioClaveNuevPortal();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/BundleCclave").getString("VCambioClaveNuevPortalCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/BundleCclave").getString("VCambioClaveNuevPortalUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/BundleCclave").getString("VCambioClaveNuevPortalDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<VCambioClaveNuevPortal> getItems() {
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
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/BundleCclave").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/BundleCclave").getString("PersistenceErrorOccured"));
            }
        }
    }

    public VCambioClaveNuevPortal getVCambioClaveNuevPortal(java.math.BigDecimal id) {
        return getFacade().find(id);
    }

    public List<VCambioClaveNuevPortal> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<VCambioClaveNuevPortal> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    /**
     * @return the itemsCclave
     */
    public List<VCambioClaveNuevPortal> getItemsCclave() {
        return itemsCclave;
    }

    /**
     * @param itemsCclave the itemsCclave to set
     */
    public void setItemsCclave(List<VCambioClaveNuevPortal> itemsCclave) {
        this.itemsCclave = itemsCclave;
    }

    @FacesConverter(forClass = VCambioClaveNuevPortal.class)
    public static class VCambioClaveNuevPortalControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            VCambioClaveNuevPortalController controller = (VCambioClaveNuevPortalController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "vCambioClaveNuevPortalController");
            return controller.getVCambioClaveNuevPortal(getKey(value));
        }

        java.math.BigDecimal getKey(String value) {
            java.math.BigDecimal key;
            key = new java.math.BigDecimal(value);
            return key;
        }

        String getStringKey(java.math.BigDecimal value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof VCambioClaveNuevPortal) {
                VCambioClaveNuevPortal o = (VCambioClaveNuevPortal) object;
                return getStringKey(o.getID());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), VCambioClaveNuevPortal.class.getName()});
                return null;
            }
        }

    }

}
