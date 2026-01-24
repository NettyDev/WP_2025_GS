package pl.szwyngiel;

import javax.swing.*;
import java.awt.*;

public class App extends JFrame
{
    private JMyPanel panel = new JMyPanel();
    private MazeFacade mazeFacade = new MazeFacade();


    public App() {
        setSize(800, 600);   // rozmiar okna aplikacji
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // sposób zamykania aplikacji - standardowy
        setLayout(new BorderLayout());  // ustawienie menadżera rozkładu
        add(panel, BorderLayout.CENTER);
        JPanel panelMenu = new JPanel(new GridLayout(1, 1));
        add(panelMenu, BorderLayout.NORTH);
        JButton buttonDraw = new JButton("Draw maze");
        buttonDraw.addActionListener(event -> {
            Maze nr1 = mazeFacade.createMaze(100, 50);
            Maze nr2 = mazeFacade.createMaze(300, 50);
            nr1.draw(panel.getImage());
            nr2.draw(panel.getImage());
            panel.repaint();
        });
        panelMenu.add(buttonDraw);
        setVisible(true);  // wyświetla okno aplikacji na ekranie
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
