package fpt.com.pcHardwareShop.controller;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import fpt.com.SerializableStrategy;
import fpt.com.pcHardwareShop.model.ModelShop;
import fpt.com.pcHardwareShop.model.Product;
import fpt.com.pcHardwareShop.serialization.BinaryStrategy;
import fpt.com.pcHardwareShop.serialization.XStreamStrategy;
import fpt.com.pcHardwareShop.serialization.XmlStrategy;
import fpt.com.pcHardwareShop.view.home.ViewShop;

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
public class ControllerShop {
	
	private ModelShop model;
	private ViewShop view;
	
	String path = "";
	private SerializableStrategy strategy;
	
	/**
	 * Class constructor specifying the model and view</br> 
	 * to be use 
	 * 
	 * @param model  reference of the model to use
	 * @param view   reference of the view to use
	 */
	public ControllerShop(ModelShop model, ViewShop view)
	{
		this.model = model;
		this.view = view;
		
		//databing mit dem View
		view.bindData(model);
		
		//activation of controllers fonctionalities
		this.addBtnController();
		this.deleteBtnController();
		this.saveBtnController();
		this.loadBtnController();
	}
	
	
	/**
	 * 
	 */
	private void addBtnController()
	{
		
		//after new entry update view
		view.addBtnHandler(e -> {
			if((view.getPriceTfdText() > 0) && (view.getCountTfdText()>0) && (view.getNameTfdText().toString().compareTo("") != 0) ){
				
				model.addProduct(view.getNameTfdText(),view.getPriceTfdText(),view.getCountTfdText());
				view.clear();
			}else{
				view.alertNoInformation();
			}
		});
	}
	
	
	/**
	 * 
	 */
	private void deleteBtnController()
	{	
		view.delBtnHandler(e -> {
			
			model.deleteProduct(view.getListProdItem());
			
		});
	}
	
	/**
	 * 
	 */
	private void saveBtnController()
	{	
		view.saveBtnHandler(e -> {
			strategy = getStrategy();
			if (strategy == null)
				return;
			this.savingStrategy(path);
			
		});
		
		
	}
	
	/**
	 * 
	 */
	private void loadBtnController()
	{	
		view.loadBtnHandler(e -> {
			model.clear();
			strategy = getStrategy();
			if (strategy == null)
				return;
	this.loadingStrategy(path);
			
		});
	}
	
	private SerializableStrategy getStrategy() throws NullPointerException {
		try {
			switch (view.getStrategy()){
				case "binStrategy":		   	path = "products.ser";
											return strategy = new BinaryStrategy();
											
											
				
				case "XStreamStrategy":		path = "xproducts.xml";
											return strategy = new XStreamStrategy();
				
				case "xmlStrategy":			path = "products.xml";
											return strategy = new XmlStrategy();
			}
		} catch (NullPointerException e) {
			view.alertNoStrategy();
		}
		return null;
	}

	private void savingStrategy(String path) {
		try {
			strategy.open(null, new FileOutputStream(path));
			for (Product product : model) {
				strategy.writeObject(product);
			}
		} catch (EOFException e) {
			
		}
		catch (IOException e) {

			e.printStackTrace();
		}

		finally {
			try {
				strategy.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void loadingStrategy(String path) {
		try {
			strategy.open(new FileInputStream(path), null);
			Product nextObject = null;
			while ((nextObject = (Product) strategy.readObject()) != null ) {
				model.add(nextObject);
			    }
		    }catch(EOFException e){
			
		    } catch (IOException e) {
			view.alertLoading();
		} finally {
			try {
				strategy.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

}

}
