import javax.swing.*;
import java.awt.*;

class ButtonFrame extends JFrame {
  public ButtonFrame() {
    this.setSize(300, 200);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JButton b1 = new JButton("NORTH");
    JButton b2 = new JButton("CENTER");
    JButton b3 = new JButton("WEST");
    JButton b4 = new JButton("EAST");
    JButton b5 = new JButton("SOUTH");
    this.add(b1, BorderLayout.NORTH);
    this.add(b2, BorderLayout.CENTER);
    this.add(b3, BorderLayout.WEST);
    this.add(b4, BorderLayout.EAST);
    this.add(b5, BorderLayout.SOUTH);
    this.setVisible(true);
  }

  public static void main(String argv[]) {
    new ButtonFrame();
  }
}
