package Lab2.Q1;

public class TestLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addToRear(1);
        list.addToRear(2);
        list.addToRear(3);
        list.addAfter(4, 2);
        list.addAfter(5, 3);
        System.out.println(list);
    }
}
