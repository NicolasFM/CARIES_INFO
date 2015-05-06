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

import com.unbosque.info.entidad.Departamento;
import com.unbosque.info.service.DepartamentoService;

@ManagedBean(name = "departamentoMB")
@SessionScoped
public class DepartamentoMB implements Serializable {

	private static final long serialVersionUID = -780939568460749463L;

	private DepartamentoMB registroSeleccionado;

	// Spring Customer Service is injected...
	@ManagedProperty(value = "#{DepartamentoService}")
	DepartamentoService departamentoService;

	List<Departamento> departamentoList;

	private int id;
	private String departamento;
	private String estado;

	public void addDepartamento() {
		try {

			RequestContext context = RequestContext.getCurrentInstance();
			FacesMessage message = null;
			boolean loggedIn = false;
			
			if(departamento.equals("")){
				
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
						"Error, El nombre del departamento no puede estar vacío ");
				FacesContext.getCurrentInstance().addMessage(null, message);
			}else{
				
				String a = departamento;
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
    	            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "","El nombre del departamento no puede contener números");
    				FacesContext.getCurrentInstance().addMessage(null, message);
        		}else{

        			loggedIn = true;
			Departamento departamento = new Departamento();
			
			departamento.setNombre(getDepartamento());
			departamento.setEstado("A");
			getDepartamentoService().addDepartamento(departamento);
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
		this.setDepartamento("");
	}

	public List<Departamento> getDepartamentosList() {
		departamentoList = new ArrayList<Departamento>();
		departamentoList.addAll(getDepartamentoService().getDepartamentos());
		return departamentoList;
	}

	public DepartamentoService getDepartamentoService() {
		return departamentoService;
	}

	public void setDepartamentoService(DepartamentoService departamentoService) {
		this.departamentoService = departamentoService;
	}

	public List<Departamento> getDepartamentoList() {
		return departamentoList;
	}

	public void setDepartamentoList(List<Departamento> departamentoList) {
		this.departamentoList = departamentoList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public DepartamentoMB getRegistroSeleccionado() {
		return registroSeleccionado;
	}

	public void setRegistroSeleccionado(DepartamentoMB registroSeleccionado) {
		this.registroSeleccionado = registroSeleccionado;
	}

}