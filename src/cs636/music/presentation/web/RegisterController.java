package cs636.music.presentation.web;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cs636.music.domain.Product;
import cs636.music.domain.Track;
import cs636.music.domain.User;
import cs636.music.service.ServiceException;
import cs636.music.service.UserServiceAPI;

public class RegisterController implements Controller{

String view;
UserServiceAPI UserService;

public RegisterController(UserServiceAPI userService, String view){
	
	System.out.println("In Register page controller");
	this.view=view;
	this.UserService=userService;
}

@Override
public String handleRequest(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
	
	System.out.println("In Register Controller");
	
	HttpSession session=request.getSession();
	
	if(session.getAttribute("user")==null){
		String email=request.getParameter("email");
		String fn=request.getParameter("firstName");
		String ln=request.getParameter("lastName");
		User u=new User();
		u.setFirstname(fn);
		u.setLastname(ln);
		u.setEmailAddress(email);
		try {
			
			u=UserService.registerUser(fn, ln, email);
			
			session.setAttribute("user", u);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	
	
	
		
		
	
		
	
	
	return view;
}
}
