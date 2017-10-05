import com.googlecode.lanterna.terminal.Terminal;

public class Print {

    // Print board via lanterna

    private Monster m1, m2,m3,m4;
    private Player player;

    public Print(Monster[] monsters, Player player) {

        this.m1 = monsters[0];
        this.m2 = monsters[1];
        this.m3 = monsters[2];
        this.m4 = monsters[3];
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
