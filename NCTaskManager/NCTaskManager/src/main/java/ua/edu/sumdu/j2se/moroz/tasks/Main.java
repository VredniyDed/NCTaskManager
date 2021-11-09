package ua.edu.sumdu.j2se.moroz.tasks;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello");
		int a=5;
		System.out.println(a);
		System.out.println(++a);
		System.out.println(a++);
		System.out.println(a);

		String[] arr1 = new String[5];
		for (String i: arr1) {
			System.out.println(i);
		}
		int[] arr2 = new int[12];

		System.out.println(arr2.length);
		int n = 10;
		int d1[] = new int[n];
		System.out.println(d1.length);
		n = 3;
		System.out.println(d1.length);
		System.out.println(n);


	}
}
