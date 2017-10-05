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
        Monster m1 = new Monster(0,0);
        Monster m2 = new Monster(0,19);
        Monster m3 = new Monster(19,0);
        Monster m4 = new Monster(19,19);


        // Run game until player dead
        Key key;

        while(true){

            //wait for a key to be pressed

            do{

                Thread.sleep(5);
                key = terminal.readInput();

            } while (key ==null);

            //send getKind to Player, return XY position to main
            player.listenKey(key);
            int playerX = player.getX(), playerY = player.getY();

            //Monster1, send monster1 place (X,Y), and Player place (X,Y) - return new position
            m1.move(player);
            m2.move(player);
            m3.move(player);
            m4.move(player);

            int m1X = m1.getPosX(), m1Y = m1.getPosY();
            int m2X = m2.getPosX(), m2Y = m2.getPosY();
            int m3X = m3.getPosX(), m3Y = m3.getPosY();
            int m4X = m4.getPosX(), m4Y = m4.getPosY();


            //When everything is done, we return all positions to Utskrift

            Print print = new Print(m1,m2,m3,m4,board,player);
            print.PrintL(terminal);


        }


        // Game over


    }
}
