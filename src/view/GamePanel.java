package view;/*
 * *OOSD
 * *@Date:  2019-03-22
 * *@author:  Biao Li
 * *StudentID :  s3675917
 * *@ver 1.0
 * */

import controller.GameControl;
import controller.SetupController;
import model.Position;
import model.player.Player;
import model.tile.Tiles;
import view.tilesMap.TileManager;
import view.tilesMap.TileMap;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class    GamePanel extends JPanel {

    private int width;
    private int height;
    private SetupController sc;

    BufferStrategy bs;

    Image img;
    Graphics g;


    public GamePanel(BufferStrategy bs, int width, int height) {
        this.bs = bs;
        this.width = width;
        this.height = height;
        setPreferredSize(new Dimension(width, height));
        setFocusable(true);
        requestFocus();
        init();
    }

    private void init() {
        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        g = img.getGraphics();
        sc = new SetupController();
    }

    public void render() {
        //drawing map
        TileManager tileManager = sc.getTm();
        ArrayList<TileMap> tileMaps = tileManager.getTm();
        for (TileMap tilemap : tileMaps
        ) {
            Tiles[] blocks = tilemap.getBlocks();
            for (Tiles tile : blocks
            ) {
                if (tile != null)
                    g.drawImage(tile.getImg(), tile.getPos().getX(), tile.getPos().getY(), tile.getWidth(), tile.getHeight(), null);

            }

        }

        //drawing player
        for (Player player : GameControl.players
        ) {
            long now;
            int offX = player.getOffX();
            int offY = player.getOffY();
            int wh = player.getWh();
            Position pos = player.getPos();
            if (player.isWalking()) {
                now = System.currentTimeMillis();
                int oldPosXxH = pos.getX() * 32;
                int oldPosYxH = pos.getY() * 32;
                if (offX != 0)
                    oldPosXxH = oldPosXxH + 32 * offX;
                if (offY != 0)
                    oldPosYxH = oldPosYxH + 32 * offY;


                if (now - player.getStart() < 1000) {
                    Double i = new Double((now - player.getStart()) / 30);
                    int j = i.intValue();
                    player.AnimationAddNum();
                    if (offX != 0)
                        g.drawImage(player.getSpriteImage(), oldPosXxH - j * offX, wh * pos.getY(), null);
                    if (offY != 0)
                        g.drawImage(player.getSpriteImage(), wh * pos.getX(), oldPosYxH - j * offY, null);
                } else {
                    player.setWalking(false);
                    player.setOffX(0);
                    player.setOffY(0);
                }

            } else
                g.drawImage(player.getStandingImage(), wh * pos.getX(), wh * pos.getY(), null);
        }


    }

    public void draw() {
        do {
            Graphics g2 = bs.getDrawGraphics();
            g2.drawImage(img, 8, 31, width, height, null);
            g2.dispose();
            bs.show();
        } while (bs.contentsLost());

    }

}
