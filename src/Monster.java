import java.util.Random;

public class Monster {
    private int posX;
    private int posY;
    private int level;

    public Monster(int posX, int posY, int level) {
        this.posX = posX;
        this.posY = posY;
        this.level = level;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void move(Player player, Monster[] monsters, int monstrNr) {
        int playerX = player.getX();
        int playerY = player.getY();

        // Moves monster
        movesMonster(playerX, playerY);

        for (int i = 0; i < monsters.length; i++) {
            if (i == monstrNr){
                continue;
            }

            if (monsters[i].getPosX() == posX && monsters[i].getPosY() == posY){
                movesMonster(playerX,playerY);
            }
        }

    }

    private void movesMonster(int playerX, int playerY) {
        if (playerX < posX) {
            posX -= 1;
        }
        if (playerX > posX) {
            posX += 1;
        }
        if (playerY < posY) {
            posY -= 1;
        }
        if (playerY > posY) {
            posY += 1;
        }
        randomer();
    }

    private void randomer() {
        Random rand = new Random();
        int r = rand.nextInt(100);
        int andelRandom = level, del = andelRandom/4;

        if (r <= andelRandom) {
            if (r < del)
                setPosX(posX+1);
            else if (r < del*2)
                setPosX(posX-1);
            else if (r < del*3)
                setPosY(posY+1);
            else
                setPosY(posY-1);
        }
    }

}
