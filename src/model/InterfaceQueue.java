package model;

public interface InterfaceQueue<T> {

	public boolean add(T element);
	
	public boolean offer(T element);
	
	public T remove();
	
	public T poll();
	
	public T element();
	
	public T peek();
}
