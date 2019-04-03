package model.blocks;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import model.Position;
import model.tile.Tiles;

public class ObjBlock extends Tiles {

    public ObjBlock(BufferedImage img, Position pos, int w, int h) {
        super(img, pos, w, h);
    }


    public void render(Graphics2D g){
        super.render(g);
    }

}
