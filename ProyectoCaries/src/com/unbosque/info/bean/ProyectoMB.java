package com.unbosque.info.bean;


import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.springframework.dao.DataAccessException;





import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;

import com.unbosque.info.entidad.Proyecto;
import com.unbosque.info.service.ProyectoService;
 
@ManagedBean (name = "proyectoMB")
@SessionScoped
public class ProyectoMB implements Serializable {
	
private static final long serialVersionUID = 464463468460743L;
	
	private ProyectoMB registroSeleccionado;
	
	// Spring Customer Service is injected...
		@ManagedProperty(value = "#{ProyectoService}")
		ProyectoService proyectoService;
   
	private int id;
	private String nompro;
    private String depar;
    private String ciudad;
    private java.util.Date fecha1;
    private java.util.Date fecha2;
    private String tipo;
    private String poblacion;
	

    List<Proyecto> proyectoList;

    public java.sql.Date sqlDate(java.util.Date calendarDate) {
    	  return new java.sql.Date(calendarDate.getTime());
    	}
    
    
    public void addProyecto() {
		try {

			RequestContext context = RequestContext.getCurrentInstance();
			FacesMessage message = null;
			
			boolean loggedIn = false;

			if(nompro.equals("")){
				
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
						"Error, El nombre del Proyecto no puede estar vacío ");
				FacesContext.getCurrentInstance().addMessage(null, message);
			}else{
			
				String a = nompro;
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
    	            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "","El nombre del Proyecto no puede contener números");
    				FacesContext.getCurrentInstance().addMessage(null, message);
        		}else{
        			
        			

			Proyecto proyecto = new Proyecto();
			proyecto.setNombre(getNompro());
			proyecto.setEstado("A");
			proyecto.setNomCiudad(getCiudad());
			proyecto.setNomDpto(getDepar());
			proyecto.setTipo(getTipo());
			proyecto.setPoblacion(getPoblacion());
			proyecto.setFechai(sqlDate(getFecha1()));
			proyecto.setFechaf(sqlDate(getFecha2()));
			getProyectoService().addProyecto(proyecto);
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
    
    public void updateProyecto(RowEditEvent event, int id, String nompro ){
        Proyecto proyecto = getProyectoService().getProyectoById(id);
        
        proyecto.setNombre(nompro);
        getProyectoService().updateProyecto(proyecto);
        reset();
        }

	// Aqui colocamos el de borrado
	public void borrarProyecto(Proyecto proyecto) {
		try {
			FacesMessage message = null;
			
			
			getProyectoService().deleteProyecto(proyecto);
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Proyecto Borrado exitosamente.","");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}


	}

	public void reset() {
		this.setId(0);
		this.setNompro("");
		this.setCiudad("");
		this.setDepar("");
		this.setFecha1(null);
		this.setFecha2(null);
		this.setTipo("");
		this.setPoblacion("");
	}

	public List<Proyecto> getProyectosList() {
		proyectoList = new ArrayList<Proyecto>();
		proyectoList.addAll(getProyectoService().getProyectos());
		return proyectoList;
	}

	public ProyectoService getProyectoService() {
		return proyectoService;
	}

	public void setProyectoService(ProyectoService proyectoService) {
		this.proyectoService = proyectoService;
	}

	public List<Proyecto> getProyectoList() {
		return proyectoList;
	}

	public void setProyectoList(List<Proyecto> proyectoList) {
		this.proyectoList = proyectoList;
	}
    
    
	public String getNompro() {
		return nompro;
	}



	public void setNompro(String nompro) {
		this.nompro = nompro;
	}



	public String getDepar() {
		return depar;
	}



	public void setDepar(String depar) {
		this.depar = depar;
	}



	public String getCiudad() {
		return ciudad;
	}



	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public java.util.Date getFecha1() {
		return fecha1;
	}

	public void setFecha1(java.util.Date fecha1) {
		this.fecha1 = fecha1;
	}

	public java.util.Date getFecha2() {
		return fecha2;
	}

	public void setFecha2(java.util.Date fecha2) {
		this.fecha2 = fecha2;
	}

	public ProyectoMB getRegistroSeleccionado() {
		return registroSeleccionado;
	}

	public void setRegistroSeleccionado(ProyectoMB registroSeleccionado) {
		this.registroSeleccionado = registroSeleccionado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	
}