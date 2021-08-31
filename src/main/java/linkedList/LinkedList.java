package linkedList;

import java.util.ArrayList;

public class LinkedList {
    public Node head;
    public Node tail;
    private int size;


    public LinkedList() {
        head = null;
        tail = null;
        this.size = 0;
    }

    public void addInHead(Node item) {
        Node tmpHead = this.head;
        this.head = item;
        if (tmpHead != null)
            this.head.next = tmpHead;
        ++this.size;
    }

    public void add(int value) {
        Node node = new Node(value);
        addInTail(node);
    }

    public void addInTail(Node item) {
        if (this.head == null) {
            this.head = item;
        } else {
            this.tail.next = item;
        }
        this.tail = item;

        ++this.size;
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
        if (this.size == 0) return nodes;
        Node node = this.head;
        while (node != null) {
            if (node.value == _value)
                nodes.add(node);
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int _value) {
        if (this.size == 0) return false;
        Node prev = null;
        Node current = this.head;
        while (true) {
            if (current == null) return false;
            if (current.value == _value) break;
            prev = current;
            current = current.next;
        }
        unlinkNode(prev, current);
        return true;
    }

    private void unlinkNode(Node prev, Node current) {
        Node nextNode = current.next;
        boolean isTail = (nextNode == null);
        if (isTail) {
            if (prev == null) {
                head = null;
            } else {
                prev.next = null;
            }
            tail = prev;

        } else {
            current.next = nextNode.next;
            current.value = nextNode.value;
        }
        --this.size;
    }

    public void removeAll(int _value) {
        if (this.size == 0) return;
        Node prevNode = null;
        Node node = this.head;
        while (node != null) {
            if (node.value == _value) {
                unlinkNode(prevNode, node);
                continue;
            }
            prevNode = node;
            node = node.next;
        }
    }

    public void clear() {
        if (this.size == 0) return;
        Node next;
        for (Node curr = this.head; curr != null; curr = next) {
            next = curr.next;
            curr.next = null;
        }
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int count() {
        return size;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        if (this.tail == _nodeAfter) {
            addInTail(_nodeToInsert);
        } else if (_nodeAfter == null) {
            addInHead(_nodeToInsert);
        } else {
            _nodeToInsert.next = _nodeAfter.next;
            _nodeAfter.next = _nodeToInsert;
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
