package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Item;

@Component
public class ItemValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Item.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Item item = (Item) target;
		if (!Pattern.compile("[A-Z]{4,200}").matcher(item.getItemCode()).matches()) {
			errors.rejectValue("itemCode", null, "Enter Valid code(4 to 8 Uppercase only) ");
		}
		if (item.getUom() == null || item.getUom().getUomId() == null) {
			errors.rejectValue("uom", null, "Please choose one Uom");
		}
		if ("".equals(item.getiWidth()) || item.getiWidth() == null || "".equals(item.getiLength())
				|| item.getiLength() == null || "".equals(item.getiHeight()) || item.getiHeight() == null) {
			errors.rejectValue("iWidth", null, "Enter Valid dimensions");
		}

		if (item.getOmSaleType() == null || item.getOmSaleType().getOmId() == null) {
			errors.rejectValue("omSaleType", null, "Please choose one Sale Type");
		}
		if (item.getOmPurchaseType() == null || item.getOmPurchaseType().getOmId() == null) {
			errors.rejectValue("omPurchaseType", null, "Please choose one Purchase Type");
		}
		if (!Pattern.compile("[0-9]{1,200}").matcher(item.getiBaseCost()).matches()) {
			errors.rejectValue("iBaseCost", null, "Enter Valid Base Cost");
		}
		if ("".equals(item.getiCurrency())) {
			errors.rejectValue("iCurrency", null, "Please choose Currency");
		}
		if (item.getVenUsers().isEmpty() || item.getVenUsers() == null) {
			errors.rejectValue("venUsers", null, "Please choose atleast one Vendor");
		}
		if (item.getCustUsers().isEmpty() || item.getCustUsers() == null) {
			errors.rejectValue("custUsers", null, "Please choose one Customer");
		}
	}

}
