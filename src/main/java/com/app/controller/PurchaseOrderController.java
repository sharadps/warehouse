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

import com.app.model.PurchaseOrder;
import com.app.model.ShipmentType;
import com.app.model.WhUserType;
import com.app.service.IPurchaseOrderService;
import com.app.service.IShipmentTypeService;
import com.app.service.IWhUserTypeService;
import com.app.validator.PurchaseOrderValidator;

@Controller
@RequestMapping("/pro")
public class PurchaseOrderController {
	@Autowired
	private IPurchaseOrderService service;

	@Autowired
	private IShipmentTypeService shipmenttypeService;
	@Autowired
	private IWhUserTypeService whuserService;
	@Autowired
	private PurchaseOrderValidator validator;

	@RequestMapping("/reg")
	public String showPurchaseOrder(ModelMap map) {
		map.addAttribute("po", new PurchaseOrder());

		// ShipmentType
		List<ShipmentType> shipcode = shipmenttypeService.getAllShipmentTypeByCode("Yes");
		map.addAttribute("shipcode", shipcode);

		// WhUserType
		List<WhUserType> vendorr = whuserService.getWhUserTypeByType("vendor");
		map.addAttribute("vendorr", vendorr);

		return "PurchaseOrderRegi";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String savePurchaseOrder(@ModelAttribute("po") PurchaseOrder po, Errors errors, ModelMap map) {
		validator.validate(po, errors);
		if (!errors.hasErrors()) {

			Integer id = service.savePurchaseOrder(po);
			String msg = "PurchaseOrder '" + id + "' Saved Successfully...";
			map.addAttribute("message", msg);
			// Clear form after submitting the data
			map.addAttribute("po", new PurchaseOrder());

			// ShipmentType
			List<ShipmentType> shipcode = shipmenttypeService.getAllShipmentTypeByCode("Yes");
			map.addAttribute("shipcode", shipcode);

			// WhUserType
			List<WhUserType> vendorr = whuserService.getWhUserTypeByType("vendor");
			map.addAttribute("vendorr", vendorr);

		}
		return "PurchaseOrderRegi";
	}

	@RequestMapping("/all")
	public String getAllPurchaseOrder(ModelMap map) {
		List<PurchaseOrder> list = service.getAllPurchaseOrder();
		map.addAttribute("list", list);
		return "PurchaseOrderData";
	}

	@RequestMapping("/delete")
	public String deletePurchaseOrder(@RequestParam("id") Integer id, ModelMap map) {
		service.deletePurchaseOrder(id);
		String msg = "PurchaseOrder '" + id + "' Deleted";
		List<PurchaseOrder> list = service.getAllPurchaseOrder();
		map.addAttribute("list", list);
		map.addAttribute("message", msg);
		return "PurchaseOrderData";
	}

	@RequestMapping("/edit")
	public String editPurchaseOrder(@RequestParam("id") Integer id, ModelMap map) {
		PurchaseOrder po = service.getOnePurchaseOrder(id);
		map.addAttribute("po", po);

		// ShipmentType
		List<ShipmentType> shipcode = shipmenttypeService.getAllShipmentTypeByCode("shipEnabled");
		map.addAttribute("shipcode", shipcode);

		// WhUserType
		List<WhUserType> vendorr = whuserService.getWhUserTypeByType("vendor");
		map.addAttribute("vendorr", vendorr);

		return "PurchaseOrderEdit";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updatePurchaseOrderData(@ModelAttribute("po") PurchaseOrder po, ModelMap map) {
		service.updatePurchaseOrder(po);
		String msg = "PurchaseOrder '" + po.getPurchaseId() + "' Updated successfully...";
		List<PurchaseOrder> list = service.getAllPurchaseOrder();
		map.addAttribute("list", list);
		map.addAttribute("message", msg);
		return "PurchaseOrderData";
	}

}
