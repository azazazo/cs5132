package Lab2.Q2;

public class TestLinkedList {
    public static void main(String[] args) {
        HeadLinkedList<Integer> list = new HeadLinkedList<>();
        list.addToRear(1);
        list.addToRear(2);
        list.addToRear(3);
        list.addAfter(4, 2);
        list.addAfter(5, 3);
        System.out.println(list);
        HeadLinkedList<Integer> back = list.frontBackSplit();
        System.out.println(back);
        System.out.println(list);
    }
}
