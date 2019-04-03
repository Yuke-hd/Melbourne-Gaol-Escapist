package model.blocks;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import model.Position;
import model.tile.Tiles;

public class HoleBlock extends Tiles {

	public HoleBlock(BufferedImage img, Position pos, int w, int h) {
		super(img, pos, w, h);
	}

	public void render(Graphics2D g) {
		super.render(g);

	}

}
