package Lec_Queue_QPS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class First_neg {
	public static void main(String[] args) {
		int[] arr = { -20, 10, -5, 4, 6, -9, -80, 60, 50 };
		int k = 3;

		Queue<Integer> Q = new LinkedList<>();

		for (int i = 0; i < k; i++) {
			if (arr[i] < 0) {
				Q.add(i);
			}
		}
		System.out.println(arr[Q.peek()]);
		for (int s = 1; s <= arr.length - k; s++) {
			if (!Q.isEmpty() && Q.peek() < s) {
				Q.poll();
			}
			int e = s + k - 1;
			if (arr[e] < 0) {
				Q.add(e);
			}
			System.out.println(arr[Q.peek()]);
		}

	}

	static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
		// Your code here
		int sum = 0;
		int i = 0;
		int idx = 0;
		ArrayList<Integer> list = new ArrayList<>();
		while (idx <= arr.length) {
			if (sum < s) {
				if (idx < arr.length) {
					sum += arr[idx];
				}
				idx++;
			} else if (sum > s) {
				sum -= arr[i];
				i++;
				if (sum == s) {
					list.add(i + 1);
					list.add(idx);
					break;
				}
			} else if (sum == s) {
				list.add(i + 1);
				list.add(idx);
				break;
			}
		}
		if (list.get(0) > idx) {
			ArrayList<Integer> list1 = new ArrayList<>();
			list1.add(-1);
			return list1;
		}
		if (list.size() == 0) {
			list.add(-1);
			return list;
		}

		return list;
	}
}
