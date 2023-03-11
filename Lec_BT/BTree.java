package Lec_BT;

import java.util.LinkedList;
import java.util.Queue;

public class BTree {
	class Node {
		public Node(int i) {
			data = i;
		}

		int data;
		Node left;
		Node right;
	}

	Node root;

	public void print() {
		pre_print(root);
	}

//	pre ordre
	private void pre_print(Node nn) {
		if (nn == null) {
			return;
		}
//	BP : nn
//	SP : nn.left ; nn.right
		String str = "";
		if (nn.left != null) {
			str = nn.left.data + "";
		}
		str = str + " => " + nn.data + " <= ";
		if (nn.right != null) {
			str = str + nn.right.data;
		}

		System.out.println(str);
		pre_print(nn.left);
		pre_print(nn.right);

	}

	public int size() {
		return size(root);
	}

	private int size(Node nn) {
		if (nn == null) {
			return 0;
		}
//		BP : size(10k)
//		SP : size(20k) size(30k)

		int sp1 = size(nn.left);
		int sp2 = size(nn.right);
		return sp1 + sp2 + 1;
	}

	public BTree(int[] pre) {
		pidx = 0;
		root = createPre(pre);
	}

	int pidx = 0;

	private Node createPre(int[] pre) {
		if (pidx >= pre.length || pre[pidx] == -1) {
			pidx++;
			return null;
		}
		Node nn = new Node(pre[pidx]);
		pidx++;
		nn.left = createPre(pre);
		nn.right = createPre(pre);
		return nn;
	}

	public void lvl() {
		Queue<Node> Q = new LinkedList<>();
		Q.add(root);
		while (!Q.isEmpty()) {
			Node nn = Q.poll();
			System.out.println(nn.data);
			if (nn.left != null) {
				Q.add(nn.left);
			}
			if (nn.right != null) {
				Q.add(nn.right);
			}
		}
	}

	public void lvlcreate(int[] lvl) {
		Queue<Node> Q = new LinkedList<>();
		root = new Node(lvl[0]);
		Q.add(root);
		int idx = 1;
		while (idx < lvl.length && !Q.isEmpty()) {
			Node nn = Q.poll();
			if (idx < lvl.length && lvl[idx] != -1) {
				nn.left = new Node(lvl[idx]);
				Q.add(nn.left);
			}
			idx++;

			if (idx < lvl.length && lvl[idx] != -1) {
				nn.right = new Node(lvl[idx]);
				Q.add(nn.right);
			}
			idx++;
		}

	}

	public void lvl2() {
		Queue<Node> cQ = new LinkedList<>();
		Queue<Node> nQ = new LinkedList<>();

		cQ.add(root);
		while (!cQ.isEmpty()) {
			Node nn = cQ.poll();
			System.out.print(nn.data + " ");
			if (nn.left != null) {
				nQ.add(nn.left);
			}
			if (nn.right != null) {
				nQ.add(nn.right);
			}
			if (cQ.isEmpty()) {
				System.out.println("~~~~~~~");
				cQ = nQ;
				nQ = new LinkedList<>();
			}
		}
	}

	public void lvl3() {
		Queue<Node> Q = new LinkedList<>();
		Q.add(root);
		while (!Q.isEmpty()) {
			int size_curr = Q.size();
			for (int cnt = 1; cnt <= size_curr; cnt++) {
				Node nn = Q.poll();
				System.out.print(nn.data + " ");
				if (nn.left != null) {
					Q.add(nn.left);
				}
				if (nn.right != null) {
					Q.add(nn.right);
				}
			}
			System.out.println();
		}
	}

	public BTree(int[] in, int[] pre) {
		root = createPreIn(in, 0, in.length - 1, pre, 0, pre.length - 1);

	}

	private Node createPreIn(int[] in, int is, int ie, int[] pre, int ps, int pe) {
		if (is > ie || ps > pe) {
			return null;
		}
		Node nn = new Node(pre[ps]);
		int f = -1;
		int L_size = 0;
		for (int i = is; i <= ie; i++) {
			if (in[i] == nn.data) {
				f = i;
				break;
			}
			L_size++;
		}

		nn.left = createPreIn(in, is, f - 1, pre, ps + 1, ps + L_size);
		nn.right = createPreIn(in, f + 1, ie, pre, ps + L_size + 1, pe);

		return nn;
	}

	public int Ht() {
		return Ht(root);
	}

	int gloabl_Dia = Integer.MIN_VALUE;

	private int Ht(Node nn) {
		if (nn == null) {
			return -1;
		}
//		BP : nn
//		SP : nn.left, nn.right
		int sp1 = Ht(nn.left);
		int sp2 = Ht(nn.right);
		int slef_Dia = sp1 + sp2 + 2;
		gloabl_Dia = Math.max(slef_Dia, gloabl_Dia);
		return Math.max(sp1, sp2) + 1;
	}

	public int Dia() {
		return Dia(root);
	}

	private int Dia(Node nn) {
		if (nn == null) {
			return 0;
		}
//		BP : 10k
//		SP : 20k amd 30k
		int sp1 = Dia(nn.left);
		int sp2 = Dia(nn.right);
		int self = Ht(nn.left) + Ht(nn.right) + 2;
//		global_isBal = global_isBal && Math.abs(sp1 - sp2) <= 1;
		return Math.max(sp2, Math.max(sp1, self));
	}

	class DiaHt {
		int Dia = 0;
		int Ht = -1;
	}

	private DiaHt Dia2(Node nn) {
		if (nn == null) {
			return new DiaHt();
		}
		DiaHt L = Dia2(nn.left);
		DiaHt R = Dia2(nn.right);

		DiaHt ans = new DiaHt();
		ans.Ht = Math.max(L.Ht, R.Ht) + 1;
		int slef = L.Ht + R.Ht + 2;

		ans.Dia = Math.max(Math.max(L.Dia, R.Dia), slef);
		return ans;
	}

	public int Dia2() {
		return Dia2(root).Dia;
	}

	public boolean isBal() {
		return isBal(root);

	}

	class isBalHtPair {
		boolean isBal = true;
		int Ht = -1;
	}

	private isBalHtPair isBal2(Node nn) {
		if (nn == null) {
			return new isBalHtPair();
		}
		isBalHtPair Left = isBal2(nn.left);
		isBalHtPair Right = isBal2(nn.right);

		isBalHtPair ans = new isBalHtPair();
		ans.Ht = Math.max(Left.Ht, Right.Ht) + 1;

		if (Left.isBal && Right.isBal) {
			ans.isBal = Math.abs(Left.Ht - Right.Ht) <= 1;
		} else {
			ans.isBal = false;
		}

		return ans;
	}

	private boolean isBal(Node nn) {
		if (nn == null) {
			return true;
		}
		boolean L = isBal(nn.left);
		boolean R = isBal(nn.right);
		if (L && R) {
			int L_Ht = Ht(nn.left);
			int R_Ht = Ht(nn.right);
			return Math.abs(L_Ht - R_Ht) <= 1;
		}
		return false;
	}
	
}
