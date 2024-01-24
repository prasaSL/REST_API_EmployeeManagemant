package com.example.RESRAPI.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RESRAPI.model.employe;
import com.example.RESRAPI.service.ServiceInterFace;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api")
public class employeController {
	
private ServiceInterFace empService;

   public employeController(ServiceInterFace empService) {
     	super();
    	this.empService = empService;
    }
   @PostMapping("employee")
   public ResponseEntity<employe> saveEmploye(@RequestBody employe emp ){
	 
	   return new ResponseEntity<employe>(empService.seveEmploye(emp), HttpStatus.CREATED);
   }
   
   @GetMapping("AllEmploye")
   public List<employe> getallEmployees(){
	   return empService.getAllemployee();
   }

   
   //build get employee by id
   @GetMapping("{id}")
   public ResponseEntity<employe> getemployeeByid(@PathVariable("id") long id ) {
	   
	   return new ResponseEntity<employe>(empService.getemployeByid(id),HttpStatus.OK);
	    
   }
   
   //build update employee REST APi
   
   @PutMapping("update/{id}")
   public ResponseEntity<employe> UpdateEmploye(@PathVariable ("id")  long id ,@RequestBody employe emp) {
     
       
       return new ResponseEntity<employe>(empService.updateEmploye(emp, id),HttpStatus.OK);
   }
   
   
   //build delete employee api
   
   @DeleteMapping("delate/{id}")
   public ResponseEntity<String> delateEmployee(@PathVariable("id") long id){
	   empService.delateempl(id);
	   
	   
	   return new  ResponseEntity<String>("Delete employee successfully",HttpStatus.OK);
   }
}
