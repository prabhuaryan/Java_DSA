package Lec_Stack_QPS;

import java.util.Arrays;
import java.util.Stack;

public class Stack_QPS {
	public static void main(String[] args) {
		Stack<Integer> S = new Stack<>();
		S.add(10);
//		System.out.println(S);
		S.add(20);
//		System.out.println(S);
		S.add(30);
		S.add(40);

//		System.out.println(S);
//		Reverse_Print(S);
//		Reverse_Print2(S);
//		System.out.println(S);
//		Reverse(S);
//		System.out.println(S);
		int[] arr = { 50, 30, 20, 40, 10, 45, 5, 60, 15, 8 };
		NextGr8_idx(arr);
	}

	public static void Reverse_Print(Stack<Integer> S) {
		Stack<Integer> EX = new Stack<>();

		while (!S.isEmpty()) {
			EX.add(S.pop());
		}

		while (!EX.isEmpty()) {
			System.out.println(EX.peek());
			S.add(EX.pop());
		}
	}

	public static void Reverse_Print2(Stack<Integer> S) {
		if (S.isEmpty()) {
			return;
		}
//		BP : S
//		SP : S with n-1;
		int ali = S.pop();
		Reverse_Print2(S); /// SP
		S.add(ali); // Stack mein vapas n elements ho jayee!!
		System.out.println(ali);
	}

	public static void Reverse(Stack<Integer> S) {
		Stack<Integer> EX = new Stack<>();

		while (!S.isEmpty()) {
			EX.add(S.pop());
		}
		copy(EX, S);
	}

	public static void copy(Stack<Integer> A, Stack<Integer> Copy) {
		if (A.isEmpty()) {
			return;
		}
//		BP : S
//		SP : S with n-1;
		int ali = A.pop();
		copy(A, Copy); /// SP
		A.add(ali); // Stack mein vapas n elements ho jayee!!
//		System.out.println(ali);
		Copy.add(ali);
	}

	public static void NextGr8(int[] arr) {
		Stack<Integer> S = new Stack<>();
		for (int B : arr) {
			while (!S.isEmpty() && S.peek() < B) {
				System.out.println(S.pop() + " => " + B);
			}
			S.push(B);
		}

		while (!S.isEmpty()) {
			System.out.println(S.pop() + " => " + -1);
		}
	}

	public static void NextGr8_idx(int[] arr) {
		Stack<Integer> S = new Stack<>();
		int[] soln = new int[arr.length];
		for (int idx =0;idx< arr.length;idx++) {
			int B = arr[idx];
			while (!S.isEmpty() && arr[S.peek()] < B) {
				int A = S.pop();
				soln[A] = B;
//				System.out.println(arr[A] + " => " + B);
			}
			S.push(idx);
		}

		while (!S.isEmpty()) {
			int A = S.pop();
			soln[A] = -1;
//			System.out.println(arr[A] + " => " + -1);
		}
		System.out.println(Arrays.toString(soln));
	}

	
}
