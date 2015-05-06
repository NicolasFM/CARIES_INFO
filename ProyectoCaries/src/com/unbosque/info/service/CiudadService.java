package com.unbosque.info.service;

import java.util.List;

import com.unbosque.info.dao.CiudadDAO;
import com.unbosque.info.entidad.Ciudad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("CiudadService")
@Transactional(readOnly = true)
public class CiudadService {

	// CiudadDAO is injected...
	@Autowired
	CiudadDAO ciudadDAO;

	@Transactional(readOnly = false)
	public void addCiudad(Ciudad ciudad) {
		getCiudadDAO().addCiudad(ciudad);
	}

	@Transactional(readOnly = false)
	public void deleteCiudad(Ciudad ciudad) {
		getCiudadDAO().deleteCiudad(ciudad);
	}

	@Transactional(readOnly = false)
	public void updateCiudad(Ciudad ciudad) {
		getCiudadDAO().updateCiudad(ciudad);
	}

	public Ciudad getCiudadById(int id) {
		return getCiudadDAO().getCiudadById(id);
	}

	public List<Ciudad> getCiudades() {
		return getCiudadDAO().getCiudades();
	}

	public CiudadDAO getCiudadDAO() {
		return ciudadDAO;
	}

	public void setCiudadDAO(CiudadDAO ciudadDAO) {
		this.ciudadDAO = ciudadDAO;
	}
}
