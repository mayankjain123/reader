package readerController;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Order;
import model.Product;
import model.User;
import dao.ProductDB;
import dao.UserDB;

public class LoginController extends HttpServlet{

	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action =request.getParameter("action");
		String userName =request.getParameter("userId");  
		String password =request.getParameter("userpass");  
        String url="";
        HttpSession session = request.getSession(true);
		
		if(action.equals("login")){
			System.out.println("Login action");
			url="/Login.jsp";
			request.setAttribute("navLink", "LogIn");
		}else if (action.equals("registration")){
			System.out.println("Registration action");
			url="/userInfo.jsp";
			request.setAttribute("navLink", "User Info");
		}else if (action.equals("logintry")){
			System.out.println("User trying to login");

			User u = (User) session.getAttribute("user");
			request.setAttribute("user", u);
			
			Double totalAmount = (Double) session.getAttribute("cardAmount");
			request.setAttribute("totalAmount", totalAmount); 
			
			request.setAttribute("productInCart", (LinkedList<Product>) session.getAttribute("theShoppingCart"));
			
			Order order = (Order) session.getAttribute("order");
			request.setAttribute("order", order);
	 					
			
			// authenticate him
			ProductDB pDB = (ProductDB)session.getAttribute("pDB");
	 		UserDB uDB = (UserDB)session.getAttribute("uDB");

	 		User foundUser = uDB.checkUser(userName, password);
	 		if(foundUser != null){// found
	 			
	 			session.setAttribute("logInUser", foundUser);
	 			request.setAttribute("userLogedIn", foundUser);
	 			// handle orders from navigation 
	 			if(session.getAttribute("NavOrder")!=null && session.getAttribute("NavOrder").equals("TRUE")){
	 				
	 				request.setAttribute("theOrders", (LinkedList<Product>)session.getAttribute("allOrders"));
	 				url="/orderlist.jsp";
	 				request.setAttribute("navLink", "OrderList");
	 			}else{
	 				request.setAttribute("navLink", "Home>Catalog>...>Order");
	 				url="/order.jsp";	 			
	 			}
	 			
	 		}else{
	 			url="/error.jsp";
	 		}
		}
				
		session = request.getSession(true);
		User u1 = (User) session.getAttribute("logInUser");
	     if(u1==null){
	    	 request.setAttribute("currUsr", "Not Signed In");
	     }else{
	    	 request.setAttribute("currUsr", u1.getFirstName());
	     }
	    		
	    
		getServletContext().getRequestDispatcher(url).forward(request, response);
		
		
	}

	
}
