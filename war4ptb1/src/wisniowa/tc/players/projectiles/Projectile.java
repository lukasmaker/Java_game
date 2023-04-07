package wisniowa.tc.players.projectiles;

import wisniowa.tc.Constants;

import javax.swing.*;
import java.awt.*;
public abstract class Projectile {
    protected int x;
    protected int y;
    protected Image baseImage;
    protected String direction;

    public Projectile(int x, int y, String direction, String imagePath) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        baseImage = new ImageIcon(Constants.IMAGE_FOLDER + imagePath).getImage();
    }
    @Override
    public String toString() {
        return this.getClass().getSimpleName()+"{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getDirection() {
        return direction;
    }

    public void setX() {
        if (direction.equals("left")) {
            x -= 1;
        } else if (direction.equals("right")) {
            x += 1;
        }
    }

    public Image getBaseImage() {
        return baseImage;
    }
}

