package Lec_OOPs_Exception;

public class Exception_demo2 {
	public static void main(String[] args) {

		Student s = new Student(12, "Chottu");
		try {
			s.setAge(-20);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
