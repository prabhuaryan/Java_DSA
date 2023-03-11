package Lec_Queue_QPS;

import java.util.LinkedList;
import java.util.Queue;

public class QPS {
	public static void main(String[] args) {
		Queue<Integer> Q = new LinkedList<>();
		Q.add(10);
		Q.add(20);
		Q.add(30);
		Q.add(40);
		Q.add(50);
		System.out.println(Q);
		System.out.println("=========");
		RevDisp(Q,0);
		System.out.println(Q);
	} 

	public static void RevDisp(Queue<Integer> Q, int cnt) {
		if(cnt==Q.size()) {
			return;
		}
		int ali = Q.poll();
		Q.add(ali);
		RevDisp(Q,cnt+1);
		System.out.println(ali);
		
	}

	public static void Rev(Queue<Integer> Q) {
		if(Q.isEmpty()) {
			return;
		}
		int ali = Q.poll();
		Rev(Q);
		Q.add(ali);
	}

}
