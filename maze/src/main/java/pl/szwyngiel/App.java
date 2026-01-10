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
        // g.drawLine(x, y, x+MapSite.Length, y+MapSite.Length);

        // Wall w1 = new Wall(Directions.North);
        // w1.setX(x);
        // w1.setY(y);
        // w1.draw(image);

        // Wall w2 = new Wall(Directions.East);
        // w2.setX(x);
        // w2.setY(y);
        // w2.draw(image);

        Room r1 = new Room(x, y, 1);
        r1.setSite(Directions.North, new Wall(Directions.North));
        r1.setSite(Directions.East, new Wall(Directions.East));
        r1.setSite(Directions.South, new Wall(Directions.South));
        r1.setSite(Directions.West, new Wall(Directions.West));
        r1.draw(image);

        Room r2 = new Room(x + MapSite.Length, y, 2);
        r2.setSite(Directions.North, new Wall(Directions.North));
        r2.setSite(Directions.East, new Wall(Directions.East));
        r2.setSite(Directions.South, new Wall(Directions.South));
        r2.setSite(Directions.West, new Wall(Directions.West));
        r2.draw(image);

        Door d1 = new Door(r1, r2);
        d1.draw(image);

        Room r3 = new Room(x + MapSite.Length, y+MapSite.Length, 3);
        r3.setSite(Directions.North, new Wall(Directions.North));
        r3.setSite(Directions.East, new Wall(Directions.East));
        r3.setSite(Directions.South, new Wall(Directions.South));
        r3.setSite(Directions.West, new Wall(Directions.West));
        r3.draw(image);

        Door d2 = new Door(r2, r3);
        d2.draw(image);

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
