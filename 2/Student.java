class Student {
  private String id;
  private String name;
  private int grade;

  public Student(String id, String name, int grade) {
    this.id = id;
    this.name = name;
    this.grade = grade;
  }
  public Student(){}

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

  void print() {
    System.out.println("ID   : "+id);
    System.out.println("Name : "+name);
    System.out.println("Grade: "+grade);
  }

  public void print_short() {
    System.out.println(this.id+","+this.name+","+this.grade)
  }
}

class Lesson {
  private String name;    // 授業名    
  private String teacher; // 担当者 
  private int max;        // 最大履修者数
  private int num;        // 登録履修者数
  private Student st[];   // Student class の配列

  public Lesson(String name,String teacher,int max){
    this.name=name;
    this.teacher=teacher;
    this.max=max;  
    this.num=0;          // num は 0 に初期化．
    st=new Student[max]; // 配列の確保(オブジェクトは別に生成する必要がある)
  }
  public void add(Student s) {
    st[this.num++] = s; 
  }
  public void print() {
    for (int i = 0; i < this.num; i++) {

    }
    System.out.println("----------");  
  }
}
