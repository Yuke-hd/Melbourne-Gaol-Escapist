package model.item;

import model.Position;

public abstract class Item {
	private Position pos;

	public Item(Position pos) {
		this.setPos(pos);
	}

	public Position getPos() {
		return pos;
	}

	public void setPos(Position pos) {
		this.pos = pos;
	}

}
