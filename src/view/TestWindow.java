package view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.color.ColorSpace;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;

import controller.GameControl;
import model.DIR;
import model.Position;
import model.player.Player;
import utility.util;

public class TestWindow {

	public static void main(String args[]) {
		GameControl.initilize();
		MyFrame mf = new MyFrame("KeyEvent test");
		mf.LaunchMyFrame();

	}
}

class Mycanvas extends Canvas {
	// 重写paint()方法，必须的，当调用repaint()时，会自动调用paint()
	Random rand = new Random();

	public void paint(Graphics g) {
//		g.setColor(new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255))); // 设置画笔颜色
//		g.drawRect(rand.nextInt(250), rand.nextInt(180), 50, 50); // 画矩形，XY坐标随机，长宽各为40，50
		int gz = GameControl.gameSize;
		for (int i = 0; i < gz; i++) {
			for (int j = 0; j < gz; j++) {
				Position position = new Position(i, j);
				if (!util.findEle(GameControl.wall, position.getSeq())) {
					g.setColor(new Color(0xFFFFFF));
					g.fillRect(25 * i, 25 * j, 25, 25);
				} else {
					g.setColor(new Color(0x000000));
					g.fillRect(25 * i, 25 * j, 25, 25);
				}
			}
		}
		
		int playerCounter =GameControl.playerCounter;
		ArrayList<Player> players  = GameControl.players;
		for (int i = 0; i < players.size(); i++) {
			Position pos = players.get(i).getPos();
			g.setColor(new Color(0x1AE6E6));
			g.fillRect(25 * pos.getX(), 25 * pos.getY(), 25, 25);
		}
	}
}

class MyFrame extends Frame {

	Mycanvas mc = new Mycanvas();

	private static final long serialVersionUID = -3939365717764479068L;

	MyFrame(String s) { // 构造方法
		super(s);
	}

	public void LaunchMyFrame() { // 定义一个运行窗体方法
		// setLayout(); // 设置默认布局
		

		setSize(300, 333); // 设置窗体大小
		mc.setPreferredSize(new Dimension(250, 180));
		//
		this.setBackground(new Color(255, 255, 255)); // 设置窗体背景色
		setVisible(true); // 设置窗体可见
		// this.addKeyListener(new Monitor()); // Monitor要实现KeyListener接口(键盘监听）
		this.add(mc);
		mc.addKeyListener(new Monitor());
		// Graphics graphics = this.getGraphics();
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}

	class Monitor extends KeyAdapter { // 内部类，实现KeyListener的子类KeyAdapter

		public void keyPressed(KeyEvent e) { // 重写要实现的按下按键的方法
			DIR dir = null;
			int count = GameControl.playerCounter;
			Player currentPlayer = GameControl.players.get(count);

			dir = getDir(e);
			System.out.println(currentPlayer.getClass().getSimpleName() + " ");
			mc.repaint();
			if (dir == null) {
				return;
			}

			try {
				currentPlayer.move(dir);
			} catch (Exception e1) {
				System.err.println(e1.getMessage());
				return;
			}
			System.out.println(" @ " + currentPlayer.getPos().getSeq());
			System.out.println(currentPlayer.getPos());
			System.out.println();
			if (count < 5) {
				GameControl.playerCounter++;
			} else {
				GameControl.playerCounter = 0;
			}
		}

		public DIR getDir(KeyEvent e) {
			int key = e.getKeyCode(); // 获取按下按键的虚拟码(int类型）
			DIR dir = null;
			if (key == KeyEvent.VK_UP) { // 与按键的虚拟码进行比较，是按下哪个按键
				dir = DIR.up;
			} else if (key == KeyEvent.VK_DOWN) { // 向下箭头
				dir = DIR.down;
			} else if (key == KeyEvent.VK_LEFT) {
				dir = DIR.left;
			} else if (key == KeyEvent.VK_RIGHT) {
				dir = DIR.right;
			} else {
				System.out.print("invalid input : ");
				return null;
			}
			return dir;
		}
	}
}
