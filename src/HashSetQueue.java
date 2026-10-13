import java.util.HashSet;

public class HashSetQueue<E> {
    private Node front;
    private Node rear;
    private int size;
    private HashSet<E> set;

    private class Node {
        E data;
        Node next;
        Node(E data) {
            this.data = data;
        }
    }

    public HashSetQueue() {
        front = rear = null;
        size = 0;
        set = new HashSet<>();
    }

    public boolean add(E item) {
        if (item == null || set.contains(item)) {
            return false;
        }

        Node newNode = new Node(item);
        if (size == 0) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        set.add(item);
        size++;
        return true;
    }

    public E remove() {
        if (size == 0) {
            return null;
        }

        E data = front.data;
        front = front.next;
        set.remove(data);
        size--;

        if (front == null) {
            front = rear = null;
        }
        return data;
    }

    public E peek() {
        if (size == 0) {
            return null;
        } else {
            return front.data;
        }
    }

    public void clear() {
        front = rear = null;
        size = 0;
        set.clear();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
