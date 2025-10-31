import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ButtonPanel extends JPanel implements ActionListener {
  private JLabel l;
  private JButton b1 = new JButton("Button 1");
  private JButton b2 = new JButton("Button 2");
  private JButton b3 = new JButton("Button 3");

  ButtonPanel() {
    l = new JLabel("0", JLabel.CENTER);
    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);
    setLayout(new GridLayout(2, 2));
    add(b1);
    add(b2);
    add(b3);
    add(l);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == b1) {
      l.setText("1");
    } else if (e.getSource() == b2) {
      l.setText("2");
    } else if (e.getSource() == b3) {
      l.setText("3");
    }
  }
}

class TestButton1 extends JFrame {
  public TestButton1() {
    ButtonPanel b = new ButtonPanel();
    this.setTitle("Test Button");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.add(b);
    this.pack();
    this.setVisible(true);
  }

  public static void main(String argv[]) {
    new TestButton1();
  }
}
