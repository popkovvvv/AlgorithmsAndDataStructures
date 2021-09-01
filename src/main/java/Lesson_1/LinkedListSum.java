package Lesson_1;

public class LinkedListSum {
    public static LinkedList sum(LinkedList list1, LinkedList list2) {
        Node currentNode1 = list1.head;
        Node currentNode2 = list2.head;

        LinkedList result = new LinkedList();
        while (currentNode1 != null && currentNode2 != null) {
            result.addInTail(new Node(currentNode1.value + currentNode2.value));
            currentNode1 = currentNode1.next;
            currentNode2 = currentNode2.next;
        }
        if (currentNode1 != null || currentNode2 != null) {
            return null;
        }
        return result;
    }
}
