package Lab2.Q2;

import java.util.Iterator;

public class HeadLinkedList<T> implements ListADT<T> {
    private int count;
    private LinearNode<T> head;

    /**
     * Creates an empty list.
     */
    public HeadLinkedList() {
        count = 0;
        head = null;
    }

    /**
     * Removes the first element in this list and returns a reference
     * to it.  Throws an EmptyListException if the list is empty.
     *
     * @return a reference to the first element of
     * this list
     * @throws EmptyCollectionException if an empty collection exception occurs
     */
    public T removeFirst() throws EmptyCollectionException {
        if (isEmpty()) throw new EmptyCollectionException("List");

        LinearNode<T> result = head;
        head = head.getNext();
        count--;

        return result.getElement();
    }

    /**
     * Removes the last element in this list and returns a reference
     * to it.  Throws an EmptyListException if the list is empty.
     *
     * @return the last element in this list
     * @throws EmptyCollectionException if an empty collection exception occurs
     */
    public T removeLast() throws EmptyCollectionException {
        if (isEmpty()) throw new EmptyCollectionException("List");

        LinearNode<T> previous = null;
        LinearNode<T> current = head;

        while (current.getNext() != null) {
            previous = current;
            current = current.getNext();
        }

        previous.setNext(null);
        LinearNode<T> result = current;
        count--;

        return result.getElement();
    }

    /**
     * Removes the first instance of the specified element from this
     * list and returns a reference to it.  Throws an EmptyListException
     * if the list is empty.  Throws a NoSuchElementException if the
     * specified element is not found in the list.
     *
     * @param targetElement the element to be removed from the list
     * @return a reference to the removed element
     * @throws EmptyCollectionException if an empty collection exception occurs
     */
    public T remove(T targetElement) throws EmptyCollectionException, ElementNotFoundException {
        if (isEmpty()) throw new EmptyCollectionException("List");

        boolean found = false;
        LinearNode<T> previous = null;
        LinearNode<T> current = head;

        while (current != null && !found) if (targetElement.equals(current.getElement())) found = true;
        else {
            previous = current;
            current = current.getNext();
        }

        if (!found) throw new ElementNotFoundException("List");

        if (size() == 1)                            //list has only 1 element
            head = null;
        else if (current.equals(head))            //delete first node (head)
            head = current.getNext();
        else if (current.getNext() == null)            //delete last node (tail)
        {
            previous.setNext(null);
        } else                                        //delete middle node
            previous.setNext(current.getNext());

        count--;

        return current.getElement();
    }

    /**
     * Returns true if the specified element is found in this list and
     * false otherwise.  Throws an EmptyListException if the specified
     * element is not found in the list.
     *
     * @param targetElement the element that is sought in the list
     * @return true if the element is found in
     * this list
     * @throws EmptyCollectionException if an empty collection exception occurs
     */
    public boolean contains(T targetElement) throws EmptyCollectionException {
        if (isEmpty()) throw new EmptyCollectionException("List");

        boolean found = false;
        Object result;

        LinearNode<T> current = head;

        while (current != null && !found) if (targetElement.equals(current.getElement())) found = true;
        else current = current.getNext();

        return found;
    }

    /**
     * Returns true if this list is empty and false otherwise.
     *
     * @return true if this list is empty
     */
    public boolean isEmpty() {
        return (count == 0);
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the integer representation of the number of elements in this list
     */
    public int size() {
        return count;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedIterator<>(head);
    }


    public LinearNode<T> getHead() {
        return head;
    }

    /**
     * Returns a string representation of this list.
     *
     * @return a string representation of this list
     */
    public String toString() {
        LinearNode<T> current = head;
        String result = "";

        while (current != null) {
            result = result + (current.getElement()).toString(); //+ "\n";
            current = current.getNext();
        }

        return result;
    }

    /**
     * Returns the first element in this list.
     *
     * @return the first element in this list
     */
    public T first() {
        return head.getElement();
    }

    /**
     * Returns the last element in this list.
     *
     * @return the last element in this list
     */
    public T last() {
        LinearNode<T> current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        return current.getElement();
    }

    /**
     * Adds element after target element.
     */
    public void addAfter(T element, T targetElement) {
        if (!contains(targetElement)) throw new ElementNotFoundException("List");
        LinearNode<T> current = head;
        while (!current.getElement().equals(targetElement)) current = current.getNext();
        LinearNode<T> gr = new LinearNode<>(element, current.getNext());
        current.setNext(gr);
        count++;
    }

    /**
     * Adds element to the end of the linked list.
     */
    public void addToRear(T element) {
        LinearNode<T> gr = new LinearNode<>(element, null);
        if (isEmpty()) head = gr;
        else {
            LinearNode<T> current = head;
            while (current.getNext() != null) current = current.getNext();
            current.setNext(gr);
        }
        count++;
    }


    public void addToFront(T element) {
        head = new LinearNode<T>(element, head);
        count++;
    }

    public void reverse() {
        LinearNode<T> current = head;
        LinearNode<T> previous = null;
        while (current != null) {
            LinearNode<T> next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        head = previous;
    }

    public HeadLinkedList<T> frontBackSplit() {
        LinearNode<T> slow = head, fast = head;
        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }

        fast = head;
        head = slow.getNext();
        slow.setNext(null);
        HeadLinkedList<T> B = new HeadLinkedList<>();
        while (fast != null) {
            B.addToRear(fast.getElement());
            fast = fast.getNext();
        }
        return B;
    }


}

class LinkedIterator<T> implements Iterator<T> {
    private LinearNode<T> curr;

    public LinkedIterator(LinearNode<T> head) {
        curr = head;
    }

    @Override
    public boolean hasNext() {
        return curr != null;
    }

    @Override
    public T next() {
        LinearNode<T> temp = curr;
        curr = curr.getNext();
        return temp.getElement();
    }
}