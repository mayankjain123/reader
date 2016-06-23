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

public class SingleOrderController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	HttpSession session;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doGet(req, resp);

	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doPost(req, resp);

		String url = "/singleOrderSelect.jsp";

		session = req.getSession(true);
		String selectItem = (String) req.getParameter("textInfo");
		System.out.println("Select item is : " + selectItem);

		Product p = ((LinkedList<Product>) session.getAttribute("allOrders")).get(Integer.parseInt(selectItem));
		System.out.println("Product is : " + p.getProductName());
		
		req.setAttribute("order", (Order) session.getAttribute("order"));
		req.setAttribute("userLogedIn", (User) session.getAttribute("logInUser"));
		req.setAttribute("productSelected", p);
		req.setAttribute("navLink", "Home>OrderList>OrderedItem");

		getServletContext().getRequestDispatcher(url).forward(req, resp);

	}

}
