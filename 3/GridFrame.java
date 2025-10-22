import javax.swing.*;
import java.awt.*;

class GridFrame extends JFrame {
  public GridFrame() {
    this.setSize(400, 250);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new GridLayout(3, 2, 10, 10)); // 3 rows, 2 columns, with gaps

    String[] texts = {
        "Pink", "Cyan", "Orange",
        "Green", "Magenta", "Yellow"
    };
    Color[] bgColors = {
        Color.PINK, Color.CYAN, Color.ORANGE,
        Color.GREEN, Color.MAGENTA, Color.YELLOW
    };
    Color[] colors = {
        Color.BLACK, Color.BLUE, Color.RED,
        Color.DARK_GRAY, Color.WHITE, Color.BLACK
    };
    int[] textSize = {
        18, 20, 22, 24, 26, 28
    };

    for (int i = 0; i < 6; i++) {
      JButton btn = new JButton(texts[i]);
      btn.setBackground(bgColors[i]);
      btn.setForeground(colors[i]);
      btn.setFont(new Font("Arial", Font.BOLD, textSize[i]));
      add(btn);
    }
    this.setVisible(true);
  }

  public static void main(String argv[]) {
    new GridFrame();
  }
}
