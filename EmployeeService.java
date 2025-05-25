package com.quickxpert.employeemanagementsystem.service;

import java.util.List;

import com.quickxpert.employeemanagementsystem.entity.Employee;


public interface EmployeeService {

	public List<Employee> getAllEmployee();
	public Employee saveEmployee(Employee employee); //add
	public Employee getById(int id);              //update
	public void deleteId(int id);                //delete
	public Employee viewById(int id);             //view
}
