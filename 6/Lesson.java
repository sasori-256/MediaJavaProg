import java.util.ArrayList;

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
  private ArrayList<Student> st; // Student class のArrayList

  public Lesson(String name, String teacher, int max) {
    this.name = name;
    this.teacher = teacher;
    st = new ArrayList<Student>(); // 配列の確保(オブジェクトは別に生成する必要がある)
  }

  public void add(Student s) {
    // TODO: 常に2分探査でId昇順に追加するように変更
    int mid = 0;
    int left = 0;
    int right = st.size() - 1;
    while (left <= right) {
      mid = (left + right) / 2;
      if (st.get(mid).getId().compareTo(s.getId()) < 0) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    st.add(left, s);
  }

  public void print() {
    System.out.println("Lesson   :" + this.name);
    System.out.println("Teacher  :" + this.teacher);
    System.out.println("#Students:" + st.size());
    for (int i = 0; i < st.size(); i++) {
      st.get(i).print_short();
    }
    System.out.println("----------");
  }

  public static void main(String[] args) {
    Lesson l = new Lesson("Programming", "Tanaka", 30);
    Student s1 = new Student("2023003", "Suzuki", 85);
    Student s2 = new Student("2023001", "Takahashi", 90);
    Student s3 = new Student("2023002", "Kato", 75);
    Student s4 = new Student("2023004", "Yamamoto", 95);
    l.add(s1);
    l.add(s2);
    l.add(s3);
    l.add(s4);
    l.print();
  }
}
