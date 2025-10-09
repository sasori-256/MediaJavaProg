class Eratosthenes {
  public static void main(String[] args) {
    int max = 200;
    boolean[] isPrime = new boolean[max + 1];
    for (int i = 2; i <= max; i++) {
      if (isPrime[i])
        continue;
      System.out.println(i);
      for (int j = i * 2; j <= max; j += i) {
        isPrime[j] = true;
      }
    }
  }
}
