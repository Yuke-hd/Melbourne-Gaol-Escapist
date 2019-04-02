package model.tile;

import model.Position;
import model.player.LawEnforcer;
import model.player.PlayerStat;

public class Trap extends Tiles {

	public Trap(Position pos) {
		super(pos);
	}

	public void trapPlayer(LawEnforcer le) {
		le.setStatus(PlayerStat.trapped);
	}

}
