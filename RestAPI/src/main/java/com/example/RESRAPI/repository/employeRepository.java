package com.example.RESRAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.RESRAPI.model.employe;
  
public interface employeRepository extends JpaRepository<employe,Long > {

}
