package com.capstone.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.entity.Register;
import com.capstone.service.RegisterService;



@RestController
@RequestMapping("register")
@CrossOrigin(origins = "http://localhost:4200")
public class RegisterController {

	@Autowired
	RegisterService reqservice;
	
	@PostMapping(value = "apply",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String requestadhar(@RequestBody Register req) {
		return reqservice.storeRequest(req);
	}
	
	@GetMapping(value="viewAllRequest",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Register> getAllReq() {
		return reqservice.getAllRequests();
	}
	
	@DeleteMapping(value="deny/{adharid}")
	public String deleteReq(@PathVariable("adharid") String adharid) {
		return reqservice.denyRequest(adharid);
	}
	@PatchMapping(value = "approve",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String approveRequest(@RequestBody Register req) {
		return reqservice.approveRequest(req);
	}
	
	@PatchMapping(value = "updateadhar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Register> updateadhar(@RequestBody Register req) {
	    Register updateadhar = reqservice.updateadhar(req);
	    if (updateadhar != null) {
	        return ResponseEntity.ok(updateadhar);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}


	@GetMapping(value="viewmyadhar/{emailid}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Register viewmyAdhar(@PathVariable("emailid") String emailid) {
		return reqservice.viewmyAdhar(emailid);
	}
}
