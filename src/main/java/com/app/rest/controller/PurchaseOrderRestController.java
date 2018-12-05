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

import com.app.model.PurchaseOrder;
import com.app.model.ShipmentType;
import com.app.service.IPurchaseOrderService;

@RestController
@RequestMapping("/rest/pro")
public class PurchaseOrderRestController {

	@Autowired
	private IPurchaseOrderService service;
	
	
	@PostMapping("/save")
	public ResponseEntity<String> saveUser(@RequestBody PurchaseOrder po) {

		ResponseEntity<String> message = null;
		try {
			service.savePurchaseOrder(po);
			message = new ResponseEntity<String>("WhUserType saved Successfully", HttpStatus.OK);
		} catch (Exception e) {
			message = new ResponseEntity<String>("WhuserType is not saved", HttpStatus.BAD_REQUEST);
		}
		return message;
	}

	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody PurchaseOrder po) {
		ResponseEntity<String> message = null;
		try {
			service.updatePurchaseOrder(po);
			message = new ResponseEntity<String>("WhUserType Updated", HttpStatus.OK);
		} catch (Exception e) {
			message = new ResponseEntity<String>("Not Updated", HttpStatus.BAD_REQUEST);
		}
		return message;
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAll() {
		ResponseEntity<?> message = null;
		List<PurchaseOrder> pro = service.getAllPurchaseOrder();
		if (pro == null || pro.isEmpty()) {
			message = new ResponseEntity<>("No Data Found...", HttpStatus.NO_CONTENT);
		} else {
			message = new ResponseEntity<List<PurchaseOrder>>(pro, HttpStatus.OK);
		}
		return message;
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<?> getOne(@PathVariable Integer id) {
		ResponseEntity<?> message = null;
		PurchaseOrder pro = service.getOnePurchaseOrder(id);
		if (pro == null) {
			message = new ResponseEntity<>("No Data Found", HttpStatus.NO_CONTENT);
		} else {
			message = new ResponseEntity<PurchaseOrder>(pro, HttpStatus.OK);
		}
		return message;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		ResponseEntity<String> message = null;
		try {
			service.deletePurchaseOrder(id);
			message = new ResponseEntity<String>("Data Deleted", HttpStatus.OK);

		} catch (Exception e) {
			message = new ResponseEntity<String>("Data Not Found", HttpStatus.BAD_REQUEST);
		}
		return message;
	}
}
