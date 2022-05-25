/*Design a Metric class that supports Kilometre to Mile conversion with distance in
Kilometre as argument and Mile to Kilometre conversion with distance in mile as argument. 
Assume, one Mile equals 1.5 Kilometre.*/
class Metric {
  double dist;

  Metric(double d) {
    this.dist = d;
  }

  double toMile() {
    double mile = this.dist / 1.5;
    return mile;
  }

  double toKilometre() {
    double km = this.dist * 1.5;
    return km;
  }
}

class qTen {
  public static void main(String[] args) {
    Metric km = new Metric(6);
    Metric mile = new Metric(6);
    System.out.println("6kms = " + km.toMile() + " miles");
    System.out.println("6miles = " + mile.toKilometre() + " kms");
  }
}
