class Tsamp2 {
  public static void main (String args[]){
    TurtleFrame f;             // TurtleFrame型の変数 f の宣言
    f =  new TurtleFrame();    // TurtleFrame(表示フレーム)を生成しfに代入
    Turtle m = new Turtle();   // Turtle(亀)を生成し，m の初期値として代入f.add(m);
    f.add(m);
    for (int i = 1; i <= 20; i++) {
      m.fd(20);
      m.rt(18);
    }
  }
}
