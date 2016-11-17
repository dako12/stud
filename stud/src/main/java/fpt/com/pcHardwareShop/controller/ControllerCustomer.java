package fpt.com.pcHardwareShop.controller;

import fpt.com.pcHardwareShop.model.ModelShop;
import fpt.com.pcHardwareShop.view.client.ViewCustomer;

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
public class ControllerCustomer {
	
	private ModelShop model;
	private ViewCustomer viewCust;
	
	public ControllerCustomer(ModelShop model, ViewCustomer viewCust){
		this.model = model;
		this.viewCust = viewCust;
		
		viewCust.bindData(model);
		
		this.buyBtncontroller();
	}
	
	private void buyBtncontroller() {
		viewCust.buyBtnHandler(e->{
			
		});
	}
}
