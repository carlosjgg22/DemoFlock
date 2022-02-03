package com.login.flock.demo.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.login.flock.demo.model.Centroide;
import com.login.flock.demo.model.DataJs;
import com.login.flock.demo.model.Provincia;
import ch.qos.logback.classic.Logger;

@RestController
public class ApiController {

	@Autowired
	private RestTemplate restTemplate;

	Logger logger = (Logger) LoggerFactory.getLogger(ApiController.class);

	private static String url = "https://apis.datos.gob.ar/georef/api/provincias";

	@GetMapping("/provincia")
	public DataJs getProvinces() {
		logger.info("Consultando Lista de todas las provincias");
		// Object[] provincias = restTemplate.getForObject(url, Object[].class);
		logger.info("Accediendo a listas de provicias:" + url);
		DataJs result = restTemplate.getForObject(url, DataJs.class);
		return result;

	}

	@GetMapping("/provincias/centroide/{provinceName}")
	public Centroide getCentroideByNameProvince(@PathVariable String provinceName) {
		Centroide centroide = null;
		logger.info("Consultando provincia: " + provinceName);
		DataJs datos = restTemplate.getForObject(url, DataJs.class);

		for (Provincia provincia2 : datos.getProvincias()) {
			if (provincia2.getNombre().toLowerCase().trim().equals(provinceName.toLowerCase().trim())) {
				centroide = provincia2.getCentroide();
				break;
			}
		}
		logger.info("Respuesta consulta provincia: " + provinceName + " " + centroide.toString());
		return centroide;

	}

	@Controller
	@RequestMapping
	public class LoginController {
		@RequestMapping(value = "/", method = RequestMethod.GET)
		@ResponseBody
		public String welcomePage(Authentication authentication) {
			logger.info("Validando Credenciales: " + authentication.getPrincipal());
			logger.info("Inicio de sesión válido: " + authentication.getName());
			return "Bienvenido, tienes permisos de" + authentication.getName();

		}
	}
}
