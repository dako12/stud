package fpt.com.pcHardwareShop;

import fpt.com.pcHardwareShop.controller.ControllerShop;
import fpt.com.pcHardwareShop.model.ModelShop;
import fpt.com.pcHardwareShop.view.client.ViewCustomer;
import fpt.com.pcHardwareShop.view.home.ViewShop;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
public class Launcher extends Application 
	{
	
	public static void main(String[] args)
	{
		Application.launch(args);
	}
	
	
	@SuppressWarnings("unused")
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		
		ModelShop model = new ModelShop();
		
		ViewShop view = new ViewShop();
		
		ControllerShop ctrl = new ControllerShop(model, view);
		
		ViewCustomer viewCust = new ViewCustomer();
	
		Stage secondStage = new Stage();
		
		//create and display window(#viewShop and #customerShop)
		Scene sceneShop = new Scene(view,450,500);
		Scene sceneCust = new Scene(viewCust,470,500);
		
		
		primaryStage.setScene(sceneShop);
		secondStage.setScene(sceneCust);
		primaryStage.setTitle("PC Hardware Shop");
		secondStage.setTitle("PC Hardware Shop");
		primaryStage.show();
		secondStage.show();
			
	}

}
