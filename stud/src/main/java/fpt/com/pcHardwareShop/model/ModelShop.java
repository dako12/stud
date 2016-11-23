package fpt.com.pcHardwareShop.model;



import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import javafx.collections.ModifiableObservableListBase;


/**
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * @author dakodak
 *
 */
public class ModelShop extends ModifiableObservableListBase<Product> {
	
	private ProductList list = new ProductList() ;
	
	/**
	 * Class Constructor.
	 * 
	 */
	public ModelShop() {
		
	}

	@Override
	public Product get(int index) {
		
		return (Product) list.get(index);
	}

	@Override
	public int size() {
		
		return list.size();
	}

	@Override
	protected void doAdd(int index, Product element)
	{
		
		list.add(index, element);
		
	}

	@Override
	protected Product doSet(int index, Product element) 
	{
		
		return (Product) list.set(index, element);
	}

	@Override
	protected Product doRemove(int index) 
	{
		
		return (Product) list.remove(index) ;
	}
	
	/**
	 * Adds a new product in the shopping cart
	 *  
	 * @param name
	 * @param price
	 * @param qty
	 */
	public void addProduct(String name, double price, int qty){
		Product newEntry = new Product (name,price,qty);
	    this.add(newEntry);
	}
	
	/**
	 * Deletes the selected  product in the shopping cart 
	 * 
	 * @param p to delete
	 */
	public void deleteProduct(Product p){
		this.remove(p);
	}


	
	
	

}
