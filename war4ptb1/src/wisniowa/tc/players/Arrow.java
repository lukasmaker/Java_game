package wisniowa.tc.players;

import wisniowa.tc.Constants;

import javax.swing.*;
import java.awt.*;

public class Arrow {
    protected int x;
    protected int y;
    protected String direction;

    protected Image baseImage;

    public Arrow(int x, int y, String direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        baseImage =
                new ImageIcon(
                        Constants.IMAGE_FOLDER +
                                "archer/" + direction + "Arrow.png"
                ).getImage();
    }
    @Override
    public String toString() {
        return "Arrow{" +
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

    public void setX(int x) {
        this.x = x;
    }

    public String getDirection() {
        return direction;
    }

    public Image getBaseImage() {
        return baseImage;
    }
}
