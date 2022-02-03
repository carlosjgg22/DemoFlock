package com.login.flock.demo.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "centroide", "id", "nombre" })

public class Provincia {

	@JsonProperty("centroide")
	private Centroide centroide;
	@JsonProperty("id")
	private String id;
	@JsonProperty("nombre")
	private String nombre;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();


	public Provincia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Provincia(Centroide centroide, String id, String nombre) {
		super();
		this.centroide = centroide;
		this.id = id;
		this.nombre = nombre;
	}

	@JsonProperty("centroide")
	public Centroide getCentroide() {
		return centroide;
	}

	@JsonProperty("centroide")
	public void setCentroide(Centroide centroide) {
		this.centroide = centroide;
	}

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("nombre")
	public String getNombre() {
		return nombre;
	}

	@JsonProperty("nombre")
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	@Override
	public String toString() {
		return "Provincia [centroide=" + centroide + ", id=" + id + ", nombre=" + nombre + "]";
	}

}
