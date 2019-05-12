package model.tile;

import java.awt.image.BufferedImage;

import model.Position;

public class Wall extends Tiles {

	public Wall(BufferedImage img, Position pos, int w, int h) {
		super(img, pos, w, h);
	}
	public void breakWall() {
		// do something
	}
}
