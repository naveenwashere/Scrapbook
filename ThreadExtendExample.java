
public class ThreadExtendExample implements Runnable {

	private Integer number;
	
	private Object object;

	public ThreadExtendExample(Integer number, Object object) {
		this.number = number;
		this.object = object;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		synchronized (object) {
			try{
				while (this.number <= 10) {
					if(this.number % 2 == 0) {
						System.out.println(this.number++);
						object.notify();
						object.wait();
					}
					if(number % 2 == 1) {
						System.out.println(this.number++);
						object.notify();
						object.wait();
					}
				}
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	public static void main(String[] args) {
		Integer number = 0;
		Object object = new Object();
		Thread teeOne = new Thread(new ThreadExtendExample(number, object));
		Thread teeTwo = new Thread (new ThreadExtendExample(number, object));
		teeOne.start();
		teeTwo.start();
		
		try {
			teeOne.join();
			teeTwo.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

}
