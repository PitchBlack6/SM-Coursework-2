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
	private GraphicsContext graphics;
	private ModelMap modelMap;
    private Image axeImage;
    private Image boatImage;
    public int mousex;
    public int mousey;
    public int itemID = 0;
    
    
    @FXML protected void setAxe(ActionEvent event) {
        actiontarget.setText("Click to set Axe position.");
        itemID = 1;
          
    }
    @FXML protected void setBoat(ActionEvent event) {
        actiontarget.setText("Click to set Boat position.");
        itemID = 2;
       
    }
    @FXML protected void mousePosition(MouseEvent event) {
        	int x = (int) (event.getSceneX()/16); 
        	int y = (int) (event.getSceneY()/16);
        	if(checkTile(x,y)) {
        		mousex = x;
        		mousey = y;
        		drawItem(mousex,mousey); //test draw s axe to the middle of the map
        	}
        	else {
        		actiontarget.setText("Invalid placement");
        	}
        }

	
	public void initialize() {
		graphics = MapCanvas.getGraphicsContext2D();
		modelMap.draw(graphics);

	}
	
	
	public Controller() {
		modelMap = new ModelMap();
		axeImage = SwingFXUtils.toFXImage(Content.ITEMS[1][1],null); // assign converted buffered image to axeimage
		boatImage = SwingFXUtils.toFXImage(Content.ITEMS[1][0],null); //assign converted boat buffered image to boat image
	}
	
	private void drawItem(int x, int y) { //draw items
		switch (itemID) {
		case 0: actiontarget.setText("No item selected");
				break;
		case 1: graphics.drawImage(axeImage, x*16, y*16);
				actiontarget.setText("Placed Axe.");
				break;
		case 2: graphics.drawImage(boatImage, x*16, y*16);
				actiontarget.setText("Placed Boat.");
				break;
		}
	}
	
	private boolean checkTile(int x, int y) {
		return modelMap.map[y][x] < 20;
	}
	
	
	
	
}