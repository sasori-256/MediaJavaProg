class Omikuji {
  public static void main(String argv[]) {
    int val;
    double rand;
    try {
      while(true) {
        val = System.in.read();
        if (val != 10) continue;
        rand = Math.random();
        if (rand <= 0.2) {
          System.out.print("bad");
        } else if (rand <= 0.7) {
          System.out.print("so so");
        } else {
          System.out.print("good");
        }
      }
    } catch (java.io.IOException e) {
      return;
    }
  }
}
