package com.codesamples;

public class NaturalNumPrinterThreads {

	OddNumThread odd;
	EvenNumThread even;

	class IntWrapper {
		private int i;

		public IntWrapper() {
			i = 0;
		}

		public int getI() {
			return i;
		}

		public synchronized void setI(int i) {
			this.i = i;
		}
	}

	volatile IntWrapper integer;

	public NaturalNumPrinterThreads() {
		integer = new IntWrapper();
		odd = new OddNumThread();
		even = new EvenNumThread();
	}

	class OddNumThread extends Thread {
		public void run() {
			synchronized (integer) {
				int curr = 0;
				try {
					while (true) {
						curr = integer.getI() + 1;
						System.out.println("Odd : " + curr);
						integer.setI(curr);
						integer.notify();
						integer.wait();
						if (curr >= 9) {
							System.out.println("Odd Breaking");
							break;
						}
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				integer.notify();
			}
		}
	}

	class EvenNumThread extends Thread {
		public void run() {
			synchronized (integer) {
				int curr = 0;
				try {
					while (true) {
						curr = integer.getI() + 1;
						System.out.println("Even : " + curr);
						integer.setI(curr);
						integer.notify();
						integer.wait();
						if (curr >= 9) {
							System.out.println("Even Breaking");
							break;
						}
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				integer.notify();
			}
		}
	}

	public static void main(String[] args) {
		NaturalNumPrinterThreads nature = new NaturalNumPrinterThreads();
		nature.startThreads();
	}

	private void startThreads() {
		odd.start();
		even.start();
		try {
			odd.join();
			even.join();
			System.out.println("Main thread exited");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
