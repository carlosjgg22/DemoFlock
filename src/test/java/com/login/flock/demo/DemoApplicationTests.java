package com.login.flock.demo;
import static org.mockito.Mockito.mock;

import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

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
	
	@Mock 
	ApiController controllerApi; 
	
	@Mock 
	DemoApplication applicationRestTemplate;
	private static String url = "https://apis.datos.gob.ar/georef/api/provincias";
	
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
		Mockito.when(controllerApi.getCentroideByNameProvince(provinciaTest.getNombre())).thenReturn(provinciaTest.getCentroide());
		Centroide response = controllerApi.getCentroideByNameProvince(provinciaTest.getNombre());
		Assert.assertEquals(provinciaTest.getCentroide(),response);
	}
	
	@Test
	public void getPronvinces() throws URISyntaxException {
		DemoApplication restTemplate = new DemoApplication();
		//DataJs data = new DataJs();
		//Mockito.when(controllerApi.getProvinces()).thenReturn(data);
		//DataJs objectResult= controllerApi.getProvinces();
		//DataJs objectResult1 =  restTemplate.getRestTemplate().getForObject(url, DataJs.class);
	    //System.out.print(objectResult1.toString());
	    //System.out.print(objectResult);
		//Assert.assertSame(objectResult1, objectResult);
		 //Assert.assertEquals(objectResult.getClass(), Object.class);
		
		//Provincia provinciaTest = new Provincia(new Centroide (-26.8753965086829,-54.6516966230371),"54","Misiones");
		//Mockito.when(controllerApi.getListProvin(provinciaTest.getNombre())).thenReturn(provinciaTest.getCentroide());
	//Centroide response = controllerApi.getListProvin(provinciaTest.getNombre());
		//Assert.assertEquals(response,HttpStatus.OK);
		
		DataJs templateMock = mock(DataJs.class);
		Mockito.when(controllerApi.getProvinces()).thenReturn(templateMock);
		DataJs objectResult= controllerApi.getProvinces();
		DataJs objectResult1 =  restTemplate.getRestTemplate().getForObject(url, DataJs.class);
		System.out.print(objectResult.toString());
		System.out.print(objectResult1);
		Assert.assertSame(objectResult1, objectResult);
	}
}
