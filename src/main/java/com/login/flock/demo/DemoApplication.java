package com.login.flock.demo;

import org.apache.catalina.security.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Configuration  
@Import({ SecurityConfig.class })
@SpringBootApplication
public class DemoApplication {

	@Bean 
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@GetMapping("/hello")	
	public String hello(@RequestParam(value ="name", defaultValue= "World its mine") String name) {
			return String.format("Hello %s!", name);
	}
	
//	@Bean
//	public RestTemplate restTemplate(RestTemplateBuilder builder) {
//		return builder.build();
//	}
//	
//	@GetMapping("/provincias")
//	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
//		
//		Provincia provincia = restTemplate.getForObject(
//				"https://apis.datos.gob.ar/georef/api/provincias", Provincia.class);
//		return (CommandLineRunner) provincia;
//			
//	
//	}
//	
//	@RequestMapping("/provincia")
//	public List<Object> getPronv() {
//		String url = "https://apis.datos.gob.ar/georef/api/provincias";
//		RestTemplate template = new RestTemplate();
//			Object[] provincia = template.getForObject(url, Provincia[].class);
//		 return Arrays.asList(provincia);
//       
	
	
	//}
	

}
