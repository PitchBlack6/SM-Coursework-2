package com.neet.MapViewer;
//this class loads the sprites of the images and splits them
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Content {
	

	public static BufferedImage[][] ITEMS = load("/Sprites/items.gif", 16, 16); 			//loads the axe and boat
	public static BufferedImage[][] DIAMONDS = load("/Sprites/diamond.gif", 16, 16); 		//loads the diamonds
	public static BufferedImage[][] PLAYER = load("/Sprites/playersprites.gif", 16, 16);	//loads the character
	
	public static BufferedImage[][] load(String s, int w, int h) {
		BufferedImage[][] ret;
		try {
			BufferedImage spritesheet = ImageIO.read(Content.class.getResourceAsStream(s));
			int width = spritesheet.getWidth() / w;
			int height = spritesheet.getHeight() / h;
			ret = new BufferedImage[height][width];
			for(int i = 0; i < height; i++) {
				for(int j = 0; j < width; j++) {
					ret[i][j] = spritesheet.getSubimage(j * w, i * h, w, h);
				}
			}
			return ret;
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error loading graphics.");
			System.exit(0);
		}
		return null;
	}
	

	
}
