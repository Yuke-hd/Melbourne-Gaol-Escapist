package view;

import controller.GameControl;
import model.DIR;
import model.player.Player;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class Monitor extends KeyAdapter { // 内部类，实现KeyListener的子类KeyAdapter


    public void keyPressed(KeyEvent e) { // 閲嶅啓瑕佸疄鐜扮殑鎸変笅鎸夐敭鐨勬柟娉�
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
            GameControl.playerCounter=0;
        } else {
            GameControl.playerCounter = 0;
        }


    }

    private DIR getDir(KeyEvent e) {
        int key = e.getKeyCode(); // 鑾峰彇鎸変笅鎸夐敭鐨勮櫄鎷熺爜(int绫诲瀷锛�
        DIR dir = null;
        if (key == KeyEvent.VK_UP) { // 涓庢寜閿殑铏氭嫙鐮佽繘琛屾瘮杈冿紝鏄寜涓嬪摢涓寜閿�
            dir = DIR.up;
        } else if (key == KeyEvent.VK_DOWN) { // 鍚戜笅绠ご
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