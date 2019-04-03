package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import model.DIR;
import model.Position;
import model.player.A47;
import model.player.Guard;
import model.player.Havoc;
import model.player.Jager;
import model.player.LockSmith;
import model.player.Player;
import model.player.Warden;
import model.tile.Wall;
import utility.util;
import view.TestWindow;

public class GameControl {
	public static int wall[]; //= { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 21, 31, 41, 51, 61, 71, 81, 91, 10, 20, 30, 40, 50,
			//60, 70, 80, 90, 100, 92, 93, 94, 95, 96, 97, 98, 99 };
	public static int gameSize = 25;
	public static DIR dir;
	public static int playerCounter;
	public static ArrayList<Player> players;
	static Random rand = new Random();
	public GameControl() {
	}

	public static void initilize() {
		iniWall();
		players = new ArrayList<Player>();

		Havoc h = new Havoc(util.randPos(), "aaa");
		Jager j = new Jager(util.randPos(), "bbb");
		A47 a = new A47(util.randPos(), "ccc");
		LockSmith l = new LockSmith(util.randPos(), "ddd");

		Warden w = new Warden(util.randPos(), "eee");
		Guard g = new Guard(util.randPos(), "fff");

		players.add(h);
		players.add(j);
		players.add(a);
		players.add(l);
		players.add(w);
		players.add(g);

		playerCounter = 0;

	}

	private static int[] iniWall() {
		List<Integer> list = new ArrayList<Integer>();// **须定义时就进行转化**
		for (int i = 0; i < gameSize; i++) {
			list.add(i+1);
			list.add(i*gameSize+1);
			list.add((i+1)*gameSize);
			if (i == gameSize-1) {
				for (int j = 0; j < gameSize-1; j++) {
					list.add(j+1+gameSize*(gameSize-1));
				}
			}
		}
		Integer[] nsz = new Integer[list.size()];
		list.toArray(nsz);
		wall = list.stream().mapToInt(Integer::intValue).toArray();
		return wall;
		
	}

	public void run() throws InterruptedException {
		Havoc p = new Havoc(new Position(2, 2), "aaa");

		try {
			p.move(dir);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		System.out.println(p.getPos().getSeq());
		System.out.println(p.getPos());

	}
}
