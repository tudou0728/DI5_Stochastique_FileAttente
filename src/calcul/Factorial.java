package calcul;

public class Factorial{
    public static double factorial(int number) {
        if (number <= 1)
            return 1;
        else
            return (number * factorial(number - 1))/1.0;
    }
}
