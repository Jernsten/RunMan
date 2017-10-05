import com.googlecode.lanterna.input.Key;

public class Player {

    public int x;
    public int y;

    public setPlayerPos() {
        this.x = x;
        this.y = y;
    }

    public void listenKey(){

        Key key;

        switch(key.getKind()){
            case ArrowUp:
                y=y+1;
                break;
            case ArrowDown:
                y=y-1;
                break;
            case ArrowLeft:
                x=x-1;
                break;
            case ArrowRight:
                x=x+1;
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