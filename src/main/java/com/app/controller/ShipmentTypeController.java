package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;
import com.app.validator.ShipmentTypeValidator;
import com.app.view.ShipmentTypeExcelView;
import com.app.view.ShipmentTypePdfView;

@Controller
@RequestMapping("/shipment")
public class ShipmentTypeController {

	@Autowired
	private IShipmentTypeService service;

	@Autowired
	private ShipmentTypeValidator validator;

	@RequestMapping("/reg")
	public String showOrderModel(ModelMap map) {
		map.addAttribute("shiptype", new ShipmentType());
		return "ShipmentTypeRegi";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String saveOrderModel(@ModelAttribute("shiptype") ShipmentType ship, Errors error, ModelMap map) {
		validator.validate(ship, error);
		if (!error.hasErrors()) {
			Integer id = service.saveShipmentType(ship);
			String msg = "ShipmentType '" + id + "' Saved Successfully";
			map.addAttribute("message", msg);
			map.addAttribute("shiptype", new ShipmentType());
		}
		return "ShipmentTypeRegi";
	}

	@RequestMapping("/all")
	public String getAllOrderModel(ModelMap map) {
		List<ShipmentType> list = service.getAllShipmentType();
		map.addAttribute("list", list);
		return "ShipmentTypeData";
	}

	@RequestMapping("/delete")
	public String deleteUom(@RequestParam("id") Integer Id, ModelMap map) {
		service.deleteShipmentType(Id);
		String msg = "ShipmentType '" + Id + "' Deleted Successfully...";
		List<ShipmentType> stype = service.getAllShipmentType();
		map.addAttribute("message", msg);
		map.addAttribute("list", stype);
		return "ShipmentTypeData";
	}

	@RequestMapping("/edit")
	public String editUom(@RequestParam("id") Integer Id, ModelMap map) {
		ShipmentType stype = service.getOneShipmentType(Id);
		map.addAttribute("shiptype", stype);
		return "ShipmentTypeEdit";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateUom(@ModelAttribute("shiptype") ShipmentType ship, ModelMap map) {
		service.updateShipmentType(ship);
		String msg = "ShipmentType '" + ship.getShipId() + "' Upadted Successfulley...";
		List<ShipmentType> list = service.getAllShipmentType();
		map.addAttribute("message", msg);
		map.addAttribute("list", list);
		return "ShipmentTypeData";
	}

	// Excel Generation
	@RequestMapping("/excel")
	public ModelAndView showShipmentTypeExcel() {
		List<ShipmentType> list = service.getAllShipmentType();
		ModelAndView sp = new ModelAndView();
		sp.setView(new ShipmentTypeExcelView());
		sp.addObject("stype", list);
		return sp;
	}

	@RequestMapping("/pdf")
	public ModelAndView showShipmentTypePdf() {
		List<ShipmentType> list = service.getAllShipmentType();
		ModelAndView sp = new ModelAndView();
		sp.setView(new ShipmentTypePdfView());
		sp.addObject("stype", list);
		return sp;
	}
}
