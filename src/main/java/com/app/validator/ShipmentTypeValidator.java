package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.ShipmentType;

@Component
public class ShipmentTypeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ShipmentType.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ShipmentType sty = (ShipmentType) target;
		if ("".equals(sty.getShipMode())) {
			errors.rejectValue("shipMode", null, "*");
		}
		if (!Pattern.compile("[A-Z]{3,7}").matcher(sty.getShipCode().trim()).matches()) {
			errors.rejectValue("shipCode", null, "Enter valid code [3 to 7 uppercase letters]");
		}
		if (sty.getShipEnabled() == null || sty.getShipEnabled().isEmpty()) {
			errors.rejectValue("shipEnabled", null, "Select this option");
		}
		if (sty.getShipGrade() == null || "".equals(sty.getShipGrade())) {
			errors.rejectValue("shipGrade", null, "plz choose atleast one");
		}
		if (!Pattern.compile("[A-Za-z\\s]{4,200}").matcher(sty.getShipDsc()).matches()) {
			errors.rejectValue("shipDsc", null, "Enter Description(Min 4 letters max 200 letters)");
		}
	}

}
