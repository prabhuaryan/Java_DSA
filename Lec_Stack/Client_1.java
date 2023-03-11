package Lec_Stack;

public class Client_1 {
	public static void main(String[] args) {
//		C obj1 = new C();
//		obj1.funP();
//		obj1.fun();
//	Case 1: Parent ka object!!
		P obj1 = new P();
		System.out.println(obj1.data);
		System.out.println(obj1.datap);
		System.out.println("========");
//		Case 2: Child ka object!!

		P obj2 = new C();
		System.out.println(obj2);
		
		System.out.println(obj2.datap);
		System.out.println(obj2.data);

		System.out.println(((C) obj2).datac);
		System.out.println(((C) obj2).data);
//		
		System.out.println("=============");
		
		obj2.fun();
		((C) obj2).fun();
		
		
////		Case 3:
//		C obj3 = new C();
//		
//		System.out.println(obj3);
//		System.out.println(obj3.data);
//		System.out.println(obj3.datac);
//		System.out.println(obj3.datap);
//
//		System.out.println(((C) obj3).data);
//		System.out.println(((P) obj3).data);
	}
}
