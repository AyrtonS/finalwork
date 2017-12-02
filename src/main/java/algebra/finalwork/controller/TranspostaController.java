package algebra.finalwork.controller;

import java.net.URL;
import java.util.ListIterator;
import java.util.ResourceBundle;

import algebra.finalwork.inversa.Inversa;
import algebra.finalwork.model.Matriz;
import algebra.finalwork.transposicao.Transposicao;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

public class TranspostaController implements Initializable {

	@FXML
	private TextField lineField;
	@FXML
	private TextField columnField;
	@FXML
	private GridPane firstGrid;
	@FXML
	private GridPane secondGrid;
	@FXML
	private Button calculate;
	@FXML
	private Button generate;

	private static int lineCount;
	private static int columnCount;
	private static double[][] newMatriz;
	private static Matriz matriz = new Matriz();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		calculate.setVisible(false);
	}

	@FXML
	private void loadFistGrid() {

		lineCount = Integer.parseInt(lineField.getText());
		columnCount = Integer.parseInt(columnField.getText());

		for (int i = 0; i < lineCount; i++) {
			RowConstraints rowConstraints = new RowConstraints();
			rowConstraints.setVgrow(Priority.SOMETIMES);
			firstGrid.getRowConstraints().add(rowConstraints);
		}
		for (int j = 0; j < columnCount; j++) {
			ColumnConstraints columnConstraints = new ColumnConstraints();
			columnConstraints.setHgrow(Priority.SOMETIMES);
			firstGrid.getColumnConstraints().add(columnConstraints);
		}

		for (int i = 0; i < lineCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				addFieldFirstGrid(i, j);
			}
		}

		generate.setVisible(false);
		calculate.setVisible(true);
		lineField.setDisable(true);
		columnField.setDisable(true);
		if (!secondGrid.getChildren().isEmpty())
			secondGrid.getChildren().clear();
	}

	private void addFieldFirstGrid(int line, int column) {
		TextField textField = new TextField();
		textField.setMaxSize(30, 20);

		try {
			textField.setText("0");
		} catch (NullPointerException e) {
			textField.setText("0");
		}
		firstGrid.add(textField, column, line);

	}

	private void addFieldSecondGrid(int line, int column) {
		TextField textField = new TextField();
		textField.setMaxSize(30, 20);

		try {
			textField.setText("" + matriz.getMatriz()[line][column]);
		} catch (NullPointerException e) {
			textField.setText("0");
		}
		secondGrid.add(textField, column, line);

	}

	@FXML
	public void calculaTransposta() {
		ListIterator<Node> nodes = firstGrid.getChildren().listIterator();
		int i = 0;
		int j = 0;

		lineCount = Integer.parseInt(lineField.getText());
		columnCount = Integer.parseInt(columnField.getText());

		newMatriz = new double[lineCount][columnCount];
		while (nodes.hasNext()) {
			TextField field = (TextField) nodes.next();
			if (!field.equals("")) {
				try {
					if (lineCount < columnCount) {
						if (j <= lineCount) {
							System.out.println("ENTROU : " + i + " | " + j);
							newMatriz[i][j] = Integer.parseInt(field.getText());
							System.out.print(newMatriz[i][j]);
							System.out.print("|");
							j++;

						}
						if (i == columnCount && j == lineCount) {
							System.out.println("iguais : " + i + " | " + j);
							newMatriz[i][j] = Integer.parseInt(field.getText());
						}
						if (lineCount < j) {
							j = 0;
							i++;
							newMatriz[i][j] = Integer.parseInt(field.getText());
							System.out.println("");

						}
					} else {
						if (j < columnCount) {
							newMatriz[i][j] = Integer.parseInt(field.getText());
							System.out.println("i = " + i + " j = " + j + " | " + newMatriz[i][j]);
							j++;
						}
						if (i == lineCount && j == columnCount) {

						}
						if (j == columnCount) {
							i++;
							j = 0;
						}

					}

				} catch (IndexOutOfBoundsException e) {
					e.printStackTrace();
				}

			} else {

			}

		}
		matriz.setMatriz(Transposicao.transposicao(newMatriz, lineCount, columnCount));
		matriz.setLine(columnCount);
		matriz.setColumn(lineCount);

		Inversa inversa = new Inversa();

		if (lineCount == columnCount) {
			matriz.setQuadrada(true);
			matriz.setInversa(inversa.getInverted2x2Matrix(matriz));
		}

		else
			matriz.setQuadrada(false);

		loadSecondGrid();
		newMatriz = null;

		lineField.setDisable(false);
		columnField.setDisable(false);
		calculate.setVisible(false);
		generate.setVisible(true);

	}

	private void loadSecondGrid() {

		for (int i = 0; i < columnCount; i++) {
			RowConstraints rowConstraints = new RowConstraints();
			rowConstraints.setVgrow(Priority.SOMETIMES);
			secondGrid.getRowConstraints().add(rowConstraints);
		}
		for (int j = 0; j < lineCount; j++) {
			ColumnConstraints columnConstraints = new ColumnConstraints();
			columnConstraints.setHgrow(Priority.SOMETIMES);
			secondGrid.getColumnConstraints().add(columnConstraints);
		}

		for (int i = 0; i < columnCount; i++) {
			for (int j = 0; j < lineCount; j++) {
				addFieldSecondGrid(i, j);
			}
		}

	}

}
