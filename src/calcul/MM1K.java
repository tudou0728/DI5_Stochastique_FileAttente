package calcul;

public class MM1K {
    private double u;
    private double lambda;
    private double K;
    private double p;

    public MM1K(double u, double lambda, double K) {
        this.u = u;
        this.lambda = lambda;
        this.K = K;
        this.p = lambda / u;
    }

    public double calculerL() {
        if (this.p == 1) {
            return K / 2;
        } else {
            return (p * (1 - (K + 1) * Math.pow(p, K) + K * Math.pow(p, K + 1)))
                    / ((1 - p) * (1 - Math.pow(p, K + 1)));
        }
    }

    public double calculerLq() {
        double q0;
        if (this.p == 1) {
            q0 = 1 / (K + 1);
        } else {
            q0 = ((1 - p) * Math.pow(p, 0)) / (1 - Math.pow(p, K + 1));
        }
        return calculerL() - (1 - q0);
    }

    public double calculerP0() {
    	double q0;
        if (this.p == 1) {
            q0 = 1 / (K + 1);
        } else {
            q0 = ((1 - p) * Math.pow(p, 0)) / (1 - Math.pow(p, K + 1));
        }
        return q0;
    }
    
    public double calculerLambdaE() {
    	double lambdaE;
    	lambdaE=this.u*(1-calculerP0());
    	return lambdaE;
    }
    
    public double calculerWq() {
    	return calculerLq() / (calculerLambdaE());
    }
    
    public double calculerW() {
    	return calculerL() / (calculerLambdaE());
    }
}
