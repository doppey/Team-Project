package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;

public class Terrain implements Commons, Position {
	
	private int xPos = 10;
	private int yPos = 100;
	
	private int width = 1100;
	private int height = 200;
	
	private BufferedImage spriteSheet;
	private BufferedImage[] sprites;
	private List<String> spriteNames;
	
	private int terrainNumberSelect;
	private int speed = 3;
	private int obstacleBorder = 100;
	private int minimumYPosition = 200;
	
	private Random randomYPosition;
	
	public Terrain(int xPos, int yPos){
		
		this.xPos = xPos;
		this.yPos = yPos; 
		
		spriteNames = new ArrayList<String>(Arrays.asList("xsmallTerrain", "smallTerrain", "regularTerrain", "mediumTerrain", 
				"largeTerrain", "xLargeTerrain"));
		
		loadImage(spriteNames.get(5).toString());
		
	}

	@Override
	public void setX(int xPos) {
		this.xPos = xPos;
	}

	@Override
	public int getX() {
		return xPos;
	}

	@Override
	public void setY(int yPos) {
		this.yPos = yPos;
		
	}

	@Override
	public int getY() {
		return yPos;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}
	
	public void incrementSpeed(){
		speed++;
	}
	
	public int getObstacleBorder() {
		
		return obstacleBorder;
	}
	
	public void update(){
		
		randomYPosition = new Random();
		terrainNumberSelect = randomYPosition.nextInt(spriteNames.size());
		
		if(xPos + width <= 0){
			
			updateTerrainWidth();
			loadImage(spriteNames.get(terrainNumberSelect).toString());
			setX(GAME_WIDTH);
			setY(randomYPosition.nextInt(GAME_HEIGHT - GAME_OBSTACLE_BORDER));
		   
			if(yPos < GAME_OBSTACLE_BORDER) {
			   
				yPos = minimumYPosition;
				yPos += randomYPosition.nextInt(yPos);
			}
		}
		
		xPos -= speed;
		
	}
	
	public void updateTerrainWidth() {
		
		switch(terrainNumberSelect) {
		
		case 0:
			
			width = 400;
			break;
		
		case 1:
			
			width = 500;
			break;
			
		case 2: case 3:
			
			width = 600;
			break;
			
		case 4: case 5:
			
			width = 800;
			break;
		
		}
	}
	
	public void loadImage(String fileName){
		
		try {
			spriteSheet = ImageIO.read(getClass().getResource(fileName +".png"));
		} catch (IOException ex) {
			ex.printStackTrace();
		}


		//final int rows = 1;
		//final int cols = 1;
		//sprites = new BufferedImage[rows * cols];

		//for (int i = 0; i < rows; i++) {
			//for (int j = 0; j < cols; j++) {
				//sprites[(i * cols) + j] = spriteSheet.getSubimage(j * width, i * height, width, height);
			//}
		//}

		
	}
	
	public void paintTerrain(Graphics g){
		
		//g.setColor(Color.BLACK);
	    //g.fillRect(xPos,yPos,width,height);
	    //g.setColor(Color.BLACK);
	    //g.drawRect(xPos,yPos,width,height);  
	    g.drawImage(spriteSheet,xPos,yPos,width,height, null);
	    //g.drawImage(img, x, y, observer)
	    
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
