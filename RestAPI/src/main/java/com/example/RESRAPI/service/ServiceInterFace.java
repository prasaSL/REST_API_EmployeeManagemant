package com.example.RESRAPI.service;

import java.util.List;

import com.example.RESRAPI.model.employe;

public interface ServiceInterFace {

	employe seveEmploye(employe emp);
	
	
	List<employe> getAllemployee();
	


	employe getemployeByid(long id);
	
	employe updateEmploye(employe emp , long id);
	
	void delateempl(long id);
	
}

