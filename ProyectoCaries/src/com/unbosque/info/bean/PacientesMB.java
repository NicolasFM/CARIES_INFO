package com.unbosque.info.bean;


import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
 









import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.springframework.dao.DataAccessException;

import com.unbosque.info.entidad.Paciente;
import com.unbosque.info.entidad.Proyecto;
import com.unbosque.info.entidad.Usuario;
import com.unbosque.info.service.PacienteService;
import com.unbosque.info.service.ProyectoService;
 
@ManagedBean (name = "pacientesMB")
@SessionScoped
public class PacientesMB implements Serializable {
	
private static final long serialVersionUID = 2563448963468460743L;
	
	private PacientesMB registroSeleccionado;
   
	// Spring Customer Service is injected...
			@ManagedProperty(value = "#{PacienteService}")
			PacienteService pacienteService;
	
	private int id;
	private String nompa;
    private String apepa;
    private int idepa;
    private int edadpa;
    private String generopa;
    private String ciudadpa;
    private String csaludpa;
    private String denticionpa;
    private int proyectospa;
    private String telpa;
    private String correopa;
    
    List<Paciente> pacienteList;

    public void addPaciente() {
		try {

			RequestContext context = RequestContext.getCurrentInstance();
			FacesMessage message = null;
			
			boolean loggedIn = false;

			if(nompa.equals("")){
				
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
						"Error, El nombre del Paciente no puede estar vacío ");
				FacesContext.getCurrentInstance().addMessage(null, message);
			}else{
			
				String a = nompa;
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
    	            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "","El nombre del Paciente no puede contener números");
    				FacesContext.getCurrentInstance().addMessage(null, message);
        		}else{

        	Paciente paciente = new Paciente();
        	paciente.setNombresApellidos(getNompa() + " " + getApepa());
        	paciente.setEdad(getEdadpa());
        	paciente.setEstado("A");
        	paciente.setCiudad(getCiudadpa());
        	paciente.setCorreo(getCorreopa());
        	paciente.setDenticion(getDenticionpa());
        	paciente.setGenero(getGeneropa());
        	paciente.setIdentificacion(getIdepa());
        	paciente.setIdProyecto(getProyectospa());
        	paciente.setLugarAtencion(getCsaludpa());
        	paciente.setTelefono(getTelpa());
			getPacienteService().addPaciente(paciente);
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
    
    public void updatePaciente(RowEditEvent event){

    }

    public void borrarPaciente(Paciente paciente) {
	try {
		FacesMessage message = null;
		
		
		getPacienteService().deletePaciente(paciente);
		message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Paciente Borrado exitosamente.","");
		FacesContext.getCurrentInstance().addMessage(null, message);
	} catch (DataAccessException e) {
		e.printStackTrace();
	}


}
    
    public void reset() {
    	this.setNompa("");
    	this.setApepa("");
		this.setId(0);
		this.setIdepa(0);
		this.setEdadpa(0);
		this.setGeneropa("");
		this.setCiudadpa("");
		this.setCsaludpa("");
		this.setDenticionpa("");
		this.setTelpa("");
		this.setCorreopa("");
	}

	public List<Paciente> getPacientesList() {
		pacienteList = new ArrayList<Paciente>();
		pacienteList.addAll(getPacienteService().getPacientes());
		return pacienteList;
	}

	public PacienteService getPacienteService() {
		return pacienteService;
	}

	public void setPacienteService(PacienteService pacienteService) {
		this.pacienteService = pacienteService;
	}

	public List<Paciente> getPacienteList() {
		return pacienteList;
	}

	public void setPacienteList(List<Paciente> pacienteList) {
		this.pacienteList = pacienteList;
	}
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNompa() {
		return nompa;
	}

	public void setNompa(String nompa) {
		this.nompa = nompa;
	}

	public String getApepa() {
		return apepa;
	}

	public void setApepa(String apepa) {
		this.apepa = apepa;
	}

	public int getEdadpa() {
		return edadpa;
	}

	public void setEdadpa(int edadpa) {
		this.edadpa = edadpa;
	}

	public String getGeneropa() {
		return generopa;
	}

	public void setGeneropa(String generopa) {
		this.generopa = generopa;
	}

	public String getCiudadpa() {
		return ciudadpa;
	}

	public void setCiudadpa(String ciudadpa) {
		this.ciudadpa = ciudadpa;
	}

	public String getCsaludpa() {
		return csaludpa;
	}

	public void setCsaludpa(String csaludpa) {
		this.csaludpa = csaludpa;
	}

	public String getDenticionpa() {
		return denticionpa;
	}

	public void setDenticionpa(String denticionpa) {
		this.denticionpa = denticionpa;
	}

	public int getIdepa() {
		return idepa;
	}

	public void setIdepa(int idepa) {
		this.idepa = idepa;
	}

	public String getTelpa() {
		return telpa;
	}

	public void setTelpa(String telpa) {
		this.telpa = telpa;
	}

	public String getCorreopa() {
		return correopa;
	}

	public void setCorreopa(String correopa) {
		this.correopa = correopa;
	}

	public int getProyectospa() {
		return proyectospa;
	}

	public void setProyectospa(int proyectospa) {
		this.proyectospa = proyectospa;
	}

	public PacientesMB getRegistroSeleccionado() {
		return registroSeleccionado;
	}

	public void setRegistroSeleccionado(PacientesMB registroSeleccionado) {
		this.registroSeleccionado = registroSeleccionado;
	}

	public void crearPa(ActionEvent event) {
	        RequestContext context = RequestContext.getCurrentInstance();
	        FacesContext contex = FacesContext.getCurrentInstance();
	        
	        FacesMessage message = null;
	        boolean loggedIn = false;
	        
	        
	        
	         
	        if(nompa != null && apepa != null && edadpa ==0 && generopa != null && ciudadpa != null && csaludpa != null && denticionpa != null
	        		&& idepa == 0 && proyectospa == 0) {
	        	

	        	
	        	
	        	int n1= 0, n2=0, n3=0, n4=0, n5=0, cont=0;
	        	String t1 = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
	        	String t2 = "abcdefghijklmnñopqrstuvwxyz";
	        	String t3 = "0123456789";
	        	
	        	

	            loggedIn = true;
	            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "creado", nompa);
	        	}
	        	
	         else {
	            loggedIn = false;
	            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "crear Error", "Invalid credentials");
	        }
	         
	        FacesContext.getCurrentInstance().addMessage(null, message);
	        //context.addCallbackParam("loggedIn", loggedIn);
	    }
	
	public void crearOdon(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesContext contex = FacesContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedOff = false;
        
        loggedOff = false;
             message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sesión cerrada", "Invalid credentials");
        
            try {
				contex.getExternalContext().redirect("Odontograma.jsf");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedOff", loggedOff);
    }  
	
	public void consultar(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesContext contex = FacesContext.getCurrentInstance();
        
        FacesMessage message = null;
        boolean loggedIn = false;
         
        if(idepa == 0 ) {
        	

            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "consulta", "");
        	}
        	
         else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error consulta", "Invalid credentials");
        }
         
        FacesContext.getCurrentInstance().addMessage(null, message);
        //context.addCallbackParam("loggedIn", loggedIn);
    }
	
}