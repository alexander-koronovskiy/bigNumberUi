package com;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Swingtest extends JFrame implements ActionListener {
    JPanel myPanel;
    JTextField txtdata;
    JTextField inputdata;
    JTextField outresult;
    JLabel label1;
    JLabel label2;

    JButton calbtn = new JButton("добавить данные");
    Algoritms algoritms = new Algoritms();

    public Swingtest() {
        myPanel = new JPanel();
        txtdata = new JTextField();
        inputdata = new JTextField();
        outresult = new JTextField();
        label1 = new JLabel("Имя");
        label2 = new JLabel("Возраст");

        add(myPanel);
        myPanel.setLayout(new GridLayout(6, 6));

        myPanel.add(label1);
        myPanel.add(txtdata);
        myPanel.add(label2);
        myPanel.add(inputdata);
        myPanel.add(calbtn);
        myPanel.add(outresult);

        calbtn.addActionListener(this);
        inputdata.addKeyListener(new KeyL());

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

    public void action() {
        String data = txtdata.getText();
        String otherdata = inputdata.getText();
        String s = algoritms.note(otherdata,data);
        outresult.setText(s);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calbtn) {
            this.action();
        }
    }

    public static void main(String args[]) {
        Swingtest g = new Swingtest();
        g.setLocation(10, 10);
        g.setSize(500, 400);
        g.setVisible(true);
        g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
