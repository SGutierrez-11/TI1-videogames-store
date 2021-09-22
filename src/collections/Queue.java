package collections;

public class Queue<T> implements InterfaceQueue<T>{

	
	private LinkedList<T> value;
	
	private LinkedList<T> lastValue;
	
	public Queue() {
		
		value = null;
		
		lastValue = null;
	}
	
	
	@Override
	public void add(T element) {
		
		
		
		;
	}

	@Override
	public boolean offer(T element) {
		
		return false;
	}

	@Override
	public T remove() {
		
		return null;
	}

	@Override
	public T poll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T element() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
