package Lec_LL;

public class LL_demo {
	public static void main(String[] args) {
		LinkedList LL = new LinkedList();
//		LL.add(10);
//		LL.add(20);
//		LL.add(30);
//		LL.add(40);
//		LL.print();
//		System.out.println(LL.removeAt(2));
//		LL.print();
//		System.out.println(LL.removeAt(2));
//		LL.print();
//		System.out.println(LL.removeFirst());
//		LL.print();
//		System.out.println(LL.removeFirst());
//		LL.print();
//		System.out.println("----");
		LL.createCycle();
		System.out.println(LL.hasCycle());
		LL.removeCyle();
		System.out.println(LL.hasCycle());
		LL.print();
		
	}
}
