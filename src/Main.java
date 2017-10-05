import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;

import java.nio.charset.Charset;

public class Main {

    public static void main(String[] args) throws InterruptedException {


        Terminal terminal = TerminalFacade.createTerminal(System.in, System.out, Charset.forName("UTF8"));
        terminal.enterPrivateMode();


        // Make board object
        Board board = new Board(20,20);


        // Make player object
        Player player = new Player(10, 10);


        // Make monster objects
        Monster[] monsters = new Monster[4];

        monsters[0] = new Monster(0,0);
        monsters[1] = new Monster(0,19);
        monsters[2] = new Monster(19,0);
        monsters[3] = new Monster(19,19);

        // Run game until player dead
        Key key;

        while(isAlive(player, monsters)){

            //wait for a key to be pressed

            do{

                Thread.sleep(5);
                key = terminal.readInput();

            } while (key ==null);

            //send getKind to Player, return XY position to main
            player.listenKey(key);
            int playerX = player.getX(), playerY = player.getY();

            //Monster1, send monster1 place (X,Y), and Player place (X,Y) - return new position

            for (int i = 0; i < monsters.length; i++) {
                monsters[i].move(player, monsters, i);
            }



            //When everything is done, we return all positions to Utskrift

            Print print = new Print(monsters,board,player);
            print.PrintL(terminal);


        }


        // Game over
        gameOver(terminal, player);


    }

    private static void gameOver(Terminal terminal, Player player) {
        String gameOver = "Game Over";

        for (int i = 0; i < gameOver.length(); i++) {
            terminal.moveCursor(player.getX()+i,player.getY());
            terminal.putCharacter(gameOver.charAt(i));
        }
        terminal.moveCursor(0,0);
    }

    private static boolean isAlive(Player player, Monster[] monsters) {
        for (int i = 0; i < monsters.length; i++) {
            if (player.getX() == monsters[i].getPosX() && player.getY() == monsters[i].getPosY()){
                return false;
            }
        }
        return true;
    }
}
