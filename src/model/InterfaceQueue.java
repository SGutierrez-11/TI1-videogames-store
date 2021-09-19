package model;

public interface InterfaceQueue<T> {

	boolean add(T element);
	
	boolean offer(T element);
	
	T remove();
	
	T poll();
	
	public T element();
	
	public T peek();
}
