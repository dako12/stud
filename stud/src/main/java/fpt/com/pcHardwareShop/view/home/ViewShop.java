package fpt.com.pcHardwareShop.view.home;


import fpt.com.pcHardwareShop.model.ModelShop;
import fpt.com.pcHardwareShop.model.Product;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
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
public class ViewShop extends BorderPane{
	
	private HBox root = new HBox();
	private VBox rootInput = new VBox();
	private HBox rootStrategy = new HBox();
	private HBox rootControlBtn = new HBox();
	
	private ListView<Product> listProd = new ListView<Product>();
	private Label nameLbl= new Label("Name : ");
	private Label priceLbl= new Label("Price : ");
	private Label countLbl = new Label("Count : ");
	private TextField nameTfd= new TextField();
	private TextField priceTfd= new TextField();
	private TextField countTfd = new TextField();
	private Button addBtn = new Button("add...");
	private Button delBtn = new Button("delete");
	private Button saveBtn = new Button("speichern");
	private Button loadBtn = new Button("Laden");
	private final ChoiceBox<String> strategyChoice = new ChoiceBox<>(FXCollections.observableArrayList("binStrategy","xmlStrategy","XStreamStrategy"));
	
	/**
	 * Class Constructor
	 */
	public ViewShop() {
		
		//--------------------------------------------------------
		//create window
		//--------------------------------------------------------
		rootControlBtn.getChildren().addAll(addBtn,delBtn);
		rootControlBtn.setPadding(new Insets(3,0,0,70));
		rootControlBtn.setSpacing(5);
		
		rootStrategy.getChildren().addAll(strategyChoice,loadBtn,saveBtn);
		rootStrategy.setSpacing(10);
		rootStrategy.setPadding(new Insets(0,4,1,4));
		
		
		rootInput.getChildren().addAll(nameLbl,nameTfd,priceLbl,priceTfd,countLbl,countTfd,rootControlBtn);
		
		strategyChoice.setTooltip(new Tooltip("Select a strategy!"));
		strategyChoice.setPrefWidth(200);
		
		root.getChildren().addAll(listProd,rootInput);
		root.setSpacing(5);
		setTop(rootStrategy);
		setCenter(root);
		
								
				
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
						
						setText("");
					}
				}

			};
			return cell;

		});
		
		
	}
	
	//----------------------------------------------------
	//help methods
	//----------------------------------------------------
	
	/**
	 * Returns the selected strategy for saving
	 * @return the value in the choice box
	 */
	public String getStrategy(){					
		return strategyChoice.getValue();
	}
	
	/**
	 * @param eventHandler for the button add
	 */
	public void addBtnHandler(EventHandler<ActionEvent>  eventHandler)
	{
		addBtn.setOnAction(eventHandler);
	}
	
	
	/**
	 * @param eventHandler for the button delete
	 */
	public void delBtnHandler(EventHandler<ActionEvent> eventHandler){
		delBtn.addEventHandler(ActionEvent.ACTION, eventHandler);
	}
	
	
	/**
	 * @param eventHandler for the button save
	 */
	public void saveBtnHandler(EventHandler<ActionEvent> eventHandler)
	{
		saveBtn.addEventHandler(ActionEvent.ACTION, eventHandler);
	}
	
	
	/**
	 * @param eventHandler for the button load
	 */
	public void loadBtnHandler(EventHandler<ActionEvent> eventHandler)
	{
		loadBtn.addEventHandler(ActionEvent.ACTION, eventHandler);
	}

	
	/**
	 * Returns the name of the product
	 * @return the text in the textfield's name
	 */
	public String getNameTfdText() 
	{
		  return  nameTfd.getText();
	}
	

	
	/**
	 * Returns the price of the product
	 * @author dakodak
	 * @return the entered value
	 * @since 18.11. #modification for a better handling of the exception
	 */
	public double getPriceTfdText() 
	{
		try {
			return Double.parseDouble(priceTfd.getText());
		} catch (java.lang.NumberFormatException e) {
			
			// return -1 to differ from 0 because of NoQuantity or noPrice
			return -1d;
		}
		
	}
	
	
	/**
	 * Returns the quantity of the product
	 * @author dakodak
	 * @since 18.11. #modification for a better handling of the exception
	 * @return the entered number in the textfield 
	 */
	public int getCountTfdText() 
	{
		try {
			return Integer.parseInt(countTfd.getText());
			
		} catch (java.lang.NumberFormatException e) {
			
			// return -1 to differ from 0 because of NoQuantity or noPrice
			return -1;
			}
	}
	
	/**
	 * clears the Textfields 
	 */
	public void clear(){
		nameTfd.clear();
		priceTfd.clear();
		countTfd.clear();
	}
	
	
	/**
	 * binds the model to view
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
	public Product getListProdItem()
	{	
		return listProd.getSelectionModel().getSelectedItem();		
	}
	
	
	/**
	 * Alert message No Price or No quantity</br>
	 * happens when the price or the name or the count wasn't specified 
	 */
	public void alertNoInformation()
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Error no complete fields  ");
		alert.setHeaderText(null);
		alert.setContentText("Please You have probably forgotten to fill a field or your entry is not correct");

		alert.showAndWait();
	}
	
	
	/**
	 * Alert message Loading</br>
	 * happens when an error occurred while loading
	 */
	public void alertLoading()
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText("Error while loading. The file doesn't exist.");

		alert.showAndWait();
	}
	
	
	/**
	 * Alert message Strategy</br>
	 * happens if no strategy exists
	 */
	public void alertNoStrategy()
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText("No Strategy chosen. You have to select a strategy!");

		alert.showAndWait();
	}
	

}
