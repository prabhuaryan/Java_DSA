package Lec_OOPs_Advanced;

public class static_client_demo {
	public static void main(String[] puipui) {
		for (String word : puipui) {
			System.out.println(word);
		}
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Student.total_Student);
		Student.increase();
		System.out.println(Student.total_Student);

		new Student("A", 99);
		System.out.println(Student.total_Student);
		new Student("A", 99);
		System.out.println(Student.total_Student);
		new Student("A", 99);
		System.out.println(Student.total_Student);

	}

	public static void main(int a) {
		System.out.println("090");
	}
}
