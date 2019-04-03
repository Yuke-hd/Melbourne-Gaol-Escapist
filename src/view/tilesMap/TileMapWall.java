package view.tilesMap;

import java.awt.Graphics;

import model.Position;
import model.blocks.NormBlock;
import model.tile.Tiles;
import view.Sprite;

public class TileMapWall extends TileMap {

    public static Tiles[] event_blocks;

    private int tileWidth;
    private int tileHeight;

    public static int width;
    public static int height;

    public TileMapWall(String data, Sprite sprite, int width, int height, int tileWidth, int tileHeight, int tileColumns) {
    	Tiles tempBlock;
        event_blocks = new Tiles[width * height];

        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;

        TileMapWall.width = width;
        TileMapWall.height = height;

        String[] block = data.split(",");
        for (int i = 0; i < (width * height); i++) {
            int temp = Integer.parseInt(block[i].replaceAll("\\s+", ""));
            int sprite_x;
            int sprite_y;
            int draw_location_x;
            int draw_location_y;
            if (temp != 0) {
                sprite_x = (temp - 1) % tileColumns;
                sprite_y = (temp - 1) / tileColumns;
                draw_location_x = (i % width) * tileWidth;
                draw_location_y = (i / width) * tileHeight;

                event_blocks[i] = new NormBlock(sprite.getSprite(sprite_x, sprite_y), new Position(draw_location_x,draw_location_y), tileWidth, tileHeight);
            }
        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < event_blocks.length;i++) {
                if(event_blocks[i] != null)
                    event_blocks[i].render(g);
            }
    }
}

