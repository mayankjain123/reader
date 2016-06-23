package readerController;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Order;
import model.OrderItem;
import model.Product;
import model.User;

public class OrderListController extends HttpServlet{

	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action =req.getParameter("action");    
        String url="";			
		

	    HttpSession session = req.getSession(true);
		User u1 = (User) session.getAttribute("logInUser");
	     if(u1==null){
	    	 req.setAttribute("currUsr", "Not Signed In");
	     }else{
	    	 req.setAttribute("currUsr", u1.getFirstName());
	     }
	            
        
	    //get orders
	    LinkedList<Product> p = new LinkedList<Product>();
	    if((LinkedList<Product>) session.getAttribute("theShoppingCart")!=null){
	    	p = (LinkedList<Product>) session.getAttribute("theShoppingCart");
	    }
	    Order o1 = new Order();
	    List l1 = o1.getOrderItems(); 
	    for(int i=0;i<l1.size();i++){
	    	p.add(((OrderItem) l1.get(i)).getProduct());   
	    	//System.out.println("data of orders: "+l1.get(i).toString());
	    }
	    session.setAttribute("allOrders", p);
	    	 
	    if(action.equals("userNavigation") && u1!=null){
	    	
	    	req.setAttribute("theOrders", p);
	    	url ="/orderlist.jsp"; 	    	
	    }else{
	    	System.out.println("User was null");
	    	session.setAttribute("NavOrder", "TRUE");
	    	url ="/CheckOutChoice.jsp"; 
	    }
	    	
	    System.out.println("The url is: "+url);
	    	
	    req.setAttribute("navLink", "OrderList");
		getServletContext().getRequestDispatcher(url).forward(req, resp);
		
		
	}

	
}
