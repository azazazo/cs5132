package Lab4.Q3;

public class Q3 {
    private static final double EPSILON = 0.001;
    public static void main(String[] args) {
        int i = 1;
        while (true) {
            double radius = Math.pow(2, -i);
            if (radius < EPSILON) return;
            System.out.println(radius);
            if ((i & 1) == 1) StdDraw.setPenColor(StdDraw.BLACK);
            else StdDraw.setPenColor(StdDraw.WHITE);
            for (int j = 0; j < Math.pow(2, i-1); ++j) {
                double x = (2*j+1)*radius;
                StdDraw.filledCircle(x, 0.5, radius);
            }
            ++i;
        }
    }
}
