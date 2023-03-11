package Lec_BST;

public class BST_client {
	public static void main(String[] args) {
		int[] lvl = {};
		BST BT = new BST(lvl);
		BT.add(10);
		BT.add(11);
		BT.add(12);
		BT.add(13);
		BT.add(14);
		
		BT.print_lvl();
	}
}
