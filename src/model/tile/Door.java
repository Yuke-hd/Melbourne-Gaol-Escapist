package model.tile;

import java.awt.image.BufferedImage;

import model.Position;

public class Door extends Tiles {
	private boolean doorOpened;

	
	public Door(BufferedImage img, Position pos, int w, int h) {
		super(img, pos, h, h);
		this.doorOpened = false;

	}

	public boolean getDoorStatus() {
		return doorOpened;
	}

	public void setDoorStatus(boolean x) {
		doorOpened = x;
	}

}
