package com.neet.MapViewer;

import com.neet.DiamondHunter.TileMap.Tile;
import com.neet.DiamondHunter.TileMap.TileMap;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class ModelMap {
	
	private int tileSize; 
	private int [][] map;
	private Image [][] tileType;

	private TileMap tileMap;
	
	public ModelMap() {
		tileSize = 16;
		tileMap = new TileMap(tileSize);
		tileMap.loadTiles("/Tilesets/testtileset.gif");
		tileMap.loadMap("/Maps/testmap.map");
		
		loadTileFile();
		loadMapFile();
		
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
	
	
	
	public void draw(GraphicsContext a) {
		for (int i=0; i<map.length; i++) {
			for (int j=0; j<map.length; j++) {
				int temp2 = map[j][i];
				int row = temp2/20;
				int col = temp2%20;
				a.drawImage(tileType[row][col], i*tileSize, j*tileSize);
				
			}
			
		}
		
	}
}
