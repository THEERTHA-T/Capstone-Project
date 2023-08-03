package com.capstone.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.entity.Register;
import com.capstone.repository.RegisterRepository;



@Service
public class RegisterService {

	@Autowired
	RegisterRepository reqrepo;
	
	public String storeRequest(Register req) {
		reqrepo.save(req);
		return "Aadhar Application Request Submitted";
	}
	
	public List<Register> getAllRequests() {
		return reqrepo.findAll();
	}
	
	public String denyRequest(String adharid) {
		Optional<Register> result  = reqrepo.findById(adharid);
		if(result.isPresent()) {
			Register p = result.get();
			reqrepo.delete(p);
			return "Application Denied";
		}else {
			return "Application not present";
		}
	}
	public String approveRequest(Register req) {
		Optional<Register> result  = reqrepo.findById(req.getAdharid());
		if(result.isPresent()) {
			Register p = result.get();
			reqrepo.saveAndFlush(p);
			return "Application Approved";
		}else {
			return "Application not present";
		}
	}
	
	public Register updateadhar(Register req) {
	    Optional<Register> result = reqrepo.findById(req.getAdharid());
	    if (result.isPresent()) {
	        Register p = result.get();
	        p.setAdharid(req.getAdharid());
	        p.setEmailid(req.getAdharid());
	        p.setName(req.getName());
	        p.setAddress(req.getAddress());
	        p.setGender(req.getGender());
	        p.setPhone(req.getPhone());
	        p.setDob(req.getDob());
	        return reqrepo.saveAndFlush(p);
	    } else {
	        // Return null or an empty object to indicate the Aadhar is not present
	        return null;
	    }
	}

	
	public Register viewmyAdhar(String emailid) {
	    return reqrepo.viewmyAdhar(emailid);
	}

}
