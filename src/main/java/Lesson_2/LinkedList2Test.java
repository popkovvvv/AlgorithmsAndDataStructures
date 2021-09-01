package Lesson_2;

import Lesson_1.LinkedList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Linked list tests")
public class LinkedList2Test {

    @Test
    void findAllInEmptyList() {
        LinkedList2 list = new LinkedList2();
        assertEquals(0, list.findAll(1).size());
    }

    @Test
    void findAll() {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(1));
        list.addInTail(new Node(3));
        list.addInTail(new Node(1));
        list.addInTail(new Node(1));
        list.addInTail(new Node(2));
        list.addInTail(new Node(2));
        list.addInTail(new Node(1));
        list.addInTail(new Node(2));
        list.addInTail(new Node(1));

        assertEquals(5, list.findAll(1).size());
    }

    @Test
    void removeFromEmptyList() {
        LinkedList list = new LinkedList();
        assertFalse(list.remove(5));
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    void removeFromOneItemList() {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(1));
        assertTrue(list.remove(1));
        assertNull(list.head);
        assertNull(list.tail);
    }

    @RepeatedTest(100)
    void removeFromLargeList() {
        LinkedList2 list = new LinkedList2();
        Random rnd = new Random();
        for (int i = 0; i < 1000; i++) {
            list.addInTail(new Node(rnd.nextInt(10)));
        }
        assertTrue(list.remove(1));
    }

    @Test
    void remove() {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(3));
        list.addInTail(new Node(5));
        list.addInTail(new Node(1));
        list.addInTail(new Node(3));

        assertTrue(list.remove(1));
        Node node = list.head;
        assertEquals(3, node.value);
        node = node.next;
        assertEquals(5, node.value);
        node = node.next;
        assertEquals(3, node.value);
        assertEquals(3, list.tail.value);
    }

    @Test
    void removeFirstItem() {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(3));
        for (int i = 0; i < 10; i++) {
            list.addInTail(new Node(1));
        }
        assertTrue(list.remove(3));
        assertEquals(1, list.head.value);
    }

    @Test
    void removeLastItem() {
        LinkedList2 list = new LinkedList2();
        for (int i = 0; i < 10; i++) {
            list.addInTail(new Node(1));
        }
        list.addInTail(new Node(3));
        list.addInTail(new Node(7));
        assertTrue(list.remove(7));
        assertEquals(3, list.tail.value);
    }

}
