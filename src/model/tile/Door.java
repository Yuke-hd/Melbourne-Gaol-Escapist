package model.tile;

import model.Position;

public class Door extends Tiles {
private boolean doorOpened;
	public Door(Position pos) {
		super(img, pos, h, h);
		this.doorOpened=false;
	}
	
	public boolean getDoorStatus() {
		return doorOpened;
	}
	public void setDoorStatus(boolean x) {
		doorOpened=x;
	}

}
