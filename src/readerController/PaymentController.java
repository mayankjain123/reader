package readerController;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Product;
import model.User;
import dao.ProductDB;
import dao.UserDB;
import emailService.UserNotification;

public class PaymentController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	String userMessage="";
	HttpSession session;
	String url="/payment.jsp";
	Double cardPayAmount = 0.0;
	
	UserDB uDB; ProductDB pDB;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		
	}
			
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		
		String action = req.getParameter("action");
				
		session = req.getSession();
		cardPayAmount = (Double) session.getAttribute("cardAmount");	
		
 		url="/payment.jsp";  
 		req.setAttribute("cardPayAmount", cardPayAmount);
 		
 		User u1 = (User) session.getAttribute("logInUser");
	    if(u1==null){
	    	req.setAttribute("currUsr", "Not Signed In");
	    }else{
	    	req.setAttribute("currUsr", u1.getFirstName());
	    }
	    
	    req.setAttribute("navLink", "Home>Catalog>Item>Cart>Payment");
 		getServletContext().getRequestDispatcher(url).forward(req, resp);
 		
	}
	
	
}
