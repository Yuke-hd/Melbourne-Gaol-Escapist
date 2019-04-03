package controller;

import java.awt.Graphics;

import view.tilesMap.TileManager;

public class SetupController {
	private TileManager tm;

	public SetupController() {
		tm = new TileManager("res/tile/untitled.xml");
	}

	public void render(Graphics g) {
		tm.render(g);

//        player.render(g);

	}

}
