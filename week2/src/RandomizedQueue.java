
import java.util.Iterator;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
	private Item[] s;
	private int N;
	public RandomizedQueue() {
		N = 0;
		s = (Item[]) new Object[2];
	}
	public boolean isEmpty() {
		return N == 0;
	}
	public int size() {
		return N;
	}
	public void enqueue(Item item) {
		if (item == null) throw new java.lang.IllegalArgumentException();
		if (N == s.length) {
			resize(2*s.length);
		}
		s[N++] = item;
	}
	public Item dequeue() {
		if (isEmpty()) throw new java.util.NoSuchElementException();
		int index = StdRandom.uniform(N);
		Item item = s[index];
		s[index] = s[--N];
		s[N] = null;
		if (N > 0 && N == s.length/4) {
			resize(s.length/2);
		}
		return item;
	}
	public Item sample() {
		if (isEmpty()) throw new java.util.NoSuchElementException();
		int index = StdRandom.uniform(N);
		Item item = s[index];
		return item;
	}

	private void resize(int capacity) {
		// TODO Auto-generated method stub
		Item[] items = (Item[]) new Object[capacity];
		Item copy[] = items;
		for (int i = 0; i < N; i++) {
			copy[i] = s[i];
		}
		s = copy;
	}
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator();
	}
	private class ListIterator implements Iterator<Item> {
		private int index;
		final Item[] r;
		public ListIterator() {
			index = 0;
			r = (Item[]) new Object[N];
			for (int i = 0; i < N; i++) {
				r[i] = s[i];
			}
			StdRandom.shuffle(r);
		}
		public void remove() {
			throw new java.lang.UnsupportedOperationException();
		}

		@Override
		public boolean hasNext() {
			return index < N;
		}

		@Override
		public Item next() {
			if(!hasNext()) {
				throw new java.util.NoSuchElementException(); 
			}
			Item item = r[index++];
			return item;
		}
		
	}
	
	
	

}
