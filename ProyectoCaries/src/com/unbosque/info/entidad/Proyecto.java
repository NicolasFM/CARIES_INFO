package com.unbosque.info.entidad;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;


/**
 * The persistent class for the proyecto database table.
 * 
 */
@Entity
@Table(name="proyecto")
public class Proyecto implements Serializable {
	private static final long serialVersionUID = 1443L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name="nombre_ciudad", nullable = false)
	private String nomCiudad;

	@Column(name="nombre_dpto", nullable = false)
	private String nomDpto;

	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	@Column(name = "estado", nullable = false)
	private String estado;
	
	@Column(name = "tipo_proyecto", nullable = false)
	private String tipo;
	
	@Column(name = "poblacion", nullable = false)
	private String poblacion;
	
	@Column(name = "fecha_inicial", nullable = false)
	private java.sql.Date fechai;
	
	@Column(name = "fecha_final", nullable = false)
	private java.sql.Date fechaf;

	public Proyecto() {
		super();
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomCiudad() {
		return this.nomCiudad;
	}

	public void setNomCiudad(String nomCiudad) {
		this.nomCiudad = nomCiudad;
	}

	public String getNomDpto() {
		return this.nomDpto;
	}

	public void setNomDpto(String nomDpto) {
		this.nomDpto = nomDpto;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public java.sql.Date getFechai() {
		return fechai;
	}

	public void setFechai(java.sql.Date date) {
		this.fechai = date;
	}

	public java.sql.Date getFechaf() {
		return fechaf;
	}

	public void setFechaf(java.sql.Date date) {
		this.fechaf = date;
	}

}