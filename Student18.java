import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
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
		Student18 stu1 = null;
		try {
			stu1 = new Student18(101, "amit");

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
		/*new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		}).start();*/
		
		FileOutputStream fos = new FileOutputStream("Ser.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(stu1);
		oos.close();
		
		FileInputStream fis = new FileInputStream("Ser.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Student18 stu = (Student18)ois.readObject();
		System.out.println(stu.rollno + " " + stu.name + " -> Hashcode:" + s1.hashCode());
		ois.close();
	}
}