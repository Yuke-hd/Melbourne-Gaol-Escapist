package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

public class SetupJFame extends JFrame implements KeyListener {
    public static final long serialVersionUID = 1L;
    private BufferStrategy bs;


    //The menu should show a squared board and the pieces placed on the board
    public SetupJFame() {
        setTitle("Game");
        setSize(1280,720);
        add(new GamePanel(1280, 720));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setIgnoreRepaint(true);
//        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }

//
//    public void addNotify() {
//        super.addNotify();
//
//        createBufferStrategy(2);
//        bs = getBufferStrategy();
//
//        setLayout(new BorderLayout());
//        add(new GamePanel(bs, 1280, 720));
//
//    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int x = 0;
        switch (e.getKeyCode()) {
            case KeyEvent.VK_DOWN:
                x = 1;
            case KeyEvent.VK_UP:
                x = 2;
            case KeyEvent.VK_RIGHT:
                x = 3;
            case KeyEvent.VK_LEFT:
                x = 4;
            case KeyEvent.VK_ESCAPE:
                x = 5;


        }


//        switch (x) {
//            case 1:
//                xpos = player.getX();
//                if (xpos == 0 || xpos == (_game.getSize() - 1) / 2 || xpos == (_game.getSize() - 1)) {
//                    if (player.getY() < _game.getSize() - 1) {
//                        player.setY(player.getY() + 1);
//                        System.out.println("down");
//                        break;
//                    }
//
//                } else
//                    System.out.println("out of border");
//                return;
//
//            case 2:
//                xpos = player.getX();
//                if (xpos == 0 || xpos == (_game.getSize() - 1) / 2 || xpos == (_game.getSize() - 1)) {
//                    if (player.getY() > 0) {
//                        player.setY(player.getY() - 1);
//                        System.out.println("up");
//                        break;
//                    }
//                } else
//                    System.out.println("out of border");
//                return;
//            case 3:
//                ypos = player.getY();
//                if (ypos == 0 || ypos == (_game.getSize() - 1) / 2 || ypos == (_game.getSize() - 1)) {
//                    if (player.getX() < _game.getSize() - 1) {
//                        player.setX(player.getX() + 1);
//                        System.out.println("to right");
//                        break;
//                    }
//                } else
//                    System.out.println("out of border");
//                return;
//            case 4:
//                ypos = player.getY();
//                if (ypos == 0 || ypos == (_game.getSize() - 1) / 2 || ypos == (_game.getSize() - 1)) {
//                    if (player.getX() > 0) {
//                        player.setX(player.getX() - 1);
//                        System.out.println("to left");
//                        break;
//                    }
//                } else
//                    System.out.println("out of border");
//                return;
//            case 5:
//                JOptionPane.showMessageDialog(mp, "Game pause", "Game", JOptionPane.WARNING_MESSAGE);
//                return;
//            default:
//                return;
//        }
        //chase();

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


}