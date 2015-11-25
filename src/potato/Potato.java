package potato;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class Potato extends Rectangle {
	private float xVel;
	private float yVel;
	private Image icon;

	public Potato(float x, float y, float width, float height, float velX, float velY) throws SlickException {
		super(x, y, width, height);
		this.icon = new Image(System.getProperty("user.dir") + "/resources/potato-icon.png").getScaledCopy(10, 10);
		this.xVel = velX;
		this.yVel = velY;
		
	}
	
	public void update() {
		this.setCenterX(this.getCenterX() + xVel);
		this.setCenterY(this.getCenterY() + yVel);
	}
	
	public Image getImage() {
		return icon;
	}

}
