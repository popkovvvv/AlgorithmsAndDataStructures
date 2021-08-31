import linkedList.LinkedList;
import org.junit.jupiter.api.*;

@DisplayName("Linked list tests")
public class LinkedListTest {

    @Test
    static void clearTest() {
        LinkedList list = new LinkedList();
        list.clear();
        Assertions.assertNull(list.head);
        Assertions.assertNull(list.tail);
        Assertions.assertEquals(0, list.count());
    }


    @Test
    void removeFailedTest() {
        LinkedList list = new LinkedList();
        list.add(123);
        list.add(12345);
        Assertions.assertFalse(list.remove(78));
    }

    @Test
    void removeAllTest() {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        Assertions.assertEquals(1000, list.count());
        list.removeAll(123);
        Assertions.assertEquals(999, list.count());
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

    @Test
    void findTest() {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        Assertions.assertNotNull(list.find(201));
    }

    @Test
    void notFoundTest() {
        LinkedList list = new LinkedList();
        list.add(20);
        list.add(202);
        list.add(202);
        list.add(201);
        list.add(20);
        Assertions.assertNull(list.find(78));
    }

    @Test
    void removeTest() {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 50000; i++) {
            list.add(i);
        }
        Assertions.assertTrue(list.remove(5999));
        Assertions.assertNull(list.find(999999));
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

    @Test
    void countTest() {
        LinkedList list = new LinkedList();
        list.add(123);
        list.add(123);
        list.add(321);
        Assertions.assertEquals(3, list.count());
    }

    @Test
    void clearIfEmptyListTest() {
        LinkedList list = new LinkedList();
        list.clear();
        Assertions.assertEquals(0, list.count());
    }

    @Test
    void clearIfOneInListTest() {
        LinkedList list = new LinkedList();
        list.add(2323);
        list.clear();
        Assertions.assertEquals(0, list.count());
    }

    @Test
    void addInTailIfListEmpty() {
        LinkedList list = new LinkedList();
        list.add(2323);
        Assertions.assertEquals(list.head, list.tail);
    }
}
