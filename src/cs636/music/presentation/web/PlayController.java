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

public class PlayController implements Controller{

String view;
UserServiceAPI UserService;

public PlayController(UserServiceAPI userService, String view){
	
	System.out.println("In play page controller");
	this.view=view;
	this.UserService=userService;
}

@Override
public String handleRequest(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
	
	System.out.println("In Play Controller");
	
	HttpSession session=request.getSession();
	User u=(User)session.getAttribute("user");
	
	
		
		Product p=(Product)session.getAttribute("product");
		int track=Integer.parseInt(request.getParameter("trackname"));
		Track t=p.findTrackByNumber(track);
		request.setAttribute("track", t.getSampleFilename());
		try {
			
			UserService.addDownload(u, t);
			
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	
	
	
		
		
	
		
	
	
	return view;
}
}
