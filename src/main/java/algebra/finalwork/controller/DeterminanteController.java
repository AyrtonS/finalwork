package algebra.finalwork.controller;

import java.net.URL;
import java.util.ListIterator;
import java.util.ResourceBundle;

import algebra.finalwork.determinanteatual.DeterminanteAtual;
import algebra.finalwork.determinantes.Determinante;
import algebra.finalwork.model.Matriz;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

public class DeterminanteController implements Initializable{
	
	@FXML
	private ComboBox<String> determinanteComboBox;
	
	@FXML 
	private static int LINHASM1;
	@FXML 
	private static int COLUNASM1;
	@FXML
	private GridPane matriz;
	@FXML
	private Button build;
	@FXML
	private Button calcular;
	@FXML
	private double newMatriz[][];
	@FXML
	private TextField resultField;
	@FXML
	private TextField line;
	@FXML
	private TextField col;
	
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	
	@FXML
	private void generateM1Pane() {
		
		if(!matriz.getChildren().isEmpty()){
			matriz.getChildren().clear();
		}
		
		LINHASM1 = Integer.parseInt(line.getText());
		COLUNASM1 = Integer.parseInt(col.getText());
		
		for (int i = 0; i < LINHASM1; i++) {
			RowConstraints rowConstraints = new RowConstraints();
			rowConstraints.setVgrow(Priority.SOMETIMES);
			matriz.getRowConstraints().add(rowConstraints);
		}

		for (int j = 0; j < COLUNASM1; j++) {
			ColumnConstraints columnConstraints = new ColumnConstraints();
			columnConstraints.setHgrow(Priority.SOMETIMES);
			matriz.getColumnConstraints().add(columnConstraints);
		}

		for (int i = 0; i < LINHASM1; i++) {
			for (int j = 0; j < COLUNASM1; j++) {
				addField(i, j, matriz);

			}
		}

	}
	
	
	private void addField(int lines, int columns, GridPane pane) {
		TextField textField = new TextField();

		textField.setText("0");

		pane.add(textField, columns, lines);

	}
	@FXML
	public void check(){
		ListIterator<Node> items = matriz.getChildren().listIterator();
		System.out.println(LINHASM1 + " | " + COLUNASM1);
		int i = 0;
		int j = 0;
		newMatriz = new double[LINHASM1][COLUNASM1];
		while (items.hasNext()) {

			TextField field = (TextField) items.next();
			if (!field.equals("")) {
				if (j < COLUNASM1) {
					newMatriz[i][j] = Double.parseDouble(field.getText());
					System.out.println(newMatriz[i][j]);
					j++;
				}
				if (j == COLUNASM1) {
					j = 0;
					i++;
				}
			}

		}
		Matriz m1 = new Matriz();
		double result = 0.0;
		m1.setMatriz(newMatriz);
		m1.setLine(LINHASM1);
		m1.setColumn(COLUNASM1);
		System.out.println("----"+newMatriz[0][0]);
			result = DeterminanteAtual.matrixDeterminant(newMatriz);

		
		System.out.println(result);
		resultField.setText(String.valueOf(result));
		
	}
	
	
}
