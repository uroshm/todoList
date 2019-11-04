package com.UrosJava.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

//URL will lead us to dispatcher servlet (this is a front controller).
//It will lead us to the login controller (handler).
//It checks our todo-servlet for a resolver, to resolve "login" which we put in URL.
//This is a view resolver.


@Controller
@SessionAttributes ("login")
public class LoginController {
	
	//auto-wiring ; important feature of Spring - UM.
	//first, we had to put @Service in LoginService to make sure Spring knows it is needed throughout app.
	@Autowired
	LoginService service;
	
	@RequestMapping(value="/Login",method=RequestMethod.GET)
	//@ResponseBody - if we want to return some text/whatever in the following method
	public String showLoginPage() { //name of method doesn't matter! the annotation above is all that does practically.
		return "Login";
	}
	
	@RequestMapping(value="/Login",method=RequestMethod.POST)
	//@ResponseBody - if we want to return some text/whatever in the following method
	public String handleLoginRequest(@RequestParam String login, ModelMap model,
			@RequestParam String pw) {
		if(service.userIsValid(login, pw)) {
			model.put("login",login);
			model.put("pw",pw);
			return "welcome";
		} else {
			model.put("errorMessage","Invalid credentials!");
			return "Login";
		}
		

	}
}










