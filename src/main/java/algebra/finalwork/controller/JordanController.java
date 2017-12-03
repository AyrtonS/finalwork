package algebra.finalwork.controller;

import java.net.URL;
import java.util.ListIterator;
import java.util.ResourceBundle;

import algebra.finalwork.gaussjordan.Gaussjordan;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

public class JordanController implements Initializable {

	public static int LINHASM1;
	public static int COLUNASM1;

	@FXML
	private TextField n;
	@FXML
	private GridPane mainGrid;
	@FXML
	private GridPane resultGrid;

	private double[][] newMatriz;
	private double[][] eliminatedMatriz;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	@FXML
	private void generateM1Pane() {

		LINHASM1 = Integer.parseInt(n.getText());
		COLUNASM1 = LINHASM1 + 1;

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
				addField(j, i, mainGrid);

			}
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
		System.out.println("row : " + rowIndex + " | col :" + colIndex);
		pane.setText("" + eliminatedMatriz[rowIndex][colIndex]);

		grid.add(pane, colIndex, rowIndex);

	}

	@FXML
	private void check() {

		ListIterator<Node> items = mainGrid.getChildren().listIterator();

		int i = 0;
		int j = 0;
		newMatriz = new double[LINHASM1][COLUNASM1];
		try {

			while (items.hasNext()) {

				TextField field = (TextField) items.next();
				if (!field.equals("")) {
					if (j < LINHASM1) {
						System.out.println("------ : " + j);
						newMatriz[i][j] = Double.parseDouble(field.getText());
						System.out.println(newMatriz[i][j]);
						j++;
					}
					if (j == COLUNASM1 - 1) {
						j = 0;
						i++;
					}
					if (i == LINHASM1) {
						j = COLUNASM1 - 1;
						i = 0;
						newMatriz[i][j] = Double.parseDouble(field.getText());

					}
					if (j == COLUNASM1) {
						newMatriz[i][j] = Double.parseDouble(field.getText());
						i++;
					}
				}

			}

			for (int u =0; u < LINHASM1; u++) {
				for (int h=0; h < COLUNASM1; h++) {
					System.out.print(newMatriz[u][h]+" | ");
				}
				System.out.println("");
			}

			Gaussjordan jordan = new Gaussjordan(newMatriz);

			eliminatedMatriz = jordan.eliminate();
			System.out.println(jordan.toString());

		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		} finally {

			for (int k = 0; k < eliminatedMatriz.length; k++) {
				for (int v = 0; v < eliminatedMatriz[k].length; v++) {
					addFieldToResult(v, k, resultGrid);

				}
			}

		}

	}

}
