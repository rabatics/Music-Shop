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

public class UserCatalogController implements Controller{

String view;
UserServiceAPI UserService;

public UserCatalogController(UserServiceAPI userService, String view){
	
	System.out.println("In user catalog page controller");
	this.view=view;
	this.UserService=userService;
}

@Override
public String handleRequest(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
	
	System.out.println("In UserCatalogController");
	
	HttpSession session = request.getSession();
	
	try {
		
		Set<Product> product=UserService.getProductList();
		
		request.setAttribute("product", product);
		
	} catch (ServiceException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return view;
}
}
