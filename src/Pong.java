import javax.swing.*;
import java.awt.*;

public class Pong extends JFrame{
    private MenuPanel menuPanel;
    private PongPanel panel;
    public Pong() {
        setSize(1920,1080);
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setTitle("Pong");
        setBackground(Color.GRAY);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        menuPanel = new MenuPanel(this);
        add(menuPanel);
        setVisible(true);
    }
    public void setPanel(PongPanel panel) {
        this.panel = panel;
        setVisible(false);
        this.remove(menuPanel);
        this.add(panel);
        this.revalidate();
        this.repaint();
        setVisible(true);
    }

    public PongPanel getPanel() {
        return panel;
    }

    public static void main(String[] args) {
        new Pong();
    }
}
