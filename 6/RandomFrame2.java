import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Figure {
  protected int x, y, vy, size;
  private final static Color colors[] = { Color.RED, Color.BLUE, Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.CYAN };
  protected Color color;

  Figure() {
    x = (int) (Math.random() * 450);
    y = (int) (Math.random() * 450);
    vy = (int) (Math.random() * 5); // 速度要素を追加
    size = (int) (Math.random() * 30 + 20);
    color = colors[(int) (Math.random() * colors.length)];

  }

  void fall() {
    y += vy;
    vy += 1; // 速度に重力加速度を加える
    if (y > 500) {
      y = 0;
      vy = (int) (Math.random() * 5);
    }
  }

  void draw(Graphics g) {
  }
}

class Circle extends Figure {
  @Override
  void draw(Graphics g) {
    g.setColor(color);
    g.drawOval(x, y, size, size);
  }
}

class Box extends Figure {
  @Override
  void draw(Graphics g) {
    g.setColor(color);
    g.drawRect(x, y, size, size);
  }
}

class Cross extends Figure {
  @Override
  void draw(Graphics g) {
    g.setColor(color);
    g.drawLine(x, y, x + size, y + size);
    g.drawLine(x + size, y, x, y + size);
  }
}

class Triangle extends Figure {
  @Override
  void draw(Graphics g) {
    g.setColor(color);
    g.drawLine(x, y + size, x + size / 2, y);
    g.drawLine(x + size / 2, y, x + size, y + size);
    g.drawLine(x, y + size, x + size, y + size);
  }
}

class RandomPanel extends JPanel {
  private final static int NUM = 50;
  protected ArrayList<Figure> fig;

  RandomPanel() {
    fig = new ArrayList<Figure>();
    for (int i = 0; i < NUM; i++) {
      fig.add(new Box());
      fig.add(new Circle());
      fig.add(new Cross());
      fig.add(new Triangle());
    }
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    for (Figure f : fig) {
      f.draw(g);
    }
  }
}

class RandomFrame2 extends JFrame implements ActionListener {
  private Timer timer;
  private RandomPanel panel;

  public RandomFrame2() {
    this.setTitle("Random Frame");
    this.setSize(500, 530);

    timer = new Timer(50, this);
    panel = new RandomPanel();
    this.add(panel);
    timer.start();

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
  }

  public void actionPerformed(ActionEvent ev) {
    for (Figure f : panel.fig) {
      f.fall();
    }
    this.repaint();
  }

  public static void main(String argv[]) {
    new RandomFrame2();
  }
}
