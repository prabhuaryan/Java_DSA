package Lec_Stack_QPS;

public class Min_stack_client {
	public static void main(String[] args) {
		Min_Stack S = new Min_Stack();
//		0,3,7,60,5,50,10
		S.add(10);
		System.out.println(S.min());
		S.add(50);

		System.out.println(S.min());
		S.add(5);

		System.out.println(S.min());
		S.add(60);
		System.out.println(S.min());

		S.add(7);

		System.out.println(S.min());
		S.add(3);

		System.out.println(S.min());
		S.add(0);

		System.out.println(S.min());
		System.out.println("============");
		S.Disp();
		System.out.println("============");
//		0,3,7,60,5,50,10
		System.out.println(S.min()+" -- "+S.pop()+" -- "+S.min());
		S.Disp();
		System.out.println("=-=-=");
		System.out.println(S.min()+" -- "+S.pop()+" -- "+S.min());
		S.Disp();
		System.out.println("=-=-=");
		System.out.println(S.min()+" -- "+S.pop()+" -- "+S.min());
		S.Disp();
		System.out.println("=-=-=");
		System.out.println(S.min()+" -- "+S.pop()+" -- "+S.min());
		S.Disp();
		System.out.println("=-=-=");
		System.out.println(S.min()+" -- "+S.pop()+" -- "+S.min());
		S.Disp();
		System.out.println("=-=-=");
		System.out.println(S.min()+" -- "+S.pop()+" -- "+S.min());
		S.Disp();
		System.out.println("=-=-=");

	}
}
