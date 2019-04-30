package calcul;

public class MMS {
    private double u;
    private double lambda;
    private double S;
    private double p;
    private double e = Math.E;

    public MMS(double u, double lambda, double S) {
        this.u = u;
        this.lambda = lambda;
        this.S = S;
        this.p = lambda / (S * u);
    }

    public double calculerL() {
        return lambda * calculerW();
    }

    public double calculerLq() {
        double sum = 0;
        double q0 = 0;
        for (int j = 0; j <= S - 1; j++) {
            sum = sum + (Math.pow(p * S, j)) / (Factorial.factorial(j));
        }
        int s = (int)S;
        q0 = 1 / (sum + Math.pow(p * S, S) / (Factorial.factorial(s) *(1 - p)));
        return q0 * ((Math.pow(p * S, S) * p)
                / (Factorial.factorial(s) * Math.pow(1 - p, 2)));
    }

    public double calculerW() {
        return calculerWq() + 1 / this.u;
    }

    public double calculerWq() {
        return calculerLq() / lambda;
    }
    int s = (int)S;
    public double calculerP(double t) {
        return Math.pow(e, -u * t) * (1 + (calculerQ(0) * Math.pow(p * S, S) / Factorial.factorial(s) / (1 - p)
                * ((1 - Math.pow(e, -u * t * (S - 1 - p * S))) / (S - 1 - p * S))));
    }

    public double calculerPA(double t) {
        if (t == 0) {
            int s = (int)S;
            return calculerQ(0) * Math.pow(p * S, S) / (Factorial.factorial(s) * (1 - p));
        } else
            return Math.pow(e, -S * u * t * (1 - p)) * calculerPA(0);
    }

    public double calculerQ(int q) {
        double sum = 0;
        int s = (int)S;
        if (q == 0) {
            for (int i = 0; i < S; i++)
                sum += (Math.pow(p * S, i) / Factorial.factorial(i));
            sum += Math.pow(p * S, S) / (Factorial.factorial(s) * (1 - p));
            return 1 / sum;
        } else if (q < S) {
            return Math.pow(p * S, q) / Factorial.factorial(q) * calculerQ(0);
        } else {
            return Math.pow(S, S) * Math.pow(p, q) / Factorial.factorial(q) * calculerQ(0);
        }
    }

}
