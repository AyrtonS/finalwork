package algebra.finalwork.controller;

import java.net.URL;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.ResourceBundle;

import algebra.finalwork.fatoracaoLU.LUDecomposition;
import algebra.finalwork.model.Matriz;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

public class LuController implements Initializable {

	public static int LINHASM1;
	public static int COLUNASM1;

	@FXML
	private TextField linField;
	@FXML
	private TextField colField;
	@FXML
	private GridPane firstGrid;
	@FXML
	private GridPane lGrid;
	@FXML
	private GridPane uGrid;

	private static double[][] newMatrizM1;
	private static double[][] newMatrizML;
	private static double[][] newMatrizMU;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	@FXML
	private void generateM1() {

		LINHASM1 = Integer.parseInt(linField.getText());
		COLUNASM1 = Integer.parseInt(colField.getText());

		if (LINHASM1 != COLUNASM1) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Os valores da linha e da coluna devem ser iguais e ser 2 ou 3");
			alert.show();
		} else {
			for (int i = 0; i < LINHASM1; i++) {
				RowConstraints rowConstraints = new RowConstraints();
				rowConstraints.setVgrow(Priority.SOMETIMES);
				firstGrid.getRowConstraints().add(rowConstraints);
			}

			for (int j = 0; j < COLUNASM1; j++) {
				ColumnConstraints columnConstraints = new ColumnConstraints();
				columnConstraints.setHgrow(Priority.SOMETIMES);
				firstGrid.getColumnConstraints().add(columnConstraints);
			}

			for (int i = 0; i < LINHASM1; i++) {
				for (int j = 0; j < COLUNASM1; j++) {
					addField(i, j, firstGrid);

				}
			}
		}
	}

	private void addField(int lines, int columns, GridPane pane) {
		TextField textField = new TextField();

		textField.setText("0");

		pane.add(textField, columns, lines);

	}

	private void addFieldToLGrid(int lines, int columns, GridPane pane) {
		TextField textField = new TextField();

		textField.setText("" + newMatrizML[lines][columns]);

		pane.add(textField, columns, lines);

	}

	private void addFieldToUGrid(int lines, int columns, GridPane pane) {
		TextField textField = new TextField();

		textField.setText("" + newMatrizMU[lines][columns]);

		pane.add(textField, columns, lines);

	}

	@FXML
	private void check() throws Exception {

		ListIterator<Node> items = firstGrid.getChildren().listIterator();

		int i = 0;
		int j = 0;
		newMatrizM1 = new double[LINHASM1][COLUNASM1];
		while (items.hasNext()) {

			TextField field = (TextField) items.next();
			if (!field.equals("")) {
				if (j < COLUNASM1) {
					newMatrizM1[i][j] = Double.parseDouble(field.getText());
					System.out.println("i = " + i + " : " + "j =" + j);
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
		matriz.setMatriz(newMatrizM1);
		HashMap<String, double[][]> mapping = new HashMap<>();

		mapping = LUDecomposition.LUDecompositonMethod(matriz, LINHASM1);

		if (mapping.containsKey("L")) {
			newMatrizML = mapping.get("L");
		} else
			throw new Exception("A chave L não existe no mapa");
		if (mapping.containsKey("U")) {
			newMatrizMU = mapping.get("U");
		} else
			throw new Exception("A chave U não existe no mapa");

		for (int k = 0; k < LINHASM1; k++) {
			for (int v = 0; v < COLUNASM1; v++) {
				addFieldToLGrid(k, v, lGrid);
			}
		}
		for (int k = 0; k < LINHASM1; k++) {
			for (int v = 0; v < COLUNASM1; v++) {
				addFieldToUGrid(k, v, uGrid);

			}
		}

	}

}
