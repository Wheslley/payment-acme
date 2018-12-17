package br.com.acme.payment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PathService {
	
	protected List<String> paths = new ArrayList<>();

	public PathService() {
		this.paths.add("[GET]    /NO PATHS");
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<String> home() {
		int contador = 0;
		String strReturn = "{ \"aplication\" : \"payment.acme\", \"paths\" : [";
		for (String path : paths) {
			if(contador != 0) strReturn = strReturn + ",";
			strReturn = strReturn + "{\"endPoint\": \""+path+"\"}";
			++contador;
		}
		strReturn = strReturn + "]}";
		return new ResponseEntity<String>( strReturn, HttpStatus.OK);
		
	}
	
}
