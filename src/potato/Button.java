package potato;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class Button extends Rectangle {
	private Image icon;

	public Button(float x, float y, float width, float height, String image) throws SlickException {
		super(x, y, width, height);
		this.icon = new Image(image);
		this.setCenterX(x);
		this.setCenterY(y);
	}
	
	public boolean hovering(float x, float y) {
		if(this.contains(x, y)) {
			return true;
		} else {
			return false;
		}
	}
	
	public Image getImage() {
		return this.icon;
	}

}
