package Lec_Queue;

public class Queue {
	int s;
	int size;
	int arr[];
	public Queue(int cap) {
		// TODO Auto-generated constructor stub
		s=0;
		size =0;
		arr = new int[cap];
	}
	public Queue() {
		this(5);
	}
	public void add(int ali) {
		if(isFull()) {
			throw new RuntimeException("is Full!!");
		}
		int idx = (s+size)%arr.length;
		arr[idx] = ali;
		size++;
	}
	public int size() {
		return size;
	}
	public int peek() {
		if(isEmpty()) {
			throw new RuntimeException("is Empty!!");
		}
		return arr[s];
	}
	public boolean isEmpty() {
		return size()== 0;
	}
	public boolean isFull() {
		return size()== arr.length;
	}
	public int poll() {
		if(isEmpty()) {
			throw new RuntimeException("is Empty!!");
		}
		int ans = arr[s];
		s=(s+1)%arr.length;
		size--;
		return ans;
	}
}
