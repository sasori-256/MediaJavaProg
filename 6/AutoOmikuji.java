import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class AutoOmikuji extends JFrame implements ActionListener {
  private JLabel label, title;
  private String[] bgColors = { "rgb(50,90,255)", "rgb(50,255,90)", "rgb(255,200,210)" };
  private Timer timer;

  public AutoOmikuji() {
    this.setSize(300, 200);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    timer = new Timer(1000, this);
    title = new JLabel("<html><h1>今日の運勢は?</h1></html>", JLabel.CENTER);
    label = new JLabel(" ", JLabel.CENTER);
    this.add(title, BorderLayout.NORTH);
    this.add(label, BorderLayout.CENTER);
    timer.start();
    this.setVisible(true);
  }

  private void printLuck() {
    double r = Math.random();
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

  public void actionPerformed(ActionEvent ev) {
    printLuck();
  }

  public static void main(String argv[]) {
    new AutoOmikuji();
  }
}
