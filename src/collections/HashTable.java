package collections;

public class HashTable<T> implements InterfaceHashTable<T> {

	private int currentSize;
	
	private int maxSize;
	
	private String[] keys;
	
	private T[] values;
	
	public HashTable(int maxSize){
		
		this.maxSize = maxSize;
		
		currentSize = 0;
		
		keys = new String[maxSize];
		
		values = (T[])new Object[maxSize];
		
	}

	@Override
	public int getSize() {
		
		return currentSize;
	}

	@Override
	public boolean isFull() {
		
			if(currentSize==maxSize) {
				return true;
			}else {
				return false;
			}
	}

	@Override
	public boolean isEmpty() {
		
			if(getSize()==0) {
				return true;
			}else {
				return false;
			}
			
	}

	@Override
	public boolean contains(String key) {
		
		if(get(key)==null) {
			return true;
		
		}else {
			return false;
		}		
	}

	@Override
	public int hash(String key) {
		
		int hashNumber = key.hashCode() % maxSize;
		return hashNumber;
	}

	@Override
	public void insert(String key, T element) {
	
		int tmp = hash(key);
		
		int i = tmp;
		
		do {
			
			if(keys[i]==null) {
				
				keys[i] = key;
				values[i] = element;
				currentSize+=1;
				return;
			}
			if(keys[i].equals(key)) {
				
				values[i] = element;
			}
			i = (i+1)% maxSize;
		}while(i!=tmp);
	}

	@Override
	public T get(String key) {
		
		int i = hash(key);
		
		while(keys[i]!=null) {
		
			if(keys[i].equals(key)) {
				
				return values[i];
			}
			i = (i+1) % maxSize;
			
			
		}
		
		return null;
	}
	
	
}
