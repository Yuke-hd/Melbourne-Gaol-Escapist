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
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel {

    private int width;
    private int height;
    private SetupController sc;

    BufferStrategy bs;

    Image img;
    Graphics g;

//    @Override
//    public void paintComponent(Graphics g){
//        render(g);
//    }

//    public void update(Graphics g){
//
//
//        //Create the offscreen graphics context, if no good one exists.
//        if  (offGraphics == null){
//            offImage = createImage(width, height);
//        }
//
//        offGraphics = offImage.getGraphics();
//        render(offGraphics);
//
//        g.drawImage(offImage, 0, 0, this);
//
//    }



    public GamePanel(BufferStrategy bs, int width, int height) {
        this.bs = bs;
        this.width = width;
        this.height = height;
        setPreferredSize(new Dimension(width, height));
        setFocusable(true);
        requestFocus();
        init();
    }

    private void init() {
        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        g = img.getGraphics();
        sc = new SetupController();
    }

    public void render() {
            sc.render(g);


    }

    public void draw() {
        do {
            Graphics g2 = bs.getDrawGraphics();
            g2.drawImage(img, 8, 31, width, height, null);
            g2.dispose();
            bs.show();
        } while(bs.contentsLost());

    }

}
