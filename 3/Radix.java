import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Radix extends JFrame implements ActionListener {
  private JFrame f;
  private JTextField hex, dec;
  private JLabel hexLabel, decLabel;

  public Radix() {
    hex = new JTextField(3);
    dec = new JTextField(3);
    this.setLayout(new GridLayout(2, 2));
    this.add(new JLabel("16"));
    this.add(hex);
    this.add(new JLabel("10"));
    this.add(dec);
    this.pack();
    hex.addActionListener(this);
    dec.addActionListener(this);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == hex) {
      String input = hex.getText();
      try {
        int decimalValue = Integer.parseInt(input, 16);
        dec.setText(Integer.toString(decimalValue));
      } catch (NumberFormatException ex) { // 念のため非数の入力でErrorと表示
        dec.setText("Error");
      }
    } // JTextFied hex に対する処理
    else if (e.getSource() == dec) {
      String input = dec.getText();
      try {
        int decimalValue = Integer.parseInt(input, 10);
        hex.setText(Integer.toString(decimalValue, 16).toUpperCase());
      } catch (NumberFormatException ex) { // 念のため非数の入力でErrorと表示
        hex.setText("Error");
      }
    } // JTextFied dec に対する処理
  }

  public static void main(String argv[]) {
    new Radix();
  }
}
