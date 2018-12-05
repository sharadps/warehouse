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

import com.app.model.Uom;
import com.app.model.WhUserType;
import com.app.service.IUomService;

@RestController
@RequestMapping("/rest/uom")
public class UomRestController {

	@Autowired
	public IUomService service;

	@PostMapping("/save")
	public ResponseEntity<String> saveUser(@RequestBody Uom uom) {

		ResponseEntity<String> message = null;
		try {
			service.saveUom(uom);
			message = new ResponseEntity<String>("Uom saved Successfully", HttpStatus.OK);
		} catch (Exception e) {
			message = new ResponseEntity<String>("Uom is not saved", HttpStatus.BAD_REQUEST);
		}
		return message;
	}

	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Uom uom) {
		ResponseEntity<String> message = null;
		try {
			service.updateUom(uom);
			message = new ResponseEntity<String>("Uom Updated", HttpStatus.OK);
		} catch (Exception e) {
			message = new ResponseEntity<String>("Uom Not Updated", HttpStatus.BAD_REQUEST);
		}
		return message;
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAll() {
		ResponseEntity<?> message = null;
		List<Uom> uoms = service.getAllUom();
		if (uoms == null || uoms.isEmpty()) {
			message = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			message = new ResponseEntity<List<Uom>>(uoms, HttpStatus.OK);
		}

		return message;
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<?> getOne(@PathVariable Integer id) {
		ResponseEntity<?> message = null;

		Uom uoms = service.getOneUom(id);
		if (uoms == null) {
			message = new ResponseEntity<>("No Data Found", HttpStatus.NO_CONTENT);
		} else {
			message = new ResponseEntity<Uom>(HttpStatus.OK);
		}
		return message;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		ResponseEntity<String> message = null;
		try {
			service.deleteUom(id);
			message = new ResponseEntity<String>("Uom Data Deleted Successfully...", HttpStatus.OK);

		} catch (Exception e) {
			message = new ResponseEntity<String>("Uom Not Found", HttpStatus.NO_CONTENT);
		}

		return message;
	}
}
