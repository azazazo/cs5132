package Lab4.Q1;

public class Q1 {
    public static int forwardcombi(int n, int k) {
        if (k == 0 || k == n) return 1;
        if (n == 1) return 1;
        return forwardcombi(n - 1, k) + forwardcombi(n - 1, k - 1);
    }

    public static void main(String[] args) {
        System.out.println(forwardcombi(35,23));
    }
}
