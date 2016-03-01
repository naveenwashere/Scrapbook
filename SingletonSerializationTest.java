import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class SerializedSingleton implements Serializable {

	private static final long serialVersionUID = -7604766932017737115L;

	private SerializedSingleton() {
	}

	private static class SingletonHelper {
		private static final SerializedSingleton instance = new SerializedSingleton();
	}

	public static SerializedSingleton getInstance() {
		return SingletonHelper.instance;
	}
	
	public Object readResolve() { //can make it protected
		return getInstance();
	}

}

public class SingletonSerializationTest {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		FileOutputStream fos = new FileOutputStream("Serialization.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(SerializedSingleton.getInstance());
		oos.close();
		
		FileInputStream fis = new FileInputStream("Serialization.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		SerializedSingleton singletonSerialized = (SerializedSingleton) ois.readObject();
		ois.close();
		
		System.out.println("Before Ser: " + SerializedSingleton.getInstance().hashCode() + ", After DeSer: " + singletonSerialized.hashCode());
	}
}
