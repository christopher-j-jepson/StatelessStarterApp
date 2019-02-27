package com.statelessstarterapp.core.controller;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * This is an example of the Spring MVC in action.<br/>
 * <br/>
 * <b>CRITICAL NOTE:</b><br/> 
 * The @Controller annotation is intentionally used in substitution of the @RestController, which is typically used 
 * for REST web services. This enforces code within this class to be modeled exclusively off an MVC design pattern. 
 * The importance of this separation is to insure that the frontend (MVC), 
 * which <i>could be STATEFUL is not translated into a REST web service, which should always remain STATELESS</i>.
 */
@Controller
public class MvcController {
	
	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {
 
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from MvcController.java **********</div><br><br>";
		return new ModelAndView("welcome", "message", message);
	}
	
}