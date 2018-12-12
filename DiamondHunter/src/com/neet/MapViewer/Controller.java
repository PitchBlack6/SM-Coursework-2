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

import com.neet.DiamondHunter.Main.Game;

public class Controller {
	
	@FXML private Button something;
	@FXML private Canvas MapCanvas;

    @FXML private Text actiontarget;
    
    @FXML private ImageView item; //new image view
  
    public int mousex;
    public int mousey;
    public int itemID = 0; //creates flag to track current item ID
    
    private GraphicsContext graphics;
	private ModelMap modelMap;
	
	
	public Controller() {
		modelMap = new ModelMap();
	}
    
	
	public void initialize() {
		graphics = MapCanvas.getGraphicsContext2D();
		modelMap.draw(graphics);

	}
    
    @FXML protected void setAxe(ActionEvent event) {
        actiontarget.setText("Click to set Axe position");
        itemID = 1;
          
    }
    @FXML protected void setBoat(ActionEvent event) {
        actiontarget.setText("Click to set Boat position");
        itemID = 2; //sets itemID to ID for boat
    }
    
    @FXML protected void saveLocation(ActionEvent event) {
    	try {
    	File file = new File("Location.txt");
    	if(!file.exists()) {
				file.createNewFile();
			}
    	
    	PrintWriter pw = new PrintWriter(file);
    	pw.print(modelMap.getAxeRow() + " " + modelMap.getAxeCol() + "\n" + modelMap.getBoatRow() + " " + modelMap.getBoatCol());
    	pw.close();
    	
    	}
    	
    	catch(IOException e){
    		e.printStackTrace();
    	}
    		
    	
        actiontarget.setText("Location saved");
          
    }
    
    @FXML protected void setDefault(ActionEvent event) {
    	actiontarget.setText("Position set to default");
    	modelMap.setItemLocation(1, 26, 37, graphics);
    	modelMap.setItemLocation(2, 12, 4, graphics);
    }
    
    @FXML protected void startGame(ActionEvent event) {
    	MapMain.primaryStage.hide();
    	Game.main(null);
    }
    
    
    @FXML protected void mousePosition(MouseEvent event) {
        	int col = (int) (event.getSceneX()/16); 
        	int row = (int) (event.getSceneY()/16);
        	String message = modelMap.setItemLocation(itemID, row, col, graphics);
        	actiontarget.setText(message);
        	itemID = 0;
    }
}