package com.quickxpert.employeemanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.quickxpert.employeemanagementsystem.entity.Employee;
import com.quickxpert.employeemanagementsystem.service.EmployeeService;


@org.springframework.stereotype.Controller
public class Controller {

	@Autowired
	private EmployeeService service;
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/employees")
	public String getAllStudents(Model model) {
		model.addAttribute("employees", service.getAllEmployee());
		return "employees";
	}
	
	@GetMapping("/employees/new")
	public String createEmployeeForm(Model model) {
		Employee e=new Employee();
		model.addAttribute("employee", e);
		return "create";
				}
	
	@PostMapping("/employees")
	public String saveStudent(@ModelAttribute("employee") Employee employee ) {
		service.saveEmployee(employee);
		return "redirect:/employees";
	}
	
	@GetMapping("/employees/edit/{id}")
	public String editEmployee(@PathVariable int id,Model model) {
		model.addAttribute("employee" , service.getById(id));
		return "edit";
	}
	
	@PostMapping("/employees/edit/{id}")
	public String updateEmployee(@PathVariable int id,@ModelAttribute("employee")Employee employee) {
		Employee existingStudent= service.getById(id);
		existingStudent.setFirstname(employee.getFirstname());
		existingStudent.setLastname(employee.getLastname());
		existingStudent.setEmail(employee.getEmail());
		service.saveEmployee(existingStudent);
		return "redirect:/employees";
	}
	
	@GetMapping("/employees/{id}")
	public String deleteById(@PathVariable int id) {
		service.deleteId(id);
		return "redirect:/employees";
	}
	
	@GetMapping("/employees/view/{id}")
	public String viewById(@PathVariable int id,Model model) {
		model.addAttribute("employee",service.getById(id));
		return "view";
	}
}
