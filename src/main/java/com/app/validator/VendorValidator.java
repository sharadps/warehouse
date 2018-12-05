package com.app.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Vendor;

@Component
public class VendorValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Vendor.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Vendor vendor = (Vendor) target;
		if ("".equals(vendor.getVenName())) {
			errors.rejectValue("venName", null, "*");
		}
		if ("".equals(vendor.getVenCode())) {
			errors.rejectValue("venCode", null, "*");
		}
		if(vendor.getVenDesg()==null|"".equals(vendor.getVenDesg())) {
			errors.rejectValue("venDesg", null, "*");
		}
	}

}
