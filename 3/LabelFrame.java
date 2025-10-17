import javax.swing.*;
import java.awt.*;

class LabelFrame extends JFrame {
  public LabelFrame() {
    this.setSize(400, 250);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JButton b = new JButton("ライオン!");
    this.add(b, BorderLayout.SOUTH);

    JLabel l1 = new JLabel("<html><img src='file:lion.jpg' width=100 height=100><br>こんにちは 🦁</html>",
        JLabel.CENTER);
    JLabel l2 = new JLabel(
        "<html><span style='font-size:36pt; color:blue; background-color:yellow;'>ライオンだよ</span></html>",
        JLabel.CENTER);
    JLabel lWest = new JLabel("<html><span style='font-size:18pt; color:green;'>ライオン</span></html>",
        JLabel.CENTER);
    JLabel lEast = new JLabel("<html><span style='font-size:18pt; color:red;'>ライオン</span></html>", 
        JLabel.CENTER);

    this.add(l1, BorderLayout.NORTH);
    this.add(l2, BorderLayout.CENTER);
    this.add(lWest, BorderLayout.WEST);
    this.add(lEast, BorderLayout.EAST);

    this.setVisible(true);
    this.setVisible(true);
  }

  public static void main(String argv[]) {
    new LabelFrame();
  }
}
