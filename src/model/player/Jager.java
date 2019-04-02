package model.player;

import model.Position;

public class Jager extends Prisoner {

	public Jager(Position pos, String name) {
		super(pos, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void useAbility() {
		placeTrap();

	}

	private void placeTrap() {
		
		
	}

}
