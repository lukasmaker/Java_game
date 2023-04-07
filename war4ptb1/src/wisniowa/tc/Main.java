package wisniowa.tc;

import wisniowa.tc.players.*;

import java.awt.event.KeyEvent;

public class Main {

    public static void main(String[] args) {
        Team team = new Team(
                new Warrior(
                        "Aragorn",
                        0,
                        0,
                        KeyEvent.VK_LEFT,
                        KeyEvent.VK_RIGHT,
                        KeyEvent.VK_UP,
                        KeyEvent.VK_DOWN,
                        KeyEvent.VK_O,
                        KeyEvent.VK_P
                ),
                new Archer(
                        "Legolas",
                        2,
                        2,
                        KeyEvent.VK_A,
                        KeyEvent.VK_D,
                        KeyEvent.VK_W,
                        KeyEvent.VK_S,
                        KeyEvent.VK_1,
                        KeyEvent.VK_2
                ),
                new Mage(
                        "Gandalf",
                        4,
                        4,
                        KeyEvent.VK_G,
                        KeyEvent.VK_H,
                        KeyEvent.VK_T,
                        KeyEvent.VK_B,
                        KeyEvent.VK_6,
                        KeyEvent.VK_7
                )
        );

        new MainWindow(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT, team);
    }
}
