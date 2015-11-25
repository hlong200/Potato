package potato;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class Enemy extends Rectangle {
	
	private int health;
	private int strength;
	private Image icon;
	private float xVel;
	private float yVel;
	protected static final int interations = 5;
	protected static final float G = .5f;

	public Enemy(float x, float y, float width, float height, int health, int strength, String image) throws SlickException {
		super(x, y, width, height);
		this.icon = new Image(image);
	}
	
	public float getHealth() {
		return health;
	}
	
	public void setHealth(int newHealth) {
		this.health = newHealth;
	}
	
	public int getStrength() {
		return strength;
	}
	
	public void setStrength(int newStrength) {
		this.strength = newStrength;
	}
	
	public Image getImage() {
		return this.icon;
	}
	
	public void setImage(Image im) {
		this.icon = im;
	}
	
	public float getVelX() {
		return xVel;
	}
	
	public void setVelX(float velX) {
		this.xVel = velX;
	}
	
	public float getVelY() {
		return yVel;
	}
	
	public void setVelY(float velY) {
		this.yVel = velY;
	}

}
