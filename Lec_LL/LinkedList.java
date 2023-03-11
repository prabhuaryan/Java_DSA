package Lec_LL;

public class LinkedList {
	class Node {
		public Node(int data2) {
			data = data2;
		}

		int data;
		Node next;
	}

	Node head;

	public void print() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " => ");
			temp = temp.next;
		}
		System.out.println("Nulli");
	}

	public int size() {
		int size = 0;
		Node temp = head;
		while (temp != null) {
			temp = temp.next;
			size++;
		}
		return size;
	}

	public int getFirst() {
		if (isEmpty()) {
			throw new RuntimeException("kya theek rha hein ?!");
		}
		return head.data;
	}

	public int getLast() {
		if (isEmpty()) {
			throw new RuntimeException("kya theek rha hein ?!");
		}
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		return temp.data;
	}

	public int getAt(int idx) {
		if (idx < 0 || idx >= size()) {
			throw new RuntimeException("kya theek rha hein ?!");
		}
		Node temp = head;
		for (int i = 1; i <= idx; i++) {
			temp = temp.next;
		}
		return temp.data;
	}

	private Node getAtNode(int idx) {
		if (idx < 0 || idx >= size()) {
			throw new RuntimeException("kya theek rha hein ?!");
		}
		Node temp = head;
		for (int i = 1; i <= idx; i++) {
			temp = temp.next;
		}
		return temp;
	}

	public void add(int data) {
		addLast(data);
	}

	public void addLast(int data) {

		Node nn = new Node(data);
		if (isEmpty()) {
			head = nn;
			return;
		}
//		####
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = nn;

	}

	public void addFirst(int data) {
		Node nn = new Node(data);
		nn.next = head;
		head = nn;
	}

	public void addAt(int idx, int data) {
		if (idx < 0 || idx >= size()) {
			throw new RuntimeException("kya theek rha hein ?!");
		}
		if (idx == 0) {
			addFirst(data);
			return;
		}
		if (idx == size() - 1) {
			addLast(data);
			return;
		}
		Node prev = getAtNode(idx - 1);
		Node after = prev.next;

		Node curr = new Node(data);

		prev.next = curr;
		curr.next = after;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public int removeLast() {
		if (isEmpty()) {
			throw new RuntimeException("kya theek rha hein ?!");
		}
		if (size() == 1) {
			return removeFirst();

		}
		Node prev = getAtNode(size() - 2);
		Node curr = prev.next;
		int ans = curr.data;

		prev.next = null;

		return ans;
	}

	public int removeFirst() {
		if (isEmpty()) {
			throw new RuntimeException("kya theek rha hein ?!");
		}
		Node curr = head;
		Node after = curr.next;

		int ans = curr.data;

		head = after;
		return ans;
	}

	public int removeAt(int idx) {
		if (isEmpty()) {
			throw new RuntimeException("kya theek rha hein ?!");
		}
		if (idx < 0 || idx >= size()) {
			throw new RuntimeException("kya theek rha hein ?!");
		}
		if (idx == 0) {
			return removeFirst();
		}
		if (idx == size() - 1) {
			return removeLast();
		}
		Node prev = getAtNode(idx - 1);
		Node curr = prev.next;
		Node after = curr.next;
		int ans = curr.data;
		prev.next = after;

		return ans;
	}
	public void Rev() {
		Node curr = head;
		Node  prev = null;
		while(curr!=null) {
			Node after = curr.next; 
			curr.next = prev;
			
			prev = curr;
			curr = after;
		}
		head = prev;
	}
	public Node reverseKGroup(Node head, int k) {
		Node temp = head;
        for(int i=1;i<=k;i++){
            if(temp==null){
                return head;
            }
            temp = temp.next;
        }
        Node sp = reverseKGroup(temp,k);
        Node prev = null;
        Node curr = head;
        for(int i=1;i<=k;i++){
        	Node after = curr.next;
            curr.next = prev;

            prev = curr;
            curr= after;
        }
        head.next = sp;
        return prev;
    }
	public int mid () {
		Node slow = head;
		Node fast = head;
		while(fast!=null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow.data;
	}
	public int KthLast(int k) {
		Node ahead = head;
		for(int i=1;i<=k;i++) {
			ahead = ahead.next;
		}
		Node curr = head;
		while(ahead!=null) {
			ahead = ahead.next;
			curr = curr.next;
		}
		return curr.data;
	}
	public void createCycle() {
		for(int i=1;i<=9;i++) {
			addLast(i);
		}
		Node last = getAtNode(this.size()-1);
		Node rand = getAtNode(3);
		last.next = rand;
	}
	public boolean hasCycle() {
		Node slow = head;
		Node fast = head;
		while(fast!=null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
			if(fast==slow) {
				return true;
			}
		}
		return false;
		
	}
	public void removeCyle() {
		if(!hasCycle()) {
			return;
		}
		Node slow = head;
		Node fast = head;
		while(true) {
			slow = slow.next;
			fast = fast.next.next;
			if(fast==slow) {
				break;
			}
		}
		Node special = fast;
		Node start = head;
		
		while(start.next!=special.next) {
			start = start.next;
			special= special.next;
		}
		special.next = null;
		return;
		
	}

}
