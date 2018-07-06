/**
 * 
 */
package com.bancoazteca.bdm.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author ajcruzmi
 *
 */
@RestController
@RequestMapping("api/bdm/")
@Api(value = "Foto")
public class FotoController {

	@ApiOperation(value = "Consulta persona por foto")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Ops Not found"),
			@ApiResponse(code = 200, message = "Sucess") })
	@RequestMapping(value = "existPersonaXFoto", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> existePersonaXFoto() throws Exception {
		
		String ip = "http://localhost:8765/WS_BiometricosDummy/";
		String path = "ms/existPersonaXFoto";
		
		String url = ip + path;
		
		
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.postForObject(url, "", String.class);
		
		System.out.println("Response**" + result);
		
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}

}
