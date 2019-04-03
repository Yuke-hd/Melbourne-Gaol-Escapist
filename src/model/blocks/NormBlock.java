package model.blocks;


import model.Position;
import model.tile.Tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

public class NormBlock extends Tiles {

    public NormBlock(BufferedImage img, Position pos, int w, int h) {
        super(img, pos, w, h);
    }


    public void render(Graphics2D g){
        super.render(g);
    }
}
