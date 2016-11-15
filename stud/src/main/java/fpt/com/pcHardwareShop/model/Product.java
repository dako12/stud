package fpt.com.pcHardwareShop.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;





/**
 * 
 * 
 * 
 * 
 * 
 * 
 * @author dakodak
 *
 */

public class Product implements fpt.com.Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StringProperty name = new SimpleStringProperty(" ");
	private DoubleProperty price = new SimpleDoubleProperty();
	private IntegerProperty quantity = new SimpleIntegerProperty();
	private long id;
	
	public Product() {
		
	}
	
	public  Product(String name, double price, int quantity) {
		setName(name);
		setPrice(price);
		setQuantity(quantity);
	}
	

	@Override
	public long getId() {
		
		return id;
	}

	@Override
	public void setId(long id) {
		
		this.id = id;
	}

	@Override
	public double getPrice() {
		
		return this.price.get();
	}

	@Override
	public void setPrice(double price) {
		
		this.price.set(price);
	}

	@Override
	public int getQuantity() {
		
		return this.quantity.get();
	}

	@Override
	public void setQuantity(int quantity) {
		
		this.quantity.set(quantity);
	}

	@Override
	public String getName() {
		
		return this.name.get();
	}

	@Override
	public void setName(String name) {
		
		this.name.set(name);
	}

	@Override
	public ObservableValue<String> nameProperty() {
		
		return name;
	}

	@Override
	public ObservableValue<Number> priceProperty() {
		
		return price;
	}

	@Override
	public ObservableValue<Number> quantityProperty() {
		
		return quantity;
	}

}
