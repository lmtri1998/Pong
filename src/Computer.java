import java.awt.*;

public class Computer extends Player{
    private static final int WIDTH = 20, HEIGHT = 150;
    private int yAcc;

    public Computer(Pong game, int yAcc, int x) {
        super(game, x);
        this.yAcc = yAcc;
    }

    public void update() {
        if(y > 0 && y < game.getHeight() - HEIGHT - 29) {
            if(this.y > game.getPanel().getBall().getY()) {
                y -= yAcc;
            }
            else if(this.y < game.getPanel().getBall().getY()) {
                y += yAcc;
            }
        }
        else if(y <=0) {
            y++;
        }
        else if(y>=game.getHeight() - HEIGHT - 29) {
            y--;
        }
    }

    public void keyPressed(int keyCode) {
    }

    public void keyRelease(int keyCode) {
    }

    public int getYAcc() {
        return yAcc;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }

    public void paint(Graphics g) {
        g.fillRect(x, y, WIDTH, HEIGHT);
    }
}
