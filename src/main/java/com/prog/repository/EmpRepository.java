package com.prog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prog.entity.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer>{

}
