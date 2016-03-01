
public class LazyInitializedSingleton {
	
	private LazyInitializedSingleton() {}
	
	private static LazyInitializedSingleton instance;
	
	public static LazyInitializedSingleton getInstance() {
		if(instance == null) {
			instance = new LazyInitializedSingleton();
		}
		return instance;
	}
	
	public static void main(String[] args) {
		LazyInitializedSingleton instance = LazyInitializedSingleton.getInstance();
		LazyInitializedSingleton anotherInstance = null;
		try {
			anotherInstance = (LazyInitializedSingleton) instance.getClass().newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(instance.hashCode() + " -> " + anotherInstance.hashCode());
	}
}
