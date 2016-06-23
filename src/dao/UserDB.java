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

import model.User;

public class UserDB {
	
	public UserDB(){
		
		addData();
		//createUserTable();
		//addUser(m1.get("john@gmail.com"));
		//addUser(m1.get("nick@gmail.com"));
		
	}
	
	
	Map<String,User> m1 = new HashMap<String,User>();
		
	public void addData(){
		
		User u = new User();
		u.setEmailAddr("mayankjain.cs@gmail.com");
		u.setAddress1("University Terrace Dr.");
		u.setAddress2("9000 Apt - A");
		u.setCity("Charlotte");
		u.setCountry("USA");
		u.setFirstName("mayank");
		u.setLastName("jain");
		u.setZipcode("28262");
		u.setState("NC");
		u.setPassword("jain");
		
		User u1 = new User();
		u1.setEmailAddr("dummy.trial.2000@gmail.com");
		u1.setAddress1("University Terrace Dr.");
		u1.setAddress2("8001 Apt - D");
		u1.setCity("Charlotte");
		u1.setCountry("USA");
		u1.setFirstName("abhijeet");
		u1.setLastName("shedge");
		u1.setZipcode("28262");
		u1.setState("NC");
		u1.setPassword("shedge");
		
		
		m1.put("mayankjain.cs@gmail.com",u);
		m1.put("dummy.trial.2000@gmail.com", u1);
				
	}	
	
	public Map<String,User> getUsers(){
		return(m1);
	}
	
	public void createUserTable() {

        Statement statement = DbAdmin.getNewStatement();

        try {
            statement.execute("CREATE TABLE IF NOT EXISTS users("
                    + "userID INT NOT NULL AUTO_INCREMENT,firstName VARCHAR(50),"
                    + "lastName VARCHAR(50), emailAddr VARCHAR(50),"
                    + "address1 VARCHAR(50), address2 VARCHAR(50),"
                    + "city VARCHAR(50),state VARCHAR(50),zipcode VARCHAR(50),"
                    + "country VARCHAR(50), pass VARCHAR(50),"
                    + "PRIMARY KEY (userID))");

            System.out.println("Created a new table: " + "USER");
        } catch (SQLException se) {
            if (se.getErrorCode() == 30000 && "X0Y32".equals(se.getSQLState())) {
                // we got the expected exception when the table is already there
            } else {
                // if the error code or SQLState is different, we have an unexpected exception
                System.out.println("ERROR: Could not create USER table: " + se);
            }
        }
    }

    public void addUser(String firstName, String lastName, String email,
            String address1, String address2, String city, String state,
            String zipcode, String country,String password) {

        Connection connection = DbAdmin.getConnection();
        PreparedStatement insertRow;
        // insert the new row into the table
        try {
            insertRow = connection.prepareStatement("INSERT INTO users (firstName,lastName,emailAddr,address1,address2,city,state,zipcode,country,pass) "
            		+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            insertRow.setString(1, firstName);
            insertRow.setString(2, lastName);
            insertRow.setString(3, email);
            insertRow.setString(4, address1);
            insertRow.setString(5, address2);
            insertRow.setString(6, city);
            insertRow.setString(7, state);
            insertRow.setString(8, zipcode);
            insertRow.setString(9, country);
            insertRow.setString(10, password);
            insertRow.executeUpdate();

        } catch (Exception e) {
            System.out.println("ERROR: Could not insert record into USER "+e.toString());
            
        }
        

    }

    public User addUser(User user) {

        Connection connection = DbAdmin.getConnection();
        PreparedStatement ps;
        // insert the new row into the table
        try {
            ps = connection.prepareStatement("INSERT INTO users (firstName,lastName,emailAddr,address1,address2,city,state,zipcode,country,pass)  "
            		+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmailAddr());
            ps.setString(4, user.getAddress1());
            ps.setString(5, user.getAddress2());
            ps.setString(6, user.getCity());
            ps.setString(7, user.getState());
            ps.setString(8, user.getZipcode());
            ps.setString(9, user.getCountry());
            ps.setString(10, user.getPassword());
            ps.executeUpdate();

        } catch (Exception e) {
        	 System.out.println("ERROR: Could not insert record into USER "+e.toString());
            return null;
        }
        

        // return the  User object
        return user;
    }

    public User getUser(int userID) {

        Statement statement = DbAdmin.getNewStatement();
        ResultSet resultSet = null;

        String firstName = "";
        String lastName = "";
        String email = "";
        String address1 = "";
        String address2 = "";
        String city = "";
        String state = "";
        String zipcode = "";
        String country = "";
        
        String query = "";
        try {
            // Find the speciic row in the table
            query = "SELECT userID, firstName, lastName, email, address1, address2, city, state, zipcode, country FROM users WHERE userID ='" + userID + "' ORDER BY userName";

            resultSet = statement.executeQuery(query);
            if (!resultSet.next()) {
                System.out.println("WARNING: Could not find user in USER table: " + userID);
                return null;
            } else {
            	userID = resultSet.getInt("userID");
                firstName = resultSet.getString("firstName");
                lastName = resultSet.getString("lastName");
                email = resultSet.getString("email");
                address1 = resultSet.getString("address1");
                address2 = resultSet.getString("address2");
                city = resultSet.getString("city");
                state = resultSet.getString("state");
                zipcode = resultSet.getString("zipcode");
                country = resultSet.getString("country");

                System.out.println("Found user in user table: " + userID);
            }
        } catch (SQLException se) {
            System.out.println("ERROR: Could not exicute SQL statement: " + query);
            System.out.println("SQL error: " + se);
            return null;
        }

        return new User(userID, firstName, lastName, email, address1, address2, city, state, zipcode, country);
    }

    public static ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<User>();

        Statement statement = DbAdmin.getNewStatement();
        ResultSet resultSet = null;

        int userID = 0;
        String firstName = "";
        String lastName = "";
        String email = "";
        String address1 = "";
        String address2 = "";
        String city = "";
        String state = "";
        String zipcode = "";
        String country = "";
        try {
            // Find the speciic row in the table
            resultSet = statement.executeQuery(
                    "SELECT userID, firstName, lastName, emailAddr, address1Field, address2Field, city, state, zipPostalCode, country FROM thereader.users ORDER BY userID");
            while (resultSet.next()) {
                userID = resultSet.getInt("userID");
                firstName = resultSet.getString("firstName");
                lastName = resultSet.getString("lastName");
                email = resultSet.getString("emailAddr");
                address1 = resultSet.getString("address1Field");
                address2 = resultSet.getString("address2Field");
                city = resultSet.getString("city");
                state = resultSet.getString("state");
                zipcode = resultSet.getString("zipPostalCode");
                country = resultSet.getString("country");
                User user = new User(userID, firstName, lastName, email, address1, address2, city, state, zipcode, country);
                users.add(user);
                System.out.println("Found user in USER table: " + userID);
            }
        } catch (SQLException se) {
            System.out.println("ERROR: Could not exicute SQL statement in: " + "UserDB.getAllUsers()");
            System.out.println("ERROR: Could not exicute SQL statement: " + se);
            return null;
        }

        return users;
    }


    public void addNewUser(User newUser){
		User u = new User();
		u.setAddress1(newUser.getAddress1());
		u.setAddress2(newUser.getAddress2());
		u.setCity(newUser.getCity());
		u.setCountry(newUser.getCountry());
		u.setEmailAddr(newUser.getEmailAddr());
		u.setEmailAddr(newUser.getFirstName());
		u.setFirstName(newUser.getLastName());
		u.setLastName(newUser.getLastName());
		u.setPassword(newUser.getPassword());
		u.setState(newUser.getState());
		u.setUserID(newUser.getUserID());
		u.setZipcode(newUser.getZipcode());
		
		this.m1.put(u.getEmailAddr(),u);
	}
	
	public User checkUser(String e, String p){ // fname
		User foundUser = new User();
		Set<String> s = m1.keySet();
		Iterator itr = s.iterator();
		while(itr.hasNext()){
			String v = (String) itr.next();
			if(m1.get(v).getFirstName().equals(e)  &&  m1.get(v).getPassword().equals(p)){
				foundUser = m1.get(v);
				return foundUser;
			}
		}		
		return null;		
	}
	
	

}
