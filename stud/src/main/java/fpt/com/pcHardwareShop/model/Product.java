package fpt.com.pcHardwareShop.model;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import fpt.com.pcHardwareShop.MyException.IDOverflowException;
import fpt.com.pcHardwareShop.util.IDGenerator;
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
@XStreamAlias("product")
public class Product implements fpt.com.Product, Externalizable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XStreamAlias("name")
	@XStreamAsAttribute
	private StringProperty name = new SimpleStringProperty(" ");
	@XStreamAlias("price")
	@XStreamAsAttribute
	private DoubleProperty price = new SimpleDoubleProperty();
	@XStreamAlias("quantity")
	@XStreamAsAttribute
	private IntegerProperty quantity = new SimpleIntegerProperty();
	@XStreamAlias("id")
	@XStreamAsAttribute
	private long id;
	
	
	/**
	 * Class constructor
	 */
	public Product() {
		
	}
	
	
	/**
	 * Class constructor 
	 * 
	 * 
	 * @param name  
	 * @param price
	 * @param quantity
	 */
	public  Product(String name, double price, int quantity) {
		setName(name);
		setPrice(price);
		setQuantity(quantity);
		
		try {
			this.id = IDGenerator.generateID() ;
		} catch (IDOverflowException e) {
			
			e.printStackTrace();
		}
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

	
	/**
	 * 
	 * @since 18.11.
	 */
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(getName());
		out.writeDouble(getPrice());
		out.writeInt(getQuantity());
		
	}

	
	/**
	 * 
	 * @since 18.11.
	 */
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		setName((String)in.readObject());
		setPrice(in.readDouble());
		setQuantity(in.readInt());
		
		
	}

}
