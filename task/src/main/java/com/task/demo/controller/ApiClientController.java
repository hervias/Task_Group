package com.task.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.task.demo.request.CredentialRequest;
import com.task.demo.request.MessageRequest;
import com.task.demo.response.CredentialResponse;
import com.task.demo.response.MessageResponse;
import com.task.demo.response.MessageTagResponse;
import com.task.demo.response.MessagetResponse;

@RestController
public class ApiClientController {
	
	@Autowired
	private  HttpServletRequest sess;
	
	@RequestMapping(value = "/credential", method = RequestMethod.PUT)
	public ResponseEntity<Object> credential(@RequestBody CredentialRequest request){
		List<Integer> keys =  new ArrayList<Integer>();
		CredentialResponse res = new CredentialResponse();
		
		if(sess.getSession().getAttribute("key") != null) {
			keys = (List<Integer>) sess.getSession().getAttribute("key");
			if(keys.contains(request.getKey())) {
				res.setStatus(403);
			}else {
				res.setStatus(204);
				keys.add(request.getKey());
				sess.getSession().setAttribute("key",keys);
			}
		}else {
			res.setStatus(204);
			keys.add(request.getKey());
			sess.getSession().setAttribute("key",keys);
		}
		
		System.out.println("*********"+request.getKey()+"******************************* "+sess.getSession().getAttribute("key"));
		
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/message", method = RequestMethod.POST)
	public ResponseEntity<Object> message(@RequestBody MessageRequest request){
		List<MessageRequest> message =  new ArrayList<MessageRequest>();
		MessageResponse res = new MessageResponse();
		
		if(sess.getSession().getAttribute("message") != null) {
			message = (List<MessageRequest>) sess.getSession().getAttribute("message");
			
			request.setId(message.size()+1);
			message.add(request);
			sess.getSession().setAttribute("message",message);
			res.setStatus(200);
			res.setIdentifier(request.getId());
		}else {
			request.setId(1);
			message.add(request);
			sess.getSession().setAttribute("message",message);
			res.setStatus(200);
			res.setIdentifier(request.getId());
		}
				
		return new ResponseEntity<>(res, HttpStatus.OK);
		
	}
	
	

	@RequestMapping(value = "/messageid", method = RequestMethod.GET)
	public ResponseEntity<Object> messageid(@RequestParam Integer identifier){
		MessageTagResponse res = new MessageTagResponse();
		List<MessageRequest> message =  new ArrayList<MessageRequest>();
		if(sess.getSession().getAttribute("message") != null) {
			message = (List<MessageRequest>) sess.getSession().getAttribute("message");
			
			for(MessageRequest m: message) {
				if(m.getId() == identifier) {
					res.setMsg(m.getMsg());
					res.setStatus(200);
				}
			}
			
			if(res.getStatus() != null && res.getStatus() != 200) {
				res.setMsg("No existe ningun registro.");
				res.setStatus(200);
			}
		}else {
			res.setMsg("No existe ningun registro.");
			res.setStatus(200);
		}

		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/messagetag", method = RequestMethod.GET)
	public ResponseEntity<Object> messagetag(@RequestParam String tag){
		MessagetResponse res = new MessagetResponse();
		List<MessageRequest> message =  new ArrayList<MessageRequest>();
		if(sess.getSession().getAttribute("message") != null) {
			message = (List<MessageRequest>) sess.getSession().getAttribute("message");
			List<String> msgs =  new ArrayList<String>();
			for(MessageRequest m: message) {
				if(m.getTags().trim().equals(tag)) {
					msgs.add(m.getMsg());
				}
			}
			res.setList_msg(msgs);
			res.setStatus(200);
			
		}else {
			res.setStatus(200);
		}

		return new ResponseEntity<>(res, HttpStatus.OK);
	}
}
