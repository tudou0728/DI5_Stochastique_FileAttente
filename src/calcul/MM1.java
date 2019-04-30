package calcul;

public class MM1 {
   private double u;
   private double lambda;

    public MM1(double u, double lambda) {
        this.u = u;
        this.lambda = lambda;
    }

    public double calculerL() {
        return lambda / (u - lambda);
    }

    public double calculerLq() {
        return (lambda * lambda) / (u * (u - lambda));
    }

    public double calculerW() {
        return 1 / (u - lambda);
    }

    public double calculerWq() {
        return lambda / (u * (u - lambda));
    }

    public double calculerP(double t) {
        double e = Math.E;
        return Math.pow(e, -1 * this.u * (1 - lambda / u) * t);
    }
}
