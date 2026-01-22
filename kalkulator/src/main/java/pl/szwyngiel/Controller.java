package pl.szwyngiel;

import javax.swing.*;
import java.awt.event.*;

public class Controller {
    private final Model model;
    private final View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        for (JButton button : view.getNumberButtons()) {
            button.addActionListener(new NumberButtonListener());
        }

        view.getButtonAdd().addActionListener(new OperationButtonListener(Operation.ADD));
        view.getButtonSub().addActionListener(new OperationButtonListener(Operation.SUB));
        view.getButtonMul().addActionListener(new OperationButtonListener(Operation.MUL));
        view.getButtonDiv().addActionListener(new OperationButtonListener(Operation.DIV));

        view.getButtonEqu().addActionListener(new EqualsButtonListener());
        view.getButtonClr().addActionListener(new ClearButtonListener());
    }

    private class NumberButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            view.setText(view.getText() + source.getText());
        }
    }

    private class OperationButtonListener implements ActionListener {
        private final Operation operation;

        public OperationButtonListener(Operation operation) {
            this.operation = operation;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            model.setFirst(Integer.parseInt(view.getText()));
            model.setOperation(operation);
            view.setText("");
        }
    }

    private class EqualsButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.setSecond(Integer.parseInt(view.getText()));
            try {
                int result = model.getResult();
                view.setText(Integer.toString(result));
            } catch (Exception exception) {
                view.setText(exception.getMessage());
            }
        }
    }

    public class ClearButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.clear();
            view.setText("");
        }
    }
}
