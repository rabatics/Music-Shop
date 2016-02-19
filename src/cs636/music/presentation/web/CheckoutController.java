package cs636.music.presentation.web;

import java.io.IOException;
import java.util.Set;

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

public class CheckoutController implements Controller{

String view;
UserServiceAPI UserService;

public CheckoutController(UserServiceAPI userService, String view){
	
	System.out.println("In Checkout page controller");
	this.view=view;
	this.UserService=userService;
}

@Override
public String handleRequest(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {

	System.out.println("In Checkout Controller");
	//String rem=request.getParameter("remove");
	HttpSession session=request.getSession();
	Cart c=(Cart)session.getAttribute("cart");
	User u=(User)session.getAttribute("user");
	

//	Product p=new Product();
	try {
		
	  Invoice i=UserService.checkout(c, u);
	 request.setAttribute("in", c.getItems());
	  
	  request.setAttribute("invoice", i);
	// session.removeAttribute("cart");
	
	} catch (ServiceException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	

	
	return view;
}
}
