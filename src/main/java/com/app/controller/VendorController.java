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

import com.app.model.Vendor;
import com.app.service.IVendorService;
import com.app.validator.VendorValidator;
import com.app.view.VendorExcelView;
import com.app.view.VendorPdfView;

@Controller
@RequestMapping("/vendor")
public class VendorController {
	@Autowired
	private IVendorService service;

	@Autowired
	private VendorValidator validator;

	@RequestMapping("/reg")
	public String showVendor(ModelMap map) {
		map.addAttribute("vendor", new Vendor());
		return "VendorRegister";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String saveVendor(@ModelAttribute("vendor") Vendor vendor, Errors errors, ModelMap map) {
		validator.validate(vendor, errors);
		if (!errors.hasErrors()) {
			Integer id = service.saveVendor(vendor);
			String msg = "Vendor '" + id + "' Saved Successfully...";
			map.addAttribute("message", msg);
			// Clear the form
			map.addAttribute("vendor", new Vendor());
		}
		return "VendorRegister";
	}

	@RequestMapping("/all")
	public String getVendor(ModelMap map) {
		List<Vendor> list = service.getAllVendor();
		map.addAttribute("list", list);
		return "VendorData";
	}

	@RequestMapping("/delete")
	public String deleteVendor(@RequestParam("id") Integer venId, ModelMap map) {
		service.deleteVendor(venId);
		String msg = "Vendor '" + venId + "' Deleted Successfully...";
		List<Vendor> vendor = service.getAllVendor();
		map.addAttribute("list", vendor);
		map.addAttribute("message", msg);
		return "VendorData";
	}

	@RequestMapping("/edit")
	public String editVendor(@RequestParam("id") Integer venId, ModelMap map) {
		Vendor vendor = service.getOneVendor(venId);
		map.addAttribute("vendor", vendor);
		return "VendorEdit";
	}

	@RequestMapping("/update")
	public String updateVendor(@ModelAttribute Vendor vendor, ModelMap map) {
		service.updateVender(vendor);
		String msg = "Vendor '" + vendor.getVenId() + "' Updated Successfully...";
		List<Vendor> list = service.getAllVendor();
		map.addAttribute("message", msg);
		map.addAttribute("list", list);
		return "VendorData";
	}

	// Excel Generation
	@RequestMapping("/excel")
	public ModelAndView showVendorExcel() {
		List<Vendor> list = service.getAllVendor();
		ModelAndView sp = new ModelAndView();
		sp.setView(new VendorExcelView());
		sp.addObject("vendor", list);
		return sp;
	}

	// Pdf Generation
	@RequestMapping("/pdf")
	public ModelAndView showVendorPdf() {
		List<Vendor> list = service.getAllVendor();
		ModelAndView sp = new ModelAndView();
		sp.setView(new VendorPdfView());
		sp.addObject("vendor", list);
		return sp;
	}
}
