package model.tile;

import model.Position;

public class Door extends Tiles {
private boolean doorOpened;
	public Door(Position pos) {
		super(pos);
		this.doorOpened=false;
	}
	
	public boolean getDoorStatus() {
		return doorOpened;
	}
	public void setDoorStatus(boolean x) {
		doorOpened=x;
	}

}
