package collections;

import java.util.ArrayList;

public class HashTable<T> implements InterfaceHashTable<T> {

	private int currentSize;
	
	private int maxSize;
	
	private String[] keys;
	
	private ArrayList<T> values;
	
	public HashTable(int maxSize){
		
		this.maxSize = maxSize;
		
		currentSize = 0;
		
		keys = new String[maxSize];
		
		values = new ArrayList<T>();
		
		for(int i=0; i < maxSize;i++) {
			
			values.add(null);
			
		}
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
		
		//System.out.println("Llega al contains");
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
		
		//System.out.println(tmp);
		
		int i = tmp;
			
		do {
			while(i<0) {
				i = (i+1)% maxSize;
			}	
			if(keys[i]==null) {
				
				keys[i] = key;
				values.set(i, element);
				currentSize+=1;
				return;
			}
			if(keys[i].equals(key)) {
				
				values.set(i, element);
			}
			i = (i+1)% maxSize;
		}while(i!=tmp);
	}

	@Override
	public T get(String key) {
		
		int i = 0;
		//System.out.println("Entra al get");
		boolean out = false;
		
		for(int j=0; j < keys.length && out==false;j++) {
			
			if(keys[j]==key) {
			
				i = j;
				out = true;
				
			}
		}
		if(out==true) {
			return values.get(i);
		}else {
			return null;
		}
		//return null;
		/*
		while(keys[i]!=null) {
		
			if(keys[i].equals(key)) {
				
				return values[i];
			}
			i = (i+1) % maxSize;
			
			
		}
		
		return null;
	}*/
	}
	
}
