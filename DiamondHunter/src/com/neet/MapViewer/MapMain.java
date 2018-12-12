package com.neet.MapViewer;

import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
public class MapMain extends Application{
	
	public static String[] args;
	
	public static Stage primaryStage; 
	private BorderPane root;		

	@Override
	public void start(Stage pStage) {
		primaryStage = pStage;
		primaryStage.setTitle("MapViewer");
		root = new BorderPane();
		
		Platform.setImplicitExit(false);
		
		initLayout();
		
		Scene scene = new Scene(root);
		primaryStage.setResizable(false);
		primaryStage.setScene(scene); 
		primaryStage.setOnCloseRequest(event -> {Platform.setImplicitExit(true); });
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
