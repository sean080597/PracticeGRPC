package services;

public class Rating {
  private final int count;
  private final double sum;

  public Rating(int count, double sum) {
    this.count = count;
    this.sum = sum;
  }

  public int getCount() {
    return count;
  }

  public double getSum() {
    return sum;
  }

  public static Rating add(Rating r1, Rating r2) {
    return new Rating(r1.count + r2.count, r1.sum + r2.sum);
  }
}
