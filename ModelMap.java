package com.neet.MapViewer;

import com.neet.DiamondHunter.TileMap.Tile;
import com.neet.DiamondHunter.TileMap.TileMap;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class ModelMap {
	
	private int tileSize; 
	public int [][] map;
	private Image [][] tileType;
	private Image axeImage;
	private Image boatImage;

	private TileMap tileMap;
	
	private int axeRow;
	private int axeCol;
	private int boatRow;
	private int boatCol;
	
	public ModelMap() {
		tileSize = 16;
		tileMap = new TileMap(tileSize);
		tileMap.loadTiles("/Tilesets/testtileset.gif");
		tileMap.loadMap("/Maps/testmap.map");

		loadTileFile();
		loadMapFile();
		
		axeImage = SwingFXUtils.toFXImage(Content.ITEMS[1][1],null); // assign converted buffered image to axeimage
		boatImage = SwingFXUtils.toFXImage(Content.ITEMS[1][0],null); //assign converted boat buffered image to boat image
	}
	
	
	private void loadTileFile() {
		Tile[][] mytile = tileMap.getTiles();
		tileType = new Image[mytile.length][mytile[0].length];
		
		for (int i=0; i<mytile.length ; i++) {
			for (int j=0; j<mytile[0].length ; j++) {
				Image temp = SwingFXUtils.toFXImage(mytile[i][j].getImage(), null);
				tileType[i][j] = temp;

			}
		}
		
		
	}
	
	private void loadMapFile() {
		map = tileMap.getMap();
	}
	
	
	
	public void draw(GraphicsContext a) {// make drawMap
		for (int i=0; i<map.length; i++) {
			for (int j=0; j<map.length; j++) {
				int temp2 = map[j][i];
				int row = temp2/20;
				int col = temp2%20;
				a.drawImage(tileType[row][col], i*tileSize, j*tileSize);
				
			}
			
		}
		
	}
	

	
//	private void drawItem(int itemID, int x, int y) { //draw items
//		switch (itemID) {
//		case 0: actiontarget.setText("No item selected");
//				break;
//		case 1: graphics.drawImage(axeImage, x*16, y*16);
//				actiontarget.setText("Placed Axe.");
//				break;
//		case 2: graphics.drawImage(boatImage, x*16, y*16);
//				actiontarget.setText("Placed Boat.");
//				break;
//		}
//	}
	
	
	
  	private boolean checkTile(int row, int col) {
		return map[row][col] < 20;
	}
	
	
	public void setItemLocation(int itemID, int row, int col, GraphicsContext a) {
		if(checkTile(row,col)) { //check if location correct
			if (itemID == 1) {// checks what item
				a.drawImage(tileType[map[axeRow][axeCol]/20][map[axeRow][axeCol]%20], axeCol*tileSize, axeRow*tileSize);
				axeRow = row;
				axeCol = col;
				a.drawImage(axeImage, axeCol*tileSize, axeRow*tileSize);
			}
			else if (itemID == 2) {
				a.drawImage(tileType[map[boatRow][boatCol]/20][map[boatRow][boatCol]%20], boatCol*tileSize, boatRow*tileSize);
				boatRow = row;
				boatCol = col;
				a.drawImage(boatImage, boatCol*tileSize, boatRow*tileSize);
			}
    	}
	}
}
