package wisniowa.tc.players;

import wisniowa.tc.Constants;
import wisniowa.tc.players.projectiles.Arrow;

import javax.swing.*;
import java.util.ArrayList;
public class Archer extends Player{
    private ArrayList<Arrow> arrows = new ArrayList<>();
    public Archer(String name, int x, int y, int goLeftKey, int goRightKey, int goUpKey, int goDownKey, int attackLeftKey, int attackRightKey) {
        super(name, x, y, goLeftKey, goRightKey, goUpKey, goDownKey, attackLeftKey, attackRightKey);
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
            Arrow arrow = new Arrow(x, y, "left");
            arrows.add(arrow); // add the new arrow to the list
            System.out.println("Left Archer arrow");
        }
    }

    @Override
    public void attackRight(){
        int i= x;
        if (i < Constants.MAX_RIGHT_PLACE){
            Arrow arrow=new Arrow(x, y, "right");
            arrows.add(arrow);
            System.out.println("Right Archer arrow");
        }
    }

    public ArrayList<Arrow> getArrows() {
        return arrows;
    }
}

