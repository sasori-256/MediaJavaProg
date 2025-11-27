import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

////////////////////////////////////////////////
// Model (M)

// 10進数の値を保持し，基数の変換をする
@SuppressWarnings("deprecation")
class RadixModel extends Observable {
  private int decimalValue;

  public RadixModel(int val) {
    this.decimalValue = val;
  }

  public String getValue(int radix) {
    return Integer.toString(decimalValue, radix).toUpperCase();
  }

  public void setValue(String input, int radix) {
    // 入力に非数がある可能性があるので例外処理
    try {
      decimalValue = Integer.parseInt(input, radix);
      setChanged();
      notifyObservers();
    } catch (NumberFormatException ex) {
      System.out.println("Invalid input: " + input);
    }
  }
}

////////////////////////////////////////////////
// View (V)

@SuppressWarnings("deprecation")
class ViewPanel extends JPanel implements Observer {
  private JTextField textField;
  private int radix;

  public ViewPanel(String label, int radix, RadixModel model) {
    this.radix = radix;
    this.setLayout(new FlowLayout());
    this.add(new JLabel(label));
    textField = new JTextField(10);
    this.add(textField);
    model.addObserver(this);
  }

  public JTextField getTextField() {
    return textField;
  }

  public void update(Observable o, Object arg) {
    RadixModel model = (RadixModel) o;
    textField.setText(model.getValue(radix));
  }
}

////////////////////////////////////////////////
// Controller (C)

// 値の更新の責任を持たせる
class RadixController implements ActionListener {
  private int radix;
  private RadixModel model;

  public RadixController(int radix, RadixModel model) {
    this.radix = radix;
    this.model = model;
  }

  public void actionPerformed(ActionEvent e) {
    JTextField source = (JTextField) e.getSource();
    String input = source.getText();
    model.setValue(input, radix);
  }
}

class RadixFrame extends JFrame {
  RadixModel model;
  ViewPanel hexView, decView, octView, binView;
  RadixController hexController, decController, octController, binController;

  public RadixFrame() {
    model = new RadixModel(0);

    hexView = new ViewPanel("Hex:", 16, model);
    decView = new ViewPanel("Dec:", 10, model);
    octView = new ViewPanel("Oct:", 8, model);
    binView = new ViewPanel("Bin:", 2, model);

    hexController = new RadixController(16, model);
    decController = new RadixController(10, model);
    octController = new RadixController(8, model);
    binController = new RadixController(2, model);

    hexView.getTextField().addActionListener(hexController);
    decView.getTextField().addActionListener(decController);
    octView.getTextField().addActionListener(octController);
    binView.getTextField().addActionListener(binController);

    this.setLayout(new GridLayout(4, 1));
    this.add(hexView);
    this.add(decView);
    this.add(octView);
    this.add(binView);
    this.pack();
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
  }

  public static void main(String[] args) {
    new RadixFrame();
  }
}
