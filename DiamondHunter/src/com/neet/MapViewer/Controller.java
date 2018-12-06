package com.neet.MapViewer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
 
import com.neet.MapViewer.ModelMap;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class Controller {
	
	
	@FXML private Button something;
	@FXML private Canvas MapCanvas;

    @FXML private Text actiontarget;
    
    @FXML protected void setAxe(ActionEvent event) {
        actiontarget.setText("Click to set Axe position.");
    }
    @FXML protected void setBoat(ActionEvent event) {
        actiontarget.setText("Click to set Boat position.");
    }
    @FXML protected void mousePosition(MouseEvent event) {
        	int mousex = (int) (event.getScreenX()/1)-0; 
        	int mousey = (int) (event.getScreenY()/1)-0; 
            actiontarget.setText("Mouse click detected! \n Coordiantes: "+ String.valueOf(mousex) + ", " + String.valueOf(mousey));
        }
    
	
	private GraphicsContext graphics;
	
	private ModelMap modelMap;
	
	public Controller() {
		modelMap = new ModelMap();
	}
	
	public void initialize() {
		graphics = MapCanvas.getGraphicsContext2D();
		modelMap.draw(graphics);

	}

	
    
}
