package week2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
	private Node first, last;
	private int N;
	
	private class Node{
		Item item;
		Node next;
		Node pre;
	}
	public Deque() {	
		first = null;
		last = null;
		N = 0;
	}
	public boolean isEmpty() {
		return N==0;
	}
	public int size() {
		return N;
	}
	public void addFirst(Item item) {
		if(item == null) throw new java.lang.IllegalArgumentException();
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		if(isEmpty()) {
			first = last;
		}
		else {
			first.next = oldFirst;
		}
		N++;
	}
	public void addLast(Item item) {
		Node oldLast = last;
		last = new Node();
		last.item = item;
		if(isEmpty()) {
			first = last;
		}
		else {
			oldLast.next = last;
		}
		N++;
	}
	public Item removeFirst() {
		if(isEmpty()) throw new java.util.NoSuchElementException();
		Item item = first.item;
		first = first.next;
		if(isEmpty()) {
			last = null;
		}
		N--;
		return item;
	}
	public Item removeLast() {
		if(isEmpty()) throw new java.util.NoSuchElementException();
		Item item = last.item;
		last = last.pre;
		if(isEmpty()) {
			first = null;
		}
		N--;
		return item;
	}

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item>{
		private Node current = first;
		public void remove() {
			throw new java.lang.UnsupportedOperationException();
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			if(current == null) throw new NoSuchElementException(); 
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
	public static void main (String[] args) {
		
	}

}
