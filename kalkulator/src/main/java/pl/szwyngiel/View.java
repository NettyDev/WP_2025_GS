package pl.szwyngiel;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private final JButton button0 = new JButton("0");
    private final JButton button1 = new JButton("1");
    private final JButton button2 = new JButton("2");
    private final JButton button3 = new JButton("3");
    private final JButton button4 = new JButton("4");
    private final JButton button5 = new JButton("5");
    private final JButton button6 = new JButton("6");
    private final JButton button7 = new JButton("7");
    private final JButton button8 = new JButton("8");
    private final JButton button9 = new JButton("9");

    private final JButton buttonAdd = new JButton("+");
    private final JButton buttonSub = new JButton("-");
    private final JButton buttonMul = new JButton("*");
    private final JButton buttonDiv = new JButton("/");

    private final JButton buttonEqu = new JButton("=");
    private final JButton buttonClr = new JButton("C");

    private final JTextField textField = new JTextField(10);

    private final JPanel panelButtons = new JPanel(new GridLayout(4,4));

    private final Font fontTextField  = new Font("Arial", Font.PLAIN, 30);
    private final Font fontButton = new Font("Arial", Font.PLAIN, 16);

    public View() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        textField.setFont(fontTextField);

        for (JButton button : this.getNumberButtons()) {
            button.setFont(fontButton);
        }
        buttonAdd.setFont(fontButton);
        buttonSub.setFont(fontButton);
        buttonMul.setFont(fontButton);
        buttonDiv.setFont(fontButton);
        buttonEqu.setFont(fontButton);
        buttonClr.setFont(fontButton);

        panelButtons.add(button9);
        panelButtons.add(button8);
        panelButtons.add(button7);
        panelButtons.add(buttonDiv);
        panelButtons.add(button6);
        panelButtons.add(button5);
        panelButtons.add(button4);
        panelButtons.add(buttonMul);
        panelButtons.add(button3);
        panelButtons.add(button2);
        panelButtons.add(button1);
        panelButtons.add(buttonSub);
        panelButtons.add(buttonClr);
        panelButtons.add(button0);
        panelButtons.add(buttonEqu);
        panelButtons.add(buttonAdd);

        setLayout(new BorderLayout());
        add(textField, BorderLayout.NORTH);
        add(panelButtons, BorderLayout.CENTER);
        pack();
        setSize(200,300);
        setVisible(true);
    }

    public String getText() {
        return textField.getText();
    }

    public void setText(String text) {
        textField.setText(text);
    }

    public JButton[] getNumberButtons() {
        return new JButton[] { button0, button1, button2, 
            button3, button4, button5, 
            button6, button7, button8, 
            button9 };
    }

    public JButton getButtonAdd() {
        return buttonAdd;
    }

    public JButton getButtonSub() {
        return buttonSub;
    }

    public JButton getButtonMul() {
        return buttonMul;
    }

    public JButton getButtonDiv() {
        return buttonDiv;
    }

    public JButton getButtonEqu() {
        return buttonEqu;
    }

    public JButton getButtonClr() {
        return buttonClr;
    }
}
