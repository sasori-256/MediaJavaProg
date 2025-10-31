import javax.swing.*;
import java.awt.*;

class RectPanel extends JPanel {
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(new Color(65, 75, 178));
    g.fillRect(100, 100, 400, 400);
  }
}

class RectFrame1 extends JFrame {
  public RectFrame1() {
    this.setTitle("RectFrame");
    this.setSize(500, 500);
    RectPanel r = new RectPanel();
    JLabel l = new JLabel("<html><body><h1>411</h1></body></html>", JLabel.CENTER);
    r.add(l);
    this.add(r);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
  }

  public static void main(String argv[]) {
    new RectFrame1();
  }
}
