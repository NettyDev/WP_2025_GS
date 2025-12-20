package pl.szwyngiel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame 
{
    private JMyPanel panel = new JMyPanel();
    private Image image;
    public App() {
        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        JPanel panelMenu = new JPanel(new GridLayout(1,1));
        add(panelMenu, BorderLayout.NORTH);
        JButton buttonDraw = new JButton("Draw maze");
        buttonDraw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = 100;
                int y = 50;
                image = panel.getImage();
                buildMaze(x,y);
                panel.repaint();
            }
        });
        panelMenu.add(buttonDraw);
        setVisible(true);
    }

    private void buildMaze(int x, int y) {
        Graphics g = image.getGraphics();
        g.drawLine(x, y, x+MapSite.Length, y+MapSite.Length);

        Wall w1 = new Wall(Directions.North);
        w1.setX(x);
        w1.setY(y);
        w1.draw(image);

        Wall w2 = new Wall(Directions.East);
        w2.setX(x);
        w2.setY(y);
        w2.draw(image);

        Room r1 = new Room(x + 20, y-10, 1);
        r1.setSite(Directions.North, w1);
        r1.setSite(Directions.East, w2);
        r1.draw(image);

    }
    public static void main( String[] args )
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new App();
            }
        });
    }
}
