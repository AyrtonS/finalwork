package algebra.finalwork;


import algebra.finalwork.view.FXML.FXMLResources;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import algebra.finalwork.multiplicacaoescalar.Escalar;


/**
 * Hello world!
 *
 */
public class App extends Application{

	private static Stage appStage;
	
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
	    Parent root = FXMLLoader.load(FXMLResources.HOMESCREEN);
	    System.out.println(FXMLResources.HOMESCREEN);
	    Scene scene  = new Scene(root,615,437);
	    
		appStage = primaryStage;
		appStage.centerOnScreen();
		appStage.setTitle("Algebra Linear");
		appStage.setScene(scene);
		appStage.show();
		
	
	}
	
	

}
