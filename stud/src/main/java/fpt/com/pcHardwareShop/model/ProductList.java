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
public class ProductList extends ArrayList<Product>  implements fpt.com.ProductList{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public ProductList() {
		
	}

	@Override
	public Iterator<Product> iterator() {
		
		return super.iterator();
	}

	@Override
	public boolean add(Product e)
	{
		
		return super.add(e);
	}

	@Override
	public boolean delete(Product product)
	{
		
		return super.remove(product);
	}

	@Override
	public int size() {
		
		return super.size();
	}

	@Override
	public Product findProductById(long id) 
	{
		
		Product foundProdruct = new fpt.com.pcHardwareShop.model.Product();
		
		for (Product product : this) {
			if (product.getId()==id) {
				foundProdruct = product;
			}else{
				return foundProdruct = null;
			}
		}
		
		return foundProdruct;
	}

	@Override
	public Product findProductByName(String name) 
	{
		
		Product foundProdruct = new fpt.com.pcHardwareShop.model.Product();
		
		for (Product product : this) {
			if (product.getName()==name) {
				foundProdruct = product;
			}else{
				return foundProdruct = null;
			}
		}
		
		return foundProdruct;
	}

	

}
