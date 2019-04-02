package model.player;

import model.Position;

public class LockSmith extends Prisoner {

	public LockSmith(Position pos, String name) {
		super(pos, name);
	}

	@Override
	public void useAbility() {
		pickLock();
		
	}
	
	private void pickLock() {
		
	}

}
