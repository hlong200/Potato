package potato;

import java.util.ArrayList;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.tiled.TiledMap;

public class Game extends BasicGame {
	//Number constants
	private static final float GRAVITY = .5f;
	private static final int INTERATIONS = 10;
	private static final float JUMP = -12;
	
	//Arrays
	private ArrayList<Rectangle> tiles;
	
	//Objects
	private Map map;
	private Music bk;
	private Player player;
	private TiledMap tm;
	
	//Numbers
	private static int height;
	private int mapX = 0;
	private int mapY = 0;
	private static int width;
	private float xDisloc = 0;
	private float yDisloc = 0;
	
	//Set up the defaults
	public Game() {
		super("The Potato Game");
	}
	
	//Math snippet for finding an x2 and y2 a given dist from x1 and y1
	public void aimSetup(float x1, float y1, float x2, float y2, float dist) {
		
		float xDiff = x1 - x2;
		float yDiff = y1 - y2;
		float theta = (float) Math.atan(yDiff / xDiff);
		float newX = dist * (float) Math.cos(theta);
		float newY = dist * (float) Math.sin(theta);
		
	}
	
	//Collision detection for two rectangles
	public boolean isColliding(Rectangle r1, Rectangle r2) {
		
		boolean collision = false;
		if(r1.intersects(r2)) {
			
			collision = true;
			
		} else {
			
			collision = false;
			
		}
		return collision;
		
	}
	
	//Collision detection for a rectangle and a rectangle list
	public boolean isColliding(Rectangle r1, ArrayList<Rectangle> r2) {
		
		boolean collision = false;
		for(int i = 0; i < r2.size(); i++) {
			if(r1.intersects(r2.get(i))) {
				
				collision = true;
				break;
				
			} else {
				
				collision = false;
			
			}
		}
		return collision;
		
	}
	
	//Handle x and y movement and collision detection (need to add a temp rectangle)
	public void move(GameContainer gc) {
		
		//X acceleration
		if(gc.getInput().isKeyDown(Input.KEY_A) && gc.getInput().isKeyDown(Input.KEY_D)) {
			
			player.setVelX(0);
			
		} else if(gc.getInput().isKeyDown(Input.KEY_A)) {
			
			player.setVelX(-4);
			
		} else if(gc.getInput().isKeyDown(Input.KEY_D)) {
			
			player.setVelX(4);
			
		} else {
			
			player.setVelX(0);
			
		}
		
		//X collision detection
		float vXTmp = player.getVelX() / INTERATIONS;
		for(int i = 0; i < INTERATIONS; i++) {
			
			map.setX(map.getX() + vXTmp);
			for(int l = 0; l < tiles.size(); l++) {
				tiles.get(l).setX(tiles.get(l).getX() + vXTmp);
			}
			if(isColliding(player, tiles)) {
				
				map.setX(map.getX() - vXTmp);
				for(int l = 0; l < tiles.size(); l++) {
					tiles.get(l).setX(tiles.get(l).getX() - vXTmp);
				}
				player.setVelX(0);
				
			}
			
		}
		
		//Y acceleration
		player.setVelY(player.getVelY() + GRAVITY);
		if(gc.getInput().isKeyDown(Input.KEY_SPACE)) {
			
			map.setY(map.getY() + .5f);
			if(isColliding(player, tiles)) {
				
				player.setVelY(JUMP);
				
			}
			map.setY(map.getY() - .5f);
			
		}		
		
		//Y collision detection
		float vYTmp = player.getVelY() / INTERATIONS;
		for(int i = 0; i < INTERATIONS; i++) {
			
			map.setY(map.getY() + vYTmp);
			for(int l = 0; l < tiles.size(); l++) {
				tiles.get(l).setY(tiles.get(l).getY() + vYTmp);
			}
			if(isColliding(player, tiles)) {
				
				map.setY(map.getY() - vYTmp);
				for(int l = 0; l < tiles.size(); l++) {
					tiles.get(l).setY(tiles.get(l).getY() + vYTmp);
				}
				player.setVelY(0);
				
			}
			
		}
		
	}
	
	//Initialization
	@Override
	public void init(GameContainer gc) throws SlickException {
		
		tm = new TiledMap(System.getProperty("user.dir") + "/resources/big.tmx");
		map = new Map(tm, 0, 0);
		tiles = map.getSolids();
		//bk = new Music(System.getProperty("user.dir") + "/resources/Trans Siberian Orchestra- A Mad Russian's Christmas.ogg");
		player = new Player(64, 64, 14, 14, 5);
		
	}
	
	//Check inputs, collision detection, sprite movement, etcetera
	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		
		if(gc.getInput().isKeyPressed(Input.KEY_ESCAPE)) {
			
			System.exit(0);
			
		}
		move(gc);
		
		/**
		if(!bk.playing()) {
			
			bk.play();
			
		}
		**/
		
	}
	
	//Render loop
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		tm.render((int) -map.getX(), (int) -map.getY());
		g.drawImage(player.getImage().getScaledCopy(16, 16), width / 2, height / 2);
		
	}
	
	//Main method
	public static void main(String[] args) {
		
		try {
			
			AppGameContainer app = new AppGameContainer(new Game());
			height = app.getScreenHeight();
			width = app.getScreenWidth();
			app.setDisplayMode(width, height, false);
			app.setTargetFrameRate(59);
			app.setAlwaysRender(true);
			app.start();
			
		} catch(SlickException se) {
			
			se.printStackTrace();
			
		}
		
	}
}