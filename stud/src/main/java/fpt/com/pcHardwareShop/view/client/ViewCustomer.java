package fpt.com.pcHardwareShop.view.client;

import fpt.com.pcHardwareShop.model.Product;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
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
		
		
		rootBtn.getChildren().add(buyBtn);
		rootBtn.setPadding(new Insets(0,0,0,415));
		root.getChildren().addAll(listProd,tabProd);
		root.setSpacing(5);
		setPadding(new Insets(0, 0, 0, 4));
		
		setCenter(root);
		setBottom(rootBtn);
		
		
	}
}
