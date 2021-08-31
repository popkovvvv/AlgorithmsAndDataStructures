package linkedList;

import java.util.ArrayList;

public class LinkedList {
    public Node head;
    public Node tail;


    public LinkedList() {
        head = null;
        tail = null;
    }

    public void addInTail(Node item) {
        if (this.head == null) {
            this.head = item;
        } else {
            this.tail.next = item;
        }
        this.tail = item;
    }

    public Node find(int value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<>();
        Node node = this.head;
        while (node != null) {
            if (node.value == _value)
                nodes.add(node);
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int _value) {
        if (head == null) {
            assert (tail == null);
            return false;
        }

        if (head.value == _value) {
            if (head == tail) {
                tail = null;
            }
            head = head.next;
            return true;
        }

        Node prev = head;
        Node curr = head.next;
        while (curr != null) {
            if (curr.value == _value) {
                prev.next = curr.next;
                if (curr == tail)
                    tail = prev;
                return true;
            }
            prev = curr;
            curr = curr.next;
        }
        return false;
    }

    public void removeAll(int _value) {
        LinkedList newList = new LinkedList();
        Node curr = head;
        while (curr != null) {
            if (curr.value != _value) {
                newList.addInTail(new Node(curr.value));
            }
            curr = curr.next;
        }
        head = newList.head;
        tail = newList.tail;
    }

    public void clear() {
        head = null;
        tail = null;
    }

    public int count() {
        int count = 0;
        Node curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        if (head == null && _nodeAfter == null) {
            assert (tail == null);
            head = _nodeToInsert;
            tail = _nodeToInsert;
            return;
        }

        if (_nodeAfter == null) {
            _nodeToInsert.next = head;
            head = _nodeToInsert;
            return;
        }

        Node curr = head;
        while (curr != null) {
            if (curr == _nodeAfter) {
                _nodeToInsert.next = curr.next;
                curr.next = _nodeToInsert;
                if (curr == tail) {
                    tail = _nodeToInsert;
                }
                return;
            }
            curr = curr.next;
        }
    }
}

class Node {
    public int value;
    public Node next;

    public Node(int _value) {
        value = _value;
        next = null;
    }
}
