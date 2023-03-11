package Lec_OOPs_Exception;

public class Student {
//	2 data member
//	data parsing ke through 
//	apna data members initialize kra hein
	 
	private String Name= "Chomu";
	private int Age= 12;
//	String dress = "1 piece";

	public void Intro() {
		System.out.println(this);
		System.out.println(Name + " - " + Age);
	}
	
	public void partyWith(String Name) {
		System.out.println(this.Name + "  party with "+Name);
	}
//	default constructor!!
	public Student(int Age, String Name){
		this.Age = Age;
		this.Name = Name;
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public int getAge() {
		return Age;
	}
	
	public String getName() {
		return Name;
	}
	public void setAge(int age) throws Exception {
		if(age<0) {
			throw new RuntimeException("chup rhe be!!");// unchecked exception
//			throw new Exception("chup rhe be"); // checked exception!!
		}
		Age = age;
	}
}
