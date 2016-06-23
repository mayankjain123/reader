package readerController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

public class CheckOutChoiceController extends HttpServlet{

	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action =req.getParameter("action");    
        String url="";			
		

	    if(action.equals("CheckOut")){
	    	getServletContext().getRequestDispatcher("/CheckOutChoice.jsp").forward(req, resp);
	    }
	    
	    HttpSession session = req.getSession(true);
		User u1 = (User) session.getAttribute("logInUser");
	     if(u1==null){
	    	 req.setAttribute("currUsr", "Not Signed In");
	     }else{
	    	 req.setAttribute("currUsr", u1.getFirstName());
	     }
	    
	     req.setAttribute("navLink", "LogIn");
		getServletContext().getRequestDispatcher(url).forward(req, resp);
		
		
	}

	
}
