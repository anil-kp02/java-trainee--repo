package com.employeeValidation.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateEmployee {
	
	
	// validate phone number
	public String validatePhoneNo(String phoneNo) {
		
		//if the number have +91 in the start or beginning
		if(phoneNo.trim().length()==13) {
			Pattern pattern = Pattern.compile("^([+]91)?([0-9]{10})([+]91)?$"); 
			Matcher matcher = pattern.matcher(phoneNo);
			if(matcher.find()) {
				String validateNo;
				if( matcher.group(1)== null) {
				    validateNo=matcher.replaceAll("+91$2");
					return validateNo;
				}else {
					validateNo=matcher.group();
					return validateNo;
							
				}
			}
			
			
		}
		else if(phoneNo.trim().length()==10) {
			Pattern pattern = Pattern.compile("^[91]?[0-9]{10}[91]?$");
			Matcher matcher = pattern.matcher(phoneNo);
			if(matcher.find()) {
				String validateNo="+91"+matcher.group();
				return validateNo;
			}
		}
		return null;
	}
	
	//validate name
	public boolean validateName(String name) {
		Pattern pattern = Pattern.compile("^[a-zA-z. ]{1,}$"); 
		Matcher matcher = pattern.matcher(name);
		if(matcher.find()) {
			return true;
		}
		
		return false;
	}
	
	//validate Email 
	public boolean validateEmail(String email) {
		Pattern pattern = Pattern.compile("^[a-zA-z0-9_+*$&!]+?@[a-zA-z]+[.]{1}[a-zA-z]{1,}$"); 
		Matcher matcher = pattern.matcher(email);
		if(matcher.find()) {
			return true;
		}
		
		return false;
	}
	
	
}
