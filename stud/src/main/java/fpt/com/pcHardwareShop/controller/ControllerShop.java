package fpt.com.pcHardwareShop.controller;

import fpt.com.pcHardwareShop.model.ModelShop;
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
	}
	
	
	/**
	 * 
	 */
	private void addBtnController()
	{
		
		//after new entry update view
		view.addBtnHandler(e -> {
			
			model.addProduct(view.getNameTfdText(),view.getPriceTfdText(),view.getCountTfdText());
			
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

}
