package com.tnsif.shoppingmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tnsif.shoppingmall.entity.Employee;
import com.tnsif.shoppingmall.repository.EmployeeRepository;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeRepository empRepo;

	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable Long id) {
		return empRepo.findById(id).get();
	}

	@GetMapping
	public List<Employee> getAllEmployees() {
		return empRepo.findAll();
	}

	@PostMapping
	public Employee createEmployee(@RequestBody Employee Employee) {
		return empRepo.save(Employee);
	}

	@PutMapping("/{id}")
	public void updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
		employee.setId(id);
		empRepo.save(employee);
	}

	@DeleteMapping("/{id}")
	public void deleteEmployeeById(@PathVariable Long id) {
		empRepo.deleteById(id);
	}
}
