package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import model.Product;


public class ProductDB {
	
	public ProductDB(){
		addData();
		/*createProductTable();
		addProduct(m1.get("F_1"));
		addProduct(m1.get("F_2"));
		addProduct(m1.get("F_3"));
		addProduct(m1.get("A_1"));
		addProduct(m1.get("A_2"));
		addProduct(m1.get("A_3"));
		addProduct(m1.get("A_4"));*/
	}
	
	
	Map<String,Product> m1 = new HashMap<String,Product>();
		
	public void addData(){
		
		Product p1 = new Product();
		p1.setCategory("Fiction");
		p1.setDescription("To Kill a Mockingbird is a novel by Harper Lee published in 1960. It was immediately successful, winning the Pulitzer Prize, and has become a classic of modern American literature.");
		p1.setImageURL("home1.jpg");
		p1.setPrice(90.99);
		p1.setProductCode("F_1");
		p1.setProductName("To Kill a Mocking bird ");
		
		Product p2 = new Product();
		p2.setCategory("Fiction");
		p2.setDescription("Epic Civil War drama focuses on the life of petulant southern belle Scarlett O'Hara (Vivien Leigh). Starting with her idyllic on a sprawling plantation, it tracs her servival.");
		p2.setImageURL("home2.jpg");
		p2.setPrice(98.50);
		p2.setProductCode("F_2");
		p2.setProductName("Gone with the Wind");
	
		Product p3 = new Product();
		p3.setCategory("Fiction");
		p3.setDescription("In The Grim Company, Luke Scull introduced a formidable and forbidding band of anti-heroes battling against ruthless Magelords and monstrous terrors. The adventure continues as the companynow brokenface new dangers on personal quests.");
		p3.setImageURL("home3.jpg");
		p3.setPrice(65.99);
		p3.setProductCode("F_3");
		p3.setProductName("Sword of the North");
	
		Product p4 = new Product();
		p4.setCategory("Art");
		p4.setDescription("Part family memoir, part political commentary, part apologia, Dream State tells the grand and sometimes crazy story of Florida through the eyes of one of its native daughters. Acclaimed journalist and NPR commentator Diane Roberts has many family secrets to tell.");
		p4.setImageURL("home4.jpg");
		p4.setPrice(50.99);
		p4.setProductCode("A_1");
		p4.setProductName("Dream States");
	
		Product p5 = new Product();
		p5.setCategory("Art");
		p5.setDescription("A unique system for jump-starting artistic creativity, encouraging experimentation and growth, and increasing sales for artists of all levels, from novices to professionals.");
		p5.setImageURL("home5.jpg");
		p5.setPrice(49.49);
		p5.setProductCode("A_2");
		p5.setProductName("Daily Painting");
	
		Product p6 = new Product();
		p6.setCategory("Art");
		p6.setDescription("Terri is an art curator, stagnating in a dead end job in London. Her ex-boyfriend, Oliver, is violent and abusive and now he's stalking her; a post curating the retrospective of a famous but reclusive artist seems the perfect escape. .");
		p6.setImageURL("home1.jpg");
		p6.setPrice(99.99);
		p6.setProductCode("A_3");
		p6.setProductName("Silent Faces");
	
		Product p7 = new Product();
		p7.setCategory("Art");
		p7.setDescription("From cave paintings to Jeff Koons—that’s where this stunningly illustrated history of art takes you. Filled with pictures of paintings, sculptures, museum artifacts, and architectural standouts, and a cross-cultural approach that encompasses European, American, Asian, and Islamic masterpieces, it proceeds on a thrilling visual tour. ");
		p7.setImageURL("home3.jpg");
		p7.setPrice(89.99);
		p7.setProductCode("A_4");
		p7.setProductName("Art History");
		
		
		m1.put("F_1",p1);
		m1.put("F_2",p2);
		m1.put("F_3",p3);
		m1.put("A_1",p4);
		m1.put("A_2",p5);
		m1.put("A_3",p6);
		m1.put("A_4",p7);
		
				
	}	
	

	public Product getProduct(String productCode){
		
		return(m1.get(productCode));
		
	}
	
	
	public Map<String,Product> getProducts(){
		
		// return products of ALL categories
		return(m1);
		
	}
	
	public Map<String,Product> getProducts(String category){
		
		Map<String,Product> categoryProducts = new HashMap<String, Product>();
		Set keys = categoryProducts.keySet();
		
		Iterator<String> itr = keys.iterator();
		while(itr.hasNext()){
			String key = itr.next();
			if(m1.get(key).getCategory().equals(category)){
				categoryProducts.put(key, m1.get(key));
			}
		}
		
		return(m1);
		
	}
	
	
	////////////////////////////////////////////
    public void createProductTable() {

        Statement statement = DbAdmin.getNewStatement();

        try {

            statement.execute("CREATE TABLE IF NOT EXISTS product("
                    + "productCode VARCHAR(10),productName VARCHAR(50),"
                    + "category VARCHAR(50),"
                    + "price FLOAT(5),description VARCHAR(800),imageURL VARCHAR(50), countItems INT, "
                    + "PRIMARY KEY (productCode))");
            System.out.println("Created a new table: " + "PRODUCT");
            
        } catch (SQLException se) {
            if (se.getErrorCode() == 30000 && "X0Y32".equals(se.getSQLState())) {
                // we got the expected exception when the table is already there
            } else {
                // if the error code or SQLState is different, we have an unexpected exception
                System.out.println("ERROR: Could not create PRODUCT table: " + se);
            }
        }
    }

    public void addProduct(String productCode, String productName, String catalogCategory,
            float price, String description, String imageUrl, int countItems) {

        Connection connection = DbAdmin.getConnection();
        PreparedStatement ps;
        // insert the new row into the table
        try {
            ps = connection.prepareStatement("INSERT INTO product VALUES (?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, productCode);
            ps.setString(2, productName);
            ps.setString(3, catalogCategory);
            ps.setFloat(4, price);
            ps.setString(5, description);
            ps.setString(6, imageUrl);
            ps.setInt(7, countItems);

            ps.executeUpdate();

        } catch (SQLException se) {
            if (((se.getErrorCode() == 30000) && ("23505".equals(se.getSQLState())))) {
                System.out.println("ERROR: Could not insert record into PRODUCT; dup primary key: " + productCode);
            } else {
                System.out.println("ERROR: Could not add row to PRODUCT table: " + productCode + " " + se.getCause());
            }
            
        } catch (Exception e) {
            System.out.println("ERROR: Could not add row to PRODUCT table: " + productCode);
            
        }
        
        System.out.println("Added product to PRODUCT table: " + productCode);

        
        
    }

    public Product addProduct(Product product) {

        Connection connection = DbAdmin.getConnection();
        PreparedStatement ps;
        // insert the new row into the table
        try {
            ps = connection.prepareStatement("INSERT INTO product VALUES (?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, product.getProductCode());
            ps.setString(2, product.getProductName());
            ps.setString(3, product.getCategory());
            ps.setDouble(4, product.getPrice());
            ps.setString(5, product.getDescription());
            ps.setString(6, product.getImageURL());
            ps.setInt(7, product.getCountItems());
            

            ps.executeUpdate();

        } catch (SQLException se) {
            if (((se.getErrorCode() == 30000) && ("23505".equals(se.getSQLState())))) {
                System.out.println("ERROR: Could not insert record into PRODUCT; dup primary key: " + product.getProductCode());
            } else {
                System.out.println("ERROR: Could not add row to PRODUCT table: " + product.getProductCode() + " " + se.getCause());
            }
            return null;
        } catch (Exception e) {
            System.out.println("ERROR: Could not add row to PRODUCT table: " + product.getProductCode());
            return null;
        }
        System.out.println("Added product to PRODUCT table: " + product.getProductCode());

        // return the  product object
        return product;
    }

    /*
    public static Product getProduct(String pcode) {

        Product product = new Product();
        product.setProductCode(pcode);

        String query = "SELECT productName, category, price, description, imageURL, countItems"
                + " from thereader.PRODUCT where PRODUCT.productCode ='" + pcode + "'";
        Statement statement = DbAdmin.getNewStatement();
        ResultSet resultSet = null;

        try {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {

                product.setProductName(resultSet.getString("productName"));
                product.setCategory(resultSet.getString("category"));
                product.setPrice(resultSet.getInt("price"));
                product.setDescription(resultSet.getString("description"));
                product.setImageURL(resultSet.getString("imageURL"));
                product.setCountItems(resultSet.getInt("countItems"));
                
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;

    }
    */
    
    public static ArrayList<Product> getAllCategoryProducts(String pcategory) {
    	System.out.println(pcategory);
        ArrayList<Product> categoryproducts = new ArrayList<Product>();

        Statement statement = DbAdmin.getNewStatement();
        ResultSet resultSet = null;

        String productCode = "";
        String productName = "";
        String catalogCategory = "";
        float price = 0.0f;
        String description = "";
        String imageUrl = "";
        int count = 0;

        try {

            resultSet = statement.executeQuery(
                    "SELECT productCode, productName, category, price, description, imageURL, countItems from thereader.PRODUCT where PRODUCT.category ='" + pcategory + "'");
            while (resultSet.next()) {
                productCode = resultSet.getString("productCode");
                productName = resultSet.getString("productName");
                catalogCategory = resultSet.getString("category");
                price = resultSet.getFloat("price");
                description = resultSet.getString("description");
                imageUrl = resultSet.getString("imageURL");
                count = resultSet.getInt("countItems");
                
                Product product = new Product();
                product.setCategory(catalogCategory);
                product.setCountItems(count);
                product.setDescription(description);
                product.setImageURL(imageUrl);
                product.setPrice(price);
                product.setProductCode(productCode);
                product.setProductName(productName);
                                
                categoryproducts.add(product);
                System.out.println("Found product in PRODUCT table: " + productCode);
            }
        } catch (SQLException se) {
            System.out.println("ERROR: Could not exicute SQL statement in: " + "ProductDB.getAllCategoryProducts()");
            System.out.println("ERROR: Could not exicute SQL statement: " + se);
            return null;
        }

        return categoryproducts;
    }
    
    public static ArrayList<Product> getAllProducts() {
        ArrayList<Product> products = new ArrayList<Product>();

        Statement statement = DbAdmin.getNewStatement();
        ResultSet resultSet = null;

        String productCode = "";
        String productName = "";
        String catalogCategory = "";
        float price = 0.0f;
        String description = "";
        String imageUrl = "";
        int count = 0;

        try {

            resultSet = statement.executeQuery(
                    "SELECT productCode, productName, category, price, description, imageURL, countItems FROM thereader.product ORDER BY productCode");
            while (resultSet.next()) {
                productCode = resultSet.getString("productCode");
                productName = resultSet.getString("productName");
                catalogCategory = resultSet.getString("category");
                price = resultSet.getFloat("price");
                description = resultSet.getString("description");
                imageUrl = resultSet.getString("imageURL");
                count = resultSet.getInt("countItems");
                
                Product product = new Product();
                product.setCategory(catalogCategory);
                product.setCountItems(count);
                product.setDescription(description);
                product.setImageURL(imageUrl);
                product.setPrice(price);
                product.setProductCode(productCode);
                product.setProductName(productName);
                                
                
                products.add(product);
                System.out.println("Found product in PRODUCT table: " + productCode);
            }
        } catch (SQLException se) {
            System.out.println("ERROR: Could not exicute SQL statement in: " + "ProductDB.getAllProducts()");
            System.out.println("ERROR: Could not exicute SQL statement: " + se);
            return null;
        }

        return products;
    }
 
    
	
}



