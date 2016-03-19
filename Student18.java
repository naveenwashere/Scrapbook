import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Student18 implements Cloneable, Serializable {
	int rollno;
	String name;

	Student18(int rollno, String name) {
		this.rollno = rollno;
		this.name = name;
	}

	public static void main(String args[]) throws IOException, ClassNotFoundException {
		Student18 stu1 = null, stu2 = null, stu3 = null, stu4 = null;
		List<Student18> studentList = null;
		try {
			stu1 = new Student18(101, "amit");
			stu2 = new Student18(109, "naveen");
			stu3 = new Student18(102, "uday");
			stu4 = new Student18(107, "kumar");
			
			studentList = new ArrayList<Student18>();
			studentList.add(stu1);
			studentList.add(stu2);
			studentList.add(stu3);
			studentList.add(stu4);

			Student18 s2 = (Student18) stu1.clone();

			System.out.println(stu1.rollno + " " + stu1.name + " -> Hashcode:" + stu1.hashCode());
			System.out.println(s2.rollno + " " + s2.name + " -> HashCode:" + s2.hashCode());

		} catch (CloneNotSupportedException c) {
			System.out.println("Clone not supported");
		}
		
		String s1 = "Naveen";
		String s2 = " Kumar";
		String s3 = s1+s2;
		String s4 = s1.concat(s2);
		System.out.println(s3.hashCode() + " -> " + s4.hashCode());
		
		String s="Java is a programming language. Java is a platform. Java is an Island.";    
		String replaceString=s.replace("^Java$","Kava");//replaces all occurrences of "Java" to "Kava"    
		System.out.println(replaceString);
		
		Pattern p = Pattern.compile("^Java.*");
		Matcher m = p.matcher(s);
		System.out.println(m.matches());
		System.out.println(Pattern.matches("^Java.*", s));
		
		FileOutputStream fos = new FileOutputStream("Ser.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(stu1);
		oos.close();
		
		FileInputStream fis = new FileInputStream("Ser.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Student18 stu = (Student18)ois.readObject();
		System.out.println(stu.rollno + " " + stu.name + " -> Hashcode:" + s1.hashCode());
		ois.close();
		
		Comparator<Student18> rollNoComparator = new Comparator<Student18>() {

			@Override
			public int compare(Student18 o1, Student18 o2) {
				if(o1.rollno < o2.rollno) {
					return -1;
				}
				if(o1.rollno > o2.rollno) {
					return 1;
				}
				return 0;
			}
			
		};
		
		System.out.println("Current Order of students");
		for(Student18 student : studentList) {
			System.out.println(student.rollno + " -> " + student.name);
		}
		
		Collections.sort(studentList, rollNoComparator);
		
		System.out.println("Current Order of students after Comparator Sort using RollNo:");
		for(Student18 student : studentList) {
			System.out.println(student.rollno + " -> " + student.name);
		}
		
	}
}