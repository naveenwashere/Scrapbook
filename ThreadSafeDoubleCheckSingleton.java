
public class ThreadSafeDoubleCheckSingleton {

	private ThreadSafeDoubleCheckSingleton() {}
	
	private static ThreadSafeDoubleCheckSingleton instance;
	
	public static ThreadSafeDoubleCheckSingleton getInstance() {
		if(instance == null) {
			synchronized (ThreadSafeDoubleCheckSingleton.class) {
				if(instance == null) {
					instance = new ThreadSafeDoubleCheckSingleton();
				}
			}
		}
		return instance;
	}
	
	public static void main(String[] args) {
		ThreadSafeDoubleCheckSingleton instance = ThreadSafeDoubleCheckSingleton.getInstance();
		ThreadSafeDoubleCheckSingleton anotherInstance = null;
		try {
			anotherInstance = (ThreadSafeDoubleCheckSingleton) instance.getClass().newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(instance.hashCode() + " -> " + anotherInstance.hashCode());
	}
}
