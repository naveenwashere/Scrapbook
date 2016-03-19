import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student implements Comparable<Student> {
	String name;
	int roll;
	Student(String name, int roll) {
		this.name = name;
		this.roll = roll;
	}
	
	public int compareTo(Student otherStu) {
		if(!(otherStu instanceof Student)) {
			return 9;
		}
		if(this.name.compareTo(otherStu.name) < 0) {
			return -1;
		}
		if(this.name.compareTo(otherStu.name) == 0) {
			return 0;
		}
		return 1;
	}
	
}


public class ComparatorComparable {

	public static void main(String[] args) {
		Student one = new Student("Naveen", 1);
		Student two = new Student("Uday", 2);
		Student three = new Student("Kumar", 3);
		
		List<Student> students = new ArrayList<Student>();
		
		students.add(one);
		students.add(two);
		students.add(three);
		
		System.out.println("Before Sorting:");
		for(Student stu : students) {
			System.out.println(stu.name + " -> " + stu.roll);
		}

		Collections.sort(students);
		
		System.out.println("\nAfter Sorting:");
		for(Student stu : students) {
			System.out.println(stu.name + " -> " + stu.roll);
		}
	}

}
