package Lec_PQ;

import java.util.PriorityQueue;

public class PQ_QPS {
	public static void main(String[] args) {
		int[] arr = { 20, 30, 60, 50, 10, 55, 57, 40 };

//		TopK(arr, 3);
		int[][] mat = { { 10, 20, 30 }, { 15, 35 }, { 5, 7, 12, 25 }, { 17, 22, 40 } };
		MergeK_Sorted(mat);
	}

	public static void TopK(int[] arr, int k) {
		PriorityQueue<Integer> PQ = new PriorityQueue<>();
		for (int ali : arr) {
			PQ.add(ali);
			if (PQ.size() > k) {
				PQ.remove();
			}
		}
		System.out.println(PQ);
	}

	static class pair implements Comparable<pair> {
		public pair(int i, int i2, int j) {
			// TODO Auto-generated constructor stub
			ali = i;
			arr_idx = i2;
			ali_idx = j;
		}

		int ali;
		int arr_idx;
		int ali_idx;

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return ali + "";
		}

		@Override
		public int compareTo(pair o) {
			return this.ali - o.ali;
//			return o.ali- this.ali ;
		}
	}

	public static void MergeK_Sorted(int[][] mat) {
		PriorityQueue<pair> PQ = new PriorityQueue<>();
		for (int i = 0; i < mat.length; i++) {
			PQ.add(new pair(mat[i][0], i, 0));
		}
		System.out.println(PQ);
		while (!PQ.isEmpty()) {
			pair p = PQ.poll();
			System.out.println(p.ali);
			p.ali_idx++;
			if (p.ali_idx < mat[p.arr_idx].length) {
				p.ali = mat[p.arr_idx][p.ali_idx];
				PQ.add(p);
			}
		}

	}
}
