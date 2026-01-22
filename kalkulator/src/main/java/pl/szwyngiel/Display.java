package pl.szwyngiel;

import java.awt.*;
import javax.swing.*;

public class Display extends JFrame implements DisplayObserver  {
    private final JTextField textField;

    public Display() {
        textField = new JTextField();
        textField.setEditable(false);
        textField.setFont(new Font("Arial", Font.BOLD, 30));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setPreferredSize(new Dimension(200, 60));
        textField.setBackground(Color.BLACK);

        setTitle("External Display");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(textField);
        pack();
        setVisible(true);
    }

    

    @Override
    public void update(String text) {
        textField.setText(text);

        try {
            int number = Integer.parseInt(text);
            if (number >= 0) {
                textField.setForeground(Color.GREEN);
            } else {
                textField.setForeground(Color.RED);
            }
        } catch (NumberFormatException e) {
            textField.setForeground(Color.WHITE);
        }
    }
}