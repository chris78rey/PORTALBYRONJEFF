package ec.mil.he1.pom_03_ejb.autogenerados.jsf;

import ec.mil.he1.pom_01_domain.SegUsuario;
import ec.mil.he1.pom_01_domain.VCambioClaveNuevPortal;
import ec.mil.he1.pom_01_domain.VUsuariosClasif;
import ec.mil.he1.pom_03_ejb.autogenerados.jsf.util.JsfUtil;
import ec.mil.he1.pom_03_ejb.autogenerados.jsf.util.JsfUtil.PersistAction;
import ec.mil.he1.pom_03_ejb.autogenerados.sessionbean.VCambioClaveNuevPortalFacade;

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
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import static javax.faces.context.FacesContext.getCurrentInstance;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

@Named("vCambioClaveNuevPortalController")
@SessionScoped
public class VCambioClaveNuevPortalController implements Serializable {

    private static final long serialVersionUID = 266615467079477041L;

    @EJB
    private ec.mil.he1.pom_03_ejb.autogenerados.sessionbean.VCambioClaveNuevPortalFacade ejbFacade;
    private List<VCambioClaveNuevPortal> items = null;

//    private VCambioClaveNuevPortal selected;

    private String claveActual = "";
    private VUsuariosClasif vUsuariosClasif;
    private SegUsuario segUsuario;
    private VCambioClaveNuevPortal vcambioclave = new VCambioClaveNuevPortal();

    @PostConstruct
    private void init() {

        FacesContext facesContext = getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        vUsuariosClasif = (VUsuariosClasif) session.getAttribute("vUsuariosClasif");
        segUsuario = (SegUsuario) session.getAttribute("segUsuario");

        /*con el usuario*/
        setVcambioclave(ejbFacade.find(segUsuario.getId()));

    }

    public VCambioClaveNuevPortalController() {
    }

    public VCambioClaveNuevPortal getSelected() {
        return vcambioclave;
    }

    public void setSelected(VCambioClaveNuevPortal selected) {
        this.vcambioclave = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private VCambioClaveNuevPortalFacade getFacade() {
        return ejbFacade;
    }

    public VCambioClaveNuevPortal prepareCreate() {
        vcambioclave = new VCambioClaveNuevPortal();
        initializeEmbeddableKey();
        return vcambioclave;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundleccccc0001").getString("VCambioClaveNuevPortalCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {

        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundleccccc0001").getString("VCambioClaveNuevPortalUpdated"));

    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundleccccc0001").getString("VCambioClaveNuevPortalDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            vcambioclave = null; // Remove selection
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
        if (vcambioclave != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(vcambioclave);
                } else {
                    getFacade().remove(vcambioclave);
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
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundleccccc0001").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundleccccc0001").getString("PersistenceErrorOccured"));
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
     * @return the claveActual
     */
    public String getClaveActual() {
        return claveActual;
    }

    /**
     * @param claveActual the claveActual to set
     */
    public void setClaveActual(String claveActual) {
        this.claveActual = claveActual;
    }

    /**
     * @return the vcambioclave
     */
    public VCambioClaveNuevPortal getVcambioclave() {
        return vcambioclave;
    }

    /**
     * @param vcambioclave the vcambioclave to set
     */
    public void setVcambioclave(VCambioClaveNuevPortal vcambioclave) {
        this.vcambioclave = vcambioclave;
    }

    public void buttonAction(ActionEvent actionEvent) {

        if (!claveActual.equalsIgnoreCase(vcambioclave.getUsuClave())) {
            addMessage("´La clave actual no coincide");
        } else if (!vcambioclave.getClaveNueva().equalsIgnoreCase(vcambioclave.getClaveNueva2())) {
            addMessage("Las claves nuevas no coinciden");
        } else if (vcambioclave.getClaveNueva().length() < 5) {
            addMessage("Las clave nueva debe tener por lo menos 5 caracteres");
        } else {
            update();
        }
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
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
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), VCambioClaveNuevPortal.class.getName()});
                return null;
            }
        }

    }

}
