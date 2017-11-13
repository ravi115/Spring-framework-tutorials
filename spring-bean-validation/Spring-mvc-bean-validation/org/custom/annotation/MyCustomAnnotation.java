package org.custom.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
/**
 * This java files shows how to create a annotation in java.
 * 
 * Rules ; -
 * 	1. we must have @interface keyword to create annotation.
 *  2. use @constraints annotation to tell which custom validation class we will be using to verify that 
 *     this annotation has been used properly.
 *  3. @Target annotation tells for which properties of a class this annotation is applicable.
 *  4. @Retention annotation tells when this annotation will be used by JVM {runtime or compile time}.
 *   
 * @author raviranjan
 *
 */
@Constraint(validatedBy = MyCustomeAnnotationValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyCustomAnnotation {

	//define default MyCustomAnnotation code
	public String value() default "JAVA";
	
	//define default error message
	public String message() default "must start with JAVA";
	
	//define default groups
	public Class<?>[] groups() default {};
	
	//default default payloads
	public Class<? extends Payload>[] payload() default {};
}
