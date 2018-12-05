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

import com.app.model.Item;
import com.app.model.PurchaseOrder;
import com.app.service.IItemService;

@RestController
@RequestMapping("/rest/item")
public class ItemRestController {

	@Autowired
	private IItemService service;

	
	@PostMapping("/save")
	public ResponseEntity<String> saveUser(@RequestBody Item item) {

		ResponseEntity<String> message = null;
		try {
			service.saveItem(item);
			message = new ResponseEntity<String>("WhUserType saved Successfully", HttpStatus.OK);
		} catch (Exception e) {
			message = new ResponseEntity<String>("WhuserType is not saved", HttpStatus.BAD_REQUEST);
		}
		return message;
	}

	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Item item) {
		ResponseEntity<String> message = null;
		try {
			service.updateItem(item);
			message = new ResponseEntity<String>("WhUserType Updated", HttpStatus.OK);
		} catch (Exception e) {
			message = new ResponseEntity<String>("Not Updated", HttpStatus.BAD_REQUEST);
		}
		return message;
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAll() {
		ResponseEntity<?> message = null;
		List<Item> item = service.getAllItem();
		if (item == null || item.isEmpty()) {
			message = new ResponseEntity<>("No Data Found...", HttpStatus.NO_CONTENT);
		} else {
			message = new ResponseEntity<List<Item>>(item, HttpStatus.OK);
		}
		return message;
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<?> getOne(@PathVariable Integer id) {
		ResponseEntity<?> message = null;
		Item item = service.getOneItem(id);
		if (item == null) {
			message = new ResponseEntity<>("No Data Found", HttpStatus.NO_CONTENT);
		} else {
			message = new ResponseEntity<Item>(item, HttpStatus.OK);
		}
		return message;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		ResponseEntity<String> message = null;
		try {
			service.deleteItem(id);
			message = new ResponseEntity<String>("Data Deleted", HttpStatus.OK);

		} catch (Exception e) {
			message = new ResponseEntity<String>("Data Not Found", HttpStatus.BAD_REQUEST);
		}
		return message;
	}
}
