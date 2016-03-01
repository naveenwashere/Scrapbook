/**
 * Doesnt need synchronization and is thread safe
 * @author naveenkumarkalapati
 *
 */
public class BillPughSingletonMethod {
	
	private BillPughSingletonMethod() {}
	
	private static class SingletonHeper {
		private static BillPughSingletonMethod instance = new BillPughSingletonMethod();
	}
	
	public static BillPughSingletonMethod getInstance() {
		return SingletonHeper.instance;
	}
	
	public static void main(String[] args) {
		BillPughSingletonMethod instance = BillPughSingletonMethod.getInstance();
		BillPughSingletonMethod anotherInstance = null;
		try {
			anotherInstance = (BillPughSingletonMethod) instance.getClass().newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(instance.hashCode() + " -> " + anotherInstance.hashCode());
	}
}
