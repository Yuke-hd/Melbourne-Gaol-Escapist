import controller.SetupController;
import view.SetupJFame;
/*The GameLauncher has 6 pieces, three pieces for each player/user. One player is going to play as prisoners and the other player
is going to play as police officers. The officers have the pieces officer,dog,guard and prisoners have kingpin,.... . There is
a key in the middle of the board that is moving left and right. The goal of the GameLauncher is for one of the player/user to move the pieces
and get the key to escape the prison or to protect the prison*/
public class GameLauncher {
public static void main(String[]args)
        {
        new SetupJFame();
        }
}