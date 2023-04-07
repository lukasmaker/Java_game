package wisniowa.tc.players;

import wisniowa.tc.Constants;

import javax.swing.*;

public class Warrior extends Player{

    public Warrior(String name, int x, int y, int goLeftKey, int goRightKey, int goUpKey, int goDownKey, int attackLeftKey, int attackRightKey) {
        super(name, x, y, goLeftKey, goRightKey, goUpKey, goDownKey, attackLeftKey, attackRightKey);
        type = "warrior";
        baseImage =
                new ImageIcon(
                        Constants.IMAGE_FOLDER +
                                "warrior/1.png"
                ).getImage();
    }

    @Override
    public void attackLeft() {
        int i = x;
        if (i > 0 && Player.occupatedPlaces[--i][y] == true) {
            System.out.println("Left attack of Warrior hit");
        } else System.out.println("Left attack of Warrior miss");
    }

    @Override
    public void attackRight(){
        int i= x;
        if (i < Constants.MAX_RIGHT_POSITION && Player.occupatedPlaces[++i][y] == true){
            System.out.println("Right attack of Warrior hit");
        }else System.out.println("Right attack of Warrior misses");
    }
}
