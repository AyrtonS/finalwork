package algebra.finalwork.controller;

import java.net.URL;
import java.util.ListIterator;
import java.util.ResourceBundle;

import algebra.finalwork.eliminacaogaussiana.GaussianElimination;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

public class GaussController implements Initializable {

	public int LINHASM1;
	public int COLUNASM1;

	@FXML
	private TextField n;
	@FXML
	private GridPane mainGrid;
	@FXML
	private GridPane equalGrid;
	@FXML
	private GridPane resultGrid;

	private double[][] newMatriz;
	private double[] newVector;
	private double[] resultVector;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	@FXML
	private void generateM1Pane() {

		LINHASM1 = Integer.parseInt(n.getText());
		COLUNASM1 = LINHASM1;

		for (int i = 0; i < LINHASM1; i++) {
			RowConstraints rowConstraints = new RowConstraints();
			rowConstraints.setVgrow(Priority.SOMETIMES);
			mainGrid.getRowConstraints().add(rowConstraints);
		}

		for (int j = 0; j < COLUNASM1; j++) {
			ColumnConstraints columnConstraints = new ColumnConstraints();
			columnConstraints.setHgrow(Priority.SOMETIMES);
			mainGrid.getColumnConstraints().add(columnConstraints);
		}

		for (int i = 0; i < LINHASM1; i++) {
			for (int j = 0; j < COLUNASM1; j++) {
				addField(i, j, mainGrid);

			}
		}

		generateM2Pane();

	}

	@FXML
	private void generateM2Pane() {

		for (int j = 0; j < LINHASM1; j++) {
			ColumnConstraints columnConstraints = new ColumnConstraints();
			columnConstraints.setHgrow(Priority.SOMETIMES);
			equalGrid.getColumnConstraints().add(columnConstraints);
		}

		for (int i = 0; i < LINHASM1; i++) {
			addField(i, 0, equalGrid);

		}

	}

	private void addField(int colIndex, int rowIndex, GridPane grid) {
		TextField pane = new TextField();
		pane.setMaxSize(80, 20);
		pane.setOnMouseEntered(e -> {
			System.out.printf("Mouse enetered cell [%d, %d]%n", colIndex, rowIndex);
		});

		pane.setText("0");

		grid.add(pane, colIndex, rowIndex);

	}
	

	private void addFieldToResult(int colIndex, int rowIndex, GridPane grid) {
		TextField pane = new TextField();
		pane.setMaxSize(80, 20);
		pane.setOnMouseEntered(e -> {
			System.out.printf("Mouse enetered cell [%d, %d]%n", colIndex, rowIndex);
		});

		pane.setText(String.valueOf(resultVector[colIndex]));

		grid.add(pane, colIndex, rowIndex);

	}
	
	
	
	@FXML
	private void check() {

		ListIterator<Node> items = mainGrid.getChildren().listIterator();

		int i = 0;
		int j = 0;
		newMatriz = new double[LINHASM1][COLUNASM1];
		while (items.hasNext()) {

			TextField field = (TextField) items.next();
			if (!field.equals("")) {
				if (j < LINHASM1) {
					System.out.println("------ : "+j);
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

		System.out.println("------------------------------");

		ListIterator<Node> items2 = equalGrid.getChildren().listIterator();

		i = 0;
		j = 0;
		newVector = new double[LINHASM1];

		while (items2.hasNext()) {

			TextField field = (TextField) items2.next();
			if (!field.equals("")) {
				if (j < LINHASM1) {
					newVector[j] = Double.parseDouble(field.getText());
					System.out.println(newVector[j]);
					j++;
				}
				if (j == COLUNASM1) {
					j = 0;
					i++;
				}
			}

		}

		resultVector = GaussianElimination.EliminacaoGaussiana(newMatriz, newVector);

		for (int k = 0; k < LINHASM1; k++) {
			addFieldToResult(k, 0, resultGrid);
		}

	}

}
