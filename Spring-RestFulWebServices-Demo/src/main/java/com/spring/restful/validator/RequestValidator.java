package com.spring.restful.validator;

import com.spring.restful.model.Followers;
import com.spring.restful.model.User;

/**
 * 
 * @author raviranjan
 *
 */
public interface RequestValidator {

	public static boolean isValidRequest(String request) {

		boolean bIsValid = false;

		if(null != request && request.length() > 0 ) {
			bIsValid = true;
		}
		return bIsValid;
	}

	public static boolean isValidRequest(Object request) {

		boolean bIsValid = false;
		if(request instanceof User) {

			bIsValid = isValidRequest(((User) request).getEmail());
		}
		if(request instanceof Followers) {

			bIsValid = isValidRequest(((Followers) request).getUserEmail());
		}
		return bIsValid;
	}
}
