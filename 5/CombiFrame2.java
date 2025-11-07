import java.awt.*;
import javax.swing.*;

class CombiFrame extends JFrame {
  public CombiFrame() {
    JPanel p1 = new JPanel(), p2 = new JPanel();
    JButton b1[] = new JButton[10];
    JButton b2[] = new JButton[5];
    for (int i = 0; i < 10; i++) {
      b1[i] = new JButton("" + (i + 1));
    }
    for (int i = 0; i < 5; i++) {
      b2[i] = new JButton("<html><body><p bgcolor='yellow'>" + (i + 11) + "</p></body></html>");
    }
    this.setTitle("Panel Combination");
    p1.setLayout(new GridLayout(1, 10));
    p2.setLayout(new GridLayout(5, 1));
    for (int i = 0; i < 10; i++) {
      p1.add(b1[i]);
    }
    for (int i = 0; i < 5; i++) {
      p2.add(b2[i]);
    }
    this.add(p1, BorderLayout.NORTH);
    this.add(p2, BorderLayout.WEST);
    this.pack();
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
  }

  public static void main(String argv[]) {
    new CombiFrame();
  }
}
