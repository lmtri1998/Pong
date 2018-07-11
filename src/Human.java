import java.awt.*;

public class Human extends Player{
    private static final int WIDTH = 20, HEIGHT=150;
    private int yAcc;
    private int up, down;

    public Human(Pong game, int up, int down, int x) {
        super(game,x);
        this.up = up;
        this.down = down;
    }

    public void update() {
        if(y > 0 && y < game.getHeight() - HEIGHT - 29) {
            y += yAcc;
        }
        else if(y <=0) {
            y++;
        }
        else if(y>=game.getHeight() - HEIGHT - 29) {
            y--;
        }
    }

    public void keyPressed(int keyCode) {
        if(keyCode == up)
            yAcc = -4;
        else if(keyCode == down)
            yAcc = 4;
    }

    public void keyRelease(int keyCode) {
        if(keyCode == up || keyCode == down)
            yAcc = 0;
    }

    public int getYAcc() {
        return yAcc;
    }

    public int getX() {
        return x;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }

    public void paint(Graphics g) {
        g.fillRect(x, y, WIDTH, HEIGHT);
    }
}
