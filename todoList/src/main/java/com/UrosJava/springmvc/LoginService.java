package com.UrosJava.springmvc;

import org.springframework.stereotype.Service;

//the way that Spring knows WHERE to search for services is defined in todo-servlet.
/*
 * <context:component-scan base-package="com.UrosJava.springmvc" />
 */

//Because of the above, it knows to search my package (com.UrosJava.springmvc) - UM

@Service
public class LoginService {

	public boolean userIsValid(String user, String pw) {
		if(user.equals("uros") && pw.equals("asdf")) {
			return true;
		} else {
			return false;
		}
	}
	
}
