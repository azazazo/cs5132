package Lab3.Q4;

import java.util.Arrays;

public class Deque<T> implements DequeADT<T> {
    private static final int DEFAULT_SIZE = 10;
    T[] array;
    private int count = 0;
    private int first, last;

    public Deque() {
        array = (T[]) new Object[DEFAULT_SIZE];
        last = array.length / 2;
        first = last - 1;
    }

    private T[] resize(T[] a) {
        T[] res = (T[]) new Object[a.length * 2];
        System.arraycopy(a, 0, res, a.length/2, a.length);
        first += a.length/2; last += a.length/2;
        return res;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public T getFirst() {
        return array[first+1];
    }

    @Override
    public T getLast() {
        return array[last-1];
    }

    @Override
    public void addFirst(T element) {
        if (first < 0) array = resize(array);
        array[first--] = element;
        count++;
    }

    @Override
    public void addLast(T element) {
        if (last == array.length) array = resize(array);
        array[last++] = element;
        count++;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) throw new EmptyCollectionException("womp womp");
        count--;
        return array[++first];
    }

    @Override
    public T removeLast() {
        if (isEmpty()) throw new EmptyCollectionException("womp womp");
        count--;
        return array[--last];
    }

    public static void main(String[] args) {
        Deque<Integer> rongyi =  new Deque<Integer>();
        for (int i = 0; i < 10; ++i) {
            rongyi.addLast(i);
//            System.out.println(Arrays.toString(rongyi.array));
        }
        System.out.println(rongyi.removeFirst());
    }
}
