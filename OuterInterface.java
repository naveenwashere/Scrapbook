public class OuterInterface {
	
	public void innerImpl() {
		OuterIntf outIn = new OuterIntf() {
			
			@Override
			public void outer() {
				// TODO Auto-generated method stub
				
			}
		};
	}
	
	public static void main(String[] args) {
		OuterIntf.InnerInterf oi = new OuterIntf.InnerInterf() {
			public void inner() {
				
			}
		};
	}
}

interface OuterIntf {
	void outer();
	interface InnerInterf {
		void inner();
	}
}
