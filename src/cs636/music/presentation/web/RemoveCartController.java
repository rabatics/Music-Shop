package cs636.music.presentation.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cs636.music.domain.Cart;
import cs636.music.domain.LineItem;
import cs636.music.domain.Product;
import cs636.music.service.ServiceException;
import cs636.music.service.UserServiceAPI;

public class RemoveCartController implements Controller{

String view;
UserServiceAPI UserService;

public RemoveCartController(UserServiceAPI userService, String view){
	
	System.out.println("In Remove Cart page controller");
	this.view=view;
	this.UserService=userService;
}

@Override
public String handleRequest(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
	
	System.out.println("In Remove Cart Controller");
	String rem=request.getParameter("remove");
	HttpSession session=request.getSession();
	Cart c=(Cart)session.getAttribute("cart");

	Product p=new Product();
	try {
		p = UserService.getProduct(rem);
	} catch (ServiceException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
Cart c1=UserService.removeCartItem(p, c);
session.setAttribute("cart", c1);
	
	

	
	return view;
}
}
