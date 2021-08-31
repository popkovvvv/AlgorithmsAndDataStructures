package linkedList;

import linkedList.LinkedList;

import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 50000; i++) {
            list.addInTail(new Node(i));
        }
        for (int i = 0; i < 50000; i++) {
            list.addInTail(new Node(i));
        }
        for (int i = 0; i < 34353; i++) {
            list.addInTail(new Node(i));
        }

        Node node = new Node(343);
        list.addInTail(node);
        list.insertAfter(list.tail, node);
        System.err.println(list.tail.value);

    }
}
