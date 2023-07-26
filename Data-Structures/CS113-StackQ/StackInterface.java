package edu.miracosta.cs113;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Queue;
import java.util.Collection;

public class ArrayListStack<E> implements StackInterface<E> {
	
	private List<E> theData;
	
	public ArrayListStack() {
		theData = new ArrayList<E>();
	}

    /**
     * Returns true if the stack is empty; otherwise, returns false
     *
     * @return true if empty, false otherwise
     */
	@Override
    public boolean empty() {
		return theData.size() == 0;
	}

    /**
     * Returns the object at the top of the stack without removing it
     *
     * @return reference (shallow copy) of object at top of stack
     */
	@Override
    public E peek() {
    	if (empty())
    	{
    		throw new EmptyStackException();
    	}
    	return theData.get(theData.size() - 1);
    }

    /**
     * Returns the object at the top of the stack and removes it
     *
     * @return reference of removed object from top of stack
     */
    public E pop() {
    	if (empty()) {
    		throw new EmptyStackException();
    	}
    	return theData.remove(theData.size() - 1);
    }

    /**
     * Pushes an item onto the top of the stack and returns the item pushed.
     *
     * @param obj object to push onto top of stack
     * @return item that was pushed
     */
    public E push(E obj)
    {
    	theData.add(obj);
    	return obj;
    }
}

public class ArrayQueue<E> extends AbstractQueue<E> implements Queue<E> {
	
	private int front;
	private int rear;
	private int size;
	private int capacity;
	private static final int DEFAULT_CAPACITY = 10;
	private E[] theData;
	
	public ArrayQueue() {
		this(DEFAULT_CAPACITY);
	}
	
	public ArrayQueue(int initCapacity) {
		capacity = initCapacity;
		theData = (E[]) new Object[capacity];
		front = 0;
		rear = capacity - 1;
		size = 0;
	}
	
	public boolean add(E e) {
		 if (size != capacity) {
	          front = (front + 1) % capacity;
	          theData.add(front, e);
	          size++;
	          return true;
		 } 
		 else {
	          throw new IllegalStateException();
	     }
	}
	
	public E element() {
		return theData.get(front);
	}
	
	public boolean offer(E item) {
		if (size == capacity) {
			reallocate();
		}
		size++;
		rear = (rear + 1) % capacity;
		theData[rear] = item;
		return true;
	}
	
	public E peek() {
		if (size == 0) {
			return null;
		}
		else {
			return theData[front];
		}
	}
	
	public E poll() {
		if (size == 0) {
			return null;
		}
		E result = theData[front];
		front = (front + 1) % capacity;
		size--;
		return result;
	}
	
	public E remove() {
		E o = null;
        
        if (size == 0)
            return null;
        else {
            rear = (rear + 1) % capacity;
            o = theData.get(rear);
            theData.remove(rear);
            size--;
        }
        return o;
	}
	
	private void reallocate() {
		int newCapacity = 2 * capacity;
		E[] newData = (E[]) new Object[newCapacity];
		int j = front;
		for (int i = 0; i < size; i++) {
			newData[i] = theData[j];
			j = (j+1) % capacity;
		}
		front = 0;
		rear = size - 1;
		capacity = newCapacity;
		theData = newData;
	}
}
