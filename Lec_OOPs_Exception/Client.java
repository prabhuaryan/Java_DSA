package Lec_OOPs_Exception;
public class Client {
	public static void main(String[] args) throws Exception {
		Student s1 = new Student(); 
		
		System.out.println(s1);
		
		System.out.println(s1.getAge());
		
		s1.setAge(10);
		System.out.println(s1.getAge());
		
		s1.setAge(20);
		System.out.println(s1.getAge());
	
	}
}
