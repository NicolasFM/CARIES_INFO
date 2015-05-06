package com.unbosque.info.bean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.springframework.dao.DataAccessException;

import com.unbosque.info.entidad.Ciudad;
import com.unbosque.info.service.CiudadService;

@ManagedBean(name = "ciudadMB")
@SessionScoped
public class CiudadMB implements Serializable {

	private static final long serialVersionUID = 34468460749463L;

	private CiudadMB registroSeleccionado;

	// Spring Customer Service is injected...
	@ManagedProperty(value = "#{CiudadService}")
	CiudadService ciudadService;

	List<Ciudad> ciudadList;

	private int id;
	private String depto;
	private String ciudad;
	private String estado;

	public void addCiudad() {
		try {

			RequestContext context = RequestContext.getCurrentInstance();
			FacesMessage message = null;
			boolean loggedIn = false;

			if(ciudad.equals("")){
				
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
						"Error, El nombre de la Ciudad no puede estar vacío ");
				FacesContext.getCurrentInstance().addMessage(null, message);
			}else{
			
				
				String a = ciudad;
				a.toCharArray();
				int nNum = 0;
				String t3 = "0123456789";
				
				for (int i=0;i<a.length();i++) {
        			if ( t3.indexOf(a.charAt(i)) != -1 ){
        				nNum++;
        				}
        		}
				
				if ( nNum!=0) {
					loggedIn = false;
    	            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "","El nombre de la ciudad no puede contener números");
    				FacesContext.getCurrentInstance().addMessage(null, message);
        		}else{
				
			Ciudad ciudad = new Ciudad();
			
			ciudad.setNombre(getCiudad());
			ciudad.setEstado("A");
			ciudad.setNombreDepto(getDepto());
			getCiudadService().addCiudad(ciudad);
			reset();
			
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
					"Registro agregado exitosamente.");
			FacesContext.getCurrentInstance().addMessage(null, message);	
        		}
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

	}

	// Aqui colocamos el de borrado
	//public String deleteTriangulo(Triangulo triangulo) {
		//try {
			//triangulo.setEstado("I");
			//getTrianguloService().updateTriangulo(triangulo);
		//} catch (DataAccessException e) {
			//e.printStackTrace();
		//}

		//return null;

	//}

	public void reset() {
		this.setId(0);
		this.setEstado("");
		this.setCiudad("");
		this.setDepto("");
	}

	public List<Ciudad> getCiudadesList() {
		ciudadList = new ArrayList<Ciudad>();
		ciudadList.addAll(getCiudadService().getCiudades());
		return ciudadList;
	}

	public CiudadService getCiudadService() {
		return ciudadService;
	}

	public void setCiudadService(CiudadService ciudadService) {
		this.ciudadService = ciudadService;
	}

	public List<Ciudad> getCiudadList() {
		return ciudadList;
	}

	public void setCiudadList(List<Ciudad> ciudadList) {
		this.ciudadList = ciudadList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDepto() {
		return depto;
	}

	public void setDepto(String depto) {
		this.depto = depto;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public CiudadMB getRegistroSeleccionado() {
		return registroSeleccionado;
	}

	public void setRegistroSeleccionado(CiudadMB registroSeleccionado) {
		this.registroSeleccionado = registroSeleccionado;
	}

}