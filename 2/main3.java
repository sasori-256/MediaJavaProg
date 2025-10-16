class main3 {
  public static void main(String[] args) {
    Lesson pro = new Lesson("Pro Enshu", "Yanai", 100);
    pro.add(new Student("012200", "Dentsu Taro", 80));
    pro.add(new Student("012205", "Uec Jiro", 54));
    pro.add(new Student("012207", "Chofu Saburo", 70));
    pro.add(new Student("012210", "Enshu Shiro", 60));

    pro.print();
  }
}
