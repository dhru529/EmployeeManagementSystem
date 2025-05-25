package com.quickxpert.employeemanagementsystem.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quickxpert.employeemanagementsystem.entity.Employee;
import com.quickxpert.employeemanagementsystem.repository.EmployeeRepository;
import com.quickxpert.employeemanagementsystem.service.EmployeeService;

@Service
public class ServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> list=employeeRepository.findAll();
		return list;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getById(int id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public void deleteId(int id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public Employee viewById(int id) {
		return employeeRepository.findById(id).get();
	}

}
