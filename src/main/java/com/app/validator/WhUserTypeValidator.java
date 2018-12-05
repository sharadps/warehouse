package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;

@Component
public class WhUserTypeValidator implements Validator {

	@Autowired
	private IWhUserTypeService service;

	@Override
	public boolean supports(Class<?> clazz) {
		return WhUserType.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		WhUserType wh = (WhUserType) target;
		if (wh.getWhType() == null || "".equals(wh.getWhType())) {
			errors.rejectValue("whType", null, "Please choose one User Type");
		}
		if (!Pattern.compile("[A-Z0-9]{4,200}").matcher(wh.getWhCode()).matches()) {
			errors.rejectValue("whCode", null, "Please Enter Valid User code");
		}else if (service.isWhUserTypeExist(wh.getWhCode())) {
			errors.rejectValue("whCode", null, "WhUserType '"+wh.getWhCode()+"' Already Exist,Please Choose Another");
			
		}
		/*
		 * if ("".equals(wh.getWhForType().trim())) { errors.rejectValue("whForType",
		 * null, "*"); }
		 */
		if (!Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}").matcher(wh.getWhEmail()).matches()) {
			errors.rejectValue("whEmail", null, "Please Enter Valid Email");
		}
		if (!Pattern.compile("((\\+){1}91){1}[1-9]{1}[0-9]{9}").matcher(wh.getWhContact()).matches()) {
			errors.rejectValue("whContact", null, "Please Enter Valid Contact");
		}
		if ("".equals(wh.getWhIdType().trim())) {
			errors.rejectValue("whIdType", null, "Please choose one User Id Type");
		} else if ("OTHER".equals(wh.getWhIdType()) && "".equals(wh.getWhIfOther())) {
			errors.rejectValue("whIfOther", null, "Please Enter Other Type");
		}

		if ("".equals(wh.getWhIdNumber().trim())) {
			errors.rejectValue("whIdNumber", null, "Please Enter User Id");
		}

	}

}
