import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

@SuppressWarnings("deprecation")
class TimeObservable extends Observable implements ActionListener {
  private javax.swing.Timer timer;
  private int hour, min, sec;
  private Calendar cal;
  private String currentTime = "";

  TimeObservable() {
    this.cal = Calendar.getInstance();
    this.hour = cal.get(Calendar.HOUR_OF_DAY);
    this.min = cal.get(Calendar.MINUTE);
    this.sec = cal.get(Calendar.SECOND);
    this.currentTime = String.format("%02d:%02d:%02d", this.hour, this.min, this.sec);
    this.timer = new javax.swing.Timer(1000, this);
    this.timer.start();
  }

  public String getValue() {
    return this.currentTime;
  }

  public void setValue(int gapHour) {
    this.cal = Calendar.getInstance();
    this.hour = (cal.get(Calendar.HOUR_OF_DAY) + gapHour + 24) % 24;
    this.min = cal.get(Calendar.MINUTE);
    this.sec = cal.get(Calendar.SECOND);
    this.currentTime = String.format("%02d:%02d:%02d", this.hour, this.min, this.sec);
    setChanged();
    notifyObservers();
  }

  public void actionPreformed(ActionEvent e) {
    this.setValue(0);
  }
}

@SuppressWarnings("deprecation")
class TextObserver extends JPanel implements Observer {
  private TimeObservable timeObservable;
  private JLabel label;

  public TextObserver(TimeObservable to) {
    this.timeObservable = to;
    this.timeObservable.addObserver(this);
    this.label = new JLabel();
    this.label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 26));
    this.add(label);
  }

  public void update(Observable o, Object arg) {
    String s = timeObservable.getValue();
    label.setText(s);
  }
}

class ObserberFrame extends JFrame {
  public ObserverFrame() {
    this.setTitle("Clock Frame");
    this.setLayout(new GridLayout(6, 1));

    TimeObservable t = new TimeObservable();
    this.add(new TextFieldObserver(t));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.pack();
    this.setVisible(true);
  }

  public static void main(String argv[]) {
    new ObserverFrame();
  }
}
