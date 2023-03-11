package Lec_Stack;

import java.util.ArrayList;

public class Client_Stack {
	public static void main(String[] args) {
		Object obj1 = new D_Stack();
		String str = obj1.toString();
		System.out.println("str = "+str);

		ArrayList<Integer> AL = new ArrayList<>();
		AL.add(10);
		
		System.out.println(AL);
		
		Stack S = new D_Stack();
		System.out.println(S);
		S.add(10);
		S.add(20);
		S.add(30);
		S.Disp();

		S.add(40);
		S.add(50);
		S.Disp();

//		S.add(60);
//		S.Disp();

	}
}
