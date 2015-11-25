package potato;

import java.util.ArrayList;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

@SuppressWarnings("serial")
public class Player extends Rectangle {
	Game game;
	private float xVel;
	private float yVel;
	private Image sprite;
	private int health;
	private ArrayList<String> effects = new ArrayList<String>();

	public Player(float x, float y, float width, float height, int health) {
		super(x, y, width, height);
		try {
			sprite = new Image(System.getProperty("user.dir") + "/resources/potato-icon.png");
		} catch(SlickException se) {
			se.printStackTrace();
		}
		sprite = sprite.getScaledCopy(30, 30);
		this.health = health;
		xVel = 0;
		yVel = 0;
	}
	
	public float getVelX() {
		return this.xVel;
	}
	
	public float getVelY() {
		return this.yVel;
	}
	
	public void setVelX(float velX) {
		this.xVel = velX;
	}
	
	public void setVelY(float velY) {
		this.yVel = velY;
	}
	
	public ArrayList<String> getEffects() {
		return this.effects;
	}
	
	public void addEffect(String newEffect) {
		this.effects.add(newEffect);
	}
	
	public void removeEffect(String effect) {
		this.effects.remove(effect);
	}
	
	public Image getImage() {
		return this.sprite;
	}
	
	public void setImage(Image newIm) {
		this.sprite = newIm;
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public void setHealth(int newHealth) {
		this.health = newHealth;
	}
}
