package Lec_BST;

import java.util.LinkedList;
import java.util.Queue;

public class BST {
	class Node {
		public Node(int i) {
			data = i;
		}

		int data;
		Node left;
		Node right;
	}

	Node root;

	public void print_lvl() {
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

	public BST(int[] lvl) {
		if (lvl.length == 0) {
			return;
		}
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

	public boolean find(int ali) {
		return find(root, ali);
	}

	private boolean find(Node nn, int ali) {
		if (nn == null) {
			return false;
		}
		if (nn.data == ali) {
			return true;
		} else if (ali > nn.data) {
			return find(nn.right, ali);
		} else {
			return find(nn.left, ali);
		}
	}

	public void add(int ali) {
		root = add(root, ali);
	}

	private Node add(Node nn, int ali) {
		if (nn == null) {
			return new Node(ali);
		}
		if (nn.data < ali) {
			nn.right = add(nn.right, ali);
		} else {
			nn.left = add(nn.left, ali);
		}
		return nn;
	}

	public void remove(int ali) {
		root = remove(root, ali);
	}

	public int min() {
		return min(root);
	}
	
	private int min(Node nn) {
		if(nn.left==null) {
			return nn.data;
		}
		return min(nn.left);
	}

	private Node remove(Node nn, int ali) {
		if (nn == null) {
			return null;
		}
		if (nn.data == ali) {
//		c1 : nn is leaf node
			if (nn.left == null && nn.right == null) {
				return null;
			}
//			c2 : nn has 1 child
			if(nn.left!=null && nn.right==null) {
				return nn.left;
			}
			if(nn.left==null && nn.left!=null) {
				return nn.right;
			}
//			c3!!!
			int Right_min = min(nn.right);
			nn.data = Right_min;
			nn.right = remove(nn.right,Right_min);
			return nn;

		} else if (ali > nn.data) {
			nn.right = remove(nn.right, ali);
		} else {
			nn.left = remove(nn.left, ali);
		}
		return nn;
	}
}
