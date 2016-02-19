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

public class ViewCartController implements Controller{

String view;
UserServiceAPI UserService;

public ViewCartController(UserServiceAPI userService, String view){
	
	System.out.println("In View Cart page controller");
	this.view=view;
	this.UserService=userService;
}

@Override
public String handleRequest(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
	
	System.out.println("In View Cart Controller");
	//String prodCode=request.getParameter("productCode");
	HttpSession session=request.getSession();
	

	
	Cart c=(Cart)session.getAttribute("cart");
	if(c!=null){
		
		session.setAttribute("cart", c);
	}
	else{
		Cart c1=UserService.createCart();
		
		session.setAttribute("cart", c1);
	}
	

	
	

	
	return view;
}
}
