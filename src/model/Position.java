package model;

import controller.GameControl;

public class Position {
	private int x;
	private int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "x: " + x + " y: " + y;
	}

	/**
	 * @return sequence of the position in game board
	 */
	public int getSeq() {
		
		int gz = GameControl.gameSize;
		
		int seq = gz * y + x + 1;
		
		
		return seq;
	}

	

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
