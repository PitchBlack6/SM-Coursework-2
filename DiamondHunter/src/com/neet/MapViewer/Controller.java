package com.neet.MapViewer;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
    
    @FXML protected void setAxe(ActionEvent event) {
        actiontarget.setText("Click to set Axe position.");
        drawItem("axe",20,20); //test draws axe to the middle of the map
        						// just need to change the 20s to the mouse coordinates
    }
    @FXML protected void setBoat(ActionEvent event) {
        actiontarget.setText("Click to set Boat position.");
        drawItem("boat",20,20); // 20 is in tiles
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
		axeImage = SwingFXUtils.toFXImage(Content.ITEMS[1][1],null); // assign converted buffered image to axeimage
		boatImage = SwingFXUtils.toFXImage(Content.ITEMS[1][0],null); //assign converted boat buffered image to boat image
	}
	
	public void initialize() {
		graphics = MapCanvas.getGraphicsContext2D();
		modelMap.draw(graphics);

	}

	
	private void drawItem(String item, int x, int y) { //draw items
		if (item.equals("axe"))	
		{
			graphics.drawImage(axeImage, x*16, y*16);//*16 to convert to pixels
		}
		else 
			{
			graphics.drawImage(boatImage, x*16, y*16);
			}
	}
}
