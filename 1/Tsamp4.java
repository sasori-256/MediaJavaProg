class Tsamp4 {
  public static void main(String[] args) {
    TurtleFrame f; // TurtleFrame型の変数 f の宣言
    f = new TurtleFrame(); // TurtleFrame(表示フレーム)を生成しfに代入
    Turtle m = new Turtle(); // Turtle(亀)を生成し，m の初期値として代入
    f.add(m); // f(表示フレーム) に m(亀) を追加
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 9; j++) {
        m.fd(100);
        m.rt(360 * 4 / 9);
      }
      m.rt(360 / 6);
    }
  }
}
