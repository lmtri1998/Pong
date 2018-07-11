
import java.awt.*;

public abstract class Player {
    private static final int WIDTH = 20, HEIGHT=150;
    protected Pong game;
    protected int x,y;

    public Player(Pong game, int x) {
        this.game = game;
        this.x = x;
        this.y = game.getHeight()/2;
    }

    public abstract int getYAcc();

    public abstract  void update();

    public abstract void keyPressed(int keyCode);

    public abstract void keyRelease(int keyCode);

    public Rectangle getBounds() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }

    public void paint(Graphics g) {
        g.fillRect(x, y, WIDTH, HEIGHT);
    }
}
