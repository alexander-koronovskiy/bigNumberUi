package com;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Swingtest extends JFrame implements ActionListener {
    JPanel myPanel;
    JTextField namedata;
    JTextField txtdata;
    JTextField inputdata;
    JTextField outresult;
    JLabel label1;
    JLabel label2;
    JLabel label3;

    JButton   calbtn    = new JButton("добавить данные");
    JButton   btn2      = new JButton("очистить содержимое");
    JButton   btn3      = new JButton("разместить предметы");
    Algoritms algoritms = new Algoritms();

    public Swingtest() {
        myPanel   = new JPanel();
        namedata  = new JTextField();
        txtdata   = new JTextField();
        inputdata = new JTextField();
        outresult = new JTextField();
        label1 = new JLabel("Наименование предмета");
        label2 = new JLabel("Вес / Объем");
        label3 = new JLabel("Ценность");

        add(myPanel);
        myPanel.setLayout(new GridLayout(10, 10));

        myPanel.add(label1);
        myPanel.add(namedata);
        myPanel.add(label2);
        myPanel.add(txtdata);
        myPanel.add(label3);
        myPanel.add(inputdata);
        myPanel.add(calbtn);
        myPanel.add(btn2);
        // myPanel.add(btn3);
        myPanel.add(outresult);

        calbtn.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        // inputdata.addKeyListener(new KeyL());

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calbtn) {
            this.put();
        }
        if (e.getSource() == btn2){
            this.clean();
        }
        if (e.getSource() == btn3){
            this.clean();
        }
    }

    public void put() {
        String object = namedata.getText();
        String volume = txtdata.getText();
        String value  = inputdata.getText();
        String s = algoritms.putInBackpack(object,volume,value);
        outresult.setText(s);
    }

    public void clean(){
        outresult.setText(algoritms.cleanBackPack());
    }
    
    public static void main(String args[]) {
        Swingtest g = new Swingtest();
        g.setLocation(10, 10);
        g.setSize(500, 400);
        g.setVisible(true);
        g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    class KeyL implements KeyListener {
        public void keyTyped(KeyEvent k) {}
        public void keyPressed(KeyEvent k) {}
        public void keyReleased(KeyEvent k) {
            if (k.getKeyCode()==10)
            {
                String data = txtdata.getText();
                String otherdata = inputdata.getText();
                String s = algoritms.note(otherdata, data);
                outresult.setText(s);
            }
        }
    }

}
