package ExamFinal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author leenz
 */
public class calculatrice extends JFrame implements ActionListener {

    JFrame frame = new JFrame();
    JPanel pan = new JPanel();
    JLabel label1 = new JLabel("Entrez le 1er nombre:");
    JLabel label2 = new JLabel("Entrez le 2eme nombre:");
    JLabel label3 = new JLabel("Resultat:");

    JTextField nbr1 = new JTextField(30);
    JTextField nbr2 = new JTextField(30);
    JTextField r = new JTextField(30);

    JButton button1 = new JButton("Addition");
    JButton button2 = new JButton("Multiplication");
    JButton button3 = new JButton("Division");
    JButton button4 = new JButton("Soustraction");

    public calculatrice() {
        this.setSize(450, 450);
        this.setTitle("Calculatrice:");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        r.setBackground(Color.BLACK);
        r.setForeground(Color.GREEN);

        // panel
        pan.setLayout(new GridLayout(5, 2));
        this.add(pan);
        pan.add(label1);
        pan.add(nbr1);

        pan.add(label2);
        pan.add(nbr2);

        pan.add(label3);
        pan.add(r);

        pan.add(button1);
        pan.add(button2);
        pan.add(button3);
        pan.add(button4);

        // buttons
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double x = Double.parseDouble(nbr1.getText());
            double y = Double.parseDouble(nbr2.getText());

            if (e.getSource() == button1) {
                String rep = String.valueOf(x + y);
                r.setText(rep);
            } 
            else if (e.getSource() == button2) {
                String rep = String.valueOf(x * y);
                r.setText(rep);
            } 
            else if (e.getSource() == button3) {
                if (y != 0) {
                    String rep = String.valueOf(x / y);
                    r.setText(rep);
                } else {
                    r.setText("Division par zero!");
                }
            } 
            else if (e.getSource() == button4) {
                String rep = String.valueOf(x - y);
                r.setText(rep);
            }
        } catch (NumberFormatException ex) {
            r.setText("Entrée invalide!");
        }
}
}