package collections;

public class LinkedList<T> implements LinkedListInterface<T> {

	private LinkedList<T> next;
	
	private T value;

	
	public LinkedList(T value) {
		this.value = value;
		
	}
	
	@Override
	public T getObject() {
		return value;
	}

	@Override
	public void setObject(T value) {
		this.value = value;
		
	}

	
	public LinkedList<T> getNext() {
		return next;
	}

	
	public void setNext(LinkedList<T> next) {
		this.next = next;
	}

	
}
