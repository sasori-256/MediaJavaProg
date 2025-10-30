class Student {
  private String id; // 学籍番号
  private String name; // 名前
  private int grade; // 成績

  public void print() {
    System.out.println("ID   : " + id);
    System.out.println("Name : " + name);
    System.out.println("Grade: " + grade);
  }

  public void setId(String i) {
    this.id = i;
  }

  public void setName(String n) {
    this.name = n;
  }

  public void setGrade(int g) {
    this.grade = g;
  }
}

class Student3 extends Student {
  private String course; // コース名

  @Override
  public void print() {
    super.print(); // super で１つ上の親クラスのprint() を呼び出す．
    System.out.println("Course: " + course); // コース名の表示の追加
  }

  public void setCourse(String c) {
    this.course = c;
  }
}

class Student4 extends Student3 {
  private String supervisor; // 指導教員名

  public void setSupervisor(String s) {
    this.supervisor = s;
  }

  @Override
  public void print() {
    super.print(); // super で１つ上の親クラスのprint() を呼び出す．
    System.out.println("Supervisor: " + supervisor); // 指導教員名の表示の追加
  }
}

class Student3_main {
  public static void main(String argv[]) {
    Student3 st3 = new Student3();
    Student4 st4 = new Student4();

    st3.setId("123456");
    st3.setName("電通 太郎");
    st3.setGrade(100);
    st3.setCourse("メディア情報学");

    st4.setId("123456");
    st4.setName("調布 次郎");
    st4.setGrade(50);
    st4.setCourse("経営社会学");
    st4.setSupervisor("電通 教授");

    System.out.println("[3年生]");
    st3.print();
    System.out.println("[4年生]");
    st4.print();
  }
}
