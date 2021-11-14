package ua.edu.sumdu.j2se.moroz.tasks;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello");
	Task t = new Task("ghtbg",5,56,8);
		LinkedTaskList l = new LinkedTaskList();
		l.add(t);
		l.add(new Task("kkkkkkkkkk",5));
		l.add(new Task("kkkkkkkkkk",14));
		System.out.println(l.size());
		l.remove(t);
		System.out.println(l.size());
//
	}
}
