package model.tile;

import model.Position;

public abstract class Tiles {
	private Position pos;

	public Tiles(Position pos) {
		this.pos = pos;

	}

	public Position getPos() {
		return pos;
	}

	public void setPos(Position pos) {
		this.pos = pos;
	}

}
