package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Uom;
import com.app.service.IUomService;

@Component
public class UomValidator implements Validator {

	@Autowired
	private IUomService service;

	@Override
	public boolean supports(Class<?> clazz) {
		return Uom.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Uom uom = (Uom) target;
		if ("".equals(uom.getUomType())) {
			errors.rejectValue("uomType", null, "*");
		}
		if (!Pattern.compile("[A-Z]{4,8}").matcher(uom.getUomModel().trim()).matches()) {
			errors.rejectValue("uomModel", null, "Enter Valid Model(4 to 8 uppercase letters only)");
		}else if (service.isUomModelExist(uom.getUomModel())) {
			errors.rejectValue("uomModel", null, "Uom '"+uom.getUomModel()+"'Model Already Exist,Please Choose Other");
			
		}
		if (!Pattern.compile("[A-Za-z0-9\\s]{5,200}").matcher(uom.getUomDsc()).matches()) {
			errors.rejectValue("uomDsc", null, "Enter Description(Min 5 letters max 200 letters)");
		}
	}

}
