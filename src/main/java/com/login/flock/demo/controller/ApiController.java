package com.login.flock.demo.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.login.flock.demo.model.Centroide;
import com.login.flock.demo.model.DataJs;
import com.login.flock.demo.model.Provincia;
import ch.qos.logback.classic.Logger;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@Controller
public class ApiController {

	@Autowired
	private RestTemplate restTemplate;

	Logger logger = (Logger) LoggerFactory.getLogger(ApiController.class);

	private static String url = "https://apis.datos.gob.ar/georef/api/provincias";

	@Operation(summary = "Consulta todas las pronvincias que ofrece la API pública")
	@ApiResponse(responseCode = "200", description = "Lista de todas las  provincias")
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/provincia")
	public DataJs getProvinces() {
		logger.info("Consultando Lista de todas las provincias");
		logger.info("Accediendo a listas de provicias:" + url);
		DataJs result = restTemplate.getForObject(url, DataJs.class);
		return result;

	}

	@Operation(summary = "Consulta el Centroide de una  provincia dando el nombre")
	@GetMapping("/provincias/centroide/{provinceName}")
	@ApiResponse(responseCode = "200", description = "Centroide Encontrado para la provincia")
	public Centroide getCentroideByNameProvince(
			@Parameter(description = "Nombre de la provincia ", required = true) @PathVariable String provinceName) {
		Centroide centroide = null;
		logger.info("Consultando provincia: " + provinceName);
		DataJs data = restTemplate.getForObject(url, DataJs.class);

		for (Provincia provincia2 : data.getProvincias()) {
			if (provincia2.getNombre().toLowerCase().trim().equals(provinceName.toLowerCase().trim())) {
				centroide = provincia2.getCentroide();
				break;
			}
		}
		logger.info("Respuesta consulta provincia: " + provinceName + " " + centroide.toString());
		return centroide;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	@Operation(summary = "Cuando un usuario inicia sesión le muestra el rol con el cual inició")
	@ApiResponse(responseCode = "200", description = "Mensaje con el Rol de usuario")
	public String welcomePage(Authentication authentication) {
		logger.info("Validando Credenciales: " + authentication.getPrincipal());
		logger.info("Inicio de sesión válido: " + authentication.getName());
		return "Bienvenido, tienes permisos de " + authentication.getName();
	}
}