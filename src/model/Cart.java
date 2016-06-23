package model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Cart implements Serializable{

	private Set orderItems;
	
	
	public void addItem(Product product, int quantity){
		
	}
	
	public void removeProduct(Product product){
		
	}
	
	public Set<OrderItem> getItems(){
		Set set = new HashSet();
		
		
		return set;
	}
	
	public void emptyCart(){
		
	}
	
	
	
}
