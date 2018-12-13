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
		primaryStage.setTitle("MapViewer");										//set title of window to Map Viewer
		root = new BorderPane();						
		
		Platform.setImplicitExit(false);										//map viewer is hidden when the user gets directed to main game
		
		initLayout();
		
		Scene scene = new Scene(root);
		primaryStage.setResizable(false);										//ensures size of window stays the same 
		primaryStage.setScene(scene); 											//specifies the scene to be used on the game
		primaryStage.setOnCloseRequest(event -> {Platform.setImplicitExit(true); }); //when the user closes the map viewer, the window will shut down and terminate the application
		primaryStage.show();													//displays the pane

	}
	
	public void initLayout() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MapMain.class.getResource("view_layout.fxml"));		//loads the fxml file
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
