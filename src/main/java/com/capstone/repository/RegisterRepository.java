package com.capstone.repository;

import java.util.Iterator;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capstone.entity.Register;


@Repository
public interface RegisterRepository extends JpaRepository<Register, String>{

	//JPQL 
		@Query("select r from Register r where r.emailid = :emailid")
		public Register viewmyAdhar(@Param("emailid") String emailid);

}
