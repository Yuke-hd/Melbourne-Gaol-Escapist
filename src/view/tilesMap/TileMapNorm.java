package view.tilesMap;/*
 * *@Date:  2019-03-23
 * *@author:  Biao Li
 * *StudentID :  s3675917
 * *@ver 1.0
 * */

import model.Position;
import model.tile.NormTiles;
import view.utils.Sprite;
import java.awt.*;

public class TileMapNorm extends TileMap {
    private NormTiles[] blocks;
    private int tileWidth;
    private int tileHeight;

    private int height;

    public TileMapNorm(String data, Sprite sprite, int width, int height, int tileWidth, int tileHeight, int tileColumns) {
        blocks = new NormTiles[width * height];

        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
        this.height = height;

        String[] block = data.split(",");
        for (int i = 0; i < (width * height); i++) {
            int sprite_x;
            int sprite_y;
            int draw_location_x;
            int draw_location_y;
            int temp = Integer.parseInt(block[i].replaceAll("\\s+", ""));
            if (temp != 0) {
                sprite_x = (temp - 1) % tileColumns;
                sprite_y = (temp - 1) / tileColumns;
                draw_location_x = (i % width) * tileWidth;
                draw_location_y = (i / width) * tileHeight;

                blocks[i] = new NormTiles(sprite.getSprite(sprite_x, sprite_y), new Position(draw_location_x,draw_location_y), tileWidth, tileHeight);
            }
        }
    }

    public void render(Graphics g) {
        for (NormTiles nt:blocks
             ) {
            if (nt != null){
                nt.render(g);
            }

        }
    }


    public Position getRandomPoint(){
        double random = Math.random() * (blocks.length-1);
        return blocks[(int)random].getPos();
    }



}
