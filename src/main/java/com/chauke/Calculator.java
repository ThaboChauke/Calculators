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
    private JButton addButton, subButton, multiplyButton, divideButton, equalButton, deleteButton, clearButton;
    private JPanel panel;

    private final Font font = new Font("Ink Free", Font.BOLD,30);

    private double num1, num2, result = 0;
    
    public Calculator(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
