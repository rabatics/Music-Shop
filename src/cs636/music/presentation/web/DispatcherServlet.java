package cs636.music.presentation.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cs636.music.service.UserService;
import cs636.music.service.UserServiceAPI;
import cs636.music.config.MusicSystemConfig;
import cs636.music.service.UserService;

// like Spring MVC DispatcherServlet and its config file, but simpler.
// This servlet is handling the student pages of the pizza project,
// calling on various controllers, roughly one for each student page or form.
// Note that all the jsp filenames (for views) are in this file, not
// in the controllers themselves.  Each controller is set up
// here and given its forward-to URLs in its constructor.

public class DispatcherServlet extends HttpServlet {

	private static final long serialVersionUID = 3971217231726348088L;
	private static UserServiceAPI studentService;
	//private static int numRooms; // number of rooms in system;

	// The controllers, roughly one per student page or form
	private static Controller UserCatalogController;
	private static Controller ProdDetailsController;
	private static Controller AddCartController;
	private static Controller RemoveCartController;
	private static Controller PlayController;
	private static Controller RegisterController;
	private static Controller RegisterControllerRedirect;
	private static Controller CheckoutController;
	private static Controller LogoutController;
		
	private static final String SITE_WELCOME_URL = "/welcome.html";
	private static final String SITE_WELCOME_VIEW = "/welcome.jsp";
	private static final String DETAILS_URL = "/prodDetails.html";
	private static final String DETAILS_VIEW = "/WEB-INF/jsp/prodDetails.jsp";
	private static final String CATALOG_URL = "/UserCatalog.html";
	private static final String CATALOG_VIEW = "/WEB-INF/jsp/UserCatalog.jsp";
	private static final String ADDTOCART_URL = "/AddToCart.html";
	private static final String VIEWCART_URL = "/showCart.html";
	private static final String VIEWCART_VIEW = "/WEB-INF/jsp/showCart.jsp";
	private static final String REMOVECART_URL = "/removeCart.html";
	private static final String PLAY_URL = "/playSong.html";
	private static final String PLAY_VIEW = "/WEB-INF/jsp/sound.jsp";
	private static final String CHECKOUT_URL = "/checkout.html";
	private static final String CHECKOUT_VIEW = "/WEB-INF/jsp/checkout.jsp";
	private static final String REGISTER_URL = "/register.html";
	private static final String REGISTER_VIEW = "/WEB-INF/jsp/register.jsp";
	private static final String REGISTERUSER_URL = "/registerUser.html";
	private static final String THANKYOU_URL = "/thanks.html";
	
	@Override
	public void init() throws ServletException {
		System.out.println("Starting dispatcher servlet initialization");
		try {
			MusicSystemConfig.configureServices();
		} catch (Exception e) {
			// log the error in tomcat's log
			System.out.println(MusicSystemConfig.exceptionReport(e));
			throw new ServletException(e); // fatal error
		}
		studentService = MusicSystemConfig.getUserService();
		if (studentService==null)
			throw new ServletException(
					"DispatcherServlet: bad initialization");
	
	UserCatalogController = new UserCatalogController(studentService,CATALOG_VIEW);
	ProdDetailsController=new ProdDetailsController(studentService,DETAILS_VIEW);
	AddCartController=new AddCartController(studentService,VIEWCART_VIEW);
	RemoveCartController=new RemoveCartController(studentService,VIEWCART_VIEW);	
	PlayController=new PlayController(studentService,PLAY_VIEW);
	RegisterController=new RegisterController(studentService,SITE_WELCOME_VIEW);
	CheckoutController=new CheckoutController(studentService,CHECKOUT_VIEW);
	LogoutController=new LogoutController(studentService,SITE_WELCOME_VIEW);
	
	
	
	}
	
	
	@Override
	public void destroy() {
		System.out.println("DispatcherServlet: shutting down");
		MusicSystemConfig.shutdownServices();
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String requestURL = request.getServletPath();
		System.out.println("DispatcherServlet: requestURL = " + requestURL);
		
		boolean hasBean = (request.getSession().getAttribute("user")
				!= null);
		boolean hasRedirect = (request.getSession().getAttribute("redirect")
				!= null);

	
		/*
			String forwardURL = null; 
		if (requestURL.equals(SITE_WELCOME_URL))
			forwardURL = SITE_WELCOME_VIEW; // no controller needed
        // test for bean, and if not there, send user to student welcome page
		else if (requestURL.equals(CATALOG_URL))  
			forwardURL = UserCatalogController.handleRequest(request, response);
		else if (requestURL.equals(DETAILS_URL))
			forwardURL = ProdDetailsController.handleRequest(request, response);
		else if (requestURL.equals(ADDTOCART_URL))
			forwardURL = AddCartController.handleRequest(request, response);
		else if (requestURL.equals(REMOVECART_URL)) 
			 forwardURL = RemoveCartController.handleRequest(request, response);
			  else if (requestURL.equals(PLAY_URL) && hasBean ) 
				 forwardURL = PlayController.handleRequest(request, response);
			  else if (requestURL.equals(PLAY_URL) && !hasBean ) 
			  { forwardURL = REGISTER_VIEW;
	            request.getSession().setAttribute("redirect", DETAILS_VIEW);
	            
			  }
			  else if(requestURL.equals(REGISTER_URL))
				  forwardURL=REGISTER_VIEW;
			  else if(requestURL.equals(REGISTERUSER_URL))
				  forwardURL=RegisterController.handleRequest(request, response);
			  else if(requestURL.equals(REGISTERUSER_URL) && hasRedirect){
				  forwardURL=new RegisterController(studentService,new ProdDetailsController(studentService,(String) request.getSession().getAttribute("redirect")).handleRequest(request, response)).handleRequest(request, response);
				  request.getSession().removeAttribute("redirect");
			  }
		
		
		
		
		
		*/
		
	
		String forwardURL = null; 
		if (requestURL.equals(SITE_WELCOME_URL))
			forwardURL = SITE_WELCOME_VIEW; // no controller needed
        // test for bean, and if not there, send user to student welcome page
		else if (requestURL.equals(CATALOG_URL))  
			forwardURL = UserCatalogController.handleRequest(request, response);
		else if (requestURL.equals(DETAILS_URL)){
			
			
			forwardURL = ProdDetailsController.handleRequest(request, response);
			
			
		}
		else if (requestURL.equals(ADDTOCART_URL))
			forwardURL = AddCartController.handleRequest(request, response);
		else if (requestURL.equals(REMOVECART_URL)) 
			 forwardURL = RemoveCartController.handleRequest(request, response);
			  else if (requestURL.equals(PLAY_URL) && hasBean ) 
				 forwardURL = PlayController.handleRequest(request, response);
			  else if (requestURL.equals(PLAY_URL) && !hasBean ) 
			  { forwardURL = REGISTER_VIEW;
			  request.setAttribute("flag", 1);
	           
	  }
			  else if(requestURL.equals(VIEWCART_URL))
				  forwardURL=VIEWCART_VIEW;
			  else if(requestURL.equals(REGISTER_URL)){
				  forwardURL=REGISTER_VIEW;
				  request.setAttribute("flag", 0);
			  }
			  else if(requestURL.equals(REGISTERUSER_URL)  && request.getParameter("red").contentEquals("1")){
				 System.out.println("1");
				  forwardURL=RegisterController.handleRequest(request, response);
				
				  HttpSession session=request.getSession();
				  request.setAttribute("productCode", (String)session.getAttribute("procode"));
		           session.removeAttribute("procode");
		        forwardURL=ProdDetailsController.handleRequest(request, response); }
			  else if(requestURL.equals(REGISTERUSER_URL)  && request.getParameter("red").contentEquals("2")){
					 System.out.println("1");
					  forwardURL=RegisterController.handleRequest(request, response);
					
					  
			        forwardURL=VIEWCART_VIEW; 
			        }
		
			  else if(requestURL.equals(REGISTERUSER_URL) && request.getParameter("red").contentEquals("0")){
				  forwardURL=RegisterController.handleRequest(request, response);
				  System.out.println("2");
			  }
			  else if(requestURL.equals(CHECKOUT_URL) && hasBean)
				  forwardURL=CheckoutController.handleRequest(request, response);
			  else if(requestURL.equals(CHECKOUT_URL) && !hasBean)
			  {
				  forwardURL = REGISTER_VIEW;
				  request.setAttribute("flag", 2);
				 
			  }
			  else if(requestURL.equals(THANKYOU_URL))
				  forwardURL=LogoutController.handleRequest(request, response);
			 
  /*else if (requestURL.equals(REMOVECART_URL)) {
					 forwardURL = RemoveCartController.handleRequest(request, response);
						else if (requestURL.equals(REMOVECART_URL)) {
							 forwardURL = RemoveCartController.handleRequest(request, response);*/
			// Here returned URL = ORDER_SUCCESS_VIEW (success case)
			// or ORDER_FORM_URL (redo form case)			
		/*	if (returnedURL.equals(ORDER_FORM_URL))
				forwardURL = returnedURL;  // handle normally (redo form case)
			else if (returnedURL.equals(STUDENT_WELCOME_URL)) { // success case
				// Special case: we avoid accidental resubmissions of the 
				// order form by redirecting rather than forwarding.
				// This way, a user page-refresh in the browser just redisplays
				// the "success" page
				response.sendRedirect(request.getContextPath() + ORDER_REDIRECT_URL);
				return; // we sent a redirect instead of forwarding
			}  else throw new ServletException(
					"DispatcherServlet: Unknown url back from orderPizzaController: "
							+ returnedURL);*/
		// the redirect comes back here--forward to success page
		
		else 
			throw new ServletException("DispatcherServlet: Unknown servlet path: "
					+ requestURL);
		// Here with good forwardURL to forward to
		System.out.println("DispatcherServlet: forwarding to "+ forwardURL);
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher(forwardURL);
		dispatcher.forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
