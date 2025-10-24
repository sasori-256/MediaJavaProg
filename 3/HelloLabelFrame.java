import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class HelloLabelFrame extends JFrame implements ActionListener {
  private JLabel label;

  public HelloLabelFrame() {
    this.setSize(300, 200);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JButton b = new JButton("今日の運勢は?");
    this.add(b, BorderLayout.SOUTH);
    label = new JLabel(" ", JLabel.CENTER);
    this.add(label, BorderLayout.CENTER);
    b.addActionListener(this);
    this.setVisible(true);
  }

  public void actionPerformed(ActionEvent ev) {
    double r = Math.random();
    String[] bgColors = { "rgb(50,90,255)", "rgb(50,255,90)", "rgb(255,200,210)" };
    if (r <= 0.2) {
      label.setText(
          "<html><div style='font-size:36pt; color:white; background-color:" + bgColors[0]
              + "; padding:10;'>bad</div></html>");
    } else if (r <= 0.7) {
      label.setText(
          "<html><div style='font-size:36pt; color:white; background-color:" + bgColors[1]
              + "; padding:10;'>soso</div></html>");
    } else {
      label.setText(
          "<html><div style='font-size:36pt; color:white; background-color:" + bgColors[2]
              + "; padding:10;'>good</div></html>");
    }
  }

  public static void main(String argv[]) {
    new HelloLabelFrame();
  }
}
