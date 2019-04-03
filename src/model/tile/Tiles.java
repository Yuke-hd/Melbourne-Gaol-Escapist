package model.tile;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import model.Position;

public abstract class Tiles {


	private int w;
	private int h;

	private BufferedImage img;
	private Position pos;

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
		g.drawImage(img, pos.getX(), pos.getY(), w, h, null);
	}

	public Position getPos() {
		return pos;
	}

	public void setPos(Position pos) {
		this.pos = pos;
	}

}
