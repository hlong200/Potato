package potato;

public class Camera {
	int x;
	int y;
	int width;
	int height;
	
	public Camera(int x, int y) {
		this.x = x;
		this.y = y;
		
	}
	
	public Camera(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
	}
	
	public int getX() {
		return x;
		
	}
	
	public int getY() {
		return y;
		
	}
	
	public int getWidth() {
		return width;
		
	}
	
	public int getHeight() {
		return height;
		
	}

}
