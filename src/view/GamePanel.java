package view;/*
 * *OOSD
 * *@Date:  2019-03-22
 * *@author:  Biao Li
 * *StudentID :  s3675917
 * *@ver 1.0
 * */

import controller.SetupController;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private int width;
    private int height;
    public static Graphics g;
    private SetupController sc;

    public void paint(Graphics g) {

        Graphics componentGraphics = getComponentGraphics(g);
        this.g = componentGraphics.create();
        render();
    }

    public GamePanel(int width, int height) {
        init();
        this.width = width;
        this.height = height;
        setPreferredSize(new Dimension(width, height));
        setFocusable(true);
        requestFocus();
    }

    private void init() {
        sc = new SetupController();
    }

    private void render() {
            sc.render(g);


    }

}
