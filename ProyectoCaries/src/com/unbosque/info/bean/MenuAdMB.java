package com.unbosque.info.bean;



import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
 







import org.primefaces.context.RequestContext;
 
@ManagedBean (name = "menuAdMB")
@SessionScoped
public class MenuAdMB implements Serializable {
   
	private static final long serialVersionUID = -78093963468460743L;
	
	private MenuAdMB registroSeleccionado;
	
	private String[] selectedOdont;   
    private List<String> odontologos;
     
    @PostConstruct
    public void init() {
    	odontologos = new ArrayList<String>();
    	odontologos.add("Dr. Carlos Sarmiento");
    	odontologos.add("Dr. Gabriel Arias");
    	odontologos.add("Dra. Diana Luna");
    	odontologos.add("Dr. Jhon Torres");
    }
 
    public String[] getSelectedOdontologos() {
        return selectedOdont;
    }
 
    public void setSelectedOdontologos(String[] selectedOdontologos) {
        this.selectedOdont = selectedOdontologos;
    }
 
    public List<String> getOdontologos() {
        return odontologos;
    }
	
	public MenuAdMB getRegistroSeleccionado() {
		return registroSeleccionado;
	}

	public void setRegistroSeleccionado(MenuAdMB registroSeleccionado) {
		this.registroSeleccionado = registroSeleccionado;
	}
	
	public void gestionUs(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean gestionIn = false;
        
        gestionIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Gestión de Usuarios", "Invalid credentials");
        
         
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("gestionIn", gestionIn);
    } 
	
	public void gestionPro(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean gestionIn = false;
        
        gestionIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Gestión de Proyectos", "Invalid credentials");
        
         
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("gestionIn", gestionIn);
    } 
	
	public void locacionPro(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean gestionIn = false;
        
        gestionIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Locaciones", "Invalid credentials");
        
         
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("gestionIn", gestionIn);
    } 
	
	public void reportes(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean reportesdIn = false;
        
        reportesdIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Reportes", "Invalid credentials");
        
         
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("reportesdIn", reportesdIn);
    } 
	
    public void cerrarSesion(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesContext contex = FacesContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedOff = false;
        
        loggedOff = false;
             message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sesión cerrada", "Invalid credentials");
        
            try {
				contex.getExternalContext().redirect("index.jsf");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedOff", loggedOff);
    }   
}