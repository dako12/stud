package fpt.com.pcHardwareShop.model;



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
public class ModelShop extends ModifiableObservableListBase<Product>  {
	
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
	 * 
	 * 
	 * @param name
	 * @param price
	 * @param qty
	 */
	public void addProduct(String name, String price, String qty){
		Product newEntry = new Product(name,Double.parseDouble(price),Integer.parseInt(qty));
	    this.add(newEntry);
	}
	
	/**
	 * 
	 * @param p
	 */
	public void deleteProduct(Product p){
		this.remove(p);
	}
	
	
	

}
