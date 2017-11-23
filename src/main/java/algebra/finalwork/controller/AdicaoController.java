package algebra.finalwork.controller;

import java.io.IOException;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import algebra.finalwork.model.Matriz;
import algebra.finalwork.utils.MatrizUtils;
import algebra.finalwork.view.FXML.FXMLResources;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AdicaoController {

	@FXML
	private GridPane grid;

	@FXML
	private GridPane secondPane;

	@FXML
	private TextField option;

	@FXML
	private GridPane thirdPane;

	@FXML
	private TextField lines;

	@FXML
	private TextField columns;

	@FXML
	public void loadAddition() {

		try {
			Parent root = FXMLLoader.load(FXMLResources.SUMSCREEN);

			Scene scene = new Scene(root, 1366, 720);

			Stage addingStage = new Stage();
			addingStage.setScene(scene);
			addingStage.centerOnScreen();
			addingStage.setTitle("Adição de Matrizes");
			addingStage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	public void createMatrix() {

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText("Olá, sou seu assistente\n Ao inserir o numero no campo aperte ENTER.\n"
				+ "A Matriz ao lado vai atualizar ja com o resultado... QUE MÁGICO;D");
		alert.show();

		Region p = new Region();
		p.setPrefSize(Double.MAX_VALUE, 0.0);

		int line = Integer.parseInt(lines.getText());
		int column = Integer.parseInt(columns.getText());

		for (int i = 0; i < column; i++) {
			ColumnConstraints colConstraints = new ColumnConstraints();
			colConstraints.setHgrow(Priority.SOMETIMES);
			grid.getColumnConstraints().add(colConstraints);
			secondPane.getColumnConstraints().add(colConstraints);
			thirdPane.getColumnConstraints().add(colConstraints);
		}

		for (int i = 0; i < line; i++) {
			RowConstraints rowConstraints = new RowConstraints();
			rowConstraints.setVgrow(Priority.SOMETIMES);
			grid.getRowConstraints().add(rowConstraints);
			secondPane.getRowConstraints().add(rowConstraints);
			thirdPane.getRowConstraints().add(rowConstraints);
		}

		for (int i = 0; i < column; i++) {
			for (int j = 0; j < line; j++) {
				addField(i, j);
			}
		}

	}

	private void addField(int colIndex, int rowIndex) {
		TextField pane = new TextField();
		pane.setMaxSize(80, 20);
		pane.setOnMouseEntered(e -> {
			System.out.printf("Mouse enetered cell [%d, %d]%n", colIndex, rowIndex);
		});

		TextField pane2 = new TextField();
		pane2.setMaxSize(80, 20);
		pane2.setOnMouseEntered(e -> {
			System.out.printf("Mouse enetered cell [%d, %d]%n", colIndex, rowIndex);
		});

		TextField pane3 = new TextField();
		pane3.setMaxSize(80, 20);
		pane3.setOnMouseEntered(e -> {
			System.out.printf("Mouse enetered cell [%d, %d]%n", colIndex, rowIndex);
		});

		pane.setOnKeyPressed(keyPressed());
		pane.setText("0");

		pane2.setOnKeyPressed(keyPressed());
		pane2.setText("0");

		grid.add(pane, colIndex, rowIndex);
		secondPane.add(pane2, colIndex, rowIndex);
		thirdPane.add(pane3, colIndex, rowIndex);
	}

	@FXML
	public EventHandler<Event> keyPressed() {
		return new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				ListIterator<Node> thridNodes = thirdPane.getChildren().listIterator();
				ListIterator<Node> secondNodes = secondPane.getChildren().listIterator();
				ListIterator<Node> firstNodes = grid.getChildren().listIterator();

				try {
					while (firstNodes.hasNext()) {
						TextField field = (TextField) thridNodes.next();
						TextField secondFields = (TextField) secondNodes.next();
						TextField firstFields = (TextField) firstNodes.next();

						int a = 0;
						int b = 0;
						if (!firstFields.getText().equals("") && !secondFields.getText().equals("")) {
							
							try{
								a = Integer.parseInt(firstFields.getText());
								b = Integer.parseInt(secondFields.getText());
								int result = a + b;

								field.setText(String.valueOf(result));
							}catch(NumberFormatException numberEX){
								System.err.println(numberEX);
								
							}
				

						} else {
							// int result = a+b;

							field.setText("0");
						}

					}
				} catch (NoSuchElementException e) {
					System.err.println("NO element" + e.getLocalizedMessage());
				}
				System.out.println("hs");

			}
		};
	}

}
