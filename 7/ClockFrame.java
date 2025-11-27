import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

@SuppressWarnings("deprecation")
class TimeObservable extends Observable implements ActionListener {
  private javax.swing.Timer timer;
  private int hour, min, sec;
  private Calendar cal;
  private String currentTime;

  TimeObservable() {
    this.cal = Calendar.getInstance();
    this.hour = cal.get(Calendar.HOUR_OF_DAY);
    this.min = cal.get(Calendar.MINUTE);
    this.sec = cal.get(Calendar.SECOND);
    this.currentTime = String.format("%02d:%02d:%02d", this.hour, this.min, this.sec);
    this.timer = new javax.swing.Timer(1000, this);
    this.timer.start();
  }

  public String getValue(int gapHour) {
    int displayHour = (this.hour + gapHour + 24) % 24;
    return String.format("%02d:%02d:%02d", displayHour, this.min, this.sec);
  }

  public void setValue() {
    this.cal = Calendar.getInstance();
    this.hour = cal.get(Calendar.HOUR_OF_DAY);
    this.min = cal.get(Calendar.MINUTE);
    this.sec = cal.get(Calendar.SECOND);
    this.currentTime = String.format("%02d:%02d:%02d", this.hour, this.min, this.sec);
    setChanged();
    notifyObservers();
  }

  public void actionPerformed(ActionEvent e) {
    this.setValue();
  }
}

@SuppressWarnings("deprecation")
class TimePanel extends JPanel implements Observer {
  private TimeObservable timeObservable;
  private String location, loc_time;
  private int gap;
  private JLabel label_location, label_time;

  public TimePanel(TimeObservable to, String location, int gap) {
    this.timeObservable = to;
    this.location = location;
    this.gap = gap;
    this.label_location = new JLabel();
    this.label_time = new JLabel();

    this.timeObservable.addObserver(this);
    this.label_location.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 26));
    this.label_location.setHorizontalAlignment(SwingConstants.CENTER);
    this.label_time.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 26));
    this.label_time.setHorizontalAlignment(SwingConstants.CENTER);

    this.label_location.setText(this.location);
    this.loc_time = this.timeObservable.getValue(this.gap);
    this.label_time.setText(this.loc_time);
    this.setLayout(new GridLayout(1, 2));
    this.add(label_location);
    this.add(label_time);
  }

  public void update(Observable o, Object arg) {
    this.loc_time = timeObservable.getValue(this.gap);
    this.label_time.setText(this.loc_time);
  }
}

class ClockFrame extends JFrame {
  static final String[] locations = { "Tokyo", "Beijing", "Paris", "London", "New York", "Los Angels" };
  static final int[] gaps = { 0, -1, -8, -9, -14, -17 };

  public ClockFrame() {
    this.setTitle("Clock Frame");
    this.setLayout(new GridLayout(6, 1));

    TimeObservable t = new TimeObservable();
    for (int i = 0; i < locations.length; i++) {
      this.add(new TimePanel(t, locations[i], gaps[i]));
    }

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.pack();
    this.setVisible(true);
  }

  public static void main(String argv[]) {
    new ClockFrame();
  }
}
