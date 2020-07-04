package com.task.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.task.demo.request.CredentialRequest;
import com.task.demo.response.CredentialResponse;

@RestController
public class ApiClientController {
	
	@Autowired
	private  HttpServletRequest sess;
	
	@RequestMapping(value = "/credential", method = RequestMethod.POST)
	public ResponseEntity<Object> credential(CredentialRequest request){
		List<Integer> keys =  new ArrayList<Integer>();
		CredentialResponse res = new CredentialResponse();
		System.out.println("*********"+request.getKey()+"******************************* "+sess.getSession().getAttribute("key"));
		if(sess.getSession().getAttribute("key") != null) {
			keys = (List<Integer>) sess.getSession().getAttribute("key");
			if(keys.contains(request.getKey())) {
				res.setStatus(403);
			}else {
				res.setStatus(205);
				keys.add(request.getKey());
				sess.getSession().setAttribute("key",keys);
			}
		}else {
			res.setStatus(204);
			keys.add(request.getKey());
			sess.getSession().setAttribute("key",keys);
		}
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

}
