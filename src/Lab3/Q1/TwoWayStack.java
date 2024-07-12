package Lab3.Q1;

import java.util.Arrays;

public class TwoWayStack<T> implements TwoWayStackADT<T> {
    private T[] a;
    private int top, bottom;

    public TwoWayStack() {
        a = (T[]) new Object[10];
        top = 0;
        bottom = a.length - 1;
    }

    @Override
    public boolean topEmpty() {
        return top == 0;
    }

    @Override
    public boolean bottomEmpty() {
        return bottom == a.length - 1;
    }

    @Override
    public T peekTop() {
        return a[top];
    }

    @Override
    public T peekBottom() {
        return a[bottom];
    }

    @Override
    public void pushTop(T item) {
        if (top == bottom) enlargeArray();
        a[top++] = item;
        System.out.println(Arrays.toString(a));
    }

    @Override
    public void pushBottom(T item) {
        if (top == bottom) enlargeArray();
        a[bottom--] = item;
        System.out.println(Arrays.toString(a));
    }

    @Override
    public T popTop() {
        if (topEmpty()) throw new EmptyCollectionException("womp womp");
        return a[--top];
    }

    @Override
    public T popBottom() {
        if (bottomEmpty()) throw new EmptyCollectionException("womp womp");
        return a[++bottom];
    }

    private void enlargeArray() {
        T[] temp = (T[]) new Object[a.length * 2];
        System.arraycopy(a, 0, temp, 0, top);
        System.arraycopy(a, bottom+1, temp, a.length+bottom+1, a.length-bottom-1);
        bottom += a.length;
        a = temp;
    }
}
