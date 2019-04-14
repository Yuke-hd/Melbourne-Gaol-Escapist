package controller;

import java.awt.Graphics;

import model.player.Player;
import view.tilesMap.TileManager;

public class SetupController {
	private TileManager tm;

	public SetupController() {
		tm = new TileManager("res/tile/untitled.xml");
		GameControl.initilize();
	}

	public TileManager getTm() {
		return tm;

	}

}
