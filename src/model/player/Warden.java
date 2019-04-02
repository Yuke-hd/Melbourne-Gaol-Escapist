package model.player;

import model.Position;

public class Warden extends LawEnforcer {

	public Warden(Position pos, String name) {
		super(pos, name);
		super.FOV=3;
		super.status = PlayerStat.invincible;
	}

}
