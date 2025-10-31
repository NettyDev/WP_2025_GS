package pl.szwyngiel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame
{
    public App() {
        Calc calc = new Calc();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panelButton =  new JPanel(new GridLayout(5,4));
        JTextField textFieldScreen = new JTextField(10);
        JButton button_09 = new JButton("9");
        button_09.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldScreen.setText(textFieldScreen.getText()+"9");
            }
        });
        panelButton.add(button_09);

        JButton button_08 = new JButton("8");
        button_08.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldScreen.setText(textFieldScreen.getText()+"8");
            }
        });
        panelButton.add(button_08);

        JButton button_07 = new JButton("7");
        button_07.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldScreen.setText(textFieldScreen.getText()+"7");
            }
        });
        panelButton.add(button_07);

        JButton button_divide = new JButton("/");
        button_divide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    calc.setFirst(Integer.parseInt(textFieldScreen.getText()));
                    calc.setOperation(Operation.DIV);
                textFieldScreen.setText("");
            }
        });
        panelButton.add(button_divide);

        JButton button_06 = new JButton("6");
        button_06.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldScreen.setText(textFieldScreen.getText()+"6");
            }
        });
        panelButton.add(button_06);

        JButton button_05 = new JButton("5");
        button_05.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldScreen.setText(textFieldScreen.getText()+"5");
            }
        });
        panelButton.add(button_05);

        JButton button_04 = new JButton("4");
        button_04.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldScreen.setText(textFieldScreen.getText()+"4");
            }
        });
        panelButton.add(button_04);
        JButton button_multiply = new JButton("*");
        button_multiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    calc.setFirst(Integer.parseInt(textFieldScreen.getText()));
                    calc.setOperation(Operation.MUL);
                textFieldScreen.setText("");
            }
        });
        panelButton.add(button_multiply);

        JButton button_03 = new JButton("3");
        button_03.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldScreen.setText(textFieldScreen.getText()+"3");
            }
        });
        panelButton.add(button_03);

        JButton button_02 = new JButton("2");
        button_02.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldScreen.setText(textFieldScreen.getText()+"2");
            }
        });
        panelButton.add(button_02);

        JButton button_01 = new JButton("1");
        button_01.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldScreen.setText(textFieldScreen.getText()+"1");
            }
        });
        panelButton.add(button_01);

        JButton button_minus = new JButton("-");
        button_minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    calc.setFirst(Integer.parseInt(textFieldScreen.getText()));
                    calc.setOperation(Operation.SUB);
                textFieldScreen.setText("");
            }
        });
        panelButton.add(button_minus);

        JButton button_10 = new JButton("0");
        button_10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!textFieldScreen.getText().equals("0"))
                    textFieldScreen.setText(textFieldScreen.getText()+"0");
            }
        });
        panelButton.add(button_10);

        panelButton.add(new JLabel());
        panelButton.add(new JLabel());

        JButton button_plus = new JButton("+");
        button_plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    calc.setFirst(Integer.parseInt(textFieldScreen.getText()));
                    calc.setOperation(Operation.ADD);
                    textFieldScreen.setText("");
            }
        });
        panelButton.add(button_plus);

        JButton button_clear = new JButton("C");
        button_clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldScreen.setText("");
                calc.setFirst(-1);
                calc.setSecond(-1);
            }
        });
        panelButton.add(button_clear);

        JButton button_equal = new JButton("=");
        button_equal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(calc.getFirst() != -1) {
                    calc.setSecond(Integer.parseInt(textFieldScreen.getText()));
                    textFieldScreen.setText(String.valueOf(calc.getResult()));
                    calc.clear();
                }
            }
        });
        panelButton.add(button_equal);




        setLayout(new BorderLayout());
        add(textFieldScreen, BorderLayout.NORTH);
        add(panelButton, BorderLayout.CENTER);

        pack();
    }

    public static void main( String[] args )
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new App().setVisible(true);
            }
        });
    }
}
