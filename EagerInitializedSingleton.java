
public class EagerInitializedSingleton {
	
	private EagerInitializedSingleton() { }
	
	private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();
	
	public static EagerInitializedSingleton getInstance() {
		return instance;
	}
	
	public static void main(String[] args) {
		EagerInitializedSingleton instance = EagerInitializedSingleton.getInstance();
		EagerInitializedSingleton anotherInstance = null;
		try {
			anotherInstance = (EagerInitializedSingleton) instance.getClass().newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(instance.hashCode() + " -> " + anotherInstance.hashCode());
	}
}
