
public enum EnumSingleton {
	INSTANCE;
	
	public void doSomething() {
		System.out.println("Doing something...");
	}
	
	public static void main(String[] args) {
		EnumSingleton.INSTANCE.doSomething();
		System.out.println(INSTANCE.hashCode());
	}
}
