package algebra.finalwork.controller;

import java.io.IOException;

import algebra.finalwork.view.FXML.FXMLResources;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HomeScreenController {

	
	
	
	@FXML
	public void loadSubtraction() {

		try {
			Parent root = FXMLLoader.load(FXMLResources.SUBCREEN);

			Scene scene = new Scene(root, 1366, 720);

			Stage addingStage = new Stage();
			addingStage.setScene(scene);
			addingStage.centerOnScreen();
			addingStage.setTitle("Subtração de Matrizes");
			addingStage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
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
	public void loadEscalar() {

		try {
			Parent root = FXMLLoader.load(FXMLResources.MULTESCALARSCREEN);

			Scene scene = new Scene(root, 1366, 720);

			Stage addingStage = new Stage();
			addingStage.setScene(scene);
			addingStage.centerOnScreen();
			addingStage.setTitle("Multiplicação por Escalar");
			addingStage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	@FXML
	public void loadTransposta() {

		try {
			Parent root = FXMLLoader.load(FXMLResources.TRANSPOSTASCREEN);

			Scene scene = new Scene(root);

			Stage addingStage = new Stage();
			addingStage.setScene(scene);
			addingStage.centerOnScreen();
			addingStage.setTitle("Transposta");
			addingStage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
	@FXML
	public void loadMultimatrizes() {

		try {
			Parent root = FXMLLoader.load(FXMLResources.MULTIMATRIZ);

			Scene scene = new Scene(root);

			Stage addingStage = new Stage();
			addingStage.setScene(scene);
			addingStage.centerOnScreen();
			addingStage.setTitle("Multiplicação de Matrizes");
			addingStage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	@FXML
	public void loadDeterminante() {

		try {
			Parent root = FXMLLoader.load(FXMLResources.DETERMINANTE);

			Scene scene = new Scene(root);

			Stage addingStage = new Stage();
			addingStage.setScene(scene);
			addingStage.centerOnScreen();
			addingStage.setTitle("Determinantes");
			addingStage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@FXML
	public void loadLUScreen() {

		try {
			Parent root = FXMLLoader.load(FXMLResources.LUSCREEN);

			Scene scene = new Scene(root);

			Stage addingStage = new Stage();
			addingStage.setScene(scene);
			addingStage.centerOnScreen();
			addingStage.setTitle("Matriz LU");
			addingStage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
