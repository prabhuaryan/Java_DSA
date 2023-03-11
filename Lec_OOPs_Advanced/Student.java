package Lec_OOPs_Advanced;

public class Student implements Comparable<Student> {
	static final int total_Student = 0;

	public Student(String c, int i) {
		Age = i;
		Name = c;
	}

	static void increase() {

//		total_Student++;
	}

	int Age;
	String Name;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "{" + Name + "," + Age + "}";
	}

	public int compareTo(Student o) {
//		A.compareTo(B)		
//		o = B , this = A

		return this.Age - o.Age;
	}

}
