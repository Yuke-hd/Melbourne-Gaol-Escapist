package model.tile;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import model.Position;

public abstract class Tiles {
//	private Position pos;
//
//	public Tiles(Position pos) {
//		this.pos = pos;
//
//	}

	protected int w;
	protected int h;

	protected BufferedImage img;
	protected Position pos;

	public Tiles (BufferedImage img, Position pos, int w, int h) {
        this.img = img;
        this.pos = pos;
        this.w = w;
        this.h = h;
    }

	public int getWidth() {
		return w;
	}

	public int getHeight() {
		return h;
	}

	public void render(Graphics g) {
		g.drawImage(img, (int) pos.getX(), (int) pos.getY(), w, h, null);
	}

	public Position getPos() {
		return pos;
	}

	public void setPos(Position pos) {
		this.pos = pos;
	}

}
