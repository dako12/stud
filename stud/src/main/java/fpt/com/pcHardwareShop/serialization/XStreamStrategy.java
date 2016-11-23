package fpt.com.pcHardwareShop.serialization;

import java.beans.XMLDecoder;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import fpt.com.ExternalizableReflectionConverter;
import fpt.com.Product;
import fpt.com.SerializableStrategy;
import fpt.com.pcHardwareShop.model.ProductList;
import fpt.com.pcHardwareShop.util.SingleValueName;
import fpt.com.pcHardwareShop.util.SingleValuePrice;

/**
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
public class XStreamStrategy implements SerializableStrategy {

	private XStream xstream = new XStream(new DomDriver());
	int index = 0;
	
    ArrayList<Product> waren;
	private FileInputStream fi;
	private FileOutputStream fo;
	
	
	/**
	 * 
	 * Class constructor 
	 */
	public XStreamStrategy() {
		
	}
	
	
	
	@Override
	public Product readObject() throws IOException
	{
		try{
			return waren.get(index++);
			}catch(IndexOutOfBoundsException e){
				return null;
			}
	}

	@Override
	public void writeObject(Product obj) throws IOException
	{
		waren.add(obj);
		
	}

	@Override
	public void close() throws IOException
	{
		if (fi != null) {
			index = 0;
			fi.close();
		}
		if (fo != null) {
			xstream.toXML(waren,fo);
			fo.close();
}
		
		
	}

	@Override
	public void open(InputStream input, OutputStream output) throws IOException {
		
		
		xstream.registerConverter(new ExternalizableReflectionConverter(xstream), XStream.PRIORITY_LOW);
						
		if (input != null) {
			xstream = new XStream(new DomDriver());
			fi = (FileInputStream) input;
			waren = null;
			waren= (ProductList) xstream.fromXML(fi);
			
		}

		if (output != null) {
			xstream = new XStream(new DomDriver());
			fo = (FileOutputStream) output;
			
			//waren = new ArrayList<>();
			waren = new ProductList();
		}
	
	}
	
	
	

}
