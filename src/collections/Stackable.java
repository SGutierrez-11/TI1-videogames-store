package collections;

public interface Stackable<T> {

	void push(T element);
	
	T pop();
	
	T peek();
	
	boolean isEmpty();
	
	int size();
	
}
