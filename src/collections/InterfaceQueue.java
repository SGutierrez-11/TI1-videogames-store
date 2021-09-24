package collections;

public interface InterfaceQueue<T> {

	void add(T element);
	
	T remove();
	
	public T peek();
	
	boolean isEmpty();
}
