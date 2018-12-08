package com.neet.MapViewer;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import java.awt.event.*;  

public class Controller {
	
	@FXML private Button something;
	@FXML private Canvas MapCanvas;

    @FXML private Text actiontarget;
    
    @FXML private ImageView item; //new image view
    private Image axeImage;
    private Image boatImage;
    public int mousex;
    public int mousey;
    public int itemID;
    
    @FXML protected void setAxe(ActionEvent event) {
        actiontarget.setText("Click to set Axe position.");
        itemID = 1;
    }
    @FXML protected void setBoat(ActionEvent event) {
        actiontarget.setText("Click to set Boat position.");
        itemID = 2;
    }
    @FXML protected void mousePosition(MouseEvent event) {
        	mousex = (int) (event.getScreenX()/16-34); 
        	mousey = (int) (event.getScreenY()/16-10); 
            drawItem(itemID,mousex,mousey); //test draw s axe to the middle of the map
        	actiontarget.setText(String.valueOf(mousex) + ", " + String.valueOf(mousey));
            
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
		if (itemID == 1)	
		{
			graphics.drawImage(axeImage, x*16, y*16);//*16 to convert to pixels
		}
		else if (itemID == 2)	
			{
			graphics.drawImage(boatImage, x*16, y*16);
			}
	}
	
	
}