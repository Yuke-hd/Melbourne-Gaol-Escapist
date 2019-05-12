package model.tile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.image.BufferedImage;


import model.Position;
import model.player.LawEnforcer;
import model.player.PlayerStat;
import model.player.Guard;

public class Trap extends Tiles {

	public Trap(BufferedImage img, Position pos, int w, int h) {
		super(img, pos, w, h);
	}
	
	/**
	 * Trap a Guard
	 * @Precondition only a Guard player in noraml status can be trapped
	 * @param le a law enforcer
	 * 
	 */
	public void trapPlayer(LawEnforcer le) {
		//precondition
		assertTrue(le.getStatus().equals(PlayerStat.normal));
		assertTrue(le instanceof Guard);
		
		//trap the player
		le.setStatus(PlayerStat.trapped);
		
		//postcondition
		assertEquals(PlayerStat.trapped, le.getStatus());
	}

}
