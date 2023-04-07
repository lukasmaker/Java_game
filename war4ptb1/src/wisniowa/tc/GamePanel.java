package wisniowa.tc;

import wisniowa.tc.players.*;
import wisniowa.tc.players.projectiles.Arrow;
import wisniowa.tc.players.projectiles.Spell;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Iterator;

public class GamePanel extends JPanel {
    Player[] players;


    public GamePanel(Team team) {
        this.players = team.getTeamMembers();
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
            if (player instanceof Archer archer) {
                Iterator<Arrow> iter = archer.getArrows().iterator();
                while (iter.hasNext()) {
                    Arrow arrow = iter.next();
                    if (arrow.getX() > Constants.MAX_RIGHT_PLACE || arrow.getX() < 0) {
                        iter.remove();
                        continue;
                    }
                    arrow.setX();
                    g.drawImage(
                            arrow.getBaseImage(),
                            arrow.getX() * Constants.CHARACTER_IMG_WIDTH,
                            arrow.getY() * Constants.CHARACTER_IMG_HEIGHT,
                            this
                    );
                }
            }
            if (player instanceof Mage mage) {
                Iterator<Spell> iter = mage.getSpells().iterator();
                while (iter.hasNext()) {
                    Spell spell = iter.next();
                    if (spell.getX() > Constants.MAX_RIGHT_PLACE || spell.getX() < 0) {
                        iter.remove();
                        continue;
                    }
                    spell.setX();
                    g.drawImage(
                            spell.getBaseImage(),
                            spell.getX() * Constants.CHARACTER_IMG_WIDTH,
                            spell.getY() * Constants.CHARACTER_IMG_HEIGHT,
                            this
                    );
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
            for (Player player : players) {
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
