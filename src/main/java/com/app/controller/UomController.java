package com.app.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateOptimisticLockingFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Uom;
import com.app.service.IUomService;
import com.app.validator.UomValidator;
import com.app.view.UomExcelView;
import com.app.view.UomPdfView;

@Controller
@RequestMapping("/uom")
public class UomController {

	// Create New Logger object
	private static final Logger log = Logger.getLogger(UomController.class);
	@Autowired
	private IUomService service;

	@Autowired
	private UomValidator validator;

	@RequestMapping("/reg")
	public String showUom(ModelMap map) {
		map.addAttribute("uom", new Uom());
		return "UomRegister";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String saveUom(@ModelAttribute Uom uom, Errors errors, ModelMap map) {

		log.info("Entered into save method");
		validator.validate(uom, errors);
		log.info("Validations Completed");
		if (!errors.hasErrors()) {// no errors

			log.info("NO erroes found in save operation");
			try {
				Integer id = service.saveUom(uom);
				log.info("Uom Created with id : " + id);
				String msg = "uom '" + id + "' Data Saved Successfully...";
				map.addAttribute("message", msg);

			} catch (Exception e) {
				log.error("Exception" + e.getMessage());
				map.addAttribute("message", "Problem in OPeartion");
			}
			// Clear data after submitting the data
			map.addAttribute("uom", new Uom());
		}
		log.info("About to leave insert code");
		return "UomRegister";
	}

	@RequestMapping("/all")
	public String getAllUom(ModelMap map) {
		List<Uom> list = service.getAllUom();
		map.addAttribute("list", list);
		return "UomData";
	}

	@RequestMapping("/delete")
	public String deleteUom(@RequestParam("id") Integer uomId, ModelMap map) {
		String message = null;
		try {
			if (service.isUomConnectedWithItem(uomId)) {
				message = "Uom '" + uomId + "' Can't be Deleted...";
			} else {
				service.deleteUom(uomId);
				message = "Uom '" + uomId + "' Deleted Successfully...";
			}
		} catch (HibernateOptimisticLockingFailureException e) {
			message = "Uom '" + uomId + "' Not Found";
		}
		List<Uom> uom = service.getAllUom();
		map.addAttribute("message", message);
		map.addAttribute("list", uom);
		return "UomData";
	}

	@RequestMapping("/edit")
	public String editUom(@RequestParam("id") Integer uomId, ModelMap map) {
		Uom uom = service.getOneUom(uomId);
		map.addAttribute("uom", uom);
		return "UomEdit";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateUom(@ModelAttribute Uom uom, ModelMap map) {
		service.updateUom(uom);
		String msg = "Uom '" + uom.getUomId() + "' Upadted Successfulley...";
		List<Uom> list = service.getAllUom();
		map.addAttribute("message", msg);
		map.addAttribute("list", list);
		return "UomData";
	}

	// Excel Generation
	@RequestMapping("/excel")
	public ModelAndView showExcel() {
		List<Uom> uoms = service.getAllUom();
		ModelAndView sp = new ModelAndView();
		sp.setView(new UomExcelView());
		sp.addObject("uom", uoms);

		return sp;
	}

	// pdf Generation
	@RequestMapping("/pdf")
	public ModelAndView showUomPdf() {
		List<Uom> uoms = service.getAllUom();
		ModelAndView sp = new ModelAndView();
		sp.setView(new UomPdfView());
		sp.addObject("uom", uoms);

		return sp;
	}

}
