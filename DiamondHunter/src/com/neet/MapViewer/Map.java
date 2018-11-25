package com.neet.MapViewer;

import java.io.IOException;

import com.neet.DiamondHunter.TileMap.TileMap;
//import com.neet.MapViewer.Main.MapMain;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;


public class Map extends Application{
	public static Stage primaryStage; 
	public static TileMap tileMapViewer; 
	
	private BorderPane root;
    public TilePane tileOverview;

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("MapViewer");
		root = new BorderPane();
		
		initLayout();
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void initLayout() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Map.class.getResource("view/layout.fxml"));
		try {
			AnchorPane pane = (AnchorPane) loader.load();
			root.setCenter(pane);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void showMap() {
		tileMapViewer.loadTiles("/Tilesets/testtileset.gif");
		tileMapViewer.loadMap("/Maps/testmap.map");
		
		/*tileOverview.setPrefColumns(tileMapViewer.numCols);
		tileOverview.setPrefRows(tileMapViewer.numRows);
		tileMapViewer.initialiseCanvas();
		tileOverview.getChildren().add(tileMapViewer.currentCanvas);*/
	}
	
	public static void main(String args[]) {
		launch(args);
	}
	
	

}
