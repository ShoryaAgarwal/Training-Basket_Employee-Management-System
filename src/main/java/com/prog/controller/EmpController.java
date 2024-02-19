package com.prog.controller;

import java.util.List;

//import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.prog.entity.Employee;
import com.prog.service.EmpService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmpController {
	
	@Autowired
	private EmpService empService;
	
	@GetMapping("/")
	public String index(Model m)
	{
		List<Employee> list = empService.getAllEmp();
		m.addAttribute("empList",list);
		return "index";
	}
	@GetMapping("/addemp")
	public String addEmpform()
	{
		return "add_emp";
	}
	
	@GetMapping("/editemp/{id}")
	public String editEmpform(@PathVariable int id,Model m)
	{
//		System.out.println(id);
		Employee emp = empService.getEmpById(id);
		m.addAttribute("emp", emp);
		return "edit";
	}
	
	@PostMapping("/saveEmp")
	public String saveEmp(@ModelAttribute Employee emp,HttpSession session) 
	{
//		System.out.println(emp);
		Employee newEmp = empService.saveEmp(emp);
		if(newEmp!=null)
		{
//			System.out.println("save");
			session.setAttribute("msg", "Register Sucessfully");
		}else {
//			System.out.println("not save");
			session.setAttribute("msg", "Putting Correct Value");
		}
		return "redirect:/addemp";
		
	}
	
	@PostMapping("/updateEmpDetails")
	public String updateEmp(@ModelAttribute Employee emp,HttpSession session) 
	{
//		System.out.println(emp);
		Employee updateEmp = empService.saveEmp(emp);
		if(updateEmp!=null)
		{
//			System.out.println("save");
			session.setAttribute("msg", "Update Sucessfully");
		}else {
//			System.out.println("not save");
			session.setAttribute("msg", "Putting Correct Value");
		}
		return "redirect:/";
		
	}
	
	
	
}
