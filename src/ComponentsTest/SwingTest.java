package ComponentsTest;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Arrays;
import java.util.Collections;

class Swingtest extends JFrame implements ActionListener{
    JTextField txtdata;
    JTextField outresult;
    JButton calbtn = new JButton("Calculate");
    Algoritms algoritms = new Algoritms();

    public Swingtest()
    {
        JPanel myPanel = new JPanel();
        add(myPanel);
        // myPanel.addKeyListener(this);
        myPanel.setLayout(new GridLayout(3, 3));
        txtdata = new JTextField();
        myPanel.add(txtdata);
        myPanel.add(calbtn);
        calbtn.addActionListener(this);
        outresult = new JTextField();
        myPanel.add(outresult);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == calbtn) {
            String data = txtdata.getText(); //perform your operation
            String s = algoritms.bigNumAlgs(data);
            outresult.setText(s);
        }
    }

    public static void main(String args[])
    {
        Swingtest g = new Swingtest();
        g.setLocation(10, 10);
        g.setSize(300, 300);
        g.setVisible(true);
        g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}