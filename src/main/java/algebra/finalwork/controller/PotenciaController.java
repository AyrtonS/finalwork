package algebra.finalwork.controller;

import java.net.URL;
import java.util.ListIterator;
import java.util.ResourceBundle;

import algebra.finalwork.model.Matriz;
import algebra.finalwork.potencia.Potencia;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

public class PotenciaController implements Initializable{
	
	
	@FXML
	private TextField lines;
	@FXML
	private TextField columns;
	@FXML
	private TextField expo;
	@FXML
	private GridPane M1;
	@FXML
	private GridPane M2;
	
	public static int LINHASM1;
	public static int COLUNASM1;
	public static double EXPONENT;
	public static double newMatrizM1[][];
	public static double result[][];
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	@FXML
	private void generateM1Pane() {

		LINHASM1 = Integer.parseInt(lines.getText());
		COLUNASM1 = Integer.parseInt(columns.getText());
		EXPONENT = Double.parseDouble(expo.getText());
		
		for (int i = 0; i < LINHASM1; i++) {
			RowConstraints rowConstraints = new RowConstraints();
			rowConstraints.setVgrow(Priority.SOMETIMES);
			M1.getRowConstraints().add(rowConstraints);
		}

		for (int j = 0; j < COLUNASM1; j++) {
			ColumnConstraints columnConstraints = new ColumnConstraints();
			columnConstraints.setHgrow(Priority.SOMETIMES);
			M1.getColumnConstraints().add(columnConstraints);
		}

		for (int i = 0; i < LINHASM1; i++) {
			for (int j = 0; j < COLUNASM1; j++) {
				addField(i, j, M1);

			}
		}

	}
	
	private void addField(int lines, int columns, GridPane pane) {
		TextField textField = new TextField();

		textField.setText("0");

		pane.add(textField, columns, lines);

	}
	
	private void addFieldToResult(int lines, int columns, GridPane pane) {
			
		TextField textField = new TextField();

		textField.setText(""+result[lines][columns]);

		pane.add(textField, columns, lines);
		
	}
	
	@FXML
	private void check() {

		ListIterator<Node> items = M1.getChildren().listIterator();

		int i = 0;
		int j = 0;
		newMatrizM1 = new double[LINHASM1][COLUNASM1];
		while (items.hasNext()) {

			TextField field = (TextField) items.next();
			if (!field.equals("")) {
				if (j < COLUNASM1) {
					newMatrizM1[i][j] = Double.parseDouble(field.getText());
					System.out.println(newMatrizM1[i][j]);
					j++;
				}
				if (j == COLUNASM1) {
					j = 0;
					i++;
				}
			}

		}
		Matriz matriz = new Matriz();
		matriz.setColumn(COLUNASM1);
		matriz.setLine(LINHASM1);
		matriz.setMatriz(newMatrizM1);
		
		result = Potencia.getExponentialMatrix(matriz,EXPONENT);
		generateM2Pane();
		
	}
	
	
	private void generateM2Pane() {


		for (int i = 0; i < LINHASM1; i++) {
			RowConstraints rowConstraints = new RowConstraints();
			rowConstraints.setVgrow(Priority.SOMETIMES);
			M2.getRowConstraints().add(rowConstraints);
		}

		for (int j = 0; j < COLUNASM1; j++) {
			ColumnConstraints columnConstraints = new ColumnConstraints();
			columnConstraints.setHgrow(Priority.SOMETIMES);
			M2.getColumnConstraints().add(columnConstraints);
		}

		for (int i = 0; i < LINHASM1; i++) {
			for (int j = 0; j < COLUNASM1; j++) {
				addFieldToResult(i, j, M2);

			}
		}

	}
		
	
}
