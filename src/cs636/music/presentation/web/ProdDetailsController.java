package cs636.music.presentation.web;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cs636.music.domain.Product;
import cs636.music.service.ServiceException;
import cs636.music.service.UserServiceAPI;

public class ProdDetailsController implements Controller{

String view;
UserServiceAPI UserService;

public ProdDetailsController(UserServiceAPI userService, String view){
	
	System.out.println("In product details page controller");
	this.view=view;
	this.UserService=userService;
}

@Override
public String handleRequest(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
	
	System.out.println("In Product Details Controller");
	String prodCode=request.getParameter("productCode");
	HttpSession session=request.getSession();
	
	session.setAttribute("procode", prodCode);
	try {
	
	
		Product product=UserService.getProduct(prodCode);
		session.setAttribute("product", product);
	
		
			request.setAttribute("product", product);
		
		
		
	} catch (ServiceException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return view;
}
}
