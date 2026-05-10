package Module4.Exercise24_03;

import java.util.ListIterator;

public class TestTwoWayLinkedList {
    public static void main(String[] args) {
        TwoWayLinkedList<String> list = new TwoWayLinkedList<>();

        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add("Date");

        System.out.println("List: " + list);

        System.out.println("Forward:");
        ListIterator<String> forward = list.listIterator();

        while (forward.hasNext()) {
            System.out.println(forward.next());
        }

        System.out.println("Backward:");
        ListIterator<String> backward = list.listIterator(list.size());

        while (backward.hasPrevious()) {
            System.out.println(backward.previous());
        }
    }
}