package model.tile;

import model.Position;

import java.awt.image.BufferedImage;

public class WallTiles extends Tiles {
    public WallTiles(BufferedImage img, Position pos, int w, int h){
        super(img,pos,w,h);
    }
}
