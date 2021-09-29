package collections;

public class Stack<T> implements Stackable<T>{

	private Stack<T> previus;
	
	private T element;
	
	public Stack() {
		
	}
	public Stack(T element) {
		this.element = element;
	}
	
	public Stack(Stack<T> previus, T element) {
		this.previus = previus;
		this.element = element;
	}
	
	public boolean empty() {
		
		if(previus == null) {
			return true;
		}else {
			return false;
		}
		
	}
	public T peek() {
		return element;
		
	}
	@Override
	public void push(T element) {
		this.previus = new Stack<T>(this.previus,this.element);
		this.element = element;
			
	}
	@Override
	public T pop() {
		
		if(isEmpty()) {
			return null;
			
		}else {
			T top = this.element;
			element = this.previus.element;
			this.previus = this.previus.previus;
			return top;
		}
		
		
	}
	@Override
	public boolean isEmpty() {
		if(this.previus==null) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public int size() {
		if(isEmpty()==true) {
			return 0;
		}else {
			
			return 1+previus.size();
		}
	}
	
}
