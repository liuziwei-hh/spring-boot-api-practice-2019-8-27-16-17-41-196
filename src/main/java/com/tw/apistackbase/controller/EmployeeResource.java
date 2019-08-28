package com.tw.apistackbase.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

public class EmployeeResource {

	public EmployeeResource() {
		// TODO Auto-generated constructor stub
	}
	@RestController
	@RequestMapping("/employees")
	public class EmployeeRescource {
		List<Employee> employees=new ArrayList<Employee>();
		@GetMapping(path="/")
	  public ResponseEntity<List<Employee>> getMapping(){
		  List<Employee> employees=new ArrayList<Employee>();
		  employees.add(new Employee(1,"xiexinfang",18,"Ů",50000));
		  employees.add(new Employee(2,"liuziwei",20,"Ů",80000));
		return ResponseEntity.ok(employees);
		}
		@PostMapping(path="/")
		@ResponseStatus(HttpStatus.CREATED)
		public Employee createEmployee(@RequestBody Employee employee) {
			employees.add(employee);
			return employee;
		}
		@RequestMapping
		public ResponseEntity<Employee> getOneEmployee(@PathVariable int id){
			
			for(Employee employee:employees) {
				if(employee.getId()==id) {
				
					return ResponseEntity.ok(employee);
				}
			}
			return new ResponseEntity(HttpStatus.NOT_FOUND);
			//return ResponEntity.notFound().build;
			
		}
		@PutMapping(path="/")
		@ResponseStatus(HttpStatus.ACCEPTED)
		public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee,@PathVariable int id){
			for(Employee employee1:employees) {
				if(employee1.getId()==id) {
				   employee1.setAge(employee.getAge());
				   employee1.setName(employee.getName());
				   employee1.setId(employee.getId());
					return ResponseEntity.ok(employee);
				}
			}
			return new ResponseEntity(HttpStatus.NOT_FOUND);
			//return ResponEntity.notFound().build;
			}
		@DeleteMapping(path="/")
		@ResponseStatus(HttpStatus.ACCEPTED)
		public void deleteEmployee(@RequestBody int id){
			for(Employee employee1:employees) {
				if(employee1.getId()==id) {
				   employees.remove(id);
				}
			}
			}
	}
}
