package com.login.flock.demo;

import java.net.URISyntaxException;

import org.apache.catalina.security.SecurityConfig;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import com.login.flock.demo.controller.ApiController;
import com.login.flock.demo.model.Centroide;
import com.login.flock.demo.model.DataJs;
import com.login.flock.demo.model.Provincia;

import junit.framework.Assert;

/**
 * @author carlos.guayapero
 *
 */
@SpringBootTest
class DemoApplicationTests {
	
	@InjectMocks
	Centroide centroide;
	
	@InjectMocks 
	AuthenticationManagerBuilder auth;
	
	@Mock 
	ApiController controllerApi; 
	
	@Mock 
	SecurityConfig securityConfig;

	@Mock 
	DemoApplication applicationRestTemplate;
	private static String url = "https://apis.datos.gob.ar/georef/api/provincias";
	
	@Test
	void contextLoads() {
	}

	/**
	 * Este método testea el método getCentroideByName de la clase ApiController
	 * se compara el resultado del controller pasandole como parámetro 
	 * el nombre de una provicia contra el de un objeto creado
	 * */
	@Test
	public void getCentroideProvincesByName() {
		
		Provincia provinciaTest = new Provincia(new Centroide (-26.8753965086829,-54.6516966230371),"54","Misiones");
		Mockito.when(controllerApi.getCentroideByNameProvince(provinciaTest.getNombre())).thenReturn(provinciaTest.getCentroide());
		Centroide response = controllerApi.getCentroideByNameProvince(provinciaTest.getNombre());
		Assert.assertEquals(provinciaTest.getCentroide(),response);
	}
	
	
	/**
	 * Este método testea el método getProvinces de la clase ApiController
	 * se compara el resultado del controller que es un Objeto DataJs con 
	 * con Objeto DataJs mockeado en la clase ControllerApi
	 * */
	@Test
	public void getPronvinces() throws URISyntaxException {
		DemoApplication restTemplate = new DemoApplication();
		DataJs objectResult1 =  restTemplate.getRestTemplate().getForObject(url, DataJs.class);
		Mockito.when(controllerApi.getProvinces()).thenReturn(objectResult1);
		DataJs objectResult= controllerApi.getProvinces();	
		Assert.assertSame(objectResult1, objectResult);
	}
	
	@Test 
	public void configureRols() {
		
		
	}
}
