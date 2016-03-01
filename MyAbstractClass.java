class Bike implements Cloneable {

	Bike() {
		System.out.println("bike is created");
	}

	void run() {}

	void changeGear() {
		System.out.println("gear changed");
	}
}

class Honda extends Bike implements Cloneable {
	void run() {
		System.out.println("running safely..");
	}
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

abstract class MyAbstractClass {
	public static void main(String args[]) {
		Honda obj = new Honda();
		obj.run();
		obj.changeGear();
		System.out.println(obj.hashCode());
		try {
			Honda newH = (Honda)obj.clone();
			newH.run();
			newH.changeGear();
			System.out.println(newH.hashCode());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
} 