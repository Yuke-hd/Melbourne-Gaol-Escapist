package view;

import controller.GameControl;
import model.DIR;
import model.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

public class SetupJFame extends JFrame  {
    public static final long serialVersionUID = 1L;
    public GamePanel gp;

    //The menu should show a squared board and the pieces placed on the board
    public SetupJFame() {
        setTitle("Game");
        setSize(1280,720);
        gp = new GamePanel(1280, 720);
        add(gp);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        gp.addKeyListener(new Monitor());

    }
    class Monitor extends KeyAdapter { // 内部类，实现KeyListener的子类KeyAdapter

        public void keyPressed(KeyEvent e) { // 重写要实现的按下按键的方法
            DIR dir = null;
            int count = GameControl.playerCounter;
            Player currentPlayer = GameControl.players.get(count);

            dir = getDir(e);
            System.out.println(currentPlayer.getClass().getSimpleName() + " ");

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

            gp.repaint();

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


