package com.chauke;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {

    private JFrame frame;
    private JTextField textField;
    private JButton[] numberButtons = new JButton[10];
    private JButton[] functionButtons = new JButton[8];
    private JButton addButton, subButton, multiplyButton, divideButton;
    private JButton decimalButton, equalButton, deleteButton, clearButton;
    private JPanel panel;

    private final Font font = new Font("Ink Free", Font.BOLD,30);

    private double num1, num2, result = 0;

    public Calculator(){

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setFont(font);
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        clearButton = new JButton("Clear");
        deleteButton = new JButton("<-");
        equalButton = new JButton("=");
        decimalButton = new JButton(".");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = multiplyButton;
        functionButtons[3] = divideButton;
        functionButtons[4] = decimalButton;
        functionButtons[5] = equalButton;
        functionButtons[6] = deleteButton;
        functionButtons[7] = clearButton;

        for (int i = 0; i < 8; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(font);
            functionButtons[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(font);
            numberButtons[i].setFocusable(false);
        }

        deleteButton.setBounds(50,430,145,50);
        clearButton.setBounds(205,430,145,50);

        frame.add(deleteButton);
        frame.add(clearButton);
        frame.add(textField);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
