package Lab3.Q3;


public class StackQueue<T> implements QueueADT<T> {
    private LinkedStack<T> in, out;

    public StackQueue() {
        in = new LinkedStack<>();
        out = new LinkedStack<>();
    }

    private void transfer() {
        while (!in.isEmpty()) {
            out.push(in.pop());
        }
    }

    @Override
    public void enqueue(T element) {
        in.push(element);
    }

    @Override
    public T dequeue() {
        if (out.isEmpty()) transfer();
        return out.pop();
    }

    @Override
    public T first() {
        if (out.isEmpty()) transfer();
        return out.peek();
    }

    @Override
    public boolean isEmpty() {
        if (out.isEmpty()) transfer();
        return out.isEmpty();
    }

    @Override
    public int size() {
        if (out.isEmpty()) transfer();
        return out.size();
    }
}
