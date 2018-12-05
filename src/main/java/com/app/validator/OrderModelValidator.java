package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.OrderModel;
import com.app.service.IOrderModelService;

@Component
public class OrderModelValidator implements Validator {

	@Autowired
	private IOrderModelService service;

	@Override
	public boolean supports(Class<?> clazz) {
		return OrderModel.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		OrderModel omg = (OrderModel) target;
		if (omg.getOmModel() == null || "".equals(omg.getOmModel())) {
			errors.rejectValue("omModel", null, "*");
		}
		if (!Pattern.compile("[A-Z]{3,7}").matcher(omg.getOmCode().trim()).matches()) {
			errors.rejectValue("omCode", null, "Enter valid code[3 to 7 uppercase letters only]");
		} else if (service.isOrderCodeExist(omg.getOmCode())) {
			errors.rejectValue("omCode", null,
					"Order Code '" + omg.getOmCode() + "' Already Exist,Please choose Another");
		}
		if ("".equals(omg.getOmMethod())) {
			errors.rejectValue("omMethod", null, "*");
		}
		if (omg.getOmAcceptt() == null || omg.getOmAcceptt().isEmpty()) {
			errors.rejectValue("omAcceptt", null, "Choose atleast one option");
		}
		if (!Pattern.compile("^[A-Za-z\\s]{4,200}$").matcher(omg.getOmDsc()).matches()) {
			errors.rejectValue("omDsc", null, "Enter Description(min 4 max 200 letters)");
		}
	}

}
