package model.player;

import model.Position;

public class Guard extends LawEnforcer {

	public Guard(Position pos, String name) {
		super(pos, name);
		super.FOV=7;
		super.status = PlayerStat.normal;
	}

}
