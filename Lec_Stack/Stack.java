package Lec_Stack;

import java.util.Arrays;

public class Stack {
	int[] arr;
	int tos;
	
	@Override
	public String toString() {
		return "aaajaaa bhai mere pad le tora "+Arrays.toString(arr);
	}
	
	public Stack() {
		this(5);
	}

	public Stack(int Cap) {
		arr = new int[Cap];
		tos = -1;
	}

	public void add(int ali) {
		if (isFull()) {
			throw new RuntimeException("full full bhai");
		}
		tos++;
		arr[tos] = ali;
	}

	public void push(int ali) {
		add(ali);
	}

	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("Empty hein bhai");
		}
		int ans = arr[tos];
		tos--;
		return ans;
	}

	public int size() {
		return tos + 1;
	}

	public boolean isFull() {
		return size() == arr.length;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public int peek() {
		if (isEmpty()) {
			throw new RuntimeException("Kya deekh rha hein bhai");
		}
		return arr[tos];
	}

	public void Disp() {
		int temp = tos;
		while (temp >= 0) {
			System.out.print(arr[temp] + " ");
			temp--;
		}
		System.out.println();
	}

}
