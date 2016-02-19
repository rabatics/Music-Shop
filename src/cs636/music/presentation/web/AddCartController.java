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

public class AddCartController implements Controller{

String view;
UserServiceAPI UserService;

public AddCartController(UserServiceAPI userService, String view){
	
	System.out.println("In Add Cart page controller");
	this.view=view;
	this.UserService=userService;
}

@Override
public String handleRequest(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
	
	System.out.println("In Add Cart Controller");
	//String prodCode=request.getParameter("productCode");
	HttpSession session=request.getSession();
	Product p=(Product)session.getAttribute("product");
	session.removeAttribute("product");
	int q=1;
	try{
		 q=Integer.parseInt(request.getParameter("quantity"));
	}catch(NumberFormatException n){
		q=1;
	}


	
	Cart c=(Cart)session.getAttribute("cart");
	if(c!=null){
	
		UserService.addItemtoCart(p, c, q);
		session.setAttribute("cart", c);
	}
	else{
		Cart c1=UserService.createCart();
		UserService.addItemtoCart(p, c1, q);
		session.setAttribute("cart", c1);
	}
	

	
	

	
	return view;
}
}
