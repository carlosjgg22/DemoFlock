package com.login.flock.demo;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"centroide",
"id",
"nombre"
})

public class Provincia {

@JsonProperty("centroide")
private Centroide centroide;
@JsonProperty("id")
private String id;
@JsonProperty("nombre")
private String nombre;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

}
