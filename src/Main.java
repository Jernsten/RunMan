import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;

import java.nio.charset.Charset;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        // Make terminal object
        Terminal terminal = TerminalFacade.createTerminal(System.in, System.out, Charset.forName("UTF8"));
        terminal.enterPrivateMode();

        // Make board object
        Board board = new Board(20,20);

        // Make player object
        Player player = new Player(10, 10);

        // Make four monster objects
        Monster[] monsters = makeMonsters();

        // Load frontpage
        loadFrontpage(terminal);

        // Run game until player dead
        int counter = play(terminal, board, player, monsters);

        // Game over
        gameOver(terminal, player);

        // Show high score
        showHighScore(terminal, counter);
    }

    private static void showHighScore(Terminal terminal, int counter) throws InterruptedException {
        Key key;
        do{

            Thread.sleep(5);
            key = terminal.readInput();

        } while (key ==null);

        terminal.clearScreen();

        String score = "Score: " + counter;

        for (int i = 0; i < score.length(); i++) {
            terminal.moveCursor(10+i,10);
            terminal.putCharacter(score.charAt(i));
        }
    }

    private static void loadFrontpage(Terminal terminal) {
        String runningman = "R U N N I N G     M A N";
        String text = "Press any key to begin!";

        for (int i = 0; i < runningman.length(); i++) {
            terminal.moveCursor(5+i,5);
            terminal.putCharacter(runningman.charAt(i));
        }

        for (int i = 0; i < text.length(); i++) {
            terminal.moveCursor(5+i, 7);
            terminal.putCharacter(text.charAt(i));
        }

        terminal.moveCursor(0,0);
    }

    private static int play(Terminal terminal, Board board, Player player, Monster[] monsters) throws InterruptedException {
        Key key;
        int counter=0;

        while(isAlive(player, monsters)){

            // wait for a key to be pressed

            do{

                Thread.sleep(5);
                key = terminal.readInput();

            } while (key ==null);

            // send key input to Player, and move the player
            player.listenKey(key);

            // send player position to monsters, and move the monsters
            for (int i = 0; i < monsters.length; i++) {
                monsters[i].move(player, monsters, i);
            }

            //When everything is done, we return all positions to Utskrift
            Print print = new Print(monsters,board,player);
            print.PrintL(terminal);

            counter++;
        }
        return counter;
    }

    private static Monster[] makeMonsters() {
        Monster[] monsters = new Monster[4];

        monsters[0] = new Monster(0,0, 40);
        monsters[1] = new Monster(0,19, 40);
        monsters[2] = new Monster(19,0, 100);
        monsters[3] = new Monster(19,19, 100);
        return monsters;
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
