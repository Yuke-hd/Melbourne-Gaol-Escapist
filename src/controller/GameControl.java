package controller;

import java.util.ArrayList;

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
import view.TestWindow;

public class GameControl {
	public static int wall[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 21, 31, 41, 51, 61, 71, 81, 91, 10, 20, 30, 40, 50,
			60, 70, 80, 90, 100, 92, 93, 94, 95, 96, 97, 98, 99 };
	public static int gameSize = 10;
	public static DIR dir;
	public static int playerCounter;
	public static ArrayList<Player> players;

	public GameControl() {
	}

	public static void initilize() {
		players= new ArrayList<Player>();
		Havoc h = new Havoc(new Position(2, 2), "aaa");
		Jager j = new Jager(new Position(3, 2), "bbb");
		A47 a = new A47(new Position(4, 2), "ccc");
		LockSmith l = new LockSmith(new Position(5, 2), "ddd");
		
		Warden w = new Warden(new Position(6, 2), "eee");
		Guard g = new Guard(new Position(7, 2), "fff");
		
		players.add(h);
		players.add(j);
		players.add(a);
		players.add(l);
		players.add(w);
		players.add(g);
		
		playerCounter=0;

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
