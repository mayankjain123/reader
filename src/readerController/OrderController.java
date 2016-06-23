package readerController;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

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
import emailService.UserNotification;

public class OrderController extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	
	LinkedList<Product> productInCart= new LinkedList<Product>();
	Double totalAmount=0.0;
	HttpSession session;
	String url="/cart.jsp";
	
	UserDB uDB; ProductDB pDB; Order o1;

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
		
		System.out.println("Inside Order controller do post method. ");
		
		String action = req.getParameter("action");
	    String productCode = req.getParameter("product");
	    String action1 = req.getParameter("action1");
	    String action2 = req.getParameter("action2");
	    System.out.println("Action : "+action);
	    
	    // payment details
	    if(action.equals("confirmOrder")){
	    	String category = req.getParameter("Category");
	    	String card_number = req.getParameter("card_number");
	    	String Month = req.getParameter("Month");
	    	String Year = req.getParameter("Year");
	    	String cvv = req.getParameter("cvv");
	    	System.out.println("Data: "+"\n"+category+"\n"+card_number+"\n"+Month+"\n"+Year+"\n"+cvv);
	    }	
			    
	    System.out.println("Dummy parameter : "+req.getParameter("dummy"));
	    
	    System.out.println("action:  "+action+"  action1  :"+action1+"  action2  :"+action2);
		
	    // session
	 	session = req.getSession(true);
	   	       
		// loads users and products
		if (session.getAttribute("appStart") == null){
				uDB = new UserDB();
				pDB = new ProductDB();
				session.setAttribute("appStart", "START");
		 		session.setAttribute("pDB", pDB);
		 		session.setAttribute("uDB", uDB);
		}else{
				pDB = (ProductDB)session.getAttribute("pDB");
		 		uDB = (UserDB)session.getAttribute("uDB");
		}
			
		o1 = new Order();
		session.setAttribute("userO1", o1);
		
		LinkedList<Product> val =  (LinkedList<Product>) session.getAttribute("theShoppingCart”");

	    if (val != null) {
	    	    
	    	productInCart = (LinkedList<Product>) session.getAttribute("theShoppingCart"); 
	    	handleAction(action, productCode, req, resp);
	    	// save to session 
	    	session.setAttribute("theShoppingCart", productInCart);
	            
	     }else{
	         handleAction(action, productCode, req, resp);
	         session.setAttribute("theShoppingCart", productInCart);
	     }
	        	
	    User u1 = (User) session.getAttribute("logInUser");
	     if(u1==null){
	    	 req.setAttribute("currUsr", "Not Signed In");
	     }else{
	    	 req.setAttribute("currUsr", u1.getFirstName());
	     }
	     
	    session.setAttribute("cardAmount", totalAmount);
	    req.setAttribute("totalAmount", totalAmount); 
	    session.setAttribute("totalAmount", totalAmount);
	    
	    //req.setAttribute("productInCart", productInCart);
	    req.setAttribute("productInCart", (LinkedList<Product>) session.getAttribute("theShoppingCart"));
		getServletContext().getRequestDispatcher(url).forward(req, resp);
	
		
	}
	
	private void handleAction(String action, String productCode, HttpServletRequest req, HttpServletResponse resp){
		 
	     if(action != null && action.equals("addToCart")){
	    	 
	    	 // add if not present
	    	 if(productCode != null){
	    		 addProdcut(productCode);
	    	 }
	    	 url="/cart.jsp";
	    	 req.setAttribute("navLink", "Home>Catalog>Item>Cart");
	    	  
	     }else if(action !=null  &&  action.equals("Update Cart")){
	    	 
	    	 System.out.println("Inside update ");
	    	 
	    	 Product prod = new Product();
	    	 for(int i=0; i<productInCart.size(); i++){
	 			prod = productInCart.get(i);
	 			String updateCount = prod.getProductCode();
	 			
	 			System.out.println("retrieved str:  "+req.getAttribute("dummy"));
	 			
	 			if(req.getAttribute(updateCount) != null){
	 			
	 				System.out.println("retrieved str:  "+(String) req.getAttribute(updateCount));
	 				
	 				int val = Integer.parseInt((String) req.getAttribute(updateCount));
	 				if(val==0){
	 					// remove product
	 					productInCart.remove(i);
	 				}else{
	 					// update sum and product list 
	 					productInCart.get(i).setCountItems(val);
	 					updateSum(productInCart);
	 					
	 				}
	 			}
	 		}
	    	
	    	req.setAttribute("navLink", "Home>Catalog>Item>Cart");
	    	 
	     }else if(action!=null && action.equals("confirmOrder")){
	    	 
	    					
	 		session = req.getSession();
	 		
	 		LinkedList<Product> c1= (LinkedList<Product>) session.getAttribute("theShoppingCart");
	 		User u1 = (User) session.getAttribute("logInUser");
	 		
	 		// sent a mail to user
	 		//UserNotification email = new UserNotification();
	 		//email.sentMail(u1,c1);
	 		
	 		url = "/paymentSuccess.jsp";
	 		
	 		req.setAttribute("navLink", "Home>Catalog>Item>Cart>Payment");
		    	
		 }else if(action!=null && action.equals("CheckOut")){
	    	     	 
			 
	    	 User user = new User();
	    	 
	    	 Map<String,User> m1 = uDB.getUsers();

	 		Iterator<String> itr = m1.keySet().iterator();
	 		int count = 0;
	 		while(itr.hasNext()){
	 			String key = itr.next();
	 			user = m1.get(key);
	 		}
	 		
	 		session.setAttribute("theUser", user); 
	 		
	 		Order order = new Order();
	 		order.setUser(user);
	 		
	 		DateFormat df = new SimpleDateFormat("MM/DD/YYYY HH:MM:SS");
	 		Date today = Calendar.getInstance().getTime();
	 		String reportDate = df.format(today);
	 		order.setDate(reportDate);
	 		
	 		order.setOrderItems(productInCart);
	 		order.setPaid(false);
	 		order.setSalesTaxRate(4.5);
	 		
	 		updateSum(productInCart);
	 		order.setSubtotal(totalAmount);
	 		order.setTotalCost(totalAmount+(totalAmount*4.5f/100));
	    	 
	 		session.setAttribute("currentOrder", order);
	 		
	 		
	 		// if user is logged in then go to check out page... 
	 		url = "/CheckOutChoice.jsp";
	 		User u1 = (User) session.getAttribute("logInUser");
	 		if(u1 != null){
	 			url = "/order.jsp";
	 		}
	 		
	 		req.setAttribute("userLogedIn", u1);
	 		req.setAttribute("user", user);
	 		req.setAttribute("order", order);
	 		session.setAttribute("user", user);
	 		session.setAttribute("order", order);
	 		
	 		req.setAttribute("navLink", "Home>Catalog>Item>Cart>CheckOut");
	 			 		
	     }
		
	}
	
	private void updateSum(LinkedList<Product> productInCart){
		
		int size1 = productInCart.size();
		
		if(size1!=0){
			totalAmount = 0.0;
			for(int i=0; i<size1; i++){
				totalAmount = totalAmount + ((Double)(productInCart.get(i).getPrice()) * (productInCart.get(i).getCountItems()));
			}
		}
		
		System.out.println("Updated sum : "+totalAmount+"  "+productInCart.size());
		
	}
	
	private void addProdcut(String productCode){
		
		boolean  toAdd = true;
		int size = productInCart.size();
		
		for(int i=0; i<size; i++){
			if(productCode.equals(productInCart.get(i).getProductCode())){
				// do not add
				toAdd = false;
			}
		}
		if(toAdd){
			
			productInCart.add(size, pDB.getProduct(productCode));						
			if(size!=0){
				productInCart.get(size).setCountItems(productInCart.get(size).getCountItems()+1);
			}else{
				productInCart.get(size).setCountItems(1);
			}
			
			
			// since updated change sum
			updateSum(productInCart);
			
		}
		
	}
	
	
}
