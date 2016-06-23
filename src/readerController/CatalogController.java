package readerController;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.security.auth.login.Configuration;
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

public class CatalogController extends HttpServlet{

	
	private static final long serialVersionUID = 1L;
	String[] categoryName;
	Product[] allProduct;
	HttpSession session;
	
	UserDB uDB; 
	ProductDB pDB;
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		
		String url="/catalog.jsp";
						
		// session
	 	session = req.getSession(true);
	    // add to session
		 	    
	    
			// 	load DB once
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
			
			
			String action=req.getParameter("action");
			String productCode=req.getParameter("productCode");
			String productCategory=req.getParameter("category");
			
			categoryName = getCatogaries(pDB);
			allProduct = getAllProducts(pDB);
			
			boolean isValid=false;
			
			if(productCategory!=null && action.equals("") && pDB.getProduct(productCategory) != null){
				isValid = true;
			}
			
			req.setAttribute("navLink", "Home>Catalog");
			
			if(productCode != null){
				
				url="/item.jsp";
				Product product = new Product();
				System.out.println("Product code: "+productCode);
				
				for(int i=0;i<allProduct.length;i++){
					if(allProduct[i].getProductCode().equals(productCode)){
						product = allProduct[i];
						System.out.println("Selected product: "+product.getProductName());
						break;
					}
				}
				
				req.setAttribute("navLink", "Home>Catalog>Cart");
				req.setAttribute("SingleProduct", product);
				
				
			}/*else if(action.equals("CatalogData")){
				
				url="/catalog.jsp";
				
			}else if(!action.equals("catalog") && isValid){
				
				url="/item.jsp";
				Map<String,Product> categoryProducts = new HashMap<String, Product>();
				categoryProducts = pDB.getProducts(productCategory);
				Product[] prod = new Product[categoryProducts.keySet().size()];
				

				Iterator<String> itr = categoryProducts.keySet().iterator();
				int count = 0;
				while(itr.hasNext()){
					String key = itr.next();
					if(categoryProducts.get(key).getCategory().equals(productCategory)){
						prod[count] = categoryProducts.get(key); 
					}
				}
				
				req.setAttribute("products", prod);
				req.setAttribute("category", productCategory);
				
				
			
			}*/
			
		User u1 = (User) session.getAttribute("logInUser");
		if(u1==null){
		    req.setAttribute("currUsr", "Not Signed In");
		}else{
			req.setAttribute("currUsr", u1.getFirstName());
		}
			
			
		req.setAttribute("URL", url);
		req.setAttribute("categoryName", categoryName);	
		req.setAttribute("allProduct", allProduct);
		
		getServletContext().getRequestDispatcher(url).forward(req, resp);
	
		
	}
	
	private String[] getCatogaries(ProductDB prod){
		
		Set<String> cSet = new HashSet<String>();
				
		Iterator<String> itr = prod.getProducts().keySet().iterator();
		while(itr.hasNext()){
			String key = itr.next();
			String c = prod.getProducts().get(key).getCategory();
			cSet.add(c);
		}
		
		categoryName = new String[cSet.size()+1];
		categoryName[0] = "All";
		Iterator<String> itr1 = cSet.iterator();
		int index = 1;
		while(itr1.hasNext()){
			String value = itr1.next();
			categoryName[index++] = value;
			System.out.println("values: "+value);
		}
		
		return (categoryName);
	}

	private Product[] getAllProducts(ProductDB prod){
		
		Map<String,Product> products = new HashMap<String, Product>();
		products = prod.getProducts();
		allProduct = new Product[products.keySet().size()];
		

		Iterator<String> itr = products.keySet().iterator();
		int count = 0;
		while(itr.hasNext()){
			String key = itr.next();
			allProduct[count++] = products.get(key);
			System.out.println("Products: "+count+"  "+allProduct[count-1].getProductName());
		}
		
		
		
		return allProduct;
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		
		System.out.println("Inside post method ");
		
	}

	
	
	
}
