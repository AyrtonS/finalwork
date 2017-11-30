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
	private static Object[][] newMatriz;
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

	}

	private void addFieldFirstGrid(int line, int column) {
		TextField textField = new TextField();
		textField.setMaxSize(80, 20);
		
		try{
			textField.setText(""+matriz.getMatriz()[line][column]);
		}catch (NullPointerException e) {
			textField.setText("0");
		}
		firstGrid.add(textField, column, line);

	}
	
	private void addFieldSecondGrid(int line, int column) {
		TextField textField = new TextField();
		textField.setMaxSize(80, 20);
		
		try{
			textField.setText(""+matriz.getMatriz()[line][column]);
		}catch (NullPointerException e) {
			textField.setText("0");
		}
		secondGrid.add(textField, line, column);

	}
	
	@FXML
	public void calculaTransposta() {
		ListIterator<Node> nodes = firstGrid.getChildren().listIterator();
		int i = 0;
		int j = 0;
		newMatriz = new Object[columnCount][lineCount];
		while (nodes.hasNext()) {
			TextField field = (TextField) nodes.next();
			if (!field.equals("")) {
				try {
					if(j<=lineCount-1){
						System.out.println("ENTROU");
						newMatriz[j][i] = Integer.parseInt(field.getText());
						j++;
						if(i == j){
							newMatriz[j][i] = Integer.parseInt(field.getText());
						}
					}
					else{
						j = 0;
						i++;

					}
					//System.out.println("linha:"+j+" | coluna:"+i+" | " +newMatriz[i][j]);

				} catch (IndexOutOfBoundsException e) {
						System.out.println("CRASH IN line = "+j + "and column = "+i);
				}

			} else {

			}

		}
		
		//System.out.println(newMatriz[0][0]);
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
