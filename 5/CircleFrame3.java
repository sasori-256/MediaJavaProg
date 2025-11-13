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

class ColorIndicatePanel extends JPanel {
  private Color color = Color.red;

  public void setColor(Color color) {
    this.color = color;
    this.repaint();
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(color);
    g.fillRect(0, 0, this.getWidth(), this.getHeight());

    g.setColor(Color.BLACK);
    g.drawRect(0, 0, this.getWidth() - 1, this.getHeight() - 1);
  }
}

class CircleFrame3 extends JFrame implements ChangeListener {
  private CirclePanel panel;
  private JPanel colorPanel;
  private JSlider radiusSlider, rSlider, gSlider, bSlider, aSlider;
  private JLabel radiusLabel, rLabel, gLabel, bLabel, aLabel;

  private ColorIndicatePanel colorIndicatePanel;
  private JTextField hexField;

  public CircleFrame3() {
    this.setTitle("Paint");
    this.setSize(1000, 800);

    panel = new CirclePanel(); // 全体のパネル

    // 半径スライダーの設定
    int initRadius = 5;
    radiusSlider = createSlider(5, 100, initRadius, 5, 5);
    radiusLabel = createLabel("Radius: " + initRadius);
    radiusSlider.addChangeListener(this);

    // 半径スライダー表示用パネル
    JPanel radiusPanel = new JPanel(new BorderLayout());
    radiusPanel.add(radiusSlider, BorderLayout.CENTER);
    radiusPanel.add(radiusLabel, BorderLayout.EAST);

    int initR = 255;
    int initG = 0;
    int initB = 0;
    int initA = 100;

    rSlider = createSlider(0, 255, initR, 50, 10);
    gSlider = createSlider(0, 255, initG, 50, 10);
    bSlider = createSlider(0, 255, initB, 50, 10);
    aSlider = createSlider(0, 255, initA, 50, 10);

    rLabel = createLabel("R: " + initR);
    gLabel = createLabel("G: " + initG);
    bLabel = createLabel("B: " + initB);
    aLabel = createLabel("A: " + initA);

    rSlider.addChangeListener(this);
    gSlider.addChangeListener(this);
    bSlider.addChangeListener(this);
    aSlider.addChangeListener(this);

    // スライダーのレイアウト
    JPanel sliderPanel = new JPanel();
    sliderPanel.setLayout(new GridLayout(4, 3, 5, 5));

    sliderPanel.add(new JLabel("Red (R):", JLabel.RIGHT));
    sliderPanel.add(rSlider);
    sliderPanel.add(rLabel);

    sliderPanel.add(new JLabel("Green (G):", JLabel.RIGHT));
    sliderPanel.add(gSlider);
    sliderPanel.add(gLabel);

    sliderPanel.add(new JLabel("Blue (B):", JLabel.RIGHT));
    sliderPanel.add(bSlider);
    sliderPanel.add(bLabel);

    sliderPanel.add(new JLabel("Alpha (A):", JLabel.RIGHT));
    sliderPanel.add(aSlider);
    sliderPanel.add(aLabel);

    // 色表示パネル
    colorIndicatePanel = new ColorIndicatePanel();
    colorIndicatePanel.setPreferredSize(new Dimension(50, 50));
    colorIndicatePanel.setColor(new Color(initR, initG, initB, initA));

    // 16進数表示テキストフィールド
    hexField = new JTextField(7);
    hexField.setHorizontalAlignment(JTextField.CENTER);
    hexField.setEditable(false);
    hexField.setFont(new Font("Monospaced", Font.BOLD, 16));
    hexField.setText(String.format("#%02x%02x%02x", initR, initG, initB));

    // 色プレビュー用パネルのレイアウト
    JPanel previewPanel = new JPanel();
    previewPanel.setLayout(new BorderLayout(10, 10));
    previewPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 20));

    previewPanel.add(new JLabel("Preview", JLabel.CENTER), BorderLayout.NORTH);
    previewPanel.add(colorIndicatePanel, BorderLayout.CENTER);
    previewPanel.add(hexField, BorderLayout.SOUTH);

    colorPanel = new JPanel(new BorderLayout()); // 色スライダー用パネル
    colorPanel.add(previewPanel, BorderLayout.WEST);
    colorPanel.add(sliderPanel, BorderLayout.CENTER);

    this.setLayout(new BorderLayout());
    this.add(radiusPanel, BorderLayout.NORTH);
    this.add(colorPanel, BorderLayout.SOUTH);
    this.add(panel, BorderLayout.CENTER);

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
  }

  private JSlider createSlider(int min, int max, int init, int majorTick, int minorTick) {
    // スライダー作成処理をまとめておく
    JSlider slider = new JSlider(JSlider.HORIZONTAL, min, max, init);
    slider.setMajorTickSpacing(majorTick);
    slider.setMinorTickSpacing(minorTick);
    slider.setPaintTicks(true);
    slider.setPaintLabels(true);
    return slider;
  }

  private JLabel createLabel(String text) {
    // スライダー用ラベル作成処理をまとめておく
    JLabel label = new JLabel(text, JLabel.CENTER);
    label.setFont(new Font("Serif", Font.BOLD, 14));
    return label;
  }

  public void stateChanged(ChangeEvent e) {
    // 半径スライダーの処理
    if (e.getSource() == radiusSlider) {
      int currentRadius = radiusSlider.getValue();
      panel.setRadius(currentRadius);
      radiusLabel.setText("Radius: " + currentRadius);
    }

    // RGB/A スライダーの処理
    else if (e.getSource() == rSlider || e.getSource() == gSlider ||
        e.getSource() == bSlider || e.getSource() == aSlider) {

      int r = rSlider.getValue();
      int g = gSlider.getValue();
      int b = bSlider.getValue();
      int a = aSlider.getValue();

      // ラベルの更新
      rLabel.setText("R: " + r);
      gLabel.setText("G: " + g);
      bLabel.setText("B: " + b);
      aLabel.setText("A: " + a);

      Color newColor = new Color(r, g, b, a);

      panel.setColor(newColor);
      colorIndicatePanel.setColor(newColor);
      hexField.setText(String.format("#%02x%02x%02x", r, g, b));
    }
  }

  public static void main(String argv[]) {
    new CircleFrame3();
  }
}
