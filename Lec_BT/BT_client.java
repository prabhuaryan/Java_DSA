package Lec_BT;

public class BT_client {
	public static void main(String[] args) {
//		int[] pre = { 10, 20, 40, -1, -1, 50, -1, -1, 30, -1, 70 };
//		BTree BT = new BTree(pre);
//		BT.print();
//		BT.lvl();
//		System.out.println("==================");
//		int[] lvl = { 10, 20, 30, 40, 50, -1, 70, -1, -1, 80, 90, -1, -1, -1, -1, 100 };
//		BT.lvlcreate(lvl);
////		BT.lvl();
//		BT.lvl3();
		int[] pre = { 10, 20, 40, 50, 30, 70 };
		int[] in = { 40, 20, 50, 10, 30, 70 };
		BTree BT = new BTree(in, pre);
		BT.print();

	}
}
