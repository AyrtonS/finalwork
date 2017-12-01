package algebra.finalwork.controller;

import java.net.URL;
import java.util.ListIterator;
import java.util.ResourceBundle;

import algebra.finalwork.model.Matriz;
import algebra.finalwork.multiplicacao.Multiplica;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

public class MultiMatrizesController implements Initializable {

	@FXML
	private Button generateM1;
	@FXML
	private Button generateM2;
	@FXML
	private GridPane M1;
	@FXML
	private GridPane M2;
	@FXML
	private Button calculate;
	@FXML
	private TextField lintmf1;
	@FXML
	private TextField lintmf2;
	@FXML
	private TextField coltmf1;
	@FXML
	private TextField coltmf2;

	public static int LINHASM1;
	public static int COLUNASM1;

	public static int LINHASM2;
	public static int COLUNASM2;

	public static double[][] newMatrizM1;
	public static double[][] newMatrizM2;
	/**
	 * 
	 */

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		calculate.setVisible(false);

	}

	@FXML
	private void generateM1Pane() {

		LINHASM1 = Integer.parseInt(lintmf1.getText());
		COLUNASM1 = Integer.parseInt(coltmf1.getText());

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

	@FXML
	private void generateM2Pane() {

		LINHASM2 = Integer.parseInt(lintmf2.getText());
		COLUNASM2 = Integer.parseInt(coltmf2.getText());

		for (int i = 0; i < LINHASM2; i++) {
			RowConstraints rowConstraints = new RowConstraints();
			rowConstraints.setVgrow(Priority.SOMETIMES);
			M1.getRowConstraints().add(rowConstraints);
		}

		for (int j = 0; j < COLUNASM2; j++) {
			ColumnConstraints columnConstraints = new ColumnConstraints();
			columnConstraints.setHgrow(Priority.SOMETIMES);
			M1.getColumnConstraints().add(columnConstraints);
		}

		for (int i = 0; i < LINHASM2; i++) {
			for (int j = 0; j < COLUNASM2; j++) {
				addField(i, j, M2);

			}
		}

		calculate.setVisible(true);
	}

	private void check() {

		ListIterator<Node> items = M1.getChildren().listIterator();

		int i = 0;
		int j = 0;

		while (items.hasNext()) {

			TextField field = (TextField) items.next();
			if (!field.equals("")) {
				if (j < COLUNASM1) {
					newMatrizM1[i][j] = Double.parseDouble(field.getText());
				}
				if(j == COLUNASM1){
					j = 0;
					i++;
				}
			}

		}
		Matriz A = new Matriz();
		//A.setMatriz(newMatrizM1);
		
		

	}

	private double[][] calculate(Matriz A, Matriz B) {

		return Multiplica.multiplica(A.getMatriz(), A.getMatriz());

	}

	private void addField(int lines, int columns, GridPane pane) {
		TextField textField = new TextField();

		textField.setText("0");

		pane.add(textField, columns, lines);

	}

	@FXML
	public void onClickCalculate() {

	}

}
