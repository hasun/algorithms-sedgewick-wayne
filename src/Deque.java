import java.util.NoSuchElementException;
import java.util.Iterator;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Deque<Item> implements Iterable<Item> {
	private Node first;    // the first item in the deque
	private Node last;    // the second to last item in the deque
	private int N;    // the size of the deque

	// inner node class
	private class Node {
		private Item item;
		private Node next;
		private Node prev;
	}

	// intializes an empty deque
	public Deque() {
		first = null;
		last = null;
		N = 0;
		assert check();
	}

	// checks if deque contains any items
	public boolean isEmpty() {
		return first == null;
	}

	// returns number of items in deque
	public int size() {
		return N;
	}

	// adds item to front of the deck
	public void addFirst(Item item) {
		if (isEmpty()) {
			first = new Node();
			last = first;
			first.item = item;
		}
		else {
			Node oldFirst = first;
			first = new Node();
			first.item = item;
			first.next = oldFirst;
			oldFirst.prev = first;
		}
		N++;
		assert check();
	}

	public void addLast(Item item) {
		if (isEmpty()) {
			last = new Node();
			first = last;
			first.item = item;
		}
		else {
			Node oldLast = last;
			last = new Node();
			last.item = item;
			last.prev = oldLast;
			oldLast.next = last;
		}
		N++;
		assert check();
	}

	public Item removeFirst() {
		if (isEmpty()) throw new NoSuchElementException("Deque is empty");
		Item item = first.item;
		if (N == 1) {
			first = null;
			last = null;
		}
		else {
			first = first.next;
			first.prev.next = null;
			first.prev = null;
		}
		N--;
		return item;
	}

	public Item removeLast() {
		if (isEmpty()) throw new NoSuchElementException("Deque is empty");
		Item item = last.item;
		if (N == 1) {
			first = null;
			last = null;
		}
		else {
			last = last.prev;
			last.next.prev = null;
			last.next = null;
		}
		N--;
		return item;
	}
	/*
    // returns string representation of the deque
    private String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
    }
    */
	// returns an iterator that cycles through deque items from first to last
	public Iterator<Item> iterator() { return new DequeIterator(); }

	private class DequeIterator implements Iterator<Item> {
		private Node current = first;

		public boolean hasNext() { return current != null; }

		public void remove() { throw new UnsupportedOperationException(); }

		public Item next() {
			if (!hasNext()) throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}
	}


	// check internal invariants
	private boolean check() {

		// check a few properties of instance variable 'first'
		if (N < 0) {
			return false;
		}
		if (N == 0) {
			if (first != null) return false;
		}
		else if (N == 1) {
			if (first == null)      return false;
			if (first.next != null) return false;
		}
		else {
			if (first == null)      return false;
			if (first.next == null) return false;
		}

		// check internal consistency of instance variable N
		int numberOfNodes = 0;
		for (Node x = first; x != null && numberOfNodes <= N; x = x.next) {
			numberOfNodes++;
		}
		if (numberOfNodes != N) return false;

		return true;
	}

	// unit testing
	public static void main(String[] args) {
		Deque<String> d = new Deque<String>();
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (item.equals("tb")) d.addLast(item);
			else if (item.equals("tf"))d.addFirst(item);
			else if (item.equals("rb")) StdOut.println(d.removeLast());
			else if (item.equals("rf")) StdOut.println(d.removeFirst());
			else StdOut.println(d.toString());
		}
		StdOut.print(d.toString());
		StdOut.print(" size: "+d.size());
	}

}