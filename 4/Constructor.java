class A {
  public A() {
    System.out.println("A()");
  }
}

class B extends A {
  public B() {
    System.out.println("B()");
  }

  public B(int x) {
    System.out.println("B(int)");
  }
}

class C extends B {
  public C() {
    System.out.println("C()");
  }

  public C(int x) {
    super(x);
    System.out.println("C(int)");
  }

  public C(double x) {
    this();
    System.out.println("C(double)");
  }

  public static void main(String[] args) {
    System.out.println("Execute new C()");
    new C();
    System.out.println("Execute new C(1)");
    new C(1);
    System.out.println("Execute new C(1.0)");
    new C(1.0);
  }
}
