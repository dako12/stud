package fpt.com.pcHardwareShop.serialization;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import fpt.com.Product;
import fpt.com.SerializableStrategy;

public class XmlStrategy implements SerializableStrategy {

	
	private FileInputStream fileIn;
	private FileOutputStream fileOut;
	private XMLDecoder decoder;
	private XMLEncoder encoder;
	
	
	
	
	@Override
	public Product readObject() throws IOException {
		Product p = null;
		try {
			p = (Product) decoder.readObject();
			
		} catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}

		return p;
	}

	@Override
	public void writeObject(Product obj) throws IOException {
		encoder.writeObject(obj);
		encoder.flush();
		
	}

	@Override
	public void close() throws IOException {
		if (encoder != null)
			encoder.close();
		if (decoder != null)
			decoder.close();
		if (fileIn != null)
			fileIn.close();
		if (fileOut != null)
			fileOut.close();
		
	}

	@Override
	public void open(InputStream input, OutputStream output) throws IOException {
		if (input != null) {
			fileIn = (FileInputStream) input;
			decoder = new XMLDecoder(fileIn);
		}

		if (output != null) {
			fileOut = (FileOutputStream) output;
			encoder = new XMLEncoder(fileOut);
		}

		
	}

}
