import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PongPanel extends JPanel implements ActionListener, KeyListener{
    private Pong game;
    private Ball ball;
    private Player player1, player2;
    private int mode;
    private int score1, score2;
    public PongPanel(Pong game, int mode) {
        setBackground(Color.BLACK);
        this.game  = game;
        this.mode = mode;
        ball = new Ball(game);
        if(this.mode == 0)
            player1 = new Human(game, KeyEvent.VK_UP, KeyEvent.VK_DOWN, game.getWidth() - 140);
        else
            player1 = new Computer(game, 4, game.getWidth() - 140);
        player2 = new Human(game, KeyEvent.VK_W, KeyEvent.VK_S, 100);
        score1 = 0;
        score2 = 0;
        Timer timer = new Timer(5, this);
        timer.start();
        addKeyListener(this);
        setFocusable(true);
    }

    public Ball getBall() {
        return ball;
    }

    public Player getPlayer(int playerNo) {
        if(playerNo == 1)
            return player1;
        else
            return player2;
    }

    public void increaseScore(int playerNo) {
        if(playerNo == 1)
            score1++;
        else
            score2++;
    }

    public int getScore(int playerNo) {
        if(playerNo == 1)
            return score1;
        else
            return score2;
    }

    private void update() {
        ball.update();
        player1.update();
        player2.update();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        update();
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(this.mode == 0) {
            player1.keyPressed(e.getKeyCode());
        }
        player2.keyPressed(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(this.mode == 0) {
            player1.keyRelease(e.getKeyCode());
        }
        player2.keyRelease(e.getKeyCode());
    }

    @Override
    public void keyTyped(KeyEvent e) {
        ;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        g.drawString(game.getPanel().getScore(1) + "   " + game.getPanel().getScore(2), game.getWidth() / 2 - 20, 35);
        g.drawLine(game.getWidth()/2, 0, game.getWidth()/2, game.getHeight());
        ball.paint(g);
        player1.paint(g);
        player2.paint(g);
    }
}
