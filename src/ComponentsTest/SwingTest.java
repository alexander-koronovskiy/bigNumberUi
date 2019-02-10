package ComponentsTest;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Swingtest extends JFrame implements ActionListener{
    JPanel myPanel;
    JTextField txtdata;
    JTextField inputdata;
    JTextField outresult;
    JButton calbtn = new JButton("Calculate");
    Algoritms algoritms = new Algoritms();

    public Swingtest()
    {
        myPanel = new JPanel();
        txtdata = new JTextField();
        inputdata = new JTextField();
        outresult = new JTextField();

        add(myPanel);
        myPanel.setLayout(new GridLayout(4, 4));

        myPanel.add(txtdata);
        myPanel.add(inputdata);
        myPanel.add(calbtn);
        myPanel.add(outresult);

        calbtn.addActionListener(this);
        txtdata.addKeyListener(new KeyL());

    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == calbtn) {
            String data = txtdata.getText();
            String otherdata = inputdata.getText();
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