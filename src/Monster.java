public class Monster {
    private int posX;
    private int posY;

    public Monster(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
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
    }

}
