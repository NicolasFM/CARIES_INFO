package com.unbosque.info.bean;


import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;



@ManagedBean (name = "loginMB")
@SessionScoped
public class LoginMB implements Serializable {
	
	
	private static final long serialVersionUID = -2152389656664659476L;
	private String nombre;
	private String clave;
	private boolean logeado = false;
	private boolean logeado2 = false;
	
	public boolean estaLogeado() {
		return logeado;
		
	}
	public boolean estaLogeado2() {
		return logeado2;
		
	} public String getNombre() {
		return nombre;
	} public void setNombre(String nombre) {
		this.nombre = nombre;
	} public String getClave() {
		return clave; }
	public void setClave(String clave) {
		this.clave = clave;
	}
	
	
	
	public void login(ActionEvent actionEvent) {
		
		RequestContext context = RequestContext.getCurrentInstance();
		RequestContext context2 = RequestContext.getCurrentInstance();
		
		FacesContext contex = FacesContext.getCurrentInstance();
		FacesMessage msg = null;
		FacesMessage msg2 = null;
		if (nombre != null && nombre.equals("admin") && clave != null
				&& clave.equals("admin")) {
			logeado = true;
			msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenid@", nombre);
			
			

				
		} else {
			logeado = false;
			msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error",
					"Credenciales no válidas");
		}
		
		
		FacesContext.getCurrentInstance().addMessage(null, msg);
		context.addCallbackParam("estaLogeado", logeado);
	
		if (logeado){
			context.addCallbackParam("view", "MenuAd.jsf");	
		}
		
			
			
		
		
		
	//*****************************************************************************
		else if(nombre != null && nombre.equals("usuario") && clave != null
				&& clave.equals("usuario")) {
			logeado = true;
			msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenid@ Doctor@: ", nombre);
			
			

				
		} else {
			logeado = false;
			msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error",
					"Credenciales no válidas");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
//		context.addCallbackParam("estaLogeado", logeado);
		if (logeado){
			//context.addCallbackParam("view", "MenuUs.jsf");	
			
			 try {
					contex.getExternalContext().redirect( "MenuUs.jsf" );
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
		}
		
		
	
	}
	
	
	
	
	
	
	
	public void logout() {
		 FacesContext contex = FacesContext.getCurrentInstance();
		FacesMessage msg = null;
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session.invalidate();
		logeado = false;
		logeado2=false;
		 try {
				contex.getExternalContext().redirect("index.jsf");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	} 
	
}