package potato;

import java.util.ArrayList;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.tiled.TiledMap;

public class Map {
	private ArrayList<Rectangle> solids = new ArrayList<Rectangle>();
	private ArrayList<Tile> nextMap = new ArrayList<Tile>();
	private float x;
	private float y;
	
	public Map(TiledMap curMap, float newX, float newY) {
		loadTiles(curMap);
		this.setX(newX);
		this.setY(newY);
	}
	
	public void loadTiles(TiledMap m) {
		@SuppressWarnings("unused")
		int width = m.getWidth();
		@SuppressWarnings("unused")
		int height = m.getHeight();
		for(int x = 0; x < m.getWidth(); x++) {
			for(int y = 0; y < m.getHeight(); y++) {
				if(m.getTileId(x, y, m.getLayerIndex("Objects")) == 2) {
					solids.add(new Tile(x * 16, y * 16, 16, 16));
				}
			}
		}
	}
	
	public ArrayList<Rectangle> getSolids() {
		return solids;
	}
	
	public ArrayList<Tile> getDoors() {
		return nextMap;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public void setX(float newX) {
		this.x = newX;
	}
	
	public void setY(float newY) {
		this.y = newY;
	}

}
