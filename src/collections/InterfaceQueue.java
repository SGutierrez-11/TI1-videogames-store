package collections;

public interface InterfaceQueue<T> {

	void add(T element);
	
	boolean offer(T element);
	
	T remove();
	
	T poll();
	
	public T element();
	
	public T peek();
}
