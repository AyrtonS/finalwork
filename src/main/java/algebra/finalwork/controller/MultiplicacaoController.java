package algebra.finalwork.controller;

import java.net.URL;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;

import algebra.finalwork.model.Matriz;
import algebra.finalwork.multiplicacaoescalar.Escalar;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

public class MultiplicacaoController implements Initializable {

	@FXML
	private TextField line;
	@FXML
	private TextField col;
	@FXML
	private TextField escalar;
	@FXML
	private GridPane matrixNovaMultiplicada;
	@FXML
	private GridPane initGrid;
	@FXML
	private Button generate;
	@FXML
	private Button calculate;
	
	
	private static int linValue;
	private static int colValue;
	private static int escalarValue;

	@FXML
	public void onClickCalculate() {

		try {
			
			
			linValue = Integer.parseInt(line.getText());
			colValue = Integer.parseInt(col.getText());
			
			generate.setVisible(false);
			calculate.setVisible(true);
			
			for (int i = 0; i < linValue; i++) {
				RowConstraints rowConstraints = new RowConstraints();
				rowConstraints.setVgrow(Priority.SOMETIMES);
				initGrid.getRowConstraints().add(rowConstraints);
				
			}
			for (int j = 0; j < colValue; j++) {
				ColumnConstraints colConstraints = new ColumnConstraints();
				colConstraints.setHgrow(Priority.SOMETIMES);
				initGrid.getColumnConstraints().add(colConstraints);
			
			}
			
			for (int i = 0; i < colValue; i++) {
				for (int j = 0; j < linValue; j++) {
					addField(i, j);
				}
			}
			escalar.setDisable(false);

		} catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Formato incorreto, numero ");
			alert.show();
		}

	}
	
	@FXML
	private Matriz calculateMatriz() {
		escalarValue = Integer.parseInt(escalar.getText());
		

		

		Escalar escalar = new Escalar();

		double[][] matriz1 = mountMatriz();

		Matriz matriz = new Matriz();

		matriz.setMatriz(escalar.escalar(matriz1, linValue, colValue, escalarValue));
		

		for (int i = 0; i < linValue; i++) {
			RowConstraints rowConstraints = new RowConstraints();
			rowConstraints.setVgrow(Priority.SOMETIMES);
			matrixNovaMultiplicada.getRowConstraints().add(rowConstraints);
			
		}
		for (int j = 0; j < colValue; j++) {
			ColumnConstraints colConstraints = new ColumnConstraints();
			colConstraints.setHgrow(Priority.SOMETIMES);
			matrixNovaMultiplicada.getColumnConstraints().add(colConstraints);
		
		}
		
		for (int i = 0; i < colValue; i++) {
			for (int j = 0; j < linValue; j++) {
				addField(i, j,matriz);
			}
		}
		
		initialDesign();
		
		return matriz;
	}


	private void addField(int colIndex, int rowIndex) {
		TextField pane = new TextField();
		pane.setMaxSize(80, 20);
		pane.setOnMouseEntered(e -> {
			System.out.printf("Mouse enetered cell [%d, %d]%n", colIndex, rowIndex);
		});

		pane.setText("0");

		initGrid.add(pane, colIndex, rowIndex);

	}
	
	
	private void addField(int colIndex, int rowIndex, Matriz matriz) {
		TextField pane = new TextField();
		pane.setMaxSize(80, 20);
		pane.setOnMouseEntered(e -> {
			System.out.printf("Mouse enetered cell [%d, %d]%n", colIndex, rowIndex);
		});

		pane.setText(""+matriz.getMatriz()[rowIndex][colIndex]);

		matrixNovaMultiplicada.add(pane, colIndex, rowIndex);

	}
	
	
	private double[][] mountMatriz() {
		ListIterator<Node> firstNodes = initGrid.getChildren().listIterator();

		try {
			double[][] newMatriz = new double[colValue][linValue];
			int j = 0;
			int i = 0;
			while (firstNodes.hasNext()) {
				TextField field = (TextField) firstNodes.next();
				try {

					if (!field.getText().equals("")) {
					newMatriz[i][j] = Integer.parseInt(field.getText());
					j++;
					if(j>=linValue){
						j=0;
						i++;
					}
					}else{
						field.setText("0");
					}
				
				} catch (NumberFormatException numberEX) {
					System.err.println(numberEX);

				}
				
			}
	
			return newMatriz;
		} catch (NoSuchElementException e) {
			System.err.println("NO element" + e.getLocalizedMessage());
			return null;
		}
		

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		initialDesign();
		
	}

	private void initialDesign() {
		generate.setVisible(true);
		calculate.setVisible(false);
		
		escalar.setDisable(true);
	}


	

}
