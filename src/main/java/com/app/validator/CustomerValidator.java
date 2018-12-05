package com.app.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Customer;

@Component
public class CustomerValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Customer.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Customer customer = (Customer) target;
		if ("".equals(customer.getCustCode())) {
			errors.rejectValue("custCode", null, "*");
		}
		if ("".equals(customer.getCustAddress())) {
			errors.rejectValue("custAddress", null, "*");
		}
		if ("".equals(customer.getCustLocs())) {
			errors.rejectValue("custLocs", null, "*");
		}
		if ("".equals(customer.getCustEmail())) {
			errors.rejectValue("custEmail", null, "*");
		}
		if("".equals(customer.getCustContact())) {
			errors.rejectValue("custContact", null, "*");
		}
	}

}
