package view;/*
				* *Network programming lab 2
				* *@Date:  2019-03-22
				* *@author:  Biao Li
				* *StudentID :  s3675917
				* *@ver 1.0
				* */

import controller.SetupController;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel {

	public static int width;
	public static int height;
	private Graphics g;

	private SetupController sc;

	public void paintComponent(Graphics g) {
		this.g = g;
		init();
		render();
		System.out.println("game run");

	}

	public GamePanel(int width, int height) {
		GamePanel.width = width;
		GamePanel.height = height;
		setPreferredSize(new Dimension(width, height));
		setFocusable(true);
		requestFocus();
	}

	private void init() {
		sc = new SetupController();
	}

	public void render() {
		if (g != null) {
			g.setColor(new Color(33, 30, 39));
			g.fillRect(0, 0, width, height);
			sc.render(g);
		}
	}

}
