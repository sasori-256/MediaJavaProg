class main {
  public static void main(String[] args) {
    Student st = new Student();
    Student st2 = new Student();
    Student st3 = new Student();

    st.set("01110", "Suzuki", 100);
    st2.set("01111", "Yamada", -256);
    st3.set("10000", "Hanako", 255);
    st.print();
    st2.print();
    st3.print();
  }
}
