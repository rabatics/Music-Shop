package cs636.music.presentation.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cs636.music.domain.Cart;
import cs636.music.domain.Invoice;
import cs636.music.domain.LineItem;
import cs636.music.domain.Product;
import cs636.music.domain.User;
import cs636.music.service.ServiceException;
import cs636.music.service.UserServiceAPI;

public class LogoutController implements Controller{

String view;
UserServiceAPI UserService;

public LogoutController(UserServiceAPI userService, String view){
	
	System.out.println("In logout page controller");
	this.view=view;
	this.UserService=userService;
}

@Override
public String handleRequest(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
HttpSession session=request.getSession();
if(session.getAttribute("user")!=null){
	session.removeAttribute("user");
}
if(session.getAttribute("cart")!=null){
	session.removeAttribute("cart");
}
if(session.getAttribute("product")!=null){
	session.removeAttribute("product");
}
if(session.getAttribute("procode")!=null){
	session.removeAttribute("procode");
}
session.invalidate();

	

	
	return view;
}
}
