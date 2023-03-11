package Lec_PQ;

import java.util.Collections;
import java.util.PriorityQueue;

public class PQ_dmo {
	public static void main(String[] args) {
//		PriorityQueue<Integer> PQ = new PriorityQueue<Integer>(); // min heap , rank !!
		PriorityQueue<Integer> PQ = 
				new PriorityQueue<Integer>(Collections.reverseOrder()); // max heap marks
		
		PQ.add(99); // O(logn)
		PQ.add(100);
		PQ.add(2);
		PQ.add(4);
		PQ.add(5);
		PQ.add(3);
		

		System.out.println(PQ);
		System.out.println(PQ.poll());// O(logn)
		System.out.println(PQ.poll());
		System.out.println(PQ.poll());
		System.out.println(PQ.poll());
		System.out.println(PQ.poll());
		

	}
}
