package view;

import javax.swing.*;
import java.awt.image.BufferStrategy;

public class SetupJFame extends JFrame implements Runnable {
    private BufferStrategy bs;
    public static final long serialVersionUID = 1L;
    private GamePanel gp;
    private Thread thread;
    //The menu should show a squared board and the pieces placed on the board

    public SetupJFame() {
        setTitle("Game");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setIgnoreRepaint(true);
        setVisible(true);
        pack();
        gp.addKeyListener(new Monitor());
    }

    public void addNotify() {
        super.addNotify();

        createBufferStrategy(2);
        bs = getBufferStrategy();
        gp = new GamePanel(bs, 1280, 720);
        add(gp);

        if (thread == null) {
            thread = new Thread(this, "GameThread");
            thread.start();
        }
    }


    @Override
    public void run() {
        while (true) {
            gp.render();
            gp.draw();
        }
    }


}


