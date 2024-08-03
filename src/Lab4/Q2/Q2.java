package Lab4.Q2;

public class Q2 {
    public static int tailcombihelper(int n, int k, double accumulator) {
        // why is accumulator a double
        if (k == 0) return (int) accumulator;
        return tailcombihelper(n - 1, k - 1, accumulator * n / k);
    }


    public static int tailcombi(int n, int k) {
        return tailcombihelper(n, k, 1);
    }

    public static void main(String[] args) {
        System.out.println(tailcombi(35, 23));
    }
}
