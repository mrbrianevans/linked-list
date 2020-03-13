
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class LinkedList<Key> implements Iterable<Key> {


	private class Node {
		private Key key;
		private Node next;
		Node(Key key, Node next){
			this.key = key;
			this.next = next;
		}
	}

	private Node firstNode;
	private Node lastNode;
	private int size;

	private Node getFirstNode() {
		return firstNode;
	}

	/**
	 * Return the first element in the list
	 * @return - first key
	 */
	public Key getFirst() {
		return firstNode.key;
	}
	
	
	/**
	 * Return the last element in the list
	 * @return - last key
	 */
	public Key getLastKey() {
		return lastNode.key;
	}
	

	
	/**
	 * Check if the list contains a key
	 * @param k - key to search
	 * @return boolean whether or not the list contains the key k
	 */
	public boolean contains(Key k) {
		for (Key l: this){
			if (l == k)
				return true;
		}
		return false;
	}
	

	
	/**
	 * Insert in the beginning
	 * @param k - key to insert
	 */
	void addFirst(Key k) {
		firstNode = new Node(k, getFirstNode()); // creates new node, pointing to the previous first node and sets it to firstNode
		if(size++==0) lastNode = firstNode;
	}

	/**
	 * Insert in the end
	 * @param key - key to insert
	 */
	void addLast(Key key) {
		lastNode.next = new Node(key, null);
		lastNode = lastNode.next;
		size++;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	
	/**
	 * Delete all occurrences of the key
	 * @param k - key to delete
	 */
	public void deleteAll(Key k) {
		Node temp = getFirstNode(); // this does not work because Java is pass by value, not pass by reference
		for (int i = 0; i < size-1; i++) {
			if(temp.next.key==k){
				temp.next = temp.next.next;
			}
		}
		if (lastNode.key == k)
			lastNode = null;
	}
	
	/**
	 * Delete the key
	 * @param k - key to delete
	 */
	public void delete(Key k) {
		Node temp = getFirstNode(); // this does not work because Java is pass by value, not pass by reference
		for (int i = 0; i < size-1; i++) {
			if(temp.next.key==k){
				temp.next = temp.next.next;
				break;
			}
		}
		if (lastNode.key == k)
				lastNode = null;
	}
	
	/**
	 * Remove the first element of the list 
	 * @return removed element
	 */
	public Key removeFirst(){
		Key key = firstNode.key;
		firstNode = firstNode.next;
		return key;
	}

 
	/**
	 * Iterator over the list
	 */
	@Override
	public Iterator<Key> iterator() {
		return new ListIterator<Key>() {
			Node temp = getFirstNode();
			@Override
			public boolean hasNext() {
				return temp.next != null;
			}

			@Override
			public Key next() {
				Key k = temp.next.key;
				temp = temp.next;
				return k;
			}

			@Override
			public boolean hasPrevious() {
				return !temp.equals(getFirstNode());
			}

			@Override
			public Key previous() {
				return null;
			}

			@Override
			public int nextIndex() {
				return 0;
			}

			@Override
			public int previousIndex() {
				return 0;
			}

			@Override
			public void remove() {

			}

			@Override
			public void set(Key key) {

			}

			@Override
			public void add(Key key) {

			}
		};
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[ ");
		for (Key k : this) {
			sb.append(k.toString()+ " ");
		}
		sb.append("]");
		return new String(sb);
	}

}
