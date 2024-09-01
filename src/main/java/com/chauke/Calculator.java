package com.chauke;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {

    private JFrame frame;
    private JTextField textField;
    private final JButton[] numberButtons = new JButton[10];
    private final JButton[] functionButtons = new JButton[9];
    private JButton addButton, subButton, multiplyButton, divideButton, negPosButton;
    private JButton decimalButton, equalButton, deleteButton, clearButton;
    private JPanel panel;

    private final Font font = new Font("Ink Free", Font.BOLD,30);

    private double num1;
    private double result = 0;
    private char operator;

    public Calculator(){
        configureFrame();
        textField = configureTextField();

        setOperatorButtons();

        configureNumberButtons();

        panel = configurePanel();
        addToPanel();

        addToFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decimalButton){
            if (!textField.getText().contains(".")){
            textField.setText(textField.getText().concat("."));
        }
        }
        if (e.getSource() == addButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == subButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == multiplyButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == divideButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource() == equalButton){
            double num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '/':
                    if (num2 == 0){
                        textField.setText("Error");
                        return;
                    }
                    result = num1 / num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clearButton) {
            textField.setText("");
        }
        if (e.getSource() == deleteButton) {
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textField.setText(textField.getText() + string.charAt(i));
            }
        }
        if (e.getSource() == negPosButton){
            double temp = Double.parseDouble(textField.getText());
            temp*=-1;
            textField.setText(String.valueOf(temp));
        }
    }

    private void configureFrame(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);

//        return frame;
    }

    private JTextField configureTextField(){
        textField = new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setFont(font);
        textField.setEditable(false);

        return textField;
    }

    private void setOperatorButtons(){
        addButton = new JButton("+");
        subButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        clearButton = new JButton("Clear");
        deleteButton = new JButton("<-");
        equalButton = new JButton("=");
        decimalButton = new JButton(".");
        negPosButton = new JButton("-/+");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = multiplyButton;
        functionButtons[3] = divideButton;
        functionButtons[4] = decimalButton;
        functionButtons[5] = equalButton;
        functionButtons[6] = deleteButton;
        functionButtons[7] = clearButton;
        functionButtons[8] = negPosButton;

        for (int i = 0; i < 9; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(font);
            functionButtons[i].setFocusable(false);
        }

        negPosButton.setBounds(50,430,100,50);
        deleteButton.setBounds(150,430,100,50);
        clearButton.setBounds(250,430,100,50);
    }

    private void configureNumberButtons(){
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(font);
            numberButtons[i].setFocusable(false);
        }
    }

    private JPanel configurePanel(){
        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));

        return panel;
    }

    private void addToPanel(){
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(multiplyButton);
        panel.add(decimalButton);
        panel.add(numberButtons[0]);
        panel.add(equalButton);
        panel.add(divideButton);

    }

    private void addToFrame(){
        frame.add(panel);
        frame.add(negPosButton);
        frame.add(deleteButton);
        frame.add(clearButton);
        frame.add(textField);
        frame.setVisible(true);
    }
}
