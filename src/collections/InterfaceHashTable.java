package collections;

public interface InterfaceHashTable<T> {

	int getSize();
	
	boolean isFull();
	
	boolean isEmpty();
	
	boolean contains(String key);
	
	int hash(String key);
	
	void insert(String key, T element);

	T get(String key);
	
}
