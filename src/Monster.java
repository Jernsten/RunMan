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

    public void move(Player player) {
        int playerX = player.getX();
        int playerY = player.getY();

        // är avstånd x eller y störst

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
