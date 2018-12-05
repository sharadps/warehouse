package com.app.rest.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Customer;
import com.app.model.ShipmentType;
import com.app.service.ICustomerService;
@RestController
@RequestMapping("/rest/customer/")
public class CustomerRestController {
	
	private ICustomerService service;
	

	@PostMapping("/save")
	public ResponseEntity<String> saveUser(@RequestBody Customer customer) {

		ResponseEntity<String> message = null;
		try {
			service.saveCustomer(customer);
			message = new ResponseEntity<String>("WhUserType saved Successfully", HttpStatus.OK);
		} catch (Exception e) {
			message = new ResponseEntity<String>("WhuserType is not saved", HttpStatus.BAD_REQUEST);
		}
		return message;
	}

	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Customer customer) {
		ResponseEntity<String> message = null;
		try {
			service.updateCustomer(customer);
			message = new ResponseEntity<String>("WhUserType Updated", HttpStatus.OK);
		} catch (Exception e) {
			message = new ResponseEntity<String>("Not Updated", HttpStatus.BAD_REQUEST);
		}
		return message;
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAll() {
		ResponseEntity<?> message = null;
		List<Customer> customer = service.getAllCustomer();
		if (customer == null || customer.isEmpty()) {
			message = new ResponseEntity<>("No Data Found...", HttpStatus.NO_CONTENT);
		} else {
			message = new ResponseEntity<List<Customer>>(customer,HttpStatus.OK);
		}
		return message;
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<?> getOne(@PathVariable Integer id) {
		ResponseEntity<?> message = null;
		Customer customer = service.getOneCustomer(id);
		if (customer == null) {
			message = new ResponseEntity<>("No Data Found", HttpStatus.NO_CONTENT);
		} else {
			message = new ResponseEntity<Customer>(customer,HttpStatus.OK);
		}
		return message;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		ResponseEntity<String> message = null;
		try {
			service.deleteCustomer(id);
			message = new ResponseEntity<String>("Data Deleted", HttpStatus.OK);

		} catch (Exception e) {
			message = new ResponseEntity<String>("Data Not Found", HttpStatus.BAD_REQUEST);
		}
		return message;
	}
}
