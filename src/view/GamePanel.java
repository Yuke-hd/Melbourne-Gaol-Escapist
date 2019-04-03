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
    public static Graphics g;
    private SetupController sc;

    public void paint(Graphics g) {

        Graphics componentGraphics = getComponentGraphics(g);
        this.g = componentGraphics.create();
        render();
    }

    public GamePanel(int width, int height) {
        //this.g = getGraphics();
        init();
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
            sc.render(g);


    }

}
