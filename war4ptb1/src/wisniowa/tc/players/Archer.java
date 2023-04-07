package wisniowa.tc.players;

import wisniowa.tc.Constants;

import javax.swing.*;
import java.util.ArrayList;

public class Archer extends Player{
    private static ArrayList<Arrow> arrows;
    public Archer(String name, int x, int y, int goLeftKey, int goRightKey, int goUpKey, int goDownKey, int attackLeftKey, int attackRightKey) {
        super(name, x, y, goLeftKey, goRightKey, goUpKey, goDownKey, attackLeftKey, attackRightKey);
        arrows = new ArrayList<Arrow>();
        type = "archer";
        baseImage =
                new ImageIcon(
                        Constants.IMAGE_FOLDER +
                                "archer/1.png"
                ).getImage();
    }
    @Override
    public void attackLeft() {
        int i = x;
        if (i > 0) {
            Arrow arrow = new Arrow(x - 1, y, "left");
            arrows.add(arrow); // add the new arrow to the list
            System.out.println("Left Archer arrow");
           // System.out.println(arrows.toString());
        }
    }

    @Override
    public void attackRight(){
        int i= x;
        if (i < Constants.MAX_RIGHT_PLACE){
            Arrow arrow=new Arrow(x+1, y, "right");
            arrows.add(arrow);
            System.out.println("Right Archer arrow");
        }
    }

    public static ArrayList<Arrow> getArrows() {
        return arrows;
    }
}

