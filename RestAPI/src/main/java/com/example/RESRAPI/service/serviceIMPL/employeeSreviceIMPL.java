package com.example.RESRAPI.service.serviceIMPL;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.RESRAPI.exception.ResourseNotException;
import com.example.RESRAPI.model.employe;
import com.example.RESRAPI.repository.employeRepository;
import com.example.RESRAPI.service.ServiceInterFace;


@Service
public class employeeSreviceIMPL implements ServiceInterFace {

	private employeRepository employerepositor;
	
	
	
	public employeeSreviceIMPL(employeRepository employerepository) {
		super();
		this.employerepositor = employerepository;
	}



	@Override
	public employe seveEmploye(employe emp) {
		 
		return employerepositor.save(emp);
	}



	@Override
	public List<employe> getAllemployee() {
		
		return employerepositor.findAll();
	}



	@Override
	public employe getemployeByid(long id) {
		
		return employerepositor.findById(id).orElseThrow(() -> new ResourseNotException("employee", "Id", id));
	}



	@Override
	public employe updateEmploye(employe emp, long id) {
		//check update data in the data base
		
		employe exsistenceemployee = employerepositor.findById(id).orElseThrow(() -> new ResourseNotException("employee", "Id", id));
		
		exsistenceemployee.setFirstName(emp.getFirstName());
		exsistenceemployee.setLastName(emp.getLastName());
		exsistenceemployee.setEmail(emp.getEmail());
		
		// save employee to data base
		
		employerepositor.save(exsistenceemployee);
		return  exsistenceemployee;
	}



	@Override
	public void delateempl(long id) {
		//check delete employee data in the data base
		
		employerepositor.findById(id).orElseThrow(() -> new ResourseNotException("employee", "Id",id));
		
		employerepositor.deleteById(id);
		
	}
	




	
	








}
