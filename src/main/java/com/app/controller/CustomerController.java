package com.app.controller;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Customer;
import com.app.service.ICustomerService;
import com.app.validator.CustomerValidator;
import com.app.view.CustomerExcelView;
import com.app.view.CustomerPdfView;

@Controller
@RequestMapping("/cust")
public class CustomerController {
	@Autowired
	private ICustomerService service;
	@Autowired
	private CustomerValidator validator;

	@RequestMapping("/reg")
	public String showCustomer(ModelMap map) {
		map.addAttribute("cust", new Customer());
		return "CustomerRegister";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("cust") Customer cust1, Errors errors, ModelMap map) {
		validator.validate(cust1, errors);
		if (!errors.hasErrors()) {// no errors
			Integer id = service.saveCustomer(cust1);
			String msg = "Customer '" + id + "' Saved Successfully...";
			map.addAttribute("message", msg);
			// Clear form
			map.addAttribute("cust", new Customer());
		}
		return "CustomerRegister";
	}

	@RequestMapping("/all")
	public String getAllCustomer(ModelMap map) {
		List<Customer> list = service.getAllCustomer();
		map.addAttribute("list", list);
		return "CustomerData";
	}

	@RequestMapping("/delete")
	public String deleteCustomer(@RequestParam("id") Integer custId, ModelMap map) {
		service.deleteCustomer(custId);
		String msg = "Customer '" + custId + "' Deleted Successfully...";
		List<Customer> list = service.getAllCustomer();
		map.addAttribute("lists", list);
		map.addAttribute("message", msg);
		return "CustomerData";
	}

	@RequestMapping("/edit")
	public String editCustomer(@RequestParam("id") Integer custId, ModelMap map) {
		Customer cust = service.getOneCustomer(custId);
		map.addAttribute("cust", cust);
		return "CustomerEdit";
	}

	@RequestMapping("/update")
	public String updateCustomer(@ModelAttribute("cust") Customer cust1, ModelMap map) {
		service.updateCustomer(cust1);
		String msg = "Customer  '" + cust1.getCustId() + "' Updated Successfully...";
		List<Customer> list = service.getAllCustomer();
		map.addAttribute("message", msg);
		map.addAttribute("list", list);
		return "CustomerData";
	}

	// Excel Generation
	@RequestMapping("/excel")
	public ModelAndView customerExcel() {
		List<Customer> cust = service.getAllCustomer();
		ModelAndView sp = new ModelAndView();
		sp.setView(new CustomerExcelView());
		sp.addObject("cust", cust);
		return sp;
	}

	// PDF Generation
	@RequestMapping("/pdf")
	public ModelAndView customerPdf() {
		List<Customer> list = service.getAllCustomer();
		ModelAndView sp = new ModelAndView();
		sp.setView(new CustomerPdfView());
		sp.addObject("cust", list);
		return sp;
	}

}
