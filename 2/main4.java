class main4 {
  public static void main(String[] args) {
    Lesson pro = new Lesson("Pro Enshu", "Yanai", 100);
    pro.add(new Student("012210", "Enshu Shiro", 60));
    pro.add(new Student("012207", "Chofu Saburo", 70));
    pro.add(new Student("012200", "Dentsu Taro", 80));
    pro.add(new Student("012205", "Uec Jiro", 54));

    System.out.println("Before sorting");
    pro.print();
    System.out.println();

    // 各ソートを実行し表示
    pro.sort_id();
    System.out.println("Sort by ID");
    pro.print();
    System.out.println();

    pro.sort_name();
    System.out.println("Sort by Name");
    pro.print();
    System.out.println();

    pro.sort_grade();
    System.out.println("Sort by Grade");
    pro.print();
    System.out.println();
  }
}
