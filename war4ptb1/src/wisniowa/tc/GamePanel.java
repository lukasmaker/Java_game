package wisniowa.tc;

import wisniowa.tc.players.Archer;
import wisniowa.tc.players.Player;
import wisniowa.tc.players.Arrow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Iterator;

public class GamePanel extends JPanel {
    public int x = 100;
    public int y = 300;
    private Team team;
    Player[] players;


    public GamePanel(Team team) {
        this.team = team;
        this.players = this.team.getTeamMembers();
        setFocusable(true);
        addKeyListener(new HeroesKeyListener2());
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Player player : players) {
            g.drawImage(
                    player.getBaseImage(),
                    player.getX() * Constants.CHARACTER_IMG_WIDTH,
                    player.getY() * Constants.CHARACTER_IMG_HEIGHT,
                    this
            );
            if (player.getClass().getSimpleName().equals("Archer")) {
                Iterator<Arrow> iter = Archer.getArrows().iterator();
                while (iter.hasNext()) {
                    Arrow arrow = iter.next();
                    System.out.println(arrow);
                    if (arrow.getX() > Constants.MAX_RIGHT_PLACE || arrow.getX() < 0) {
                        iter.remove();
                        repaint();
                        break;
                    }
                    g.drawImage(
                            arrow.getBaseImage(),
                            arrow.getX() * Constants.CHARACTER_IMG_WIDTH,
                            arrow.getY() * Constants.CHARACTER_IMG_HEIGHT,
                            this
                    );
                    if (arrow.getDirection().equals("left")) {
                        arrow.setX(arrow.getX() - 1);
                    } else if (arrow.getDirection().equals("right")) {
                        arrow.setX(arrow.getX() + 1);
                    }
                }
            }
        }
    }



        //g.drawImage(tmpImage, x, y, this);

        /*System.out.println(Player.getOccupatedPlaces().length);
        for (boolean[]rows : Player.getOccupatedPlaces()) {
            for (boolean occupPlace : rows) {
                System.out.print(occupPlace + " ");
            }
            System.out.println();
        }
        System.out.println();*/
    public class HeroesKeyListener2 extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();
            /*if (key == KeyEvent.VK_SHIFT) {
                if (e.getKeyLocation() == 2) {
                    System.out.println("Lewy SHIFT");
                } else {
                    System.out.println("Prawy SHIFT");
                }
            }*/

            for (Player player: players) {
                if (player.getGoLeftKey() == key) {
                    player.tryGoLeft();
                    //player.setX(player.getX() - Constants.CHARACTER_IMG_WIDTH);
                }
                if (player.getGoRightKey() == key) {
                    player.tryGoRight();
                    //player.setX(player.getX() + Constants.CHARACTER_IMG_WIDTH);
                }
                if (player.getGoUpKey() == key) {
                    player.tryGoUp();
                    //player.setY(player.getY() - Constants.CHARACTER_IMG_HEIGHT);
                }
                if (player.getGoDownKey() == key) {
                    player.tryGoDown();
                    //player.setY(player.getY() + Constants.CHARACTER_IMG_HEIGHT);
                }
                if (player.getAttackLeftKey() == key) {
                    player.tryAttackLeft();
                }
                if (player.getAttackRightKey() == key) {
                    player.tryAttackRight();
                }
            }
            repaint();
        }
    }
}
