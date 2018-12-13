package com.neet.MapViewer;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import com.neet.DiamondHunter.Main.Game;

public class Controller {
	
	@FXML private Canvas MapCanvas;

    @FXML private Text actiontarget;
    
    @FXML private ImageView item; //new image view
  
    public int mousex; //stores the x coordinate
    public int mousey; //stores the y coordinate 
    public int itemID = 0; //creates indicator to track current item ID
    
    private GraphicsContext graphics;
	private ModelMap modelMap;
	
	
	public Controller() { //constructor 
		modelMap = new ModelMap();
	}
    
	
	public void initialize() { 
		graphics = MapCanvas.getGraphicsContext2D();
		modelMap.draw(graphics);
	}
    
	/**
	 * displays text when axe is set and sets itemID to 1 for axe
	 */
    @FXML protected void setAxe(ActionEvent event) {  
        actiontarget.setText("Click to set Axe position");
        itemID = 1;
          
    } 
    
    /**
   	 * displays text when boat is set and sets itemID to 2 for boat
   	 */
    @FXML protected void setBoat(ActionEvent event) {  
        actiontarget.setText("Click to set Boat position");
        itemID = 2; 
    }
    
    /**
	 * Saves the location of the axe and boat to file
	 */
    @FXML protected void saveLocation(ActionEvent event) {  
    	try {
    	File file = new File("Location.txt");
    	if(!file.exists()) {						//checks if file does not exist
				file.createNewFile();				//if it does not, create new file
			}
    	
    	PrintWriter pw = new PrintWriter(file);		//write to file 
    	//it writes the coordinates of axe and boat in the file
    	pw.print(modelMap.getAxeRow() + " " + modelMap.getAxeCol() + "\n" + modelMap.getBoatRow() + " " + modelMap.getBoatCol());
    	pw.close();
    	
    	}
    	
    	catch(IOException e){
    		e.printStackTrace();
    	}
    		
    	
        actiontarget.setText("Location saved");
          
    }
    
    /**
	 * resets the items to their default location
	 */
    @FXML protected void setDefault(ActionEvent event) { 
    	actiontarget.setText("Position set to default");
    	modelMap.setItemLocation(1, 26, 37, graphics); //when itemID = 1, the location is set to the values specified
    	modelMap.setItemLocation(2, 12, 4, graphics); //when itemID = 2, the location is set to the values specified
    }
    
    /**
	 * starts the game when start button is pressed
	 */
    @FXML protected void startGame(ActionEvent event) { 
    	MapMain.primaryStage.hide(); 				//hides the map viewer when the game is started
    	Game.main(null);
    }
    
    /**
	 * saves the mouse coordinates when mouse is clicked
	 */
    @FXML protected void mousePosition(MouseEvent event) { 
        	int col = (int) (event.getSceneX()/16); //column is obtained by dividing size of canvas by the pixels (16)
        	int row = (int) (event.getSceneY()/16); // row is obtained by dividing size of canvas by the pixels (16)
        	String message = modelMap.setItemLocation(itemID, row, col, graphics); //displays message depending on chosen item
        	actiontarget.setText(message); 
        	itemID = 0; 							//if no items are selected before clicking on the map
    }
}