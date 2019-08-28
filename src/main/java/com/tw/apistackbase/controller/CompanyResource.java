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

@RestController
@RequestMapping("/employees")
public class CompanyResource {

	public CompanyResource() {
		// TODO Auto-generated constructor stub
	}
		List<Employee> employees=new ArrayList<Employee>();
		List<Company> companies=new ArrayList<Company>();
		@GetMapping(path="/")
	  public ResponseEntity<List<Company>> getMapping(){
			companies.add(new Company(1,"xiexinfang",18,"Ů",50000));
			companies.add(new Company(2,"liuziwei",20,"Ů",80000));
		return ResponseEntity.ok(companies);
		}
		@PostMapping(path="/")
		@ResponseStatus(HttpStatus.CREATED)
		public Company createCompany(@RequestBody Company company) {
			companies.add(company);
			return company;
		}
		@RequestMapping
		public ResponseEntity<Company> getOneCompany(@PathVariable int id){
			
			for(Company company:companies) {
				if(company.getCompanyId()==id) {
				
					return ResponseEntity.ok(company);
				}
			}
			return new ResponseEntity(HttpStatus.NOT_FOUND);
			//return ResponEntity.notFound().build;
			
		}
		@PutMapping(path="/")
		@ResponseStatus(HttpStatus.ACCEPTED)
		public ResponseEntity<Company> updateCompany(@RequestBody Company company,@PathVariable int id){
			for(Company company1:employees) {
				if(company1.getCompanyId()==id) {
					company1.setEmployeesNumber(company.getEmployeesNumber());
					company1.setCompanyName(company.getCompanyName());
					company1.setCompanyId(company.getCompanyId());
					company1.setEmployees(company.getEmployees());
					return ResponseEntity.ok(company);
				}
			}
			return new ResponseEntity(HttpStatus.NOT_FOUND);
			//return ResponEntity.notFound().build;
			}
		@DeleteMapping(path="/")
		@ResponseStatus(HttpStatus.ACCEPTED)
		public void deleteCompany(@RequestBody int id){
			for(Company company1:companies) {
				if(company1.getCompanyId()==id) {
				   companies.remove(id);
				}
			}
			}
	}

