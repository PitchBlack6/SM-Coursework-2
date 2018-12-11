package com.neet.MapViewer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Controller {
	
	@FXML private Button something;
	@FXML private Canvas MapCanvas;

    @FXML private Text actiontarget;
    
    @FXML private ImageView item; //new image view
  
    public int mousex;
    public int mousey;
    public int itemID = 0; //creates flag to track current item ID
  
	private ModelMap modelMap;
	
	
	public Controller() {
		modelMap = new ModelMap();
	}
  
	public void initialize() {
		graphics = MapCanvas.getGraphicsContext2D();
		modelMap.draw(graphics);

	}
    
    @FXML protected void setAxe(ActionEvent event) {
        actiontarget.setText("Click to set Axe position.");
        itemID = 1;
          
    }
    @FXML protected void setBoat(ActionEvent event) {
        actiontarget.setText("Click to set Boat position.");
        itemID = 2; //sets itemID to ID for boat
    
    @FXML protected void mousePosition(MouseEvent event) {
        	int col = (int) (event.getSceneX()/16); 
        	int row = (int) (event.getSceneY()/16);
    }
}