import linkedList.LinkedList;
import org.junit.jupiter.api.*;

import java.util.Arrays;

@DisplayName("Linked list tests")
public class LinkedListTest {

    @Test
    void removeFailedTest() {
        LinkedList list = new LinkedList();
        list.add(123);
        list.add(12345);
        Assertions.assertFalse(list.remove(78));
    }

    @Test
    void removeTest() {
        LinkedList list = new LinkedList();
        list.add(123);
        list.add(234);
        Assertions.assertTrue(list.remove(234));
        Assertions.assertNull(list.find(234));
    }

    @Test
    void removeAllTest() {
        LinkedList list = new LinkedList();
        list.add(123);
        list.add(123);
        list.add(321);
        Assertions.assertEquals(list.count(), 3);
        list.removeAll(123);
        Assertions.assertEquals(1, list.count());
    }

    @Test
    void clearTest() {
        LinkedList list = new LinkedList();
        list.add(123);
        list.add(123);
        list.add(321);
        Assertions.assertEquals(list.count(), 3);
        list.clear();
        Assertions.assertNull(list.head);
        Assertions.assertNull(list.tail);
        Assertions.assertEquals(0, list.count());
    }

    @Test
    void countTest() {
        LinkedList list = new LinkedList();
        list.add(123);
        list.add(123);
        list.add(321);
        Assertions.assertEquals(list.count(), 3);
        list.clear();
        Assertions.assertEquals(0, list.count());
    }

    @Test
    void removeIfEmpty() {
        LinkedList list = new LinkedList();
        Assertions.assertFalse(list.remove(34));
    }

    @Test
    void removeIfOneElementContains() {
        LinkedList list = new LinkedList();
        list.add(20);
        Assertions.assertTrue(list.remove(20));
    }

//    @Test
//    void getAllTest() {
//        LinkedList list = new LinkedList();
//        list.add(20);
//        list.add(56);
//        list.add(232);
//        list.add(56);
//        list.add(20);
//        list.add(20);
//        Assertions.assertEquals(list.findAll(20), Arrays.asList(20, 20, 20));
//    }
}
