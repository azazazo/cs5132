package Lab3.Q2;

public class MinStack<E extends Comparable<E>> {
    private ArrayStack<E> stack, min;

    public MinStack() {
        stack = new ArrayStack<>();
        min = new ArrayStack<>();
    }

    //complete the code required for MinStack to work
    public void push(E element) {
        stack.push(element);
        E curmin = (min.isEmpty()) ? element : min.peek();
        min.push((element.compareTo(curmin) > 0) ? curmin : element);
    }

    public E peek() {
        return stack.peek();
    }

    public E pop() {
        this.min.pop();
        return stack.pop();
    }

    public E min() {
        return min.peek();
    }
}

