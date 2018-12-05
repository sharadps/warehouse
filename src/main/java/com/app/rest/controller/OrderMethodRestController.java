package com.app.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.app.model.OrderModel;
import com.app.model.ShipmentType;
import com.app.service.IOrderModelService;

@RestController
@RequestMapping("/rest/om")
public class OrderMethodRestController {

	@Autowired
	private IOrderModelService service;


	@PostMapping("/save")
	public ResponseEntity<String> saveUser(@RequestBody OrderModel om) {

		ResponseEntity<String> message = null;
		try {
			service.saveOrderModel(om);
			message = new ResponseEntity<String>("WhUserType saved Successfully", HttpStatus.OK);
		} catch (Exception e) {
			message = new ResponseEntity<String>("WhuserType is not saved", HttpStatus.BAD_REQUEST);
		}
		return message;
	}

	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody OrderModel om) {
		ResponseEntity<String> message = null;
		try {
			service.updateOrderModel(om);
			message = new ResponseEntity<String>("WhUserType Updated", HttpStatus.OK);
		} catch (Exception e) {
			message = new ResponseEntity<String>("Not Updated", HttpStatus.BAD_REQUEST);
		}
		return message;
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAll() {
		ResponseEntity<?> message = null;
		List<OrderModel> om = service.getAllOrderModel();
		if (om == null || om.isEmpty()) {
			message = new ResponseEntity<>("No Data Found", HttpStatus.NO_CONTENT);
		} else {
			message = new ResponseEntity<List<OrderModel>>(HttpStatus.OK);
		}
		return message;
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<?> getOne(@PathVariable Integer id) {
		ResponseEntity<?> message = null;
		OrderModel om = service.getOneOrderModel(id);
		if (om == null) {
			message = new ResponseEntity<>("Data Not Found", HttpStatus.NO_CONTENT);
		} else {
			message = new ResponseEntity<OrderModel>(HttpStatus.OK);
		}
		return message;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		ResponseEntity<String> message = null;
		try {
			service.deleteOrderModel(id);
			message = new ResponseEntity<String>("Uom Data Deleted Successfully...", HttpStatus.OK);

		} catch (Exception e) {
			message = new ResponseEntity<String>("Uom Data Not Found", HttpStatus.NO_CONTENT);
		}

		return message;
	}
}
