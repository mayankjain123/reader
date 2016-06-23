package readerController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

public class AboutController extends HttpServlet{

	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		
			String url="/aboutUs.jsp";
			
			System.out.println("About us controller");
			HttpSession session = req.getSession(true);
			User u1 = (User) session.getAttribute("logInUser");
		     if(u1==null){
		    	 req.setAttribute("currUsr", "Not Signed In");
		     }else{
		    	 req.setAttribute("currUsr", u1.getFirstName());
		     }
		    
		     req.setAttribute("navLink", "Home>About");
			
			getServletContext().getRequestDispatcher(url).forward(req, resp);
		
			
		}

	

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		
		System.out.println("Inside post method ");
		
	}


	
	
}
