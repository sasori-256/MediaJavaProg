class Student {
  private String id;
  private String name;
  private int grade;

  public Student(String id, String name, int grade) {
    this.id = id;
    this.name = name;
    this.grade = grade;
  }

  public Student() {
  }

  void setId(String id) {
    this.id = id;
  }

  void setName(String name) {
    this.name = name;
  }

  void setGrade(int grade) {
    this.grade = grade;
  }

  void set(String id, String name, int grade) {
    if (grade < 0) {
      grade = 0;
    } else if (grade > 100) {
      grade = 100;
    }
    this.id = id;
    this.name = name;
    this.grade = grade;
  }

  String getId() {
    return this.id;
  }

  String getName() {
    return this.name;
  }

  int getGrade() {
    return this.grade;
  }

  void print() {
    System.out.println("ID   : " + id);
    System.out.println("Name : " + name);
    System.out.println("Grade: " + grade);
  }

  public void print_short() {
    System.out.println(this.id + "," + this.name + "," + this.grade);
  }
}

class Lesson {
  private String name; // 授業名
  private String teacher; // 担当者
  private int max; // 最大履修者数
  private int num; // 登録履修者数
  private Student st[]; // Student class の配列

  public Lesson(String name, String teacher, int max) {
    this.name = name;
    this.teacher = teacher;
    this.max = max;
    this.num = 0; // num は 0 に初期化．
    st = new Student[max]; // 配列の確保(オブジェクトは別に生成する必要がある)
  }

  public void add(Student s) {
    st[this.num++] = s;
  }

  public void print() {
    System.out.println("Lesson   :" + this.name);
    System.out.println("Teacher  :" + this.teacher);
    System.out.println("#Students:" + this.num);
    for (int i = 0; i < this.num; i++) {
      st[i].print_short();
    }
    System.out.println("----------");
  }

  // use bubble sort
  void sort_id() {
    for (int i = this.num; i > 1; i--) {
      for (int j = 1; j < i; j++) {
        if (st[j - 1].getId().compareTo(st[j].getId()) > 0) {
          Student tmp = st[j - 1];
          st[j - 1] = st[j];
          st[j] = tmp;
        }
      }
    }
  }

  void sort_name() {
    for (int i = this.num; i > 1; i--) {
      for (int j = 1; j < i; j++) {
        if (st[j - 1].getName().compareTo(st[j].getName()) > 0) {
          Student tmp = st[j - 1];
          st[j - 1] = st[j];
          st[j] = tmp;
        }
      }
    }
  }

  void sort_grade() {
    for (int i = this.num; i > 1; i--) {
      for (int j = 1; j < i; j++) {
        if (st[j - 1].getGrade() < st[j].getGrade()) {
          Student tmp = st[j - 1];
          st[j - 1] = st[j];
          st[j] = tmp;
        }
      }
    }
  }

  // use java.util.Arrays.sort()
  void sortId() {
  }

  void sortName() {
  }

  void sortGrade() {
  }
}
