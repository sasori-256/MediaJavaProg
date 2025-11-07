import javax.swing.*;
import java.awt.*;

class RectPanel extends JPanel {
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    // 動的に幅と高さを取得
    int width = getWidth();
    int height = getHeight();
    g.setColor(new Color(65, 75, 178));
    g.fillRect(width / 4, 0, width / 2, height);
  }
}

class DrawedOvalPanel extends JPanel {
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(new Color(178, 75, 65));
    g.drawOval(0, 100, 400, 100);
  }
}

class LinePanel extends JPanel {
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    // 動的に幅と高さを取得
    int width = getWidth();
    int height = getHeight();
    g.setColor(new Color(75, 178, 65));
    g.drawLine(0, 0, width, height);
    g.drawLine(0, height, width, 0);
  }
}

class DrawedRectPanel extends JPanel {
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(new Color(65, 75, 178));
    g.drawRect(50, 100, 300, 200);
  }
}

class OvalFrame extends JPanel {
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(new Color(178, 65, 75));
    g.fillOval(150, 100, 100, 200);
  }
}

class RectFrame1 extends JFrame {
  public RectFrame1() {
    this.setTitle("RectFrame");
    this.setSize(1200, 800);
    JPanel p = new JPanel();
    p.setLayout(new GridLayout(2, 3));
    RectPanel r = new RectPanel();
    DrawedOvalPanel o = new DrawedOvalPanel();
    LinePanel l = new LinePanel();
    DrawedRectPanel dr = new DrawedRectPanel();
    OvalFrame of = new OvalFrame();
    p.add(o);
    p.add(l);
    p.add(dr);
    p.add(of);
    p.add(r);
    p.add(r);
    this.add(p);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
  }

  public static void main(String argv[]) {
    new RectFrame1();
  }
}
