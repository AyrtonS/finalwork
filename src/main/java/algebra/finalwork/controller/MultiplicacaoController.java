package algebra.finalwork.controller;

import algebra.finalwork.multiplicacaoescalar.Escalar;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class MultiplicacaoController {

	@FXML
	private TextField line;
	@FXML
	private TextField col;
	@FXML 
	private TextField escalar;
	
	
	@FXML
	public void onClickCalculate(){
		
		try{
			int escalarValue = Integer.parseInt(escalar.getText());
			double linValue = Double.parseDouble(line.getText());
			double colValue = Double.parseDouble(col.getText());
		}catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Formato incorreto, numero ");
			alert.show();
		}
		
		
	}
	
	
	
	
}
