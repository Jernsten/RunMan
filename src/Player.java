import com.googlecode.lanterna.input.Key;

public class Player {

    private int x;
    private int y;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setPlayerPos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void listenKey(Key key){


        switch(key.getKind()){
            case ArrowUp:
                y=y-2;
                break;
            case ArrowDown:
                y=y+2;
                break;
            case ArrowLeft:
                x=x-2;
                break;
            case ArrowRight:
                x=x+2;
                break;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}