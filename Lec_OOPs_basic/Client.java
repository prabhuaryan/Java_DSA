package Lec_OOPs_basic;
public class Client {
	public static void main(String[] args) {
		Student s1 = new Student(); 
		// mene Object create 
//		mene Student noun ka Student class ka Instance create kiya!!
		
		System.out.println(s1);
		System.out.println(s1.Age);
		System.out.println(s1.Name);
		
		Student s2 = new Student(20,"boii");
		System.out.println(s2.Age);
		System.out.println(s2.Name);
	
		


		
		
		
	}
}
