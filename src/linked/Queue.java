package linked;

import java.util.Iterator;

public class Queue<Item> implements Iterable{

    private Node last;
    private Node first;
    private Item item;
    private int N;

    @Override
    public Iterator iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current.next == null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    private class Node {
        Item item;
        Node next;
    }

    public Item dequeue(){
        Item item = first.item;
        first = first.next;
        if (isEmpty()) last = first;
        N--;
        return item;
    }

    public void enqueue(Item item){
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldLast.next = last;
        N++;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

}
