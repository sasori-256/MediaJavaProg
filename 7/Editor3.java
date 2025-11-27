import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.ArrayList;

// ArrayListなどを使い、Editorを複数行対応に拡張したバージョン

///////////////////////////////////////
// Model (M)

@SuppressWarnings("deprecation")
class EditorModel extends Observable {
  protected ArrayList<StringBuffer> lines = new ArrayList<>();

  public EditorModel() {
    // 最初は1行分のバッファを用意
    lines.add(new StringBuffer());
  }

  public void insertCharAt(int line, int pos, char c) {
    try {
      lines.get(line).insert(pos, c);
      notify(new InsertEvent(line, pos));
    } catch (StringIndexOutOfBoundsException e) {
    }
  }

  public void deleteCharAt(int line, int pos) {
    try {
      lines.get(line).deleteCharAt(pos);
      notify(new DeleteEvent(line, pos));
    } catch (StringIndexOutOfBoundsException e) {
    }
  }

  public String getString(int line) {
    return lines.get(line).toString();
  }

  public int getLineCount() {
    return lines.size();
  }

  public void addLine() {
    lines.add(new StringBuffer());
    notify(new LineAddEvent(lines.size() - 1));
  }
}

///////////////////////////////////////
// Main class
//
class Editor3 {
  EditorModel m;

  public static void main(String argv[]) {
    m = new EditorModel();
  }
}
