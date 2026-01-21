package pl.szwyngiel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame
{
    private JMyPanel panel = new JMyPanel();;
    private Image image;


    public App() {
        setSize(400, 300);   // rozmiar okna aplikacji
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // sposób zamykania aplikacji - standardowy
        setLayout(new BorderLayout());  // ustawienie menadżera rozkładu
        add(panel, BorderLayout.CENTER);
        JPanel panelMenu = new JPanel(new GridLayout(1, 1));
        add(panelMenu, BorderLayout.NORTH);
        JButton buttonDraw = new JButton("Draw maze");
        buttonDraw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = 100;
                int y = 50;  // współrzędne początku labiryntu
                image = panel.getImage();   // pobieramy z panela referencję obiektu obrazu, na którym rysujemy
                buildMaze(x, y);   // rysujemy labirynt
                panel.repaint();   // odrysowanie obrazu na panelu

            }
        });
        panelMenu.add(buttonDraw);
        setVisible(true);  // wyświetla okno aplikacji na ekranie
    }

    private void buildMaze(int x, int y) {

        int nr = 1;

        // Graphics g = image.getGraphics();
//        g.drawLine(x, y, x + MapSite.Length, y + MapSite.Length);

        Wall w1 = new Wall(Directions.North);
        w1.setX(x);
        w1.setY(y);
        //w1.draw(image);

        Wall w2 = new Wall(Directions.East);
        w2.setX(x);
        w2.setY(y);
//         w2.draw(image);

        Room r1 = new Room(x, y, nr++);
        r1.setSite(Directions.South, w1);
        r1.setSite(Directions.East, w2);
        r1.setSite(Directions.North, new Wall(Directions.South));
        r1.setSite(Directions.West, new Wall(Directions.West));



        Room r2 = new Room(x + MapSite.Length, y, nr++);
        r2.setSite(Directions.South, new Wall(Directions.North));
        r2.setSite(Directions.East, new Wall(Directions.East));
        r2.setSite(Directions.North, new Wall(Directions.South));
        r2.setSite(Directions.West, new Wall(Directions.West));

        Room r3 = new Room(x + MapSite.Length, y + MapSite.Length, nr++);
        r3.setSite(Directions.South, new Wall(Directions.North));
        r3.setSite(Directions.East, new Wall(Directions.East));
        r3.setSite(Directions.North, new Wall(Directions.South));
        r3.setSite(Directions.West, new Wall(Directions.West));

        // Door d12 = new Door(r1, r2);
        // Door d23 = new Door(r2, r3);

        r1.draw(image);
        r2.draw(image);
        r3.draw(image);


    }

    public static void main( String[] args )
    {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new App();
            }
        });

    }
}
