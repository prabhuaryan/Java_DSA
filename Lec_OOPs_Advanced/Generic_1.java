package Lec_OOPs_Advanced;

import java.util.Comparator;

public class Generic_1 {
	public static void main(String[] args) {
		Student[] arr = new Student[5];
		arr[0] = new Student("UA", 10);
		arr[1] = new Student("aB", -11);
		arr[2] = new Student("CZ", 12);
		arr[3] = new Student("CD", 130);
		arr[4] = new Student("Ea", 3);

		println(arr);
//		sort(arr);
		sort(arr, new pair_Name());
		println(arr);

	}

//	public static void println(Object[] arr) {
//		for(Object obj : arr) {
//			System.out.print(obj+ " ");
//		}
//	}
	public static <puipui> void println(puipui[] arr) {
		for (puipui obj : arr) {
			System.out.print(obj + " ");
		}
		System.out.println();
	}

	public static <Y extends Comparable<Y>> void sort(Y[] arr) {
		for (int count = -0; count < arr.length; count++) {
			for (int i = 0; i <= arr.length - 2; i++) {

//				if (arr[i].Age > arr[i + 1].Age) {
				if (arr[i].compareTo(arr[i + 1]) >= 0) {
//					A.compareTo(B) = A-B
					Y temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
		}
	}
	
	
	static class pair_Name implements Comparator<Student>{

		@Override
		public int compare(Student o1, Student o2) {
			return o1.Name.compareTo(o2.Name);
		}
		
	}
	public static <T> void sort(T[] arr, Comparator<T> comp) {
		for (int count = -0; count < arr.length; count++) {
			for (int i = 0; i <= arr.length - 2; i++) {
//				comparing_fn(A,B) = A-B

				if (comp.compare(arr[i], arr[i + 1]) >= 0) {
					T temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
		}
	}
}
