import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ButtonPanel extends JPanel implements ActionListener {
  private JLabel l;

  ButtonPanel() {
    JButton b1 = new JButton("Button 1");
    JButton b2 = new JButton("Button 2");
    JButton b3 = new JButton("Button 3");
    l = new JLabel("0", JLabel.CENTER);
    b1.setActionCommand("1");
    b2.setActionCommand("2");
    b3.setActionCommand("3");
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
    String es = e.getActionCommand();
    if (es.equals("1")) {
      l.setText("1");
    } else if (es.equals("2")) {
      l.setText("2");
    } else if (es.equals("3")) {
      l.setText("3");
    }
  }
}

class TestButton2 extends JFrame {
  public TestButton2() {
    ButtonPanel b = new ButtonPanel();
    this.setTitle("Test Button");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.add(b);
    this.pack();
    this.setVisible(true);
  }

  public static void main(String argv[]) {
    new TestButton2();
  }
}
