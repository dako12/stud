package fpt.com.pcHardwareShop.view.home;


import fpt.com.pcHardwareShop.model.ModelShop;
import fpt.com.pcHardwareShop.model.Product;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


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
public class ViewShop extends HBox{
	
	
	private VBox root = new VBox();
	private HBox rootBtn = new HBox();
	
	private ListView<Product> listProd = new ListView<Product>();
	private Label nameLbl= new Label("Name : ");
	private Label priceLbl= new Label("Price : ");
	private Label countLbl = new Label("Count : ");
	private TextField nameTfd= new TextField();
	private TextField priceTfd= new TextField();
	private TextField countTfd = new TextField();
	private StringProperty strBtn = new SimpleStringProperty("add...");
	private Button addBtn = new Button();
	private Button delBtn = new Button("delete");
	
	
	public ViewShop() {
		
		rootBtn.getChildren().addAll(addBtn,delBtn);
		
		root.getChildren().addAll(nameLbl,nameTfd,priceLbl,priceTfd,countLbl,countTfd,rootBtn);
		
		getChildren().addAll(listProd,root);
		
		addBtn.textProperty().bind(strBtn);
		
		
		
		
		
		listProd.setCellFactory(c -> {

			ListCell<Product> cell = new ListCell<Product>() 
			{
				@Override
				protected void updateItem(Product myObject, boolean b) 
				{
					
					super.updateItem(myObject,  b);
					if (myObject != null) 
					{
						setText(myObject.getName()+ " | "+ myObject.getPrice()+"$" + " | "+ myObject.getQuantity());
					} 
					else
					{
						//util for the delete fonction
						setText("");
					}
				}

			};
			return cell;

		});
	}
	
	/**
	 * 
	 * @param eventHandler
	 */
	public void addBtnHandler(EventHandler<ActionEvent>  eventHandler)
	{
		addBtn.setOnAction(eventHandler);
	}
	
	
	/**
	 * 
	 * @param eventHandler
	 */
	public void delBtnHandler(EventHandler<ActionEvent> eventHandler){
		delBtn.addEventHandler(ActionEvent.ACTION, eventHandler);
	}

	
	/**
	 * 
	 * @return
	 */
	public String getNameTfdText() 
	{
		return nameTfd.getText();
	}

	
	/**
	 * 
	 * @return
	 */
	public String getPriceTfdText() 
	{
		return priceTfd.getText();
	}
	
	
	/**
	 * 
	 * @return
	 */
	public String getCountTfdText() 
	{
		return countTfd.getText();
	}
	
	
	/**
	 * 
	 * @param model
	 */
	public void bindData(ModelShop model)
	{
		//receives model data and update view
				listProd.setItems(model);			
	}
	
	
	/**
	 * Returns a product when an item is selected
	 * 
	 * @return the selected Product of the list
	 */
	public Product getListProdItem(){
		
	
		
		return listProd.getSelectionModel().getSelectedItem();
		
	}
	

}
