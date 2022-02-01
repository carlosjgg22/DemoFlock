package com.login.flock.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController 
public class ApiController {
	
	@Autowired
	private RestTemplate restTemplate; 
	
	private static String url="https://apis.datos.gob.ar/georef/api/provincias";
	@GetMapping("/provincias")
	public List<Object> getProvincias(){
		//Object[] provincias = restTemplate.getForObject(url, Object[].class);
		Provincia provincias = restTemplate.getForObject(url, Provincia.class);
		
		provincias.toString();
		return Arrays.asList(provincias);
		
	}
	
	@GetMapping("/provincia")
	public Object getProvins(){
		//Object[] provincias = restTemplate.getForObject(url, Object[].class);
		return restTemplate.getForObject(url, String.class);
		}
	
	@GetMapping("/provinciascentroide/{provinceName}")
	public Centroide getListProvin(@PathVariable String provinceName){
	Centroide centroide=null;
	DataJs datos = restTemplate.getForObject(url, DataJs.class);
		for (Provincia provincia2 : datos.getProvincias()) {
		if(provincia2.getNombre().toLowerCase().trim().equals(provinceName.toLowerCase().trim())) {
			 centroide = provincia2.getCentroide();
			 	break;
				}}
		return centroide;
	
		}
}
