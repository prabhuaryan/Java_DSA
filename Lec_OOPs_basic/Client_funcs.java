package Lec_OOPs_basic;

public class Client_funcs {
	public static void main(String[] args) {
		Student s1 = new Student();
		s1.Name = "A";
		s1.Age = 10;
		System.out.println(s1);
		s1.Intro();
		

		Student s2 = new Student();
		s2.Name = "B";
		s2.Age = 20;
		System.out.println(s2);
		s2.Intro();
		
		System.out.println("==============");
		s1.partyWith(s2.Name);
//		
	}
}
