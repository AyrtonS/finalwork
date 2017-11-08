package algebra.finalwork.controller;

import java.io.IOException;

import algebra.finalwork.view.FXML.FXMLResources;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AdicaoController {


@FXML
private TextField option;

@FXML
private Pane mainPane;

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

@FXML
public void buildScenario(){
	
	
	buildScenario(2,3);
	
} 

private void buildScenario(int column,int line){
	
	for(int i = 0 ; i < line-1 ; i++){
		for(int j = 0; j < column-1 ; j++){
			
			TextField op= new TextField();
			mainPane.getChildren().add(op);
			
		}
		
	}
	
	
}


	
}
