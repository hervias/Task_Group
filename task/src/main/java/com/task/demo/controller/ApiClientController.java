package com.task.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.task.demo.response.CredentialResponse;

@RestController
public class ApiClientController {
	
	@RequestMapping(value = "/credential", method = RequestMethod.PUT)
	public ResponseEntity<Object> userplaquentf(){
		CredentialResponse res = new CredentialResponse();
		res.setStatus(204);
		
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

}
