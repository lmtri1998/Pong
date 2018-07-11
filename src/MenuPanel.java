import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel implements ActionListener{
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private Pong game;

    public MenuPanel(Pong game) {
        setBackground(Color.BLACK);
        this.game = game;
        setLayout(new GridBagLayout());
        JLabel title = new JLabel("Pong");
        title.setFont(new Font("Verdana",1,100));
        b1 = new JButton("Player vs Player");
        b2 = new JButton("Player vs Computer");
        b3 = new JButton("Computer vs Computer");
        b1.setBackground(Color.GRAY);
        b2.setBackground(Color.GRAY);
        b3.setBackground(Color.GRAY);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        this.add(title);
        this.add(b1);
        this.add(b2);
        this.add(b3);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(b1.getText()))
            game.setPanel(new PongPanel(game, 0));
        else if(e.getActionCommand().equals(b2.getText()))
            game.setPanel(new PongPanel(game, 1));
        else
            game.setPanel(new PongPanel(game,2));
    }
}
