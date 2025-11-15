import javax.swing.*;

import org.w3c.dom.Text;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

@SuppressWarnings("deprecation")
class IntObservable extends Observable {
  private int value = 0;

  public String getValue(int n) {
    return Integer.toString(value + n);
  }

  public void setValue(String s, int n) {
    value = Integer.parseInt(s.trim()) - n;
    setChanged();
    notifyObservers();
  }
}

@SuppressWarnings("deprecation")
class TextFieldObserver extends JTextField implements Observer, ActionListener {
  private IntObservable intObservable;
  private int fieldNumber;

  public TextFieldObserver(IntObservable so, int n) {
    this.intObservable = so;
    this.fieldNumber = n;
    this.intObservable.addObserver(this);
    this.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 26)); // 文字を大きくします．
    addActionListener(this);
  }

  public void update(Observable o, Object arg) {
    String s = this.intObservable.getValue(this.fieldNumber);
    setText(s);
  }

  public void actionPerformed(ActionEvent e) {
    String s = getText();
    this.intObservable.setValue(s, this.fieldNumber);
  }
}

class ObserverFrame2 extends JFrame {
  public ObserverFrame2() {
    this.setTitle("Observer Frame2");
    this.setLayout(new GridLayout(5, 1));

    IntObservable num = new IntObservable();
    for (int i = 0; i < 5; i++) {
      TextFieldObserver tfo = new TextFieldObserver(num, +i);
      this.add(tfo);
    }
    num.setValue("10000      ", 0);

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.pack();
    this.setVisible(true);
  }

  public static void main(String argv[]) {
    new ObserverFrame2();
  }
}
