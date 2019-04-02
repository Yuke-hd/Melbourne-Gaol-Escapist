package model.player;

import java.util.ArrayList;

import controller.GameControl;
import model.DIR;
import model.Position;
import model.item.Item;
import utility.util;

public class Player {

	protected Position pos;
	protected String name;
	protected ArrayList<Item> inventory = null;
	protected int FOV;
	protected Enum<PlayerStat> status;

	public Player(Position pos, String name) {
		this.pos = pos;
		this.name = name;
		this.FOV = 5;
		this.status = PlayerStat.normal;
	}

	public Position checkMove(DIR dir) {
		int x = this.pos.getX();
		int y = this.pos.getY();
		switch (dir) {
		case up:
			y--;
			break;
		case down:
			y++;
			break;
		case left:
			x--;
			break;
		case right:
			x++;
			break;
		}
		Position pos=new Position(x, y);
		return pos;
	}
	
	public void move(DIR dir) throws Exception {
		Position nextPos = checkMove(dir);
		int posSeq= nextPos.getSeq();
		if (!util.findEle(GameControl.wall, posSeq)) {
			setPos(nextPos);
		}else {
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

}
