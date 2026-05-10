package Module4.Exercise24_03;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class TwoWayLinkedList<E> implements Iterable<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    // Node stores the element, the next node, and the previous node
    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> previous;

        public Node(E element) {
            this.element = element;
        }
    }

    public TwoWayLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public TwoWayLinkedList(E[] objects) {
        for (E object : objects) {
            add(object);
        }
    }

    public int size() {
        return size;
    }

    public E getFirst() {
        if (size == 0) {
            return null;
        }

        return head.element;
    }

    public E getLast() {
        if (size == 0) {
            return null;
        }

        return tail.element;
    }

    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);

        if (size == 0) {
            head = tail = newNode;
        }
        else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }

        size++;
    }

    public void addLast(E e) {
        Node<E> newNode = new Node<>(e);

        if (size == 0) {
            head = tail = newNode;
        }
        else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }

        size++;
    }

    public void add(E e) {
        addLast(e);
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (index == 0) {
            addFirst(e);
        }
        else if (index == size) {
            addLast(e);
        }
        else {
            Node<E> current = getNode(index);
            Node<E> previousNode = current.previous;
            Node<E> newNode = new Node<>(e);

            previousNode.next = newNode;
            newNode.previous = previousNode;
            newNode.next = current;
            current.previous = newNode;

            size++;
        }
    }

    public E removeFirst() {
        if (size == 0) {
            return null;
        }

        E temp = head.element;
        head = head.next;
        size--;

        if (size == 0) {
            tail = null;
        }
        else {
            head.previous = null;
        }

        return temp;
    }

    public E removeLast() {
        if (size == 0) {
            return null;
        }

        E temp = tail.element;
        tail = tail.previous;
        size--;

        if (size == 0) {
            head = null;
        }
        else {
            tail.next = null;
        }

        return temp;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        if (index == 0) {
            return removeFirst();
        }
        else if (index == size - 1) {
            return removeLast();
        }
        else {
            Node<E> current = getNode(index);
            Node<E> previousNode = current.previous;
            Node<E> nextNode = current.next;

            previousNode.next = nextNode;
            nextNode.previous = previousNode;

            size--;
            return current.element;
        }
    }

    public boolean remove(E e) {
        Node<E> current = head;

        while (current != null) {
            if ((e == null && current.element == null) ||
                (e != null && e.equals(current.element))) {

                if (current == head) {
                    removeFirst();
                }
                else if (current == tail) {
                    removeLast();
                }
                else {
                    current.previous.next = current.next;
                    current.next.previous = current.previous;
                    size--;
                }

                return true;
            }

            current = current.next;
        }

        return false;
    }

    public boolean contains(E e) {
        return indexOf(e) >= 0;
    }

    public E get(int index) {
        return getNode(index).element;
    }

    public E set(int index, E e) {
        Node<E> current = getNode(index);
        E oldValue = current.element;
        current.element = e;
        return oldValue;
    }

    public int indexOf(E e) {
        Node<E> current = head;
        int index = 0;

        while (current != null) {
            if ((e == null && current.element == null) ||
                (e != null && e.equals(current.element))) {
                return index;
            }

            current = current.next;
            index++;
        }

        return -1;
    }

    public int lastIndexOf(E e) {
        Node<E> current = tail;
        int index = size - 1;

        while (current != null) {
            if ((e == null && current.element == null) ||
                (e != null && e.equals(current.element))) {
                return index;
            }

            current = current.previous;
            index--;
        }

        return -1;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    private Node<E> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node<E> current;

        // If index is in the first half, start from head
        if (index < size / 2) {
            current = head;

            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        }
        // If index is in the second half, start from tail
        else {
            current = tail;

            for (int i = size - 1; i > index; i--) {
                current = current.previous;
            }
        }

        return current;
    }

    public Iterator<E> iterator() {
        return new TwoWayLinkedListIterator(0);
    }

    public ListIterator<E> listIterator() {
        return new TwoWayLinkedListIterator(0);
    }

    public ListIterator<E> listIterator(int index) {
        return new TwoWayLinkedListIterator(index);
    }

    private class TwoWayLinkedListIterator implements ListIterator<E> {
        private Node<E> current;
        private int currentIndex;

        public TwoWayLinkedListIterator(int index) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
            }

            currentIndex = index;

            if (index == size) {
                current = null;
            }
            else {
                current = getNode(index);
            }
        }

        public boolean hasNext() {
            return currentIndex < size;
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            E temp = current.element;
            current = current.next;
            currentIndex++;

            return temp;
        }

        public boolean hasPrevious() {
            return currentIndex > 0;
        }

        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }

            if (current == null) {
                current = tail;
            }
            else {
                current = current.previous;
            }

            currentIndex--;
            return current.element;
        }

        public int nextIndex() {
            return currentIndex;
        }

        public int previousIndex() {
            return currentIndex - 1;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public void set(E e) {
            throw new UnsupportedOperationException();
        }

        public void add(E e) {
            throw new UnsupportedOperationException();
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder("[");

        Node<E> current = head;

        while (current != null) {
            result.append(current.element);

            if (current.next != null) {
                result.append(", ");
            }

            current = current.next;
        }

        result.append("]");
        return result.toString();
    }
}