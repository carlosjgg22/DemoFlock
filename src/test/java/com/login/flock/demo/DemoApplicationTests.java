package com.login.flock.demo;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import com.login.flock.demo.controller.ApiController;
import com.login.flock.demo.model.Centroide;
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
	
	@Mock 
	ApiController controllerApi; 
	
	@Test
	void contextLoads() {
	}

	/**
	 * Este método testea el método getListProvin de la clase ApiController
	 * se compara el resultado del controller pasandole como parámetro 
	 * el nombre de una provicia contra el de un objeto creado
	 * */
	@Test
	public void getCentroideProvincesByName() {
		
		Provincia provinciaTest = new Provincia(new Centroide (-26.8753965086829,-54.6516966230371),"54","Misiones");
		Mockito.when(controllerApi.getListProvin(provinciaTest.getNombre())).thenReturn(provinciaTest.getCentroide());
		Centroide response = controllerApi.getListProvin(provinciaTest.getNombre());
		Assert.assertEquals(provinciaTest.getCentroide(),response);
	}
	
	@Test
	public void getCentroideProvincese() {
		
		Provincia provinciaTest = new Provincia(new Centroide (-26.8753965086829,-54.6516966230371),"54","Misiones");
		Mockito.when(controllerApi.getListProvin(provinciaTest.getNombre())).thenReturn(provinciaTest.getCentroide());
		Centroide response = controllerApi.getListProvin(provinciaTest.getNombre());
		//Assert.assertEquals(response,HttpStatus.OK);
		
		
	}
}
