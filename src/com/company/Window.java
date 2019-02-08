package com.company;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    // объявление компонентов окна
    private JFrame w = new JFrame();
    private JTextField inputField = new JTextField();
    private JButton button = new JButton("Получить наибольшее");
    private JTextField outputField = new JTextField();
    private JLabel inLabel = new JLabel("Введите большое число");
    private JLabel buttonLabel = new JLabel();
    private JLabel outLabel = new JLabel("Наибольшее число из введенных цифр");

    // геттеры и сеттеры
    public JButton getButton(){return button;}
    public JTextField getInputField(){return inputField;}

    // размеры окна
    private Dimension wSize = new Dimension(300, 400);

    //местоположение поля ввода
    private int inBordX = 20;
    private int inBordY = 50;
    private int inBordWidth = 200;
    private int inBordHeight = 20;

    // местоположение кнопки
    private int buttonBordX = 20;
    private int buttonBordY = 100;
    private int buttonBordWidth = 200;
    private int buttonBordHeight = 20;

    // местоположение поля вывода
    private int outBordX = 20;
    private int outBordY = 180;
    private int outBordWidth = 200;
    private int outBordHeight = 20;

    // местоположение подписей
    private int inLabelX = 20;
    private int inLabelY = 20;
    private int inLabelWidth = 200;
    private int inLabelHeight = 20;

    private int outLabelX = 20;
    private int outLabelY = 150;
    private int outLabelWidth = 300;
    private int outLabelHeight = 20;

    public void init() {
        // задание параметров окна
        w.setSize(wSize);
        w.setLayout(null);
        w.setVisible(true);

        // добавление компонентов
        w.add(inputField);
        w.add(button);
        w.add(outputField);

        // добавление подписей
        w.add(inLabel);
        w.add(buttonLabel);
        w.add(outLabel);

        // параметры компонентов
        inputField.setBounds(inBordX,inBordY,inBordWidth,inBordHeight);
        outputField.setBounds(outBordX,outBordY,outBordWidth,outBordHeight);
        button.setBounds(buttonBordX,buttonBordY,buttonBordWidth,buttonBordHeight);

        // параметры подписей
        inLabel.setBounds(inLabelX,inLabelY,inLabelWidth,inLabelHeight);
        outLabel.setBounds(outLabelX,outLabelY,outLabelWidth,outLabelHeight);

        // обработка событий
        Events event = new Events();
        button.addActionListener(event);
        inputField.addActionListener(event);

        // логика приложения

    }

}
