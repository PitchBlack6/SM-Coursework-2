package com.neet.MapViewer;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class Controller {
	
	@FXML private Button something;
	@FXML private Canvas MapCanvas;

    @FXML private Text actiontarget;
    
    @FXML private ImageView item; //new image view
    private Image axeImage;
    private Image boatImage;
    public int mousex;
    public int mousey;
    public int itemID = 0; //creates flag to track current item ID
    
    @FXML protected void setAxe(ActionEvent event) {
        actiontarget.setText("Click to set Axe position.");
        itemID = 1; //sets itemID to ID for axe
    }
    @FXML protected void setBoat(ActionEvent event) {
        actiontarget.setText("Click to set Boat position.");
        itemID = 2; //sets itemID to ID for boat
    }
    @FXML protected void mousePosition(MouseEvent event) {
        	mousex = (int) (event.getScreenX()/16-34); // divide by 16 to make the coordinates the correct scale, -34 to correct for size of screen
        	mousey = (int) (event.getScreenY()/16-10); 
            drawItem(itemID,mousex,mousey); //draws the item to the mouseclick
            
        }
    
	
	private GraphicsContext graphics;
	
	private ModelMap modelMap;
	
	public Controller() {
		modelMap = new ModelMap();
		axeImage = SwingFXUtils.toFXImage(Content.ITEMS[1][1],null); // assign converted buffered image to axeimage
		boatImage = SwingFXUtils.toFXImage(Content.ITEMS[1][0],null); //assign converted boat buffered image to boat image
	}
	
	public void initialize() {
		graphics = MapCanvas.getGraphicsContext2D();
		modelMap.draw(graphics);

	}
	
	private void drawItem(int itemID, int x, int y) { //draw items
		switch (itemID) {
		case 0: actiontarget.setText("No item selected");
				break;
		case 1: graphics.drawImage(axeImage, x*16, y*16);
				actiontarget.setText("Placed Axe.");
				break;
		case 2: graphics.drawImage(boatImage, x*16, y*16);
				actiontarget.setText("Placed Boat.");
				break;
		default: actiontarget.setText("Invalid placement.");
				break;
		}
	}
	
	
}