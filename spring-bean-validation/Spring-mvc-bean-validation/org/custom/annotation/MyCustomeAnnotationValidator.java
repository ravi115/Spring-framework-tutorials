package org.custom.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * To validate our custom annotation, the validation class must implement ConstraintsValidaor java class.
 *   
 * @author raviranjan
 *
 */
public class MyCustomeAnnotationValidator implements 
							ConstraintValidator<MyCustomAnnotation, String> {

	private String customePrefix;
	
	@Override
	public void initialize(MyCustomAnnotation myCustomAnnotation ) {
		customePrefix = myCustomAnnotation.value();
	}
	
	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext arg1) {
		
		 boolean result;
		
		 if(null != theCode ) {
			 result = theCode.startsWith(customePrefix);
		 }else {
			 result= false;
		 }
		 return result;
	}

}
