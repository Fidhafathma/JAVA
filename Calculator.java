import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Calc extends JFrame implements ActionListener {
    
    JFrame f;
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, badd, bsub, bmul, bdiv, bc, be;
    JTextField t;
    double a, b, r;
    int op  ;

    Calc() {
        f = new JFrame("Calculator");
        f.setLayout(null);
        f.setVisible(true);
        f.setBounds(50, 50, 400, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        t = new JTextField();
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        b0 = new JButton("0");
        be = new JButton("=");
        bc = new JButton("clr");
        badd = new JButton("+");
        bsub = new JButton("-");
        bmul = new JButton("*");
        bdiv = new JButton("/");

        b1.setBounds(60, 60, 50, 50);
        b2.setBounds(120, 60, 50, 50);
        b3.setBounds(180, 60, 50, 50);
        b4.setBounds(240, 60, 50, 50);
        b5.setBounds(60, 120, 50, 50);
        b6.setBounds(120, 120, 50, 50);
        b7.setBounds(180, 120, 50, 50);
        b8.setBounds(240, 120, 50, 50);
        b9.setBounds(60, 180, 50, 50);
        b0.setBounds(120, 180, 50, 50);
        be.setBounds(180, 180, 50, 50);
        bc.setBounds(240, 180, 50, 50);
        badd.setBounds(60, 240, 50, 50);
        bsub.setBounds(120, 240, 50, 50);
        bmul.setBounds(180, 240, 50, 50);
        bdiv.setBounds(240, 240, 50, 50);

        t.setBounds(60, 20, 230, 30);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b0.addActionListener(this);
        be.addActionListener(this);
        bc.addActionListener(this);
        badd.addActionListener(this);
        bsub.addActionListener(this);
        bmul.addActionListener(this);
        bdiv.addActionListener(this);

        f.add(t);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);
        f.add(b6);
        f.add(b7);
        f.add(b8);
        f.add(b9);
        f.add(b0);
        f.add(be);
        f.add(bc);
        f.add(badd);
        f.add(bsub);
        f.add(bmul);
        f.add(bdiv);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            t.setText(t.getText().concat("1"));
        } else if (e.getSource() == b2) {
            t.setText(t.getText().concat("2"));
        } else if (e.getSource() == b3) {
            t.setText(t.getText().concat("3"));
        } else if (e.getSource() == b4) {
            t.setText(t.getText().concat("4"));
        } else if (e.getSource() == b5) {
            t.setText(t.getText().concat("5"));
        } else if (e.getSource() == b6) {
            t.setText(t.getText().concat("6"));
        } else if (e.getSource() == b7) {
            t.setText(t.getText().concat("7"));
        } else if (e.getSource() == b8) {
            t.setText(t.getText().concat("8"));
        } else if (e.getSource() == b9) {
            t.setText(t.getText().concat("9"));
        } else if (e.getSource() == b0) {
            t.setText(t.getText().concat("0"));
        } else if (e.getSource() == badd) {
            a = Double.parseDouble(t.getText());
            op = 1;
            t.setText(null);
        } else if (e.getSource() == bsub) {
            a = Double.parseDouble(t.getText());
            op = 2;
            t.setText(null);
        } else if (e.getSource() == bmul) {
            a = Double.parseDouble(t.getText());
            op = 3;
            t.setText(null);
        } else if (e.getSource() == bdiv) {
            a = Double.parseDouble(t.getText());
            op = 4;
            t.setText(null);
        } else if (e.getSource() == be) {
            b = Double.parseDouble(t.getText());
            switch (op) {
                case 1:
                    r = a + b;
                    break;
                case 2:
                    r = a - b;
                    break;
                case 3:
                    r = a * b;
                    break;
                case 4:
                    if (b != 0) {
                        r = a / b;
                    } else {
                        t.setText("Error");
                        return;
                    }
                    break;
            }
            t.setText(""+r);
        } else if (e.getSource() == bc) {
            t.setText(null);
        }
    }   
}   
class Calculator {
    public static void main(String[] args){
        Calc c = new Calc();
    }
}
