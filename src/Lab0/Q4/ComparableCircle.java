package Lab0.Q4;

public class ComparableCircle extends Circle implements Comparable<ComparableCircle> {
    public ComparableCircle(double radius) {
        super(radius);
    }

    @Override
    public double getArea() {
        return super.getRadius();
    }

    @Override
    public double getPerimeter() {
        return super.getPerimeter();
    }

    @Override
    public int compareTo(ComparableCircle o) {
        return (int) (this.getRadius() - o.getRadius());
    }
}
