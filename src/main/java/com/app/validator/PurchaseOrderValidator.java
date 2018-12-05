package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.PurchaseOrder;

@Component
public class PurchaseOrderValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return PurchaseOrder.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		PurchaseOrder pom = (PurchaseOrder) target;

		if (!Pattern.compile("[A-Z0-9]{4,8}").matcher(pom.getPurchaseCode()).matches()) {
			errors.rejectValue("purchaseCode", null, "Enter 4 to 8 Uppercase Letters Only");
		}
		if ("".equals(pom.getPurchaseshipCode().getShipCode()) || pom.getPurchaseshipCode().getShipCode() == null) {
			errors.rejectValue("purchaseshipCode.shipId", null, "Choose AtLeast One");
		}
		/*if ("".equals(pom.getPurchaseVendor().getWhCode()) || pom.getPurchaseVendor().getWhCode() == null) {
			errors.rejectValue("purchaseVendor", null, "Choose AtLeast One");
		}*/
		if (!Pattern.compile("[A-Za-z0-9]{4,200}").matcher(pom.getPurchaseRefno()).matches()) {
			errors.rejectValue("purchaseRefno", null, "Enter 4 to 8 Uppercase Letters Only ");
		}
		if ("".equals(pom.getPurchaseQcheck()) || pom.getPurchaseQcheck() == null) {
			errors.rejectValue("purchaseQcheck", null, "Choose AtLeast One");
		}
		if (!Pattern.compile("[A-Za-z0-9]{4,200}").matcher(pom.getPurchaseDsc()).matches()) {
			errors.rejectValue("purchaseDsc", null, "Enter 4 to 8 Uppercase Letters Only ");
		}

	}
}
