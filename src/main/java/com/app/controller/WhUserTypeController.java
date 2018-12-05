package com.app.controller;

import java.util.List;

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

import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;
import com.app.validator.WhUserTypeValidator;
import com.app.view.WhUserTypeExcelView;
import com.app.view.WhUserTypePdfView;

@Controller
@RequestMapping("/whuser")
public class WhUserTypeController {

	@Autowired
	private IWhUserTypeService service;

	@Autowired
	private WhUserTypeValidator validator;

	@RequestMapping("/reg")
	public String showWhUserType(ModelMap map) {
		map.addAttribute("whtyuser", new WhUserType());
		return "WhUserTypeRegi";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String saveWhUserType(@ModelAttribute("whtyuser") WhUserType whusertype, Errors errors, ModelMap map) {
		validator.validate(whusertype, errors);
		if (!errors.hasErrors()) {
			Integer id = service.saveWhUserType(whusertype);
			String msg = "WhUserType '" + id + "' Saved Successfully...";
			map.addAttribute("message", msg);
			// clear form after submitting the data
			map.addAttribute("whtyuser", new WhUserType());
		}
		return "WhUserTypeRegi";
	}

	@RequestMapping("/all")
	public String getWhUserType(ModelMap map) {
		List<WhUserType> list = service.getAllWhUserType();
		map.addAttribute("list", list);
		return "WhUserTypeData";
	}

	@RequestMapping("/delete")
	public String deleteWhUserType(@RequestParam("id") Integer whid, ModelMap map) {
		String message = null;

		try {
			if (service.isVendorWhUserTypeConnecteWithItem(whid)
					|| service.isCustomerWhUserTypeConnecteWithItem(whid)) {
				message = "WhUserType '" + whid + "' Can't Be Deleted";
			} else {
				service.deleteWhUserType(whid);
				message = "WhUserType '" + whid + "' Deleted";
			}

		} catch (HibernateOptimisticLockingFailureException e) {
			message = "Data Not Found";
		}
		List<WhUserType> list = service.getAllWhUserType();
		map.addAttribute("list", list);
		map.addAttribute("message", message);
		return "WhUserTypeData";
	}

	@RequestMapping("/edit")
	public String editWhUserType(@RequestParam("id") Integer whid, ModelMap map) {
		WhUserType whtyuse = service.getOneWhUserType(whid);
		map.addAttribute("whtyuser", whtyuse);
		return "WhUserTypeEdit";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateWhUserType(@ModelAttribute WhUserType whusertype, ModelMap map) {
		service.updateWhUserType(whusertype);
		String msg = "WhUserType '" + whusertype.getWhId() + "' Updated Successfully...";
		List<WhUserType> list = service.getAllWhUserType();
		map.addAttribute("message", msg);
		map.addAttribute("list", list);
		return "WhUserTypeData";

	}

	// Excel Generation
	@RequestMapping("/excel")
	public ModelAndView showWhUserTypeExcel() {
		List<WhUserType> list = service.getAllWhUserType();
		ModelAndView sp = new ModelAndView();
		sp.setView(new WhUserTypeExcelView());
		sp.addObject("whty", list);
		return sp;
	}

	// Pdf Generation
	@RequestMapping("/pdf")
	public ModelAndView showWhUserTypePdf() {
		List<WhUserType> list = service.getAllWhUserType();
		ModelAndView sp = new ModelAndView();
		sp.setView(new WhUserTypePdfView());
		sp.addObject("whty", list);
		return sp;
	}
}
