import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class HelloLabelFrame extends JFrame implements ActionListener { 
    private JLabel label;

    public HelloLabelFrame(){
      this.setSize(300,200);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JButton b = new JButton("Hello");
      this.add(b,BorderLayout.SOUTH);
      label = new JLabel(" ",JLabel.CENTER);
      this.add(label,BorderLayout.CENTER);
      b.addActionListener(this);
      this.setVisible(true);
    }
    public void actionPerformed(ActionEvent ev) {
      double r = Math.random();
      if (r <= 0.2) {
        label.setText("<html><span style='font-size:36pt; color:white; background-color:rgb(50,90,255);'>bad</span></html>");
      } else if (r <= 0.7) {
        label.setText("<html><span style='font-size:36pt; color:white; background-color:rgb(50,255,90);'>soso</span></html>");
      } else {
        label.setText("<html><span style='font-size:36pt; color:white; background-color:rgb(255,200,210);'>good</span></html>");
      }
    }
    public static void main(String argv[]) {
      new HelloLabelFrame();
    }
}
