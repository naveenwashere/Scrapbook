
public class StaticBlockInitializedSingletion {

	private StaticBlockInitializedSingletion() { }
	
	private static StaticBlockInitializedSingletion instance;
	
	static {
		instance = new StaticBlockInitializedSingletion();
	}
	
	public static StaticBlockInitializedSingletion getInstance() {
		return instance;
	}
	
	public static void main(String[] args) {
		StaticBlockInitializedSingletion instance = StaticBlockInitializedSingletion.getInstance();
		StaticBlockInitializedSingletion anotherInstance = null;
		try {
			anotherInstance = (StaticBlockInitializedSingletion) instance.getClass().newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(instance.hashCode() + " -> " + anotherInstance.hashCode());
	}
}
