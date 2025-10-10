class main2 {
  public static void main(String[] args) {
    Student st = new Student();
    Student st2 = new Student();
    st.setId("01110");
    st.setName("Suzuki");
    st.setGrade(100);
    st2.setId("01111");
    st2.setName("Yamada");
    st2.setGrade(80);

    st.print();
    st2.print();

    System.out.println();

    Student st3 = new Student("01110", "Suzuki", 100);
    Student st4 = new Student("01111", "Yamada", 80);

    st3.print();
    st4.print();
  }
}
