package model.player;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import controller.GameControl;
import model.DIR;
import model.Position;
import model.item.Item;
import utility.util;
import view.utils.Animation;
import view.utils.Sprite;

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

    private int offX;
    private int offY;

    private Animation animation;

    public Player(Position pos, String name) {
        this.pos = pos;
        this.name = name;
        this.FOV = 5;
        this.status = PlayerStat.normal;
        sprite = new Sprite("res/entity/references/player_referrence.png", wh, wh);
        walking = false;
        offX = 0;
        offY = 0;
        animation = new Animation(0, 0);

    }

    public Position checkMove(DIR dir) {
        int x = this.pos.getX();
        int y = this.pos.getY();
        switch (dir) {
            case up:
                y--;
                offY++;
                animation.setDirection(3);
                break;
            case down:
                y++;
                offY--;
                animation.setDirection(0);
                break;
            case left:
                x--;
                offX++;
                animation.setDirection(1);
                break;
            case right:
                x++;
                offX--;
                animation.setDirection(2);
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

    /**
     * Set the player's field of view
     * @Precondition FOV must greater than 0
     * @param FOV field of view
     * 
     */
    public void setFOV(int FOV) {
    	assert FOV > 0 : ("FOV must greater than 0");
        this.FOV = FOV;
    }

    public Enum<PlayerStat> getStatus() {
        return status;
    }

    public void setStatus(Enum<PlayerStat> status) {
        this.status = status;
    }

    public void render(Graphics g) {
    }

    public long getStart() {
        return start;
    }

    public void setWalking(boolean walking) {
        this.walking = walking;
    }

    public boolean isWalking() {
        return walking;
    }

    public BufferedImage getSpriteImage() {
        return sprite.getSprite(animation.getNum(), animation.getDirection(), wh, wh);
    }

    public void AnimationAddNum() {
        animation.addNum();
    }

    public BufferedImage getStandingImage() {
        return sprite.getSprite(0, 2, wh, wh);
    }

    public int getWh() {
        return wh;
    }

    public void setOffX(int offX) {
        this.offX = offX;
    }

    public void setOffY(int offY) {
        this.offY = offY;
    }

    public int getOffX() {
        return offX;
    }

    public int getOffY() {
        return offY;
    }
}
