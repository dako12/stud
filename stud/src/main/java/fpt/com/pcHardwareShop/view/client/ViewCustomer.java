package fpt.com.pcHardwareShop.view.client;

import fpt.com.pcHardwareShop.model.ModelShop;
import fpt.com.pcHardwareShop.model.Product;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;


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
public class ViewCustomer extends BorderPane{

	private HBox root = new HBox();
	private HBox rootBtn = new HBox();
	
	private TableView<String> tabProd = new TableView<>();
	private ListView<Product> listProd = new ListView<Product>();
	private Button buyBtn = new Button("Buy");
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ViewCustomer() {
		
		TableColumn name = new TableColumn("Name");
		
		name.setPrefWidth(80);
		TableColumn price = new TableColumn("Price");
		price.setPrefWidth(80);
		TableColumn buyCount = new TableColumn("Buy Count");
		buyCount.setPrefWidth(90);
		tabProd.getColumns().addAll(name,price,buyCount);
		listProd.setPrefWidth(200);
		
		
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
	
		
		
		rootBtn.getChildren().add(buyBtn);
		rootBtn.setPadding(new Insets(0,0,0,415));
		root.getChildren().addAll(listProd,tabProd);
		root.setSpacing(5);
		setPadding(new Insets(0, 0, 0, 4));
		
		setCenter(root);
		setBottom(rootBtn);
		
	
		
		
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
	
	public void buyBtnHandler(EventHandler<ActionEvent> eventHandler){
		buyBtn.setOnAction(eventHandler);
	}
	
}
