import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel implements ActionListener{
    private JButton b1;
    private JButton b2;
    private Pong game;

    public MenuPanel(Pong game) {
        setBackground(Color.BLACK);
        this.game = game;
        setLayout(new GridBagLayout());
        JLabel title = new JLabel("Pong");
        title.setFont(new Font("Verdana",1,100));
        b1 = new JButton("Player vs Player");
        b2 = new JButton("Player vs Computer");
        b1.setBackground(Color.GRAY);
        b2.setBackground(Color.GRAY);
        b1.addActionListener(this);
        b2.addActionListener(this);
        this.add(title);
        this.add(b1);
        this.add(b2);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(b1.getText()))
            game.setPanel(new PongPanel(game, 0));
        else
            game.setPanel(new PongPanel(game, 1));
    }
}
