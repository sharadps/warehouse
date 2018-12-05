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

import com.app.model.OrderModel;
import com.app.service.IOrderModelService;
import com.app.validator.OrderModelValidator;
import com.app.view.OrderModelExcelView;
import com.app.view.OrderModelPdfView;

@Controller
@RequestMapping("/ordermodel")
public class OrederModelController {

	@Autowired
	private IOrderModelService service;

	@Autowired
	private OrderModelValidator validator;

	@RequestMapping("/reg")
	public String showOrderModel(ModelMap map) {
		map.addAttribute("om", new OrderModel());
		return "OrderModelRegi";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String saveOrderModel(@ModelAttribute("om") OrderModel om, Errors errors, ModelMap map) {
		validator.validate(om, errors);
		if (!errors.hasErrors()) {
			Integer id = service.saveOrderModel(om);
			String msg = "OrderModel '" + id + "' Saved Successfully";
			map.addAttribute("message", msg);
			map.addAttribute("om", new OrderModel());
		}
		return "OrderModelRegi";
	}

	@RequestMapping("/all")
	public String getAllOrderModel(ModelMap map) {
		List<OrderModel> list = service.getAllOrderModel();
		map.addAttribute("list", list);
		return "OrderModelData";
	}

	@RequestMapping("/delete")
	public String deleteUom(@RequestParam("id") Integer Id, ModelMap map) {
		String message = null;
		try {
			if (service.isOMSaleTypeConnectedWithItem(Id) || service.isOMPurchaseTypeConnectedWithItem(Id)) {
				message = "OrderModel '" + Id + "' Can't be Deleted...";
			} else {
				service.deleteOrderModel(Id);
				message = "OrderModel '" + Id + "' Deleted ";
			}
		} catch (HibernateOptimisticLockingFailureException e) {
			message = "OrderModel '" + Id + "' Not Found";
		}
		List<OrderModel> om = service.getAllOrderModel();
		map.addAttribute("message", message);
		map.addAttribute("list", om);
		return "OrderModelData";
	}

	@RequestMapping("/edit")
	public String editUom(@RequestParam("id") Integer Id, ModelMap map) {
		OrderModel om = service.getOneOrderModel(Id);
		map.addAttribute("om", om);
		return "OrderModelEdit";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateUom(@ModelAttribute OrderModel om, ModelMap map) {
		service.updateOrderModel(om);
		String msg = "Uom '" + om.getOmId() + "' Upadted Successfulley...";
		List<OrderModel> list = service.getAllOrderModel();
		map.addAttribute("message", msg);
		map.addAttribute("list", list);
		return "OrderModelData";
	}

	// Excel Generation
	@RequestMapping("/excel")
	public ModelAndView showOrderModelExcel() {
		List<OrderModel> list = service.getAllOrderModel();
		ModelAndView sp = new ModelAndView();
		sp.setView(new OrderModelExcelView());
		sp.addObject("om", list);
		return sp;
	}

	// pdf Generation
	@RequestMapping("/pdf")
	public ModelAndView showOrderModelpdf() {
		List<OrderModel> list = service.getAllOrderModel();
		ModelAndView sp = new ModelAndView();
		sp.setView(new OrderModelPdfView());
		sp.addObject("om", list);
		return sp;
	}
}
