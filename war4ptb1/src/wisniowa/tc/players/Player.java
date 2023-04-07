package wisniowa.tc.players;

import wisniowa.tc.Constants;

import java.awt.*;

public class Player{
    protected static boolean [][] occupatedPlaces =
            new boolean
                    [Constants.WINDOW_WIDTH/Constants.CHARACTER_IMG_WIDTH]
                    [Constants.WINDOW_HEIGHT/Constants.CHARACTER_IMG_HEIGHT];
    protected String name;
    protected int x;
    protected int y;
    protected Image baseImage;
    protected String type;
    int goLeftKey;
    int goRightKey;
    int goUpKey;
    int goDownKey;
    int attackLeftKey;
    int attackRightKey;

    public Player(String name, int x, int y, int goLeftKey, int goRightKey, int goUpKey, int goDownKey, int attackLeftKey, int attackRightKey) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.goLeftKey = goLeftKey;
        this.goRightKey = goRightKey;
        this.goUpKey = goUpKey;
        this.goDownKey = goDownKey;
        this.attackLeftKey = attackLeftKey;
        this.attackRightKey = attackRightKey;
        occupatedPlaces[x][y] = true;

    }

    public Image getBaseImage() {
        return baseImage;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        if (x >= 0 && x < (Constants.MAX_RIGHT_POSITION)) {
            this.x = x;
        }
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getGoLeftKey() {
        return goLeftKey;
    }

    public int getGoRightKey() {
        return goRightKey;
    }

    public int getGoUpKey() {
        return goUpKey;
    }

    public int getGoDownKey() {
        return goDownKey;
    }

    public int getAttackLeftKey() {
        return attackLeftKey;
    }

    public int getAttackRightKey() {
        return attackRightKey;
    }

    public void tryGoLeft() {
        if (x > 0 && occupatedPlaces[x - 1][y] == false) {
            occupatedPlaces[x][y] = false;
            occupatedPlaces[--x][y] = true;
        }
    }

    public void tryGoRight() {
        if (x*Constants.CHARACTER_IMG_WIDTH < Constants.MAX_RIGHT_POSITION && occupatedPlaces[x+1][y] == false) {
            occupatedPlaces[x][y] = false;
            occupatedPlaces[++x][y] = true;
        }
    }

    public void tryGoUp() {
        if (y > 0 && occupatedPlaces[x][y-1] == false) {
            occupatedPlaces[x][y] = false;
            occupatedPlaces[x][--y] = true;
        }
    }

    public void tryGoDown() {
        if (y*Constants.CHARACTER_IMG_HEIGHT < Constants.MAX_DOWN_POSITION  && occupatedPlaces[x][y+1] == false) {
            occupatedPlaces[x][y] = false;
            occupatedPlaces[x][++y] = true;
        }
    }

    public void attackLeft() {
        System.out.println("Attack left!");
    }

    public void attackRight() {
        System.out.println("Attack right!");
    }
    public void tryAttackLeft(){
        String className = this.getClass().getSimpleName();
        System.out.println("dziala left: "+className);
        attackLeft();
    }

    public void tryAttackRight(){
        String className = this.getClass().getSimpleName();
        System.out.println("dziala right: " +className);
        attackRight();
    }
/*        if (className.equals("Warrior")){
            System.out.println("ala");
            Warrior.WarriorAttackRight(x,y);
        }
        else System.out.println("nope");
    }
*/
    public static boolean[][] getOccupatedPlaces() {
        return occupatedPlaces;
    }

}
