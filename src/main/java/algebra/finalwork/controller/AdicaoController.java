package algebra.finalwork.controller;

import java.io.IOException;

import algebra.finalwork.view.FXML.FXMLResources;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AdicaoController {


	

@FXML
public void loadAddition(){
	
try {
	Parent root = FXMLLoader.load(FXMLResources.SUMSCREEN);
		
	Scene scene = new Scene(root,1366,720);
	
	Stage addingStage = new Stage();
	addingStage.setScene(scene);
	addingStage.centerOnScreen();
	addingStage.setTitle("Adição de Matrizes");
	addingStage.show();
	
	
	
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	
	
}

	
}
