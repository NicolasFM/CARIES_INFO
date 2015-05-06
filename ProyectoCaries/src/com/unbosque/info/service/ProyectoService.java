package com.unbosque.info.service;

import java.util.List;

import com.unbosque.info.dao.ProyectoDAO;
import com.unbosque.info.entidad.Proyecto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("ProyectoService")
@Transactional(readOnly = true)
public class ProyectoService {

	// ProyectoDAO is injected...
	@Autowired
	ProyectoDAO proyectoDAO;

	@Transactional(readOnly = false)
	public void addProyecto(Proyecto proyecto) {
		getProyectoDAO().addProyecto(proyecto);
	}

	@Transactional(readOnly = false)
	public void deleteProyecto(Proyecto proyecto) {
		getProyectoDAO().deleteProyecto(proyecto);
	}

	@Transactional(readOnly = false)
	public void updateProyecto(Proyecto proyecto) {
		getProyectoDAO().updateProyecto(proyecto);
	}

	public Proyecto getProyectoById(int id) {
		return getProyectoDAO().getProyectoById(id);
	}

	public List<Proyecto> getProyectos() {
		return getProyectoDAO().getProyectos();
	}

	public ProyectoDAO getProyectoDAO() {
		return proyectoDAO;
	}

	public void setProyectoDAO(ProyectoDAO proyectoDAO) {
		this.proyectoDAO = proyectoDAO;
	}
}
