package model.player;

import java.awt.*;
import java.util.ArrayList;

import controller.GameControl;
import model.DIR;
import model.Position;
import model.item.Item;
import utility.util;
import view.Sprite;

public class Player {

    protected Position pos;
    protected String name;
    protected ArrayList<Item> inventory = null;
    protected int FOV;
    protected Enum<PlayerStat> status;
    private Sprite sprite;
    private long start;
    private long now;
    private boolean walking;
    private int wh = 32;
    private int fp;

    private int offX;
    private int offY;

    private int animation;

    public Player(Position pos, String name) {
        this.pos = pos;
        this.name = name;
        this.FOV = 5;
        this.status = PlayerStat.normal;
        sprite = new Sprite("res/entity/references/player_referrence.png", wh, wh);
        walking = false;
        offX = 0;
        offY = 0;
        animation = 0;
        fp = 0;
    }

    public Position checkMove(DIR dir) {
        int x = this.pos.getX();
        int y = this.pos.getY();
        switch (dir) {
            case up:
                y--;
                offY++;
                break;
            case down:
                y++;
                offY--;
                break;
            case left:
                x--;
                offX++;
                break;
            case right:
                x++;
                offX--;
                break;
        }
        Position pos = new Position(x, y);
        return pos;
    }

    public void move(DIR dir) throws Exception {
        Position nextPos = checkMove(dir);
        int posSeq = nextPos.getSeq();
        if (!util.findEle(GameControl.wall, posSeq)) {
            setPos(nextPos);
            walking = true;
            start = System.currentTimeMillis();
        } else {
            throw new Exception("wall ahead");
        }
    }

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFOV() {
        return FOV;
    }

    public void setFOV(int fOV) {
        FOV = fOV;
    }

    public Enum<PlayerStat> getStatus() {
        return status;
    }

    public void setStatus(Enum<PlayerStat> status) {
        this.status = status;
    }

    public void render(Graphics g) {
        if (walking) {
            now = System.currentTimeMillis();
            int oldPosXxH = pos.getX() * 32;
            int oldPosYxH = pos.getY() * 32;
            if (offX != 0)
                oldPosXxH = oldPosXxH + 32 * offX;
            if (offY != 0)
                oldPosYxH = oldPosYxH + 32 * offY;


            if (now - start < 1000) {
                    Double i = new Double((now - start) / 30);
                    int j = i.intValue();
                    animation++;
                    if (animation == 3) animation = 0;
                    if (offX != 0)
                        g.drawImage(sprite.getSprite(animation, 0, wh, wh), oldPosXxH - j * offX, wh * pos.getY(), null);
                    if (offY != 0)
                        g.drawImage(sprite.getSprite(animation, 0, wh, wh), wh * pos.getX(), oldPosYxH - j * offY, null);
            } else {
                walking = false;
                offY = 0;
                offX = 0;
                fp = 0;
            }

        } else
            g.drawImage(sprite.getSprite(0, 2, wh, wh), wh * pos.getX(), wh * pos.getY(), null);
    }

}
