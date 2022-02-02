package com.login.flock.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"lat",
"lon"
})

public class Centroide {

@JsonProperty("lat")
private Double lat;
@JsonProperty("lon")
private Double lon;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public Centroide() {
	super();
	// TODO Auto-generated constructor stub
}

public Centroide(Double lat, Double lon) {
	super();
	this.lat = lat;
	this.lon = lon;
}

@JsonProperty("lat")
public Double getLat() {
return lat;
}

@JsonProperty("lat")
public void setLat(Double lat) {
this.lat = lat;
}

@JsonProperty("lon")
public Double getLon() {
return lon;
}

@JsonProperty("lon")
public void setLon(Double lon) {
this.lon = lon;
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

