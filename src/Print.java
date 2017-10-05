import com.googlecode.lanterna.terminal.Terminal;

public class Print {

    // Print board via lanterna

    private Monster m1, m2,m3,m4;
    private Board board;
    private Player player;

    public Print(Monster m1, Monster m2, Monster m3, Monster m4, Board board, Player player) {
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
        this.m4 = m4;
        this.board = board;
        this.player = player;
    }

    public void PrintL(Terminal terminal){

        terminal.clearScreen();
        // Print player
        terminal.moveCursor(player.getX(),player.getY());
        terminal.putCharacter('P');

        // Print monsters
        terminal.moveCursor(m1.getPosX(),m1.getPosY());
        terminal.putCharacter('1');

        terminal.moveCursor(m2.getPosX(),m2.getPosY());
        terminal.putCharacter('2');

        terminal.moveCursor(m3.getPosX(),m3.getPosY());
        terminal.putCharacter('3');

        terminal.moveCursor(m4.getPosX(),m4.getPosY());
        terminal.putCharacter('4');

        terminal.moveCursor(0,0);


    }

}
