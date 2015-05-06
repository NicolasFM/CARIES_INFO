package com.unbosque.info.bean;


import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
 



import org.primefaces.context.RequestContext;
 
@ManagedBean (name = "menuUsMB")
@SessionScoped
public class MenuUsMB implements Serializable {
   
	private static final long serialVersionUID = -78093963468460743L;
	
	private MenuUsMB registroSeleccionado;
	
	
	public MenuUsMB getRegistroSeleccionado() {
		return registroSeleccionado;
	}

	public void setRegistroSeleccionado(MenuUsMB registroSeleccionado) {
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