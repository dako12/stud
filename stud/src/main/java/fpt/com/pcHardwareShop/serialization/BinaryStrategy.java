package fpt.com.pcHardwareShop.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import fpt.com.Product;


public class BinaryStrategy implements fpt.com.SerializableStrategy {
	
	private FileInputStream fileIn;
	private FileOutputStream fileOut;
	private ObjectInputStream in;
	private ObjectOutputStream out;

	@Override
	public Product readObject() throws IOException {
		Product p = null;
		try {
			
				p = (Product)in.readObject();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		
		}
		//System.out.println(p);
		return p;
	}

	@Override
	public void writeObject(Product obj) throws IOException {
		
		out.writeObject(obj);
		
		
		
	}

	@Override
	public void close() throws IOException {
		if (fileIn != null)
			fileIn.close();
		if (fileOut != null)
			fileOut.close();
		if (in != null)
			in.close();
		if (out != null)
			out.close();
		
	}

	@Override
	public void open(InputStream input, OutputStream output) throws IOException {
		if (input != null) {
			fileIn = (FileInputStream) input;
			in = new ObjectInputStream(fileIn);
		}
		if (output != null) {
			fileOut = (FileOutputStream) output;
			out = new ObjectOutputStream(fileOut);
		}
	}
		
		

}
