package Lesson_1;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Linked list sum tests")
class LinkedListSumTest {
    @Test
    public void testSum_emptyLists() {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        assertEquals(0, LinkedListSum.sum(list1, list2).count());
    }

    @Test
    public void testSumFirstLonger() {
        LinkedList list1 = new LinkedList();
        list1.addInTail(new Node(1));
        list1.addInTail(new Node(2));
        LinkedList list2 = new LinkedList();
        list2.addInTail(new Node(5));
        LinkedList result = LinkedListSum.sum(list1, list2);
        assertNull(result);
    }

    @Test
    public void testSumSecondLonger() {
        LinkedList list1 = new LinkedList();
        list1.addInTail(new Node(1));
        list1.addInTail(new Node(2));
        LinkedList list2 = new LinkedList();
        list2.addInTail(new Node(5));
        LinkedList result = LinkedListSum.sum(list2, list1);
        assertNull(result);
    }

    @Test
    public void testSum() {
        LinkedList list1 = new LinkedList();
        list1.addInTail(new Node(1));
        list1.addInTail(new Node(2));
        LinkedList list2 = new LinkedList();
        list2.addInTail(new Node(5));
        list2.addInTail(new Node(10));
        LinkedList result = LinkedListSum.sum(list2, list1);
        assertNotNull(result);
        assertEquals(2, result.count());
        assertEquals(6, result.head.value);
        assertEquals(12, result.tail.value);
    }
}
