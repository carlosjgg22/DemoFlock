package com.login.flock.demo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"cantidad",
"inicio",
"parametros",
"provincias",
"total"
})

public class DataJs {
	@JsonProperty("cantidad")
	private Integer cantidad;
	@JsonProperty("inicio")
	private Integer inicio;
	@JsonProperty("parametros")
	private Parametros parametros;
	@JsonProperty("provincias")
	private List<Provincia> provincias = null;
	@JsonProperty("total")
	private Integer total;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("cantidad")
	public Integer getCantidad() {
	return cantidad;
	}

	@JsonProperty("cantidad")
	public void setCantidad(Integer cantidad) {
	this.cantidad = cantidad;
	}

	@JsonProperty("inicio")
	public Integer getInicio() {
	return inicio;
	}

	@JsonProperty("inicio")
	public void setInicio(Integer inicio) {
	this.inicio = inicio;
	}

	@JsonProperty("parametros")
	public Parametros getParametros() {
	return parametros;
	}

	@JsonProperty("parametros")
	public void setParametros(Parametros parametros) {
	this.parametros = parametros;
	}

	@JsonProperty("provincias")
	public List<Provincia> getProvincias() {
	return provincias;
	}

	@JsonProperty("provincias")
	public void setProvincias(List<Provincia> provincias) {
	this.provincias = provincias;
	}

	@JsonProperty("total")
	public Integer getTotal() {
	return total;
	}

	@JsonProperty("total")
	public void setTotal(Integer total) {
	this.total = total;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
	return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
	this.additionalProperties.put(name, value);
	}

	}
