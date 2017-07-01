//program to remove thelock on integer class and string class
public class RemoveLock {
	static class ThreadOne implements Runnable {

		public void run() {
			synchronized (Integer.class) {
				System.out.println(Thread.currentThread().getName() + " - Got lock on Integer.class");
				synchronized (String.class) {
					System.out.println(Thread.currentThread().getName() + " - Got lock on String.class");
				}
			}
		}
	}
	/*
	 * Both method are now requesting lock in same order, first Integer and then
	 * String. both method are requesting lock in consistent order.
	 */

	static class ThreadTwo implements Runnable {

		public void run() {
			synchronized (Integer.class) {
				System.out.println(Thread.currentThread().getName() + " - Got lock on Integer.class");
				synchronized (String.class) {
					System.out.println(Thread.currentThread().getName() + " - Got lock on String.class");
				}
			}
		}

	}

	/**
	 * here we create the main method then create the two thread for calling the
	 * method run
	 */
	public static void main(String[] args) {
		new Thread(new ThreadOne(), "ThreadOne").start();
		new Thread(new ThreadTwo(), "ThreadTwo").start();
	}

}
