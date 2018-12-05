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

import com.app.model.Item;
import com.app.model.OrderModel;
import com.app.model.Uom;
import com.app.model.WhUserType;
import com.app.service.IItemService;
import com.app.service.IOrderModelService;
import com.app.service.IUomService;
import com.app.service.IWhUserTypeService;
import com.app.validator.ItemValidator;
import com.app.view.ItemExcelView;
import com.app.view.ItemPdfView;

@Controller
@RequestMapping("/item")
public class ItemController {
	@Autowired
	private IItemService service;

	@Autowired
	private IUomService uomService;

	@Autowired
	private IOrderModelService omService;

	@Autowired
	private IWhUserTypeService whUserTypeService;

	@Autowired
	private ItemValidator validator;

	@RequestMapping("/reg")
	public String showItem(ModelMap map) {
		map.addAttribute("item", new Item());

		// UOM Model
		List<Uom> uoms = uomService.getAllUom();
		map.addAttribute("uoms", uoms);

		// Order Model
		List<OrderModel> sales = omService.getOrderMethodByMode("sale");
		map.addAttribute("sales", sales);
		List<OrderModel> purchase = omService.getOrderMethodByMode("purchase");
		map.addAttribute("purchase", purchase);

		// WhUserType Model
		List<WhUserType> vendors = whUserTypeService.getWhUserTypeByType("vendor");
		map.addAttribute("vendors", vendors);
		List<WhUserType> customers = whUserTypeService.getWhUserTypeByType("customer");
		map.addAttribute("customers", customers);

		return "ItemRegister";

	}

	@RequestMapping(value = "/insert")
	public String saveItem(@ModelAttribute("item") Item item, Errors errors, ModelMap map) {
		validator.validate(item, errors);
		if (!errors.hasErrors()) {
			Integer id = service.saveItem(item);
			String msg = "Item '" + id + "' Saved Successfully...";
			map.addAttribute("message", msg);
			// UOM Model
			List<Uom> uoms = uomService.getAllUom();
			map.addAttribute("uoms", uoms);

			// Order Model
			List<OrderModel> sales = omService.getOrderMethodByMode("sale");
			map.addAttribute("sales", sales);
			List<OrderModel> purchase = omService.getOrderMethodByMode("purchase");
			map.addAttribute("purchase", purchase);

			// WhUserType Model
			List<WhUserType> vendors = whUserTypeService.getWhUserTypeByType("vendor");
			map.addAttribute("vendors", vendors);
			List<WhUserType> customers = whUserTypeService.getWhUserTypeByType("customer");
			map.addAttribute("customers", customers);

			// clear form data after submitting the data
			map.addAttribute("item", new Item());
		}
		return "ItemRegister";
	}

	@RequestMapping("/all")
	public String getItem(ModelMap map) {
		List<Item> list = service.getAllItem();
		map.addAttribute("list", list);
		return "ItemData";
	}

	@RequestMapping("/delete")
	public String deleteItem(@RequestParam("id") Integer iId, ModelMap map) {
		service.deleteItem(iId);
		String msg = "Item '" + iId + "' Deleted Successfully...";
		List<Item> list = service.getAllItem();
		map.addAttribute("message", msg);
		map.addAttribute("list", list);
		return "ItemData";
	}

	@RequestMapping("/edit")
	public String editData(@RequestParam("id") Integer iId, ModelMap map) {
		Item item = service.getOneItem(iId);
		map.addAttribute("item", item);
		List<Uom> uoms = uomService.getAllUom();
		map.addAttribute("uoms", uoms);

		List<OrderModel> sales = omService.getOrderMethodByMode("sale");
		map.addAttribute("sales", sales);

		List<OrderModel> purchase = omService.getOrderMethodByMode("purchase");
		map.addAttribute("purchase", purchase);

		// WhUserType Model
		List<WhUserType> vendors = whUserTypeService.getWhUserTypeByType("vendor");
		map.addAttribute("vendors", vendors);
		List<WhUserType> customers = whUserTypeService.getWhUserTypeByType("customer");
		map.addAttribute("customers", customers);
		return "ItemEdit";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateItem(@ModelAttribute Item item, ModelMap map) {
		service.updateItem(item);
		String msg = "Item '" + item.getiId() + "' Updated Successfully...";
		List<Item> list = service.getAllItem();
		map.addAttribute("message", msg);
		map.addAttribute("list", list);
		return "ItemData";
	}

	@RequestMapping("/excel")
	public ModelAndView showExcel() {
		List<Item> item = service.getAllItem();
		ModelAndView m = new ModelAndView();
		m.setView(new ItemExcelView());
		m.addObject("item", item);
		return m;
	}

	@RequestMapping("/pdf")
	public ModelAndView ItemPdf() {
		List<Item> item = service.getAllItem();
		ModelAndView m = new ModelAndView();
		m.setView(new ItemPdfView());
		m.addObject("item", item);
		return m;

	}
}
