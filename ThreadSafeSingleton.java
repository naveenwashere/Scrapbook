
public class ThreadSafeSingleton {

	private ThreadSafeSingleton() {}
	
	private static ThreadSafeSingleton instance;
	
	public static synchronized ThreadSafeSingleton getInstance() {
		if(instance == null) {
			instance = new ThreadSafeSingleton();
		}
		return instance;
	}
	
	public static void main(String[] args) {
		ThreadSafeSingleton instance = ThreadSafeSingleton.getInstance();
		ThreadSafeSingleton anotherInstance = null;
		try {
			anotherInstance = (ThreadSafeSingleton) instance.getClass().newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(instance.hashCode() + " -> " + anotherInstance.hashCode());
	}
}
