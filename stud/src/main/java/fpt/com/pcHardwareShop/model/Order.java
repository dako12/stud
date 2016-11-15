package fpt.com.pcHardwareShop.model;


import java.util.ArrayList;
import java.util.Iterator;
import fpt.com.Product;


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
 * @author dakodak
 *
 */

public class Order implements fpt.com.Order{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Product>  shoppingCart = new ArrayList<Product>();

	@Override
	public Iterator<Product> iterator() {
		
		return shoppingCart.iterator();
	}

	@Override
	public boolean add(Product e) {
		
		return shoppingCart.add(e);
	}

	@Override
	public boolean delete(Product p) {
		
		return shoppingCart.remove(p);
	}

	@Override
	public int size() {
		
		return shoppingCart.size();
	}

	@Override
	public Product findProductById(long id) {
		
		Product foundProdruct = new fpt.com.pcHardwareShop.model.Product();
		for (Product product : shoppingCart) {
			if (product.getId()==id) {
				foundProdruct = product;
			}else{
				return foundProdruct = null;
			}
		}
		
		return foundProdruct;
		
	}

	@Override
	public Product findProductByName(String name) {
		
		Product foundProdruct = new fpt.com.pcHardwareShop.model.Product();
		
		for (Product product : shoppingCart) {
			if (product.getName()==name) {
				foundProdruct = product;
			}else{
				return foundProdruct = null;
			}
		}
		
		return foundProdruct;
	}

	@Override
	public double getSum() {
		double sum = 0.0;
		for (Product product : shoppingCart) {
			sum += product.getPrice(); 
		}
		return sum;
	}

	@Override
	public int getQuantity() {
		int qty = 0;
		for (Product product : shoppingCart) {
			qty += product.getQuantity();
		}
		return qty;
	}

}
