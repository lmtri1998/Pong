import javax.swing.*;
import java.awt.*;
public class Ball {
    private static final int WIDTH = 30, HEIGHT=30;
    private Pong game;
    private int x,y, xAcc = 2, yAcc = 2;

    public Ball(Pong game) {
        this.game = game;
        this.x = game.getWidth()/2;
        this.y = game.getHeight()/2;
    }

    public int getY() {
        return this.y;
    }

    public void update() {
        x += xAcc;
        y += yAcc;
        if(x < 0) {
            game.getPanel().increaseScore(2);
            x = game.getWidth()/2;
            y = game.getHeight()/2;
            xAcc = -xAcc;
            yAcc = 2;
        }
        else if(x > game.getWidth() - HEIGHT - 14) {
            game.getPanel().increaseScore(1);
            x = game.getWidth()/2;
            y = game.getHeight()/2;
            xAcc = -xAcc;
            yAcc = 2;
        }
        else if(y < 0 || y > game.getHeight() - HEIGHT - 29) {
            yAcc = -yAcc;
        }
        // Check score
        if(game.getPanel().getScore(1) == 10) {
            JOptionPane.showMessageDialog(null, "Player 1 wins", "Pong", JOptionPane.PLAIN_MESSAGE);
        }
        else if(game.getPanel().getScore(2) == 10) {
            JOptionPane.showMessageDialog(null, "Player 2 wins", "Pong", JOptionPane.PLAIN_MESSAGE);
        }
        checkCollision();
    }

    public void checkCollision() {
        if(game.getPanel().getPlayer(1).getBounds().intersects(getBounds())) {
            xAcc = -xAcc;
            yAcc += game.getPanel().getPlayer(2).getYAcc();
        }
        if(game.getPanel().getPlayer(2).getBounds().intersects(getBounds())) {
            xAcc = - xAcc;
            yAcc += game.getPanel().getPlayer(2).getYAcc();
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }

    public void paint(Graphics g) {
        g.fillRect(x, y, WIDTH, HEIGHT);
    }
}
