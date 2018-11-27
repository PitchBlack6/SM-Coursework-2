package com.neet.MapViewer;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class MapMain extends Application{
	
	public Stage primaryStage; 
	private BorderPane root;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("MapViewer");
		root = new BorderPane();
		
		initLayout();
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene); 
		primaryStage.show();
	}
	
	public void initLayout() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MapMain.class.getResource("view_layout.fxml"));
		try {
			BorderPane pane = (BorderPane) loader.load();
			root = pane;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) {
		launch(args);
	}
	
	
	

}
