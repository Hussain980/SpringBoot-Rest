package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@Autowired
	EmployeeRepository empRepo;

	/*
	 * @GetMapping("/home") public String home() {
	 * System.out.println("method called"); return "home"; }
	 */
	
	@GetMapping("/")
	@ResponseBody
	public String home() {
		return "Spring Rest working";
	}
	
	@PostMapping("/employee")
	@ResponseBody
	public String create(@RequestBody Employee employee)
	{
		empRepo.save(employee);
		return "employee saved";
	}
	
	@GetMapping("/employee/{id}")
	public Optional<Employee> getBYId(@PathVariable Integer id) {
		return empRepo.findById(id);
	}
	
	@GetMapping("/employees")
	public List<Employee> getList(){
		return empRepo.findAll();
	}
	
	@PutMapping("/employee")
	public Employee update(@RequestBody Employee employee)
	{
		return empRepo.save(employee);
	}
	
	@DeleteMapping("/employee/{id}")
	@ResponseBody
	public String delete(@PathVariable Integer id) {
		 empRepo.deleteById(id);
		 return "employee deleted";
	}

}
