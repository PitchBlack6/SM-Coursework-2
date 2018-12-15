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
	private Image diamondImage;
	private Image playerImage;

	private TileMap tileMap;
	
	private int axeRow;
	private int axeCol;
	private int boatRow;
	private int boatCol;
	
	//initializing the coordinates of the diamonds in the map
	public static final int[][] diamond_coords = new int [][] { {20,20}, {12,36}, {28,4}, {4,34}, {28,19}, {35,26}, {38,36}, {27,28}, {20,30},
																{14,25}, {4,21}, {9,14}, {4,3}, {20,14}, {13,20} };
			
	
	
	/**
     * Loads the tiles and map and assigns the items to axeImage/boatImage
     */
	public ModelMap() {
		
		tileSize = 16;									//setting the tilesize to 16 pixels
		tileMap = new TileMap(tileSize);				
		tileMap.loadTiles("/Tilesets/testtileset.gif"); //loads the tile file
		tileMap.loadMap("/Maps/testmap.map");			//loads the map file

		loadTileFile();
		loadMapFile();
		
		
		axeImage = SwingFXUtils.toFXImage(Content.ITEMS[1][1],null); // assign converted buffered image to axeimage
		boatImage = SwingFXUtils.toFXImage(Content.ITEMS[1][0],null); //assign converted boat buffered image to boat image
		diamondImage = SwingFXUtils.toFXImage(Content.DIAMONDS[0][3], null); //assign converted diamond buffered image to diamond image
		playerImage = SwingFXUtils.toFXImage(Content.PLAYER[0][0], null); //assign converted player buffered image to player image
	}
	
	/**
     * loads the tiles
     */
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
	
	/**
     * Loads the map
     */
	private void loadMapFile() {
		map = tileMap.getMap();
	}

	/**
     * Draws the map
     */
	public void draw(GraphicsContext a) {
		for (int i=0; i<map.length; i++) {
			for (int j=0; j<map.length; j++) {
				int temp2 = map[j][i];
				int row = temp2/20;				//row is obtained by dividing the number of row with the array size in the tileset
				int col = temp2%20;				//row is obtained by finding the modulus of the number of row with the array size in the tileset
				a.drawImage(tileType[row][col], i*tileSize, j*tileSize);
				
			}
			
		}
		
		for (int dRow=0; dRow <diamond_coords.length ; dRow++) {
				a.drawImage(diamondImage, diamond_coords[dRow][1]*tileSize, diamond_coords[dRow][0]*tileSize); //draws the diamonds on the map viewer
			}
		
		a.drawImage(playerImage, 17*tileSize,  17*tileSize); //draws the character on the map viewer
		
	}
	
	
	/**
     * Checks if the tile is suitable to place items (e.g not on trees and water)
     * @param row
     * @param col
     */
  	private boolean checkTile(int row, int col) {
		return map[row][col] < 20;		//returns true if tile number is lesser than 20 in the tileset
	}
	
  	/**
     * Replaces the old item sprite if placed and places the item on the new selected tile
     * @param itemID
     * @param row
     * @param col
     * @param GraphicsContext
     */
  	public String setItemLocation(int itemID, int row, int col, GraphicsContext a) {
        if(checkTile(row,col)) { //check if location correct
            switch (itemID) {// checks what item
            	case 0 : return "No item selected";
                case 1: {
                    a.drawImage(tileType[map[axeRow][axeCol]/20][map[axeRow][axeCol]%20], axeCol*tileSize, axeRow*tileSize); //replaces the item with
                                                                                                                            //a grass tile
                    axeRow = row;
                    axeCol = col;
                    a.drawImage(axeImage, axeCol*tileSize, axeRow*tileSize);
                    return "Placed axe";
                }
                case 2: {
                    a.drawImage(tileType[map[boatRow][boatCol]/20][map[boatRow][boatCol]%20], boatCol*tileSize, boatRow*tileSize);
                    boatRow = row;
                    boatCol = col;
                    a.drawImage(boatImage, boatCol*tileSize, boatRow*tileSize);
                    return "Placed boat";
                }
            }
        }
        return "Invalid placement";
    }
	
  	/**
     * Returns axeRow
     */
	public int getAxeRow() {
		return axeRow;
	}

	/**
     * Returns axeCol
     */
	public int getAxeCol() {
		return axeCol;
	}

	/**
     * Returns boatRow
     */
	public int getBoatRow() {
		return boatRow;
	}

	/**
     * Returns boatCol
     */
	public int getBoatCol() {
		return boatCol;
	}
	
		
	
}



