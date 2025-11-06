import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.lang.Math;

class CirclePanel extends JPanel implements MouseListener, MouseMotionListener {
  private int radius = 5;
  private Color color = new Color(255, 0, 0, 80);
  private int x[], y[], r[];
  private int lastX = -1, lastY = -1;
  private Color c[];
  private int num = 0;
  final static int MAX = 5000;

  public CirclePanel() {
    x = new int[MAX];
    y = new int[MAX];
    r = new int[MAX];
    c = new Color[MAX];
    this.addMouseListener(this);
    this.addMouseMotionListener(this);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    for (int i = 0; i < num; i++) {
      g.setColor(c[i]);
      g.fillOval(x[i] - r[i], y[i] - r[i], r[i] * 2, r[i] * 2);
    }
  }

  private void addCircle(int x0, int y0) {
    if (num >= MAX)
      return;
    x[num] = x0;
    y[num] = y0;
    r[num] = radius;
    c[num] = color;
    num++;
    this.repaint();
  }

  void setRadius(int radius) {
    this.radius = radius;
  }

  void setColor(Color color) {
    this.color = color;
  }

  public void mousePressed(MouseEvent e) {
    lastX = e.getX();
    lastY = e.getY();
    addCircle(lastX, lastY);
  }

  public void mouseClicked(MouseEvent e) {
  }

  public void mouseReleased(MouseEvent e) {
  }

  public void mouseEntered(MouseEvent e) {
  }

  public void mouseExited(MouseEvent e) {
  }

  public void mouseDragged(MouseEvent e) {
    // TODO: 点が半径距離以上離れているときに線形補間で点を追加するようにする
    int mx = e.getX();
    int my = e.getY();
    int dx = mx - lastX;
    int dy = my - lastY;
    double dist = Math.sqrt(dx * dx + dy * dy);
    if (dist > radius) {
      int steps = (int) Math.floor(dist / radius);
      for (int i = 1; i <= steps; i++) {
        int ix = lastX + (int) (dx * i / (double) (steps + 1));
        int iy = lastY + (int) (dy * i / (double) (steps + 1));
        addCircle(ix, iy);
      }
    }
    addCircle(mx, my);
    lastX = mx;
    lastY = my;
  }

  public void mouseMoved(MouseEvent e) {
  }
}

class CircleFrame2 extends JFrame implements ActionListener, ChangeListener {
  private CirclePanel panel;
  private JPanel buttonPanel;
  private JButton redButton, greenButton, blueButton, cyanButton, magentaButton, yellowButton;
  private JSlider radiusSlider;
  private JLabel radiusLabel;

  public CircleFrame2() {
    this.setTitle("CircleFrame");
    this.setSize(800, 500);

    panel = new CirclePanel(); // 全体のパネル
    buttonPanel = new JPanel(); // ボタン用パネル
    redButton = new JButton("<html><h1>Red</h1></html>");
    greenButton = new JButton("<html><h1>Green</h1></html>");
    blueButton = new JButton("<html><h1>Blue</h1></html>");
    cyanButton = new JButton("<html><h1>Cyan</h1></html>");
    magentaButton = new JButton("<html><h1>Magenta</h1></html>");
    yellowButton = new JButton("<html><h1>Yellow</h1></html>");

    // スライダーの設定
    int initRadius = 5;
    radiusSlider = new JSlider(JSlider.HORIZONTAL, 5, 50, initRadius);
    radiusSlider.setMajorTickSpacing(5);
    radiusSlider.setPaintTicks(true);
    radiusSlider.setPaintLabels(true);

    // 半径表示ラベルの設定
    radiusLabel = new JLabel("Radius: " + initRadius + " ", JLabel.CENTER);
    radiusLabel.setFont(new Font("Serif", Font.BOLD, 16));

    // ActionListenerとChangeListenerの登録
    redButton.addActionListener(this);
    greenButton.addActionListener(this);
    blueButton.addActionListener(this);
    cyanButton.addActionListener(this);
    magentaButton.addActionListener(this);
    yellowButton.addActionListener(this);
    radiusSlider.addChangeListener(this);

    JPanel radiusPanel = new JPanel(new BorderLayout());
    radiusPanel.add(radiusSlider, BorderLayout.CENTER);
    radiusPanel.add(radiusLabel, BorderLayout.EAST);

    buttonPanel.setLayout(new FlowLayout());
    buttonPanel.add(redButton);
    buttonPanel.add(greenButton);
    buttonPanel.add(blueButton);
    buttonPanel.add(cyanButton);
    buttonPanel.add(magentaButton);
    buttonPanel.add(yellowButton);

    this.setLayout(new BorderLayout());
    this.add(radiusPanel, BorderLayout.NORTH);
    this.add(buttonPanel, BorderLayout.SOUTH);
    this.add(panel, BorderLayout.CENTER);

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == redButton) {
      panel.setColor(new Color(255, 0, 0, 80));
    } else if (e.getSource() == greenButton) {
      panel.setColor(new Color(0, 255, 0, 80));
    } else if (e.getSource() == blueButton) {
      panel.setColor(new Color(0, 0, 255, 80));
    } else if (e.getSource() == cyanButton) {
      panel.setColor(new Color(0, 255, 255, 80));
    } else if (e.getSource() == magentaButton) {
      panel.setColor(new Color(255, 0, 255, 80));
    } else if (e.getSource() == yellowButton) {
      panel.setColor(new Color(255, 255, 0, 80));
    }
  }

  public void stateChanged(ChangeEvent e) {
    int currentRadius = radiusSlider.getValue();
    panel.setRadius(radiusSlider.getValue());
    radiusLabel.setText("Radius: " + currentRadius);
  }

  public static void main(String argv[]) {
    new CircleFrame2();
  }
}
