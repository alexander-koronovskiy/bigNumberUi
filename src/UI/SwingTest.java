package UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Swingtest extends JFrame implements ActionListener {
    JPanel myPanel;
    JTextField txtdata;
    JTextField inputdata;
    JTextField outresult;

    JButton calbtn = new JButton("Calculate");
    Algoritms algoritms = new Algoritms();

    public Swingtest() {
        myPanel = new JPanel();
        txtdata = new JTextField("первое слагаемое");
        inputdata = new JTextField("второе слагаемое");
        outresult = new JTextField("результат");

        add(myPanel);
        myPanel.setLayout(new GridLayout(4, 4));

        myPanel.add(txtdata);
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
                String s = algoritms.sum(data,otherdata);
                outresult.setText(s);
            }
        }
    }

    public void action() {
        String data = txtdata.getText();
        String otherdata = inputdata.getText();
        String s = algoritms.sum(data,otherdata);
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
        g.setSize(300, 300);
        g.setVisible(true);
        g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
